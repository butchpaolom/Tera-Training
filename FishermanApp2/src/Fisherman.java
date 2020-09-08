
public class Fisherman implements FishermanAction {
	final static int MIN_MASS = 1, MAX_MASS = 500;
	final static Class<?>[] SEAFOOD_CLASSES = { Fish.class, Crustacean.class };

	Basket<Fish> fishBasket = new Basket<Fish>();
	Basket<Crustacean> crustaceanBasket = new Basket<Crustacean>();

	public void catchSeafood() {
		int randomMass = Randomizer.range(MIN_MASS, MAX_MASS);
		Class<?> randomType = Randomizer.arrays(SEAFOOD_CLASSES);
		if (randomType.equals(Fish.class)) {
			fishBasket.put(new Fish(randomMass));
		} else if (randomType.equals(Crustacean.class)) {
			crustaceanBasket.put(new Crustacean(randomMass));
		}
	}

	public void eatFish() {
		eat(fishBasket, Fish.COOK_TYPES.length);
	}

	public void eatCrustacean() {
		eat(crustaceanBasket, Crustacean.COOK_TYPES.length);
	}

	private void eat(Basket<?> basket, int arrayLength) {
		Seafood seafood = basket.get();
		if (seafood != null) {
			seafood.cook(Randomizer.integer(arrayLength));
		}
		else {
			System.out.println("You have none! Go catch!");
		}
	}

	public void checkBaskets() {
		listSeafoods(crustaceanBasket);
		listSeafoods(fishBasket);
	}

	private void listSeafoods(Basket<?> basket) {
		if (basket.isEmpty()) {
			System.out.println("--Empty basket--");
			return;
		}
		else {
			String seafoodType = basket.getSeafoodTypeString();
			System.out.println("--" + seafoodType + " basket--");
		}
		Seafood[] seafoods = basket.getSeafoods();
		for (int i = 0; i < seafoods.length; i++) {
			if (seafoods[i] != null) {
				String seafoodName = seafoods[i].getName();
				int seafoodMass = seafoods[i].getSize();
				System.out.println(i + 1 + ". " + seafoodName + " - " + seafoodMass + "g");
			}
		}
	}
}
