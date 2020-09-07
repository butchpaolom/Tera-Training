
public class Fish extends Seafood implements CookSeafood {
	public static final String[] COOK_TYPES = { "Grilled", "Fried", "Corned" };

	public void cook(int CookType) {
		System.out.println("You " + COOK_TYPES[CookType] + " a " + this.getClass().getSimpleName() + ". ");
	}
}
