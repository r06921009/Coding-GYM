package Big2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class testPlayer {

	@Test
	void testPlayerAction() {
		Player p1 = new Player("Mick");
		p1.addCard(Deck.getCard(0, 7));
		p1.addCard(Deck.getCard(1, 2));
		p1.addCard(Deck.getCard(3, 2));
		p1.addCard(Deck.getCard(3, 3));
		p1.addCard(Deck.getCard(3, 1));
		p1.addCard(Deck.getCard(1, 10));
		p1.addCard(Deck.getCard(2, 12));
		p1.addCard(Deck.getCard(0, 3));
		p1.addCard(Deck.getCard(1, 6));
		p1.addCard(Deck.getCard(3, 4));
		
		PairPatternEvaluate eval = new PairPatternEvaluate();
		
		PairPattern pair = eval.evaluate(p1.action(0, 2).getCards());
		assertNull(pair);
		
		Action action = p1.action(3, 4);
		
		pair = eval.evaluate(action.getCards());
		assertNotNull(pair);
		
		p1.removeAction(action);
		
		assertFalse(p1.getCard().anyMatch(card -> card == Deck.getCard(0, 3)));
	}

}
