
public abstract class CardGameSystem {
	private Hand[] hands;
	public static final String CPU_NAME = "CPU";

	public CardGameSystem(Hand userHand) {
		this(new Hand(CPU_NAME), userHand);
	}

	public CardGameSystem(Hand... hands) {
		this.hands = hands;
	}

	public Hand[] getHands() {
		return hands;
	}

	public abstract void start();
}
