package email;

/**
 * Test the JavaMail class; includes the credentials for an email for the 
 * program to use
 * @author 
 */
public class JavaMailMain {
	
	private static final String recipient = "chejac@sas.upenn.edu";
	private static final String myAccountEmail = "mcitobooking@gmail.com";
	private static final String myPassword = "pennapps2020@";
	private static final String subject = "HelloWorld";
	private static final String text = "First email sent using Java Mail " + 
									   "API. Hurray!";
	
	public static void main(String[] args) {
		JavaMail.sendMail(recipient, myAccountEmail, myPassword, subject, text);
	}
}
