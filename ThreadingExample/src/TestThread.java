import java.util.concurrent.locks.ReentrantLock;

public class TestThread {
	ReentrantLock lock;

	public TestThread(ReentrantLock lock) {
		this.lock = lock;
	}
	
	public void shout() {
		
	}

	public void doIt(int i) {
		lock.lock();
		System.out.println(i + "# Locked!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(i + "# Unlocking!");
		lock.unlock();
	}
}
