package Big2;

public class FullHouseEvaluate implements CardPatternEvaluate {

	@Override
	public FullHousePattern evaluate(Card... cards) {
		if(cards.length != 5) {
			return null;
		}
		
		if(Card.hasSameRank(cards[0], cards[1], cards[2]) && Card.hasSameRank(cards[3], cards[4])) {
			return new FullHousePattern(cards[0], cards.clone());
		}
		
		if(Card.hasSameRank(cards[0], cards[1]) && Card.hasSameRank(cards[2], cards[3], cards[4])) {
			return new FullHousePattern(cards[2], cards.clone());
		}
		
		return null;
	}

}
