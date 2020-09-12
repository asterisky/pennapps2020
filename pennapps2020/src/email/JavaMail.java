package email;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * Sends out a simple email using Java Mail API
 * @author 
 */
public class JavaMail {
	
	/**
	 * Sends out a simple email to given recipient from a Gmail account
	 * containing given subject and text
	 * @param recipient receiving the email
	 * @param myAccountEmail of the sender
	 * @param myPassword of the sender
	 * @param subject of the message
	 * @param text of the message
	 */
	public static void sendMail(String recipient, String myAccountEmail, 
								String myPassword, String subject, 
								String text) {
		System.out.println("Preparing to send email");
		
		// Set up the mail server properties to use Gmail
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.stmp.port", "587");
		
		// Log into the Gmail using the given account credentials and properties
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, myPassword);
			}
		});
		
		// Create the message to be sent
		Message message = prepMessage(session, myAccountEmail, recipient, 
									  subject, text);
		
		// Try to send the message and catch any exceptions
		try {
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Message sent successfully");
	}
	
	/**
	 * Helper function to prepare the message
	 * @param session of the login configuration
	 * @param myAccountEmail of the sender
	 * @param recipient of the message
	 * @param subject of the message
	 * @param text of the message
	 * @return
	 */
	private static Message prepMessage(Session session, String myAccountEmail, 
									   String recipient, String subject, 
									   String text) {
		// Try to create a message and catch any exceptions
		try {
			Message message = new MimeMessage(session);
			
			// Set the sender and recipient email address as internet addresses
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, 
								 new InternetAddress(recipient));
			// Set the subject and text of the message
			message.setSubject(subject);
			message.setText(text);
			
			return message;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
