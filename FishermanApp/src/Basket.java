
public class Basket<T> {

	Seafood[] seafoods = new Seafood[10];
	private boolean isFull;

	public void put(T seafood) {
		for (int i = 0; i < seafoods.length; i++) {
			if (seafoods[i] == null) {
				if (seafoods.length - 1 == i) {
					isFull = true;
				}
				seafoods[i] = (Seafood) seafood;
				System.out.println("You stored the " + seafood.getClass().getSimpleName() + " to the basket.");
				break;
			} else if (isFull) {
				System.out.println(
						"The basket is full! You've thrown the " +  seafood.getClass().getSimpleName() + " back to the sea!");
				break;
			}
		}
	}

	public Seafood get() {
		for (int i = 0; i < seafoods.length; i++) {
			if (seafoods[i] instanceof Seafood) {
				Seafood seafood = seafoods[i];
				seafoods[i] = null;
				isFull = false;
				return (Seafood) seafood;
			}
		}
		return null;
	}

	private boolean isEmpty() {
		for (Seafood seafood : seafoods) {
			if (seafood != null) {
				return false;
			}
		}
		return true;
	}

	public void checkContents() {
		for (int i = 0; i < seafoods.length; i++) {
			if (!isEmpty()) {
				if (seafoods[i] instanceof Seafood) {
					System.out.println(i + 1 + ". " + seafoods[i].getClass().getSimpleName());
				}
			} else {
				System.out.println("Empty.");
				break;
			}
		}
	}

}
