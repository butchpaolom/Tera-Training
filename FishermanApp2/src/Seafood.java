
abstract public class Seafood implements CookSeafood{
	private String name;
	private int size;
	
	public Seafood(int size) {
		this.size = size;
		this.name = identifySeafood(size);
	}
	
	public void cook(int cookType) {
		System.out.println("You cooked a " + getName());
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}
	
	abstract public String identifySeafood(int mass);
}
