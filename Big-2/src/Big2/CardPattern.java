package Big2;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class CardPattern {
	final Card order;
	final Card[] cards;

	CardPattern(Card order, Card... cards) {
		this.order = order;
		this.cards = cards;
	}

	abstract String getName();

	boolean hasClubThree() {
		return cards[0].isClubThree();
	}
	
	boolean isLargerThan(CardPattern pattern) {
		return order.compareTo(pattern.order) > 0;
	}

	@Override
	public String toString() {
		return String.format("%s %s", getName(),
				Arrays.stream(cards).map(Card::toString).collect(Collectors.joining(" ")));
	}

}
