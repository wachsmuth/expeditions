package gamestate;

import eventCards.MoraleFalters;
import eventCards.Respite;
import eventCards.Rodents;
import expeditionCards.Porter;
import expeditionCards.Walk;

public class InitialSetup {

	public static void createDeck(){
		Game.gainCard(new Porter());
		Game.gainCard(new Porter());
		Game.gainCard(new Porter());
		Game.gainCard(new Porter());
		Game.gainCard(new Walk());
		Game.gainCard(new Walk());
		Game.gainCard(new Walk());
		Game.gainCard(new Walk());
		Game.gainCard(new Walk());
	}
	
	public static Deck<EventCard> createEventDeck(){
		Deck<EventCard> deck = new Deck<>();
		deck.addCard(new MoraleFalters());
		deck.addCard(new Respite());
		deck.addCard(new Respite());
		deck.addCard(new Rodents());
		return deck;
	}
	
}
