import java.util.concurrent.atomic.AtomicInteger;

class Counter{
	AtomicInteger c = new AtomicInteger();
	
	
	public void increment() {
		c.incrementAndGet();
	}

	public void decrement() {
		c.decrementAndGet();
	}

	public int value() {
		return c.get();
	}
}