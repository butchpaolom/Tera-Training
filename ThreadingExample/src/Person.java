
public class Person {
	private String email;
	private String name;

	public Person(String email, String name) {
		this.email = email;
		this.name = name;
	}

	public void save(){
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("[pgAdmin] Person added (name: " + name + ", email: " + email + ")");
	}
}
