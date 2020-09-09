import java.util.Scanner;

public class LuckyNineSystem extends CardGameSystem {
	private Deck deck;
	private Scanner scanner = new Scanner(System.in);
	private final int MAX_DRAW = 3;
	private long breakTime;
	private Hand[] hands;

	public LuckyNineSystem(Hand userHand) {
		this(0, userHand);
	}

	public LuckyNineSystem(long breakTime, Hand userHand) {
		super(userHand);
		this.breakTime = breakTime * 1000;
		hands = getHands();
	}

	public LuckyNineSystem(Hand... userHands) {
		this(0, userHands);
	}

	public LuckyNineSystem(long breakTime, Hand... userHands) {
		super(userHands);
		this.breakTime = breakTime * 1000;
		hands = getHands();
	}

	public void start() {
		resetTalkingCards();
		deck = new Deck();
		distributeCards();
		announceWinner();
		displayCards();
		try {
			Thread.sleep(breakTime);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	private void giveCard(Hand hand) {
		TalkingCard talkingCard = deck.releaseRandomTalkingCard();
		hand.receiveTalkingCard(talkingCard);
		if (!hand.getNameString().equals(CPU_NAME)) {
			talkingCard.talk();
		}
	}

	private void distributeCards() {
		int draws = 0;
		for (int i = 0; i < MAX_DRAW * hands.length; i++) {
			if (i % hands.length == 0) {
				draws++;
			}
			String name = hands[i % hands.length].getNameString();
			if (name != CPU_NAME && draws == MAX_DRAW) {
				System.out.println("\n[SYSTEM] " + name + ", do you still want to get a card?");
				System.out.println("1. Yes\n2. No");
				int option = scanner.nextInt();
				if (option == 1) {
					giveCard(hands[i % hands.length]);
				}
			} else {
				giveCard(hands[i % hands.length]);
			}

		}
	}

	private void displayCards() {
		for (Hand hand : hands) {
			hand.displayAllTalkingCards();
		}
	}

	private void announceWinner() {
		String winner = null;
		int highestValue = 0;
		for (Hand hand : hands) {
			int handTalkingCardsValue = hand.getTalkingCardsValue();
			if (handTalkingCardsValue > highestValue) {
				highestValue = handTalkingCardsValue;
				winner = hand.getNameString();
			}
		}
		if (winner != null) {
			System.out.println("[SYSTEM] The winner is " + winner + "\n");
		} else {
			System.out.println("[SYSTEM] Draw\n");
		}
	}

	private void resetTalkingCards() {
		for (Hand hand : hands) {
			hand.releaseAllTalkingCards();
		}
	}

}
