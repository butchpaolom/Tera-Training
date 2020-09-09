import java.util.Arrays;
import java.util.Collections;

public class Deck<T> {
	final private int SUIT_COUNT = 4;
	final private int RANK_COUNT = 13;

	private int remainingCards = SUIT_COUNT * RANK_COUNT;
	private TalkingCard[][] talkingCards = new TalkingCard[SUIT_COUNT][RANK_COUNT];

	public Deck() {
		generateCards();
	}

	public void generateCards() {
		TalkingCard.Suit[] suitValues = TalkingCard.Suit.values();
		TalkingCard.Rank[] rankValues = TalkingCard.Rank.values();
		for (int i = 0; i < SUIT_COUNT; i++) {
			for (int j = 0; j < RANK_COUNT; j++) {
				talkingCards[i][j] = new TalkingCard(suitValues[i], rankValues[j]);
			}
		}
	}
	

	public TalkingCard[][] getTalkingCards() {
		return talkingCards;
	}

	public TalkingCard releaseRandomTalkingCard() {
		TalkingCard talkingCard;
		if (remainingCards < 1) {
			System.out.println("No more cards! Regenerating cards..");
			generateCards();
			releaseRandomTalkingCard();
		}
		do {
			int randomSuit = Randomizer.integer(SUIT_COUNT);
			int randomRank = Randomizer.integer(RANK_COUNT);
			talkingCard = talkingCards[randomSuit][randomRank];
			talkingCards[randomSuit][randomRank] = null;
		} while (talkingCard == null);
		remainingCards -= 1;
		return talkingCard;
	}

}
