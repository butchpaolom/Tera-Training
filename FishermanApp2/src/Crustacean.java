
public class Crustacean extends Seafood{
	public static final String[] COOK_TYPES = { "Steamed", "Boiled", "Grilled" };

	public Crustacean(int mass) {
		super(mass);
	}
	
	@Override
	public String identifySeafood(int mass) {
		if (mass >= 1 && mass <= 50) {
			return "Shrimp";
		} else if (mass >= 51 && mass <= 200) {
			return "Crab";
		} else if (mass >= 201 && mass <= 500) {
			return "Lobster";
		}
		return null;
	}

	public void cook(int CookType) {
		String seafoodName = this.getName();
		int seafoodMass = this.getSize();
		System.out.println("You " + COOK_TYPES[CookType] + " a " + seafoodMass + "g " + seafoodName + ". ");
	}
}
