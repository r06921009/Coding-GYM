package Big2;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Big2 {
	final static Action PASS = new Action();
	final static List<CardPatternEvaluate> sEvals = new ArrayList<>();
	FirstRound clubThreeRound;
	FirstRound firstRound;
	NormalRound normalRound;
	OverRound overRound;
	// private final static Scanner scanner = new Scanner(System.in);
	public static final String TESTCASES_DIR = "testcases";
	private static Scanner scanner;
	
	
	static {
		register(new SinglePatternEvaluate());
		register(new PairPatternEvaluate());
		register(new FullHouseEvaluate());
		register(new StraightPatternEvaluate());
		try {
			scanner = new Scanner(new File("test.in"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static void register(CardPatternEvaluate eval) {
		sEvals.add(eval);
	}
	
	Deck deck = new Deck();
	Round curRound;
	List<Player> players = new ArrayList<>();
	
	Player curPlayer;
	Iterator<Player> playerIter;

	
	Big2() {
		clubThreeRound = new FirstRound(this);
		firstRound = new FirstRound(this);
		normalRound = new NormalRound(this);
		overRound = new OverRound(this);
		curRound = clubThreeRound;
		clubThreeRound.setConstraint(CardPattern::hasClubThree);
		init();
	}
	
	private void init() {
		prepareCard();
		preparePlayer();
		dealCard();	
		preparePlayerOrder();
	}

	private void preparePlayer() {
		for(int i = 0; i < 4; i++)
			players.add(new Player(scanner.nextLine()));	
	}

	private void preparePlayerOrder() {
		playerIter = players.iterator();
		for(int i = 0; i < players.size(); i++) {
			if(players.get(i) == curPlayer)
				return;
			else
				playerIter.next();
		}
		
	}
	
	private void dealCard() {
		int idx = 0; 
		int size = players.size();
		while(deck.hasNext()) {
			Card card = deck.deal();
			if(card.isClubThree()) {
				curPlayer = players.get(idx%size);
			}
			players.get(idx%size).addCard(card);;
			idx++;
		}
	}

	private void prepareCard() {
		//deck.generateDeck();	
		getDeckFromString(scanner.nextLine());
	}

	private void getDeckFromString(String s) {
		Stack<Card> stack = new Stack<>(); 
		Arrays.stream(s.split(" ")).map(Card::getCardFromString).forEach(stack::push);
		deck.setCards(stack);
	}
	
	void start() {
		System.out.println("New round begins.");
		nextPlayer();
		while(curRound != overRound) {
			curPlayer.printCard();
			curRound.takeAction(takeAction(), curPlayer);
		}
		System.out.println(String.format("Game over, the winner is %s.", curPlayer.getName()));
	}
	
	private Action takeAction() {
		String action = scanner.nextLine();
		if(action.equals("-1") || action.toLowerCase().equals("pass"))
			return PASS;
		else
			return getCardAction(action);
	}

	private Action getCardAction(String action) {
		return curPlayer.action(Arrays.stream(action.split(" "))
			    .mapToInt(Integer::parseInt).sorted()
			    .toArray());
	}

	void setRound(Round round) {
		curRound = round;
	}
	
	Player nextPlayer() {
		if(curPlayer.cardOut()) {
			setRound(overRound);
			return null;
		}
		if(!playerIter.hasNext()) {
			playerIter = players.iterator();
		} 
		curPlayer = playerIter.next();
		System.out.println(String.format("Next turn: %s", curPlayer.getName()));
		return curPlayer;
	}

	public FirstRound getClubThreeRound() {
		return clubThreeRound;
	}

	public FirstRound getFirstRound() {
		return firstRound;
	}

	public NormalRound getNormalRound() {
		return normalRound;
	}
	
	
}
