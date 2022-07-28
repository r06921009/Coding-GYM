package Big2;

public class OverRound extends Round {
	OverRound(Big2 big2) {
		super(big2);
	}

	@Override
	boolean takeAction(Action action, Player player) {
		return false;
	}

}
