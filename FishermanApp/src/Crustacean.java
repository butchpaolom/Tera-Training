
public class Crustacean extends Seafood {
	public static final String[] COOK_TYPES = {"Steamed", "Boiled", "Grilled"};
	
	public void cook(int CookType) {
		System.out.println("You " + COOK_TYPES[CookType]+ " a " + this.getClass().getSimpleName());
	}
}
