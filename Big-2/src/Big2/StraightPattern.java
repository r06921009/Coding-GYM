package Big2;

public class StraightPattern extends CardPattern {

	StraightPattern(Card order, Card... cards) {
		super(order, cards);
	}

	@Override
	String getName() {
		return "straight";
	}

}
