package Big2;

public class SinglePattern extends CardPattern {
	public SinglePattern(Card card) {
		super(card, card);
	}

	@Override
	String getName() {
		return "single";
	}

}
