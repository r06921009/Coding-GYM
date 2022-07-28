package Big2;

public class FullHousePattern extends CardPattern {
	public FullHousePattern(Card order, Card... cards) {
		super(order, cards);
	}

	@Override
	String getName() {
		return "full house";
	}
}
