package gamestate;

import helpers.CardType;

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
		System.out.println("Event played: " + c.getName() + ": " + c.getDescription());
		c.playEvent();		
		eventDeck.removeCard(c);
		eventDiscardPile.addCard(c);
	}

	public static void printState() {
		System.out.println("Morale: " + morale + " Rations: " + rations
				+ " Appeal: " + appeal + " Travel: " + travel);
	}

	public static void printHand() { //prints entire contents of hand on a single line
		ArrayList<String> strings = new ArrayList<>();

		for (ExpeditionCard c : hand) {
			strings.add(c.getName());
		}
		Collections.sort(strings); //if multiples exist, print those
		
		System.out.print("Your hand:");
		for (int i = 0; i < strings.size(); i++){
			int j = i;
			int count = 0;
			while (j < strings.size() && strings.get(i).equals(strings.get(j))){
				count++;
				j++;
			}
			if (count > 1){
				System.out.print(" " + count + "x");
			}
			System.out.print(" " + strings.get(i));
			i = j-1;
			if (strings.size() > j){
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
			System.out.println(c.getName() + " drawn");
		} else if (expeditionDiscardPile.getSize() > 0) {
			System.out.println("The expedition deck is reshuffled.");
			expeditionDeck = expeditionDiscardPile;
			expeditionDeck.shuffle();
			expeditionDiscardPile = new Deck<>();
			drawCard();
		}		
	}

	public static void discardHand() {
		for (ExpeditionCard e : hand) {
			expeditionDiscardPile.addCard(e);
		}
		hand = new ArrayList<>();
	}

	public static void discardSpecificCard(ExpeditionCard c) {
		hand.remove(c);
		expeditionDiscardPile.addCard(c);
	}

	public static void setup() { // setup start of game
		setRations(10);
		setMorale(10);
		appeal = 10;
		InitialSetup.createDeck();
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

	public static Boolean changeMorale(int change) {
		morale = morale + change;
		if (morale < 0) {
			morale = 0;
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
