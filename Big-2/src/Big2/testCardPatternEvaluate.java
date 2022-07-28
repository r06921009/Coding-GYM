package Big2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Big2.Card.Rank;
import Big2.Card.Suit;

class testCardPatternEvaluate {

	@Test
	void testSinglePatternEvaluate() {
		SinglePattern single;
		SinglePatternEvaluate eval = new SinglePatternEvaluate();

		single = eval.evaluate(new Card(Rank.two, Suit.spade));
		assertNotNull(single);

		single = eval.evaluate(new Card(Rank.two, Suit.spade), new Card(Rank.three, Suit.spade));
		assertNull(single);
	}

	@Test
	void testPairPatternEvaluate() {
		PairPattern pair;
		PairPatternEvaluate eval = new PairPatternEvaluate();

		pair = eval.evaluate(new Card(Rank.two, Suit.spade));
		assertNull(pair);

		pair = eval.evaluate(new Card(Rank.two, Suit.spade), new Card(Rank.three, Suit.spade));
		assertNull(pair);

		pair = eval.evaluate(new Card(Rank.two, Suit.spade), new Card(Rank.two, Suit.heart));
		assertNotNull(pair);
	}

	@Test
	void testFullHousePatternEvaluate() {
		FullHouseEvaluate eval = new FullHouseEvaluate();
		FullHousePattern fullHouse1;
		FullHousePattern fullHouse2;
		
		Card card1 = new Card(Rank.eight, Suit.club);
		Card card2 = new Card(Rank.eight, Suit.diamond);
		Card card3 = new Card(Rank.eight, Suit.spade);
		Card card4 = new Card(Rank.ten, Suit.club);
		Card card5 = new Card(Rank.ten, Suit.diamond);
		
		Card card6 = new Card(Rank.six, Suit.club);
		Card card7 = new Card(Rank.six, Suit.diamond);
		Card card8 = new Card(Rank.twelve, Suit.club);
		Card card9 = new Card(Rank.twelve, Suit.diamond);
		Card card10 = new Card(Rank.twelve, Suit.spade);
		
		fullHouse1 = eval.evaluate(card6, card7, card4, card5, card10);
		assertNull(fullHouse1);
		
		fullHouse1 = eval.evaluate(card1, card2, card3, card4, card5);
		assertNotNull(fullHouse1);
		
		fullHouse2 = eval.evaluate(card6, card7, card8, card9, card10);
		assertNotNull(fullHouse2);
		
		assertTrue(fullHouse2.isLargerThan(fullHouse1));
	}
	
	@Test
	void testStraightPatternEvaluate() {
		StraightPatternEvaluate eval = new StraightPatternEvaluate();
		StraightPattern s1;
		StraightPattern s2;
		
		Card[] card = new Card[5];
		
		for(int i = 0; i < 5; i++) {
			card[i] = Deck.getCard(3, i+7);
		}
		card[0] = Deck.getCard(1, 1);
		
		s1 = eval.evaluate(card);
		
		assertNull(s1);
		
		card[0] = Deck.getCard(3, 7);
		s1 = eval.evaluate(card);
		
		assertNotNull(s1);
		
		for(int i = 0; i < 4; i++) {
			card[i] = Deck.getCard(0, i);
		}
		
		card[4] = Deck.getCard(3, 12);
		
		s2 = eval.evaluate(card);
		
		assertNotNull(s2);
		assertTrue(s2.isLargerThan(s1));
		
	}
}
