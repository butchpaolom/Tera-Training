
public class CarParkApp{
	//The default values mean that every 3 real time seconds is equivalent to 1 time unit in the application.
	public final static int TIME_FACTOR = 3; //virtual time unit equivalent to real time unit.
	public final static int TIME_PREFIX = 1000*1; //default is millis. Therefore, to cancel out the existing prefix, *10^3.
	public final static int TIME_UNIT = TIME_PREFIX*TIME_FACTOR;
	//The checkout time is equivalent to 1 real time seconds. This is not related to TIME_FACTOR.
	public final static int CHECKOUT_TIME = 1*TIME_PREFIX; //Alloted time for checking out. Change the first operand, must be positive.
	public final static int MAX_PARK_TIME = 15; //Maximum parking time per car, must be positive.
	public final static int MAX_PARKING_SLOTS = 10; //Maximum parking slots, must be positive.
	public final static int NEW_CAR_CHANCE = 65; //Chance of a new car coming. Must be positive and within 1-100 range.
	public final static int FEE = 10; //Car fee per 1 time unit.

	
	public void start() {
		CarPark carPark = new CarPark();
		
		new Thread(() -> {
			while (true) {
				try {
					carPark.checkSlot();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(() -> {
			while (true) {
				try {
					carPark.incrementClock();
					Thread.sleep(TIME_FACTOR*TIME_PREFIX);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(() -> {
			while (true) {
				try {
					carPark.checkCars();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
