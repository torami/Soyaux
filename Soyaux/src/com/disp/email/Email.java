package com.disp.email;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	public static void SendMyEmail (String reciver, String body){

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("reporter.bergerlevrault@gmail.com", "Snoopy12");
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(reciver));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(reciver));
			message.setSubject("REPORTING");
			message.setText(body);
			Transport.send(message);
			System.out.println("Done ... Your email was sent ! ");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}