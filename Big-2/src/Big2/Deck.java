package Big2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import Big2.Card.Rank;
import Big2.Card.Suit;

public class Deck {
	private Stack<Card> stack = new Stack<>();
	private static final List<Card> CARDS = generateCards();

	private static List<Card> generateCards() {
		List<Card> list = new ArrayList<>();

		for (Suit suit : Suit.getSuits()) {
			for (Rank rank : Rank.getRanks()) {
				list.add(new Card(rank, suit));
			}
		}
		return list;
	}
	
	public static void printSortCards() {
		System.out.println(CARDS);
	}

	public static Card getCard(int suit, int rank) {
		return CARDS.get(suit * 13 + rank);
	}
	
	
	public Deck() {
	}

	public void generateDeck() {
		List<Card> list = new ArrayList<>(CARDS);
		Collections.shuffle(list);

		stack.clear();
		
		for (Card card : list) {
			stack.push(card);
		}
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	public Card deal() {
		return stack.pop();
	}
	
	public void setCards(Stack<Card> s) {
		this.stack = s;
	}
}
