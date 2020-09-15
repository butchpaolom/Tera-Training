
import java.util.Random;

public class Car {

	final private int totalFee;

	private int outTime;
	private int ID;

	public Car(int ID, int entryTime, int FEE) {
		this.ID = ID;
		int lengthOfStay = new Random().nextInt(15) + 1;
		this.outTime = lengthOfStay + entryTime;
		this.totalFee = FEE * lengthOfStay;
		System.out.println("New car #" + ID + ", entered at " + entryTime + ", will stay for " + lengthOfStay
				+ ", will checkout at " + outTime);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean willCheckout(int currentTime) {
		return currentTime == outTime;
	}

	public void checkout() throws InterruptedException {
		System.out.println("Car " + ID + " will checkout.");
		Thread.sleep(1000);
		System.out.println("Car " + ID + " has checked out. Paid: " + totalFee);
	}

}
