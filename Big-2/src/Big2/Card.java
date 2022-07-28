package Big2;

import java.util.Arrays;
import java.util.stream.Stream;

public class Card implements Comparable<Card> {
	enum Suit {
		club("C"), diamond("D"), heart("H"), spade("S");

		String print;

		private static final Suit[] suits = values();

		public static Suit[] getSuits() {
			return suits;
		}

		Suit(String print) {
			this.print = print;
		}

		@Override
		public String toString() {
			return print;
		}
		
		public static Suit getFromString(String s) {
			for(Suit suit : suits) {
				if(s.equals(suit.print)) {
					return suit;
				}
			}
			return null;
		}
	}

	enum Rank {
		three("3"), four("4"), five("5"), six("6"), seven("7"), eight("8"), night("9"), ten("10"), eleven("J"),
		twelve("Q"), thirteen("K"), one("A"), two("2");

		String print;

		private static final Rank[] ranks = values();

		public static Rank[] getRanks() {
			return ranks;
		}

		Rank(String print) {
			this.print = print;
		}

		@Override
		public String toString() {
			return print;
		}
		
		public static Rank getFromString(String s) {
			for(Rank rank : ranks) {
				if(s.equals(rank.print)) {
					return rank;
				}
			}
			return null;
		}
	}

	public static Card getCardFromString(String s) {
		String suit = String.valueOf(s.charAt(0));
		String rank = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
		return new Card(Rank.getFromString(rank), Suit.getFromString(suit));
	}
	
	public static boolean hasSameRank(Card... cards) {
		Rank first = cards[0].rank;

		return !Arrays.stream(cards).anyMatch(card -> card.rank != first);
	}

	public static int isConsective(int start, int end, Card... cards) {
		for (int i = start + 1; i <= end; i++) {
			if (cards[i].rank.ordinal() - cards[i - 1].rank.ordinal() != 1)
				return i - 1;
		}
		return -1;
	}

	Rank rank;
	Suit suit;

	Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public boolean isThree() {
		return rank == Rank.three;
	}
	
	public boolean isTwo() {
		return rank == Rank.two;
	}
	
	@Override
	public String toString() {
		return String.format("%s[%s]", suit, rank);
	}

	@Override
	public int compareTo(Card o) {
		if (rank != o.rank) {
			return rank.compareTo(o.rank);
		}
		return suit.compareTo(o.suit);
	}

	public boolean isClubThree() {
		return rank == Rank.three && suit == Suit.club;
	}
	
}
