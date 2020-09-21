
public class Mailer extends Thread {
	String email;
	
	@Override
	public void run() {
		try {
			send(email);
		} catch (Exception e) {
			System.out.println(e);
		}
		super.run();
	}
	
	public Mailer(String email) {
		this.email = email;
	}
	
	public static void send(String email) throws InterruptedException{
		Thread.sleep(1000);
		System.out.println("[Mailer] an email has been sent to " + email);
	}
}
