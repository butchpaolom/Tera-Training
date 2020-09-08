
public class Fish extends Seafood{
	public static final String[] COOK_TYPES = { "Grilled", "Fried", "Corned" };

	public Fish(int mass) {
		super(mass);
	}

	@Override
	public String identifySeafood(int mass) {
		if (mass >= 1 && mass <= 50) {
			return "Anchovy";
		} else if (mass >= 51 && mass <= 200) {
			return "Tilapia";
		} else if (mass >= 201 && mass <= 500) {
			return "Tuna";
		}
		return null;
	}

	public void cook(int CookType) {
		String seafoodName = this.getName();
		int seafoodMass = this.getSize();
		System.out.println("You " + COOK_TYPES[CookType] + " a " + seafoodMass + "g " + seafoodName + ". \n");
	}
}
