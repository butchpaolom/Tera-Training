
import java.util.Random;

public class Car implements Runnable {
	private final int totalFee;
	private int ID;
	private int lengthOfStay; //Not multiplied by the TIME_UNIT
	private CarBoy carBoy;

	public Car(int ID, int entryTime, CarBoy carBoy) {
		this.carBoy = carBoy;
		this.ID = ID;
		this.lengthOfStay = new Random().nextInt(CarParkApp.MAX_PARK_TIME) + 1;
		int outTime = lengthOfStay + entryTime;
		this.totalFee = CarParkApp.FEE * lengthOfStay;
		System.out.println("New car #" + ID + " has entered at Time: " + entryTime + ", will stay for " + lengthOfStay
				+ "TU , will checkout at Time: " + outTime);
	}
	
	@Override
	public void run() {
		startPark();
	}

	private void checkout() {
		carBoy.checkoutLock();
		notifyCarBoy();
		startCheckout();
		carBoy.checkoutUnlock();
	}

	private void startCheckout() {
		System.out.println("Car " + ID + " will checkout.");
		try {
			Thread.sleep(CarParkApp.CHECKOUT_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Car " + ID + " has checked out. Paid: " + totalFee);
	}

	private void startPark() {
		try {
			Thread.sleep(lengthOfStay*CarParkApp.TIME_UNIT);
			checkout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void notifyCarBoy() {
		synchronized (carBoy) {
			carBoy.setleavingCar(this);
			carBoy.notify();
		}
	}
}
