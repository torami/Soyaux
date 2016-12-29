package com.disp.activmq;
import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.disp.bean.Demande;

public class Consumer {
    // URL of the JMS server
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    // Name of the topic from which we will receive messages from = " testt"

    public static void main(String[] args) throws JMSException {
        // Getting JMS connection from the server

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();

        // need to setClientID value, any string value you wish
        connection.setClientID("12345");

        try{
        connection.start();
        }catch(Exception e){
            System.err.println("NOT CONNECTED!!!");
        }
        Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);

        Queue topic = session.createQueue("Securité");

        //need to use createDurableSubscriber() method instead of createConsumer() for topic
         MessageConsumer consumer = session.createConsumer(topic);


        MessageListener listner = new MessageListener() {
        	  public void onMessage(Message message) {
                  try {
                      if (message instanceof ObjectMessage) {
                          ObjectMessage textMessage = (ObjectMessage) message;
                          System.out.println("Received message"
                                  + textMessage.getObject()+ "'");
                          Demande ob = (Demande) textMessage.getObject();
                          System.out.println(ob.getImportance());
                      }
                  } catch (JMSException e) {
                      System.out.println("Caught:" + e);
                      e.printStackTrace();
                  }
              }
          };

        consumer.setMessageListener(listner);
        //connection.close();

    }
}