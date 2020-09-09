
public class Hand extends Player{
	private TalkingCard[] talkingCards;
	private boolean isFull;
	private int talkingCardsValue;
	
	public Hand(String nameString) {
		this(nameString, 3);
	}
	
	public Hand(String nameString, int totalCards) {
		setNameString(nameString);
		talkingCards = new TalkingCard[totalCards];
	}
	
	public void releaseAllTalkingCards() {
		for (int i = 0; i < talkingCards.length; i++) {
			talkingCards[i]=null;
		}
		isFull=false;
	}

	public void receiveTalkingCard(TalkingCard talkingCard) {
		if (isFull) {
			System.out.println("You can't ask for more cards!");
		} else {
			System.out.println("[" + getNameString() + "]:" + " I received a card.");
			for (int i = 0; i < talkingCards.length; i++) {
				if (talkingCards[i] == null) {
					if (i == talkingCards.length - 1) {
						isFull = true;
					}
					talkingCards[i] = talkingCard;
					talkingCardsValue += talkingCards[i].getRankValue();
					break;
				}
			}

		}
	}

	public void displayAllTalkingCards() {
		System.out.println("--Cards of " + getNameString() + "--");
		for (TalkingCard talkingCard : talkingCards) {
			if (talkingCard != null) {
				talkingCard.talk();
			}
		}
	}

	public int getTalkingCardsValue() {
		return talkingCardsValue % 10;
	}
}
