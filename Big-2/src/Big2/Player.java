package Big2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Player {
	private String name;
	private Set<Card> cardSet = new TreeSet<>();

	public Player(String name) {
		this.name = name;
	}

	public void addCard(Card card) {
		cardSet.add(card);
	}

	public Action action(int... j) {
		Card[] cards = new Card[j.length];
		List<Card> list = new ArrayList<>(cardSet);
		int i = 0;
		for (int idx : j) {
			cards[i++] = list.get(idx);
		}

		return new Action(cards);
	}

	public void removeAction(Action action) {
		for (Card card : action.getCards()) {
			cardSet.remove(card);
		}
	}

	public Stream<Card> getCard() {
		return cardSet.stream();
	}

	public void printCard() {
		StringBuilder numbers = new StringBuilder();
		StringBuilder cards = new StringBuilder();
		int i = 0;
		for (Card card : cardSet) {
			numbers.append(String.format("%" + (-card.toString().length()) + "s", i++)).append(" ");
			cards.append(card).append(" ");
		}

		// the following will print
		System.out.println(numbers.toString().stripTrailing()); // strip the trailing whitespaces
		System.out.println(cards.toString().stripTrailing()); // strip the trailing whitespace
	}

	public boolean cardOut() {
		return cardSet.isEmpty();
	}

	public String getName() {
		return name;
	}
}
