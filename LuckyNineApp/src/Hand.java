
public class Hand {
	private TalkingCard[] talkingCards;
	private boolean isFull;
	private int talkingCardsValue;

	public Hand(int totalCards) {
		talkingCards = new TalkingCard[totalCards];
	}

	public void releaseAllTalkingCards() {
		for (int i = 0; i < talkingCards.length; i++) {
			talkingCards[i] = null;
		}
		isFull = false;
	}

	public void addTalkingCard(TalkingCard talkingCard) {
		if (isFull) {
			System.out.println("Hand is full! Can't accept anymore.");
		} else {
			for (int i = 0; i < talkingCards.length; i++) {
				if (talkingCards[i] == null) {
					talkingCards[i] = talkingCard;
					if (i == talkingCards.length - 1) {
						isFull = true;
					}
					talkingCardsValue += talkingCards[i].getRankValue();
					break;
				}
			}
		}
	}

	public TalkingCard[] getTalkingCards() {
		return talkingCards;
	}

	public int getTalkingCardsValue() {
		return talkingCardsValue % 10;
	}
}
