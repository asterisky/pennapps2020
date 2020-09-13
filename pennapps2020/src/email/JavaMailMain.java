package email;

/**
 * Test the JavaMail class; includes the credentials for an email for the 
 * program to use
 * @author 
 */
public class JavaMailMain {
	
	private static final String recipient = "katiepi@seas.upenn.edu";
	private static final String myAccountEmail = "mcitobooking@gmail.com";
	private static final String myPassword = "pennapps2020@";
	private static final String subject = "Booking Appointment for MCIT 593!";
	private static final String text = "Hello, you are assigned to a study group for MCIT 593.\n\n" + 
									   "Please coordinate with Jack Chen at chejac@seas.upenn.edu " + 
									   "to meet on Monday 12PM to 2PM.\n\n" +
									   "Happy studying!\n\n" + "-MCITO Booking";
	
	public static void main(String[] args) {
		JavaMail.sendMail(recipient, myAccountEmail, myPassword, subject, text);
	}
}
