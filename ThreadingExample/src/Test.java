
public class Test implements Runnable{
	private Object object;

	public Test(Object object) {
		System.out.println("Test created!");
		this.object=object;

	}
	
	public void tryLock(){
		synchronized (object) {
			try {
				System.out.println("Waiting...");
				object.wait();
				System.out.println("Done");
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public void syncTest() {
		synchronized (this) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Synctest!");
		}
	}
	
	public void unlockIt() {
		synchronized (object) {
			object.notifyAll();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		tryLock();
	}
}
