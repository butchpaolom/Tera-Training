import java.util.Scanner;

public class LuckyNineSystem extends CardGameSystem {
	private Deck<TalkingCard> deck = new Deck<TalkingCard>();
	private Scanner scanner = new Scanner(System.in);
	private final int MAX_DRAW = 3;
	private long breakTime;
	private Player[] players;

	public LuckyNineSystem(Player player) {
		this(0, player);
	}

	public LuckyNineSystem(long breakTime, Player player) {
		super(player);
		this.breakTime = breakTime;
		this.players = getPlayers();
	}

	public LuckyNineSystem(long breakTime, Player... players) {
		super(players);
		this.breakTime = breakTime * 1000;
		this.players = getPlayers();
	}

	public void start() {
		collectTalkingCards();
		deck.generateCards();
		distributeCards();
		announceWinner();
		displayCards();
		goBreak(breakTime);
	}

	private void goBreak(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	private void giveCard(Player player) {
		TalkingCard talkingCard = deck.releaseRandomTalkingCard();
		player.receiveTalkingCard(talkingCard);
		if (!player.getNameString().equals(CPU_NAME)) {
			talkingCard.talk();
		}
	}

	private void distributeCards() {
		int draws = 0;
		for (int i = 0; i < MAX_DRAW * players.length; i++) {
			if (i % players.length == 0) {
				draws++;
			}
			String name = players[i % players.length].getNameString();
			if (name != CPU_NAME && draws == MAX_DRAW) {
				System.out.println("\n[SYSTEM] " + name + ", do you still want to get a card?");
				System.out.println("1. Yes\n2. No");
				int option = scanner.nextInt();
				if (option == 1) {
					giveCard(players[i % players.length]);
				}
			} else if (name != CPU_NAME) {
				int option;
				do {
					System.out.println("[SYSTEM] I'm distributing cards. Is this " + name + "? ");
					System.out.println("1. Yes\n2. No");
					option = scanner.nextInt();
					if (option == 1) {
						giveCard(players[i % players.length]);
					} else {
						System.out.println("[SYSTEM] Let " + name + " answer.");
					}
				} while (option != 1);
				System.out.println("[SYSTEM] Press enter to continue.");
				try {
					System.in.read();
				} catch (Exception e) {
					System.out.println(e);
				}
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			} else {
				giveCard(players[i % players.length]);
			}
		}
	}

	private void displayCards() {
		for (Player player : players) {
			player.displayAllTalkingCards();
		}
	}

	private void announceWinner() {
		String winner = null;
		int highestValue = 0;
		for (Player player : players) {
			int handTalkingCardsValue = player.getHand().getTalkingCardsValue();
			if (handTalkingCardsValue > highestValue) {
				highestValue = handTalkingCardsValue;
				winner = player.getNameString();
			}
		}
		if (winner != null) {
			System.out.println("[SYSTEM] The winner is " + winner + "\n");
		} else {
			System.out.println("[SYSTEM] Draw\n");
		}
	}

	private void collectTalkingCards() {
		for (Player player : players) {
			player.getHand().releaseAllTalkingCards();
		}
	}

}
