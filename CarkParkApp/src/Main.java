
public class Main {
	public static void main(String[] args) {
		CarPark carPark = new CarPark();

		new Thread(() -> {
			while (true) {
				try {
					carPark.checkSlot();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		
		new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(3000);
					carPark.incrementTime();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(1000);
					carPark.checkCars();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
