import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarPark implements Runnable{
	final static private int FEE = 10;
	
	private ArrayList<Car> slots = new ArrayList<Car>();

	private int clock;
	private int lastId;

	public void checkCars() {
		List<Car> clearList = new ArrayList<Car>();
		synchronized (this) {
			for (Car car : slots) {
				if (car.willCheckout(clock)) {
					clearList.add(car);
				}
			}
		}
		clearCars(clearList);
	}

	public void incrementTime() {
		System.out.println("Time: " + ++clock);
	}

	public synchronized void checkSlot() {
		boolean willAdd = new Random().nextInt(100) < 65 ? true : false;
		if (slots.size() < 10 && willAdd) {
			slots.add(new Car(++lastId, clock, FEE));
		}
	}

	private synchronized void clearCars(List<Car> clearList) {
		for (Car car : clearList) {
			try {
				car.checkout();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		slots.removeAll(clearList);
	}

	@Override
	public void run() {
		new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(3000);
					checkSlot();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(() -> {
			while (true) {
				try {
					incrementTime();
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
					checkCars();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
