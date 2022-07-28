package Big2;

public class PairPatternEvaluate implements CardPatternEvaluate {
	
	@Override
	public PairPattern evaluate(Card... cards) {
		if(cards.length == 2 && Card.hasSameRank(cards)) {
			return new PairPattern(cards.clone());
		}
		
		return null;
	}
}
