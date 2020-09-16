import java.util.concurrent.locks.ReentrantLock;

public class CarBoy {
	private ReentrantLock checkoutLock = new ReentrantLock();
	private Car leavingCar;
	
	public void setleavingCar(Car car) {
		this.leavingCar = car;
	}
	
	public Car getLeavingCar() {
		return leavingCar;
	}
	
	public void checkoutLock() {
		checkoutLock.lock();
	}
	
	public void checkoutUnlock() {
		checkoutLock.unlock();
	}
}
