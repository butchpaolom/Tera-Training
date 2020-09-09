public class Main {
	public static void main(String[] args) {
		Hand userHand = new Hand("Butch");
		long breakTime = 5;
		LuckyNineSystem system = new LuckyNineSystem(breakTime, userHand);
		while (true) {
			system.start();
		}
	}
}
