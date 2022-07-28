package Big2;

public class SinglePatternEvaluate implements CardPatternEvaluate {

	@Override
	public SinglePattern evaluate(Card... cards) {
		if (cards.length != 1) {
			return null;
		}
		
		return new SinglePattern(cards[0]);
	}
}
