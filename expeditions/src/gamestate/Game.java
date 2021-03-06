package gamestate;

import helpers.CardType;
import helpers.InputLoop;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

	private static int morale = 0;
	private static int rations = 0;
	private static int appeal = 0;
	private static int actions = 0;
	private static int travel = 0;
	private static Deck<EventCard> eventDeck = new Deck<EventCard>();
	private static Deck<EventCard> eventDiscardPile = new Deck<EventCard>();
	private static Deck<ExpeditionCard> expeditionDeck = new Deck<>();
	private static Deck<ExpeditionCard> expeditionDiscardPile = new Deck<>();
	private static ArrayList<ExpeditionCard> hand = new ArrayList<>();
	private static ArrayList<ExpeditionCard> cardsInPlay = new ArrayList<>();

	public Game() {

	}
	
	

	public static ArrayList<ExpeditionCard> getCardsInPlay() {
		return cardsInPlay;
	}



	public static void setCardsInPlay(ArrayList<ExpeditionCard> cardsInPlay) {
		Game.cardsInPlay = cardsInPlay;
	}



	public static EventCard drawFromEventDeck() {
		if (eventDeck.isEmpty()) {
			Deck<EventCard> swap = eventDeck;
			eventDeck = eventDiscardPile;
			eventDiscardPile = swap;
			eventDeck.shuffle();
		}
		EventCard c = eventDeck.getTopCard();
		return c;
	}

	public static void gainCard(ExpeditionCard e) {
		expeditionDiscardPile.addCard(e);
	}

	public static void playEvent() {
		EventCard c = drawFromEventDeck();
		System.out.println("Event played: " + c.getName() + ": "
				+ c.getDescription());
		c.playEvent();
		eventDeck.removeCard(c);
		eventDiscardPile.addCard(c);
	}

	public static void printState() {
		System.out.println("Morale: " + morale + " Rations: " + rations
				+ " Appeal: " + appeal + " Travel: " + travel);
	}

	public static void printHand() { // prints entire contents of hand on a
										// single line
		ArrayList<String> strings = new ArrayList<>();

		for (ExpeditionCard c : hand) {
			strings.add(c.getName());
		}
		Collections.sort(strings); // if multiples exist, print those

		System.out.print("Your hand:");
		for (int i = 0; i < strings.size(); i++) {
			int j = i;
			int count = 0;
			while (j < strings.size() && strings.get(i).equals(strings.get(j))) {
				count++;
				j++;
			}
			if (count > 1) {
				System.out.print(" " + count + "x");
			}
			System.out.print(" " + strings.get(i));
			i = j - 1;
			if (strings.size() > j) {
				System.out.print(",");
			}
		}
		System.out.println("");
	}

	public static void drawCard() {
		if (expeditionDeck.getSize() > 0) {
			ExpeditionCard c = expeditionDeck.getTopCard();
			expeditionDeck.removeCard(c);
			hand.add(c);
			System.out.println("Card drawn: " + c.getName() + " - " + c.getDescription());
		} else if (expeditionDiscardPile.getSize() > 0) {
			System.out.println("The expedition deck is reshuffled.");
			expeditionDeck = expeditionDiscardPile;
			expeditionDeck.shuffle();
			expeditionDiscardPile = new Deck<>();
			drawCard();
		}
	}

	
	
	public static ArrayList<ExpeditionCard> getHand() {
		return hand;
	}

	public static void discardHand() {
		for (ExpeditionCard e : hand) {
			expeditionDiscardPile.addCard(e);
		}
		hand = new ArrayList<>();
	}

	public static void discardCardsOfTypeInPlay(CardType ct) {
		ArrayList<ExpeditionCard> cardsToDiscard = new ArrayList<>();
		for (ExpeditionCard e : cardsInPlay) {
			if (e.getType() == ct) {
				cardsToDiscard.add(e);
				
			}
		}
		for (ExpeditionCard e : cardsToDiscard) {
				expeditionDiscardPile.addCard(e);
				cardsInPlay.remove(e);

		}
	}

	public static void discardSpecificCard(ExpeditionCard c) {
		hand.remove(c);
		expeditionDiscardPile.addCard(c);
	}
	
	public static void trashCard(ExpeditionCard c){
		expeditionDeck.removeCard(c);
		expeditionDiscardPile.removeCard(c);
		hand.remove(c);
		cardsInPlay.remove(c);
	}

	public static void addCardToPlay(ExpeditionCard c) {
		hand.remove(c);
		cardsInPlay.add(c);
	}

	public static void setup() { // setup start of game
		setRations(10);
		setMorale(10);
		appeal = 10;
		InitialSetup.createDeck();
		InitialSetup.createPurchases();
		eventDeck = InitialSetup.createEventDeck();
		for (int i = 0; i < 5; i++) {
			drawCard();
		}
		printState();
		printHand();
		Turn.conductTurn();
	}

	public static void gainAction() {
		actions = actions + 1;
	}

	public static void loseAction() {
		actions = -1;
		if (actions < 0) {
			actions = 0;
		}
	}

	public static void modifyActions(int change) {
		actions = actions + change;
		if (actions < 0) {
			actions = 0;
		}
	}

	public static int getActions() {
		return actions;
	}

	public static void setActions(int a) {
		actions = Math.max(0, a);
	}

	public static void printActions() {
		System.out.println("Actions: " + actions);
	}

	public static void setMorale(int i) {
		morale = i;
	}

	public static int getRations() {
		return rations;
	}

	public static void setRations(int rations) {
		Game.rations = rations;
	}

	public static int getMorale() {
		return morale;
	}

	
	
	public static int getAppeal() {
		return appeal;
	}

	public static void setAppeal(int appeal) {
		Game.appeal = appeal;
	}

	public static int getTravel() {
		return travel;
	}

	public static boolean addTravel(int change) {
		if (change > 0){
			travel = travel + change;
		}
		return false;
	}

	public static boolean changeMorale(int change) {
		morale = morale + change;
		if (morale < 0) {
			morale = 0;
			return false;
		}
		return true;
	}
	
	public static boolean changeAppeal(int change) {
		appeal = appeal + change;
		if (appeal < 0) {
			appeal = 0;
			return false;
		}
		return true;
	}

	public static ArrayList<ExpeditionCard> getCardsOfTypeInHand(CardType ct) {
		ArrayList<ExpeditionCard> list = new ArrayList<>();
		for (ExpeditionCard ec : hand) {
			if (ec.getType() == ct) {
				list.add(ec);
			}
		}
		return list;
	}
	
	public static ArrayList<ExpeditionCard> getCardsOfTypeInDiscard(CardType ct) {
		ArrayList<ExpeditionCard> list = new ArrayList<>();
		for (ExpeditionCard ec : expeditionDiscardPile.getDeck()) {
			if (ec.getType() == ct) {
				list.add(ec);
			}
		}
		return list;
	}
	
	public static void killCharacter(){ //choose a character from the discard pile. This character dies and is removed from the game.
		if (getCardsOfTypeInDiscard(CardType.ACTION).size() > 0){
			int i = (InputLoop.inputLoop("Choose a character to die.", getCardsOfTypeInDiscard(CardType.ACTION)));
			trashCard(getCardsOfTypeInDiscard(CardType.ACTION).get(i));
		}
		else {
			System.out.println("Miraculously, no one dies!");
		}
	}

	public static Boolean changeRations(int change) {
		rations = rations + change;
		if (rations < 0) {
			rations = 0;
			return false;
		}
		return true;
	}

	public static Boolean changeTravel(int change) {
		travel = travel + change;
		if (travel < 0) {
			travel = 0;
			return false;
		}
		return true;
	}
}
