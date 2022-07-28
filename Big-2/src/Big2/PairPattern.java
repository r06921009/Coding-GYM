package Big2;

public class PairPattern extends CardPattern{

	public PairPattern(Card... cards) {
		super(cards[1], cards);
	}

	@Override
	String getName() {
		return "pair";
	}
}
