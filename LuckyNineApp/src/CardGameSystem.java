
public abstract class CardGameSystem {
	private Player[] players;
	public static final String CPU_NAME = "CPU";

	public CardGameSystem(Player player) {
		this(new Player(CPU_NAME), player);
	}
	
	public CardGameSystem(Player... players) {
		this.players = players;
	}


	public Player[] getPlayers() {
		return players;
	}

	public abstract void start();
}
