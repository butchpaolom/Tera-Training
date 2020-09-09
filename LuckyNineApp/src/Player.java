
public class Player {
	private String nameString;
	private Hand hand;
	private boolean isComputer;

	public Player(String nameString) {
		setNameString(nameString);
		System.out.println("[" + nameString + "] Hello, I'm " + nameString + "!");
		hand = new Hand(3);
	}
	
	public Player(boolean isComputer) {
		this.isComputer = isComputer;
		setNameString(nameString);
		System.out.println("[" + nameString + "] Hello, I'm " + nameString + "!");
		hand = new Hand(3);
	}


	public String getNameString() {
		return nameString;
	}

	public Hand getHand() {
		return hand;
	}

	public void setNameString(String nameString) {
		this.nameString = isComputer ? CardGameSystem.CPU_NAME : nameString;
	}

	public void receiveTalkingCard(TalkingCard talkingCard) {
		System.out.println("[" + nameString + "] I received a talking card.");
		hand.addTalkingCard(talkingCard);
	}

	public void displayAllTalkingCards() {
		System.out.println("--Cards of " + getNameString() + "--");
		for (TalkingCard talkingCard : hand.getTalkingCards()) {
			if (talkingCard != null) {
				talkingCard.talk();
			}
		}
	}
}
