import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class CarPark {

	private final CarBoy carBoy = new CarBoy();

	private ArrayList<Car> slots = new ArrayList<Car>();

	private int clock;
	private int lastId;

	public void checkCars() throws InterruptedException {
		synchronized (carBoy) {
			carBoy.wait();
			synchronized (slots) {
				slots.remove(carBoy.getLeavingCar());
			}
		}
	}

	public void incrementClock() throws InterruptedException {
		synchronized (this) {
			System.out.println("Time: " + ++clock);
			notifyAll();
		}
		Thread.sleep(CarParkApp.TIME_UNIT);
	}

	public void checkSlot() throws InterruptedException {
		synchronized (this) {
			wait(); //waiting for increment time to finish from other Thread
			boolean willAdd = new Random().nextInt(100) + 1 <= CarParkApp.NEW_CAR_CHANCE ? true : false; //100 represents percentage
			if (slots.size() < CarParkApp.MAX_PARKING_SLOTS && willAdd) {
				Car car = new Car(++lastId, clock, carBoy);
				slots.add(car);
				new Thread(car).start();
			}
		}
	}

}
