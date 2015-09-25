package gamestate;

import helpers.CardType;

import java.util.ArrayList;

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
	private static Deck<ExpeditionCard> hand = new Deck<>();

	public Game(){
		
	}
	
	public static EventCard drawFromEventDeck(){
		if (eventDeck.isEmpty()){
			Deck<EventCard> swap = eventDeck;
			eventDeck = eventDiscardPile;
			eventDiscardPile = swap;
			eventDeck.shuffle();
		}
		EventCard c = eventDeck.getTopCard();
		return c;
	}
	
	public static void gainCard(ExpeditionCard e){
		expeditionDiscardPile.addCard(e);
	}
	
	public static void playEvent(){
		EventCard c = drawFromEventDeck();
		c.playEvent();
		eventDeck.removeCard(c);
		eventDiscardPile.addCard(c);
	}
	
	public static void printState(){
		System.out.println("Morale: " + morale + " Rations: " + rations + " Appeal: " + appeal + " Travel: " + travel);
	}
	
	public static void printHand(){
		for (Object c : hand){
			System.out.println(((Card) c).getName());
		}
	}
	
	public static void setup(){
		setRations(10);
		setMorale(10);
		printState();
		Turn.conductTurn();
	}

	public static void gainAction(){
		actions =+ actions;
	}
	
	public static int getActions(){
		return actions;
	}
	
	public static void setActions(int a){
		actions = Math.max(0, a);
	}
	
	public static void printActions(){
		System.out.println("Actions: " + actions);
	}
	
	public static void setMorale(int i){
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

	public static Boolean changeMorale(int change){
		morale = morale + change;
		if (morale < 0){
			morale = 0;
			return false;
		}
		return true;
	}
	
    public static ArrayList<ExpeditionCard> getCardsOfTypeInHand(CardType ct){
    	ArrayList<ExpeditionCard> list = new ArrayList<>();
    	for (ExpeditionCard ec : hand.getDeck()){
    		if (ec.getType() == ct){
    			list.add(ec);
    		}
    	}
    	return list;
    }
	
	public static Boolean changeRations(int change){
		rations = rations + change;
		if (rations < 0){
			rations = 0;
			return false;
		}
		return true;
	}
	
	public static Boolean changeTravel(int change){
		travel = travel + change;
		if (travel < 0){
			travel = 0;
			return false;
		}
		return true;
	}
}
