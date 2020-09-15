import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class CarPark{
	final static private int FEE = 10;
	
	private ArrayList<Car> slots = new ArrayList<Car>();

	private int clock;
	private int lastId;

	public void checkCars() throws InterruptedException{
		synchronized (this) {
			wait();
			List<Car> clearList = new ArrayList<Car>();
			for (Car car : slots) {
				if (car.willCheckout(clock)) {
					clearList.add(car);
				}
			}
			new Thread(()->clearCars(clearList)).start();
		}
	}

	public synchronized void incrementTime() {
		System.out.println("Time: " + ++clock);
		notifyAll();
	}

	public void checkSlot() throws InterruptedException {
		synchronized (this) {
			wait();
			boolean willAdd = new Random().nextInt(100) < 65 ? true : false;
			if (slots.size() < 10 && willAdd) {
				slots.add(new Car(++lastId, clock, FEE));
			}
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

}
