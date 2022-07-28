package Big2;

import java.util.function.Predicate;

public class FirstRound extends Round {
	Predicate<CardPattern> constraint;
	
	FirstRound(Big2 big2) {
		super(big2);
	}
	
	void setConstraint(Predicate<CardPattern> constraint) {
		this.constraint = constraint;
	}
	
	@Override
	public boolean takeAction(Action action, Player player) {
		if(action == Big2.PASS) {
			passErrorMsg();
			return false;
		} else {
			for(CardPatternEvaluate eval : Big2.sEvals) {
				CardPattern pattern = eval.evaluate(action.getCards());
				if(pattern != null && checkConstraint(pattern)) {
					playerPatternMsg(player, pattern);
					player.removeAction(action);
					NormalRound r = big2.getNormalRound();
					r.setNewRound(player, eval, pattern);
					big2.setRound(r);
					big2.nextPlayer();
					return true;
				}
			}
			invalidPlayMsg();
			return false;
		}
	}
	
	boolean checkConstraint(CardPattern pattern) {
		if(constraint != null) {
			return constraint.test(pattern);
		}
		return true;
	}
}
