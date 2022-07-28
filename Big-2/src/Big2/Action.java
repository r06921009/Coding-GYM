package Big2;

public class Action {
	private Card[] cards;
	
	public Action() {
		
	}
	
	public Action(Card... card) {
		cards =  card;
	}
	
	public Card[] getCards() {
		return cards;
	}
}
