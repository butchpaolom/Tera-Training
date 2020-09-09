
public class TalkingCard {
	public static enum Rank {
		ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(0), JACK(0), KING(0),
		QUEEN(0);

		private final int value;

		Rank(int value) {
			this.value = value;
		}
	}

	public enum Suit {
		HEARTS, CLUBS, DIAMONDS, SPADES
	}

	private Rank rank;
	private Suit suit;

	public TalkingCard(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public void talk() {
		System.out.println(rank + " of " + suit + ".\n");
	}
	
	public int getRankValue() {
		return rank.value;
	}
}
