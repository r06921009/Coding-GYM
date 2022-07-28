package Big2;

public class NormalRound extends Round {
	Player prevPlayer;
	CardPatternEvaluate eval;
	CardPattern prevPattern;
	
	NormalRound(Big2 big2) {
		super(big2);
	}
	
	@Override
	public boolean takeAction(Action action, Player player) {
		if(action == Big2.PASS) {
			System.out.println(String.format("Player %s passes.", player.getName()));
			if(big2.nextPlayer() == prevPlayer) {
				System.out.println("New round begins.");
				big2.setRound(big2.getFirstRound());
			}
			return true;
		} else {
			CardPattern pattern = eval.evaluate(action.getCards());
			if(pattern != null && pattern.isLargerThan(prevPattern)) {
				player.removeAction(action);
				playerPatternMsg(player, pattern);
				prevPattern = pattern;
				prevPlayer = player;
				big2.nextPlayer();
				return true;
			}
			invalidPlayMsg();
			return false;
		}
	}
	
	void setNewRound(Player player, CardPatternEvaluate eval, CardPattern pattern) {
		this.prevPlayer = player;
		this.eval = eval;
		this.prevPattern = pattern;
	}
}
