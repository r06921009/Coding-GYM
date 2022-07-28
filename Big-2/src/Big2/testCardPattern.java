package Big2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Big2.Card.Rank;
import Big2.Card.Suit;

class testCardPattern {
	@Test
	void testSinglePattern() {
		SinglePattern singleEightDiamond = new SinglePattern(new Card(Rank.eight, Suit.diamond));
		SinglePattern singleEightHeart = new SinglePattern(new Card(Rank.eight, Suit.heart));

		assertEquals("single D[8]", singleEightDiamond.toString());
		assertEquals("single H[8]", singleEightHeart.toString());

		assertTrue(singleEightHeart.isLargerThan(singleEightDiamond));
	}

	@Test
	void testPairPattern() {
		PairPattern eight = new PairPattern(new Card(Rank.eight, Suit.diamond), new Card(Rank.eight, Suit.spade));
		PairPattern night = new PairPattern(new Card(Rank.night, Suit.diamond), new Card(Rank.night, Suit.spade));

		assertEquals("pair D[8] S[8]", eight.toString());
		assertEquals("pair D[9] S[9]", night.toString());

		assertTrue(night.isLargerThan(eight));
	}

	@Test
	void testFullHousePattern() {
		Card card1 = new Card(Rank.eight, Suit.club);
		Card card2 = new Card(Rank.eight, Suit.diamond);
		Card card3 = new Card(Rank.eight, Suit.spade);
		Card card4 = new Card(Rank.ten, Suit.club);
		Card card5 = new Card(Rank.ten, Suit.diamond);

		FullHousePattern eight = new FullHousePattern(card1, card1, card2, card3, card4, card5);

		assertEquals("full house C[8] D[8] S[8] C[10] D[10]", eight.toString());

		card1 = new Card(Rank.six, Suit.club);
		card2 = new Card(Rank.six, Suit.diamond);
		card3 = new Card(Rank.twelve, Suit.club);
		card4 = new Card(Rank.twelve, Suit.diamond);
		card5 = new Card(Rank.twelve, Suit.spade);

		FullHousePattern twelve = new FullHousePattern(card3, card1, card2, card3, card4, card5);

		assertEquals("full house C[6] D[6] C[Q] D[Q] S[Q]", twelve.toString());

		assertTrue(twelve.isLargerThan(eight));
	}

	@Test
	void testStraightPattern() {
		StraightPattern straight = new StraightPattern(Deck.getCard(0, 4), Deck.getCard(0, 0), Deck.getCard(0, 1),
				Deck.getCard(0, 2), Deck.getCard(0, 3), Deck.getCard(0, 4));
		assertEquals("straight C[3] C[4] C[5] C[6] C[7]", straight.toString());
	}
}
