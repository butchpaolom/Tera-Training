
public class Main {
	public static void main(String[] args) {
		CarPark carPark = new CarPark();

		new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(3000);
					carPark.checkSlot();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		
		new Thread(() -> {
			while (true) {
				try {
					carPark.incrementTime();
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(3000);
					carPark.checkCars();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
