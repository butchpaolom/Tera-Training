import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarPark {

	private ArrayList<Car> slots = new ArrayList<Car>();

	private int clock;
	private int lastId;


	public synchronized void checkSlot() {
		boolean willAdd = new Random().nextInt(100) < 65 ? true : false;
		if (slots.size() < 10 && willAdd) {
			slots.add(new Car(++lastId, clock));
		}
	}

	public void checkCars() {
		List<Car> clearList = new ArrayList<Car>();
		synchronized (this) {
			for (Car car : slots) {
				if (car.willCheckout(clock)) {
					clearList.add(car);
				}
			}
			clearCars(clearList);
		}
	}

	private void clearCars(List<Car> clearList) {
		for (Car car : clearList) {
			try {
				car.checkout();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		slots.removeAll(clearList);
	}

	public void incrementTime() {
		System.out.println("Time is: " + ++clock);
	}

}
