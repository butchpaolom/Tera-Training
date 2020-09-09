public class Main {
	public static void main(String[] args) {
		Player player1 = new Player("Butch");
//		Player player2 = new Player("Tera");
//		Player player3 = new Player("System");
		long breakTime = 5;
		LuckyNineSystem system = new LuckyNineSystem(breakTime, player1);
		system.start();
//		while (true) {
//			system.start();
//		}
	}
}
