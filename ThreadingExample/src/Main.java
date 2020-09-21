import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	public static void main(String[] args) throws InterruptedException {
//		Counter counter = new Counter();
//
//		Thread t1 = new Thread(counter::increment); 
//		Thread t2 = new Thread(()->counter.decrement());
//
//		t1.start(); // Thread 1 is started
//		t2.start(); // Thread 2 is started
//
//		t1.join(); // wait for thread 1 to finish
//		t2.join(); // wait for thread 2 to finish
//
//		System.out.println(counter.value()); // prints the final value of counter

//		Scanner scanner = new Scanner(System.in);
//
//		System.out.println("Send request.");
//
//		System.out.print("Name: ");
//		String name = scanner.next();
//
//		System.out.print("Email: ");
//		String email = scanner.next();
//
//		System.out.println("[REQUEST] " + "(name: " + name + ", email: " + email + ")");
//
//		long startTime = System.nanoTime(); // ignore
//
//		new Mailer(email).start();
//		new Thread(() -> new Person(email, name).save()).start();
//
//		long endTime = System.nanoTime(); // ignore
//		long totalTime = (endTime - startTime) / (long) Math.pow(10, 6); // ignore
//
//		System.out.println("[RESPONSE] " + totalTime + "ms. We will send you an email!");
//
//		scanner.close();
//		Object object = new Object();
//		Test test = new Test(object);
//		new Thread(()->test.syncTest()).start();
//		new Thread(()->test.syncTest()).start();
//		Thread.sleep(1000);
//		new Thread(()->test.unlockIt()).start();
		
		ReentrantLock lock = new ReentrantLock();
		TestThread test = new TestThread(lock);
		new Thread(()->{
			while(true) {
				test.shout();
			}
		}).start();
		new Thread(()->test.doIt(1)).start();
		new Thread(()->test.doIt(2)).start();
		new Thread(()->test.doIt(3)).start();
		new Thread(()->test.doIt(4)).start();
		new Thread(()->test.doIt(5)).start();
		new Thread(()->test.doIt(6)).start();
	}
}
