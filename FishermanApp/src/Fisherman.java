public class Fisherman {
	final int MIN_WEIGHT = 1, MAX_WEIGHT = 500;
	final static Class<?>[] SEAFOOD_CLASSES = { Fish.class, Crustacean.class };

	private Basket<Fish> fishBasket = new Basket<Fish>();
	private Basket<Crustacean> crustaceanBasket = new Basket<Crustacean>();

	public void catchSeafood() {
		int randomWeight = Randomizer.range(MIN_WEIGHT, MAX_WEIGHT);
		Class<?> randomType = Randomizer.arrays(SEAFOOD_CLASSES);
		storeSeafood(randomType, randomWeight);
	}

	public void checkBaskets() {
		System.out.println("--Fish Basket--");
		fishBasket.checkContents();
		System.out.println("--Crustacean Basket--");
		crustaceanBasket.checkContents();
	}

	public void eatFish() {
		Seafood fish = fishBasket.get();
		if (fish == null) {
			System.out.println("You don't have any fishes. Go catch some!");
		} else {
			int randomCookType = Randomizer.integer(Fish.COOK_TYPES.length);
			fish.cook(randomCookType);
		}
	}

	public void eatCrustacean() {
		Seafood crustacean = crustaceanBasket.get();
		if (crustacean == null) {
			System.out.println("You don't have any crustaceans. Go catch some!");
		} else {
			int randomCookType = Randomizer.integer(Fish.COOK_TYPES.length);
			crustacean.cook(randomCookType);
		}
	}

	private void storeSeafood(Class<?> seafoodType, int mass) {
		System.out.println("You've caught a " + seafoodType.getSimpleName() + " (" + mass + "grams).");
		if (seafoodType.equals(Fish.class)) {
			Fish seafood = identifyFish(mass);
			fishBasket.put(seafood);
		} else if (seafoodType.equals(Crustacean.class)) {
			Crustacean seafood = identifyCrustacean(mass);
			crustaceanBasket.put(seafood);
		}
	}

	private Fish identifyFish(int mass) {
		if (mass >= 1 && mass <= 50) {
			return new Anchovy();
		} else if (mass >= 51 && mass <= 200) {
			return new Tilapia();
		} else if (mass >= 201 && mass <= 500) {
			return new Tuna();
		}
		return null;
	}

	private Crustacean identifyCrustacean(int mass) {
		if (mass >= 1 && mass <= 50) {
			return new Shrimp();
		} else if (mass >= 51 && mass <= 200) {
			return new Crab();
		} else if (mass >= 201 && mass <= 500) {
			return new Lobster();
		}
		return null;
	}

}
