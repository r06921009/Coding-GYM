package Big2;

public class StraightPatternEvaluate implements CardPatternEvaluate {

	@Override
	public StraightPattern evaluate(Card... cards) {

		if (cards.length != 5) {
			return null;
		}

		int status = Card.isConsective(0, 4, cards);

		if (status == -1 || hasTwoSequence(status, cards)) {
			return new StraightPattern(cards[4], cards.clone());
		} else {
			return null;
		}
	}

	private boolean hasTwoSequence(int idx, Card... cards) {
		return cards[0].isThree() && cards[4].isTwo() && Card.isConsective(idx + 1, 4, cards) == -1;
	}

}
