package Big2;

public abstract class Round {
	Big2 big2;
	
	Round(Big2 big2) {
		this.big2 = big2;
	}
	
	abstract boolean takeAction(Action action, Player player);
	
	void passErrorMsg() {
		System.out.println("You can't pass in the new round.");
	}
	
	void invalidPlayMsg() {
		System.out.println("Invalid play, please try again.");
	}
	
	void playerPatternMsg(Player player, CardPattern pattern) {
		System.out.println(String.format("Player %s plays a %s.", player.getName(), pattern.toString()));
	}
}
