
public class CounterRunnable implements Runnable {

	@Override
	public void run() {
		Counter counter = new Counter();
		counter.increment();
	}

}
