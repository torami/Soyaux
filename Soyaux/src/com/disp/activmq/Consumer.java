package com.disp.activmq;
import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.disp.bean.Demande;

public class Consumer {
    // URL of the JMS server
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;


    public static void consume (String nameQueue, String nameConsumer) throws JMSException  {
        // Getting JMS connection from the server

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();

        // need to setClientID value, any string value you wish
        connection.setClientID(nameConsumer);

        try{
        connection.start();
        }catch(Exception e){
            System.err.println("NOT CONNECTED!!!");
        }
        Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);

        Queue topic = session.createQueue(nameQueue);

        //need to use createDurableSubscriber() method instead of createConsumer() for topic
         MessageConsumer consumer = session.createConsumer(topic);


        MessageListener listner = new MessageListener() {
        	  public void onMessage(Message message) {
                  try {
                      if (message instanceof ObjectMessage) {
                          ObjectMessage textMessage = (ObjectMessage) message;
                          Demande ob = (Demande) textMessage.getObject();
                          System.out.println("Signalement reçu");
                          System.out.println("Importance: "+ob.getImportance()+"# l'objet: "+ob.getObject()+"# Description: "+ob.getObject()+"# Adresse: "+ob.getPlace());
                      }
                  } catch (JMSException e) {
                      System.out.println("Caught:" + e);
                      e.printStackTrace();
                  }
              }
          };

        consumer.setMessageListener(listner);
//        connection.close();

    }
}