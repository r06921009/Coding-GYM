package Big2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Big2.Card.Rank;
import Big2.Card.Suit;

class testCard {

	@Test
	void test() {
		Card clubTwo = new Card(Rank.two, Suit.club);
		Card clubTen = new Card(Rank.ten, Suit.club);
		Card heartTwo = new Card(Rank.two, Suit.heart);
		Card spadeThirteen = new Card(Rank.thirteen, Suit.spade);
		Card spadeFive = new Card(Rank.five, Suit.spade);

		assertEquals(clubTwo.toString(), "C[2]");
		assertEquals(clubTen.toString(), "C[10]");
		assertEquals(heartTwo.toString(), "H[2]");
		assertEquals(spadeThirteen.toString(), "S[K]");
		assertEquals(spadeFive.toString(), "S[5]");

		assertTrue(clubTwo.compareTo(clubTen) > 0);
		assertTrue(clubTwo.compareTo(heartTwo) < 0);
		assertTrue(clubTwo.compareTo(spadeFive) > 0);
		assertTrue(spadeFive.compareTo(spadeThirteen) < 0);
	}
	
	@Test
	void testHasSameRank() {
		Card heartTwo = new Card(Rank.two, Suit.heart);
		Card clubTwo = new Card(Rank.two, Suit.club);
		Card spadeTwo = new Card(Rank.two, Suit.spade);
		
		assertTrue(Card.hasSameRank(heartTwo, clubTwo, spadeTwo));
		
		Card spadeThree = new Card(Rank.three, Suit.spade);
		
		assertFalse(Card.hasSameRank(heartTwo, clubTwo, spadeTwo, spadeThree));
	}
	
	@Test
	void testIsConsective() {
		Card[] card = new Card[3];
		
		for(int i = 0; i < 3; i++) {
			card[i] = Deck.getCard(1, i);
		}
		
		assertTrue(Card.isConsective(0, 2, card) == -1);
		
		card[2] = Deck.getCard(1, 3);
		
		assertTrue(Card.isConsective(0, 2, card) == 1);	
	}
	
	@Test
	void testIsThree() {
		Card card = Deck.getCard(0, 0);
		
		assertTrue(card.isThree());
		
		card = Deck.getCard(0, 1);
		
		assertFalse(card.isThree());
	}
}
