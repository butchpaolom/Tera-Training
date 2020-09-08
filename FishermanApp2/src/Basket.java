
public class Basket<T> {
	private Seafood[] seafoods = new Seafood[10];
	private String seafoodTypeString;
	boolean isFull;

	public void put(Seafood seafood) {
		setSeafoodTypeString(seafood);
		String seafoodName = seafood.getName();
		int seafoodMass = seafood.getSize();
		if (isFull) {
			System.out.println(
					"Your " + seafoodTypeString + " basket is full! You threw the " + seafoodName + " to the sea!\n");
		}
		for (int i = 0; i < seafoods.length; i++) {
			if (seafoods[i] == null) {
				if (seafoods.length - 1 == i) {
					isFull = true;
				}
				seafoods[i] = seafood;
				System.out.println("You stored the " + seafoodName + " - " + seafoodMass + "g to the basket.\n");
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
				shiftSeafoods();
				return (Seafood) seafood;
			}
		}
		return null;
	}

	public Seafood[] getSeafoods() {
		return seafoods;
	}


	public String getSeafoodTypeString() {
		return seafoodTypeString;
	}

	public boolean isEmpty() {
		for (Seafood seafood : seafoods) {
			if (seafood != null) {
				return false;
			}
		}
		return true;
	}

	private void setSeafoodTypeString(Seafood seafood) {
		if (seafoodTypeString == null) {
			seafoodTypeString = seafood.getClass().getSimpleName();
		}
	}
	
	private void shiftSeafoods() {
		Seafood[] newSeafoodsPosition = new Seafood[10];
		for (int i=1; i<seafoods.length;i++) {
			newSeafoodsPosition[i-1] = seafoods[i];
		}
		seafoods = newSeafoodsPosition;
	}

}
