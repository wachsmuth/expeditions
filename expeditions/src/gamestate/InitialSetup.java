package gamestate;

import helpers.ShopBias;
import eventCards.MoraleFalters;
import eventCards.NativeVillage;
import eventCards.Respite;
import eventCards.Rodents;
import eventCards.Snakebite;
import expeditionCards.ExpeditionLeader;
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
		Game.gainCard(new ExpeditionLeader());
	}
	
	public static Deck<EventCard> createEventDeck(){
		Deck<EventCard> deck = new Deck<>();
		deck.addCard(new MoraleFalters());
		deck.addCard(new Respite());
		deck.addCard(new Respite());
		deck.addCard(new Rodents());
		deck.addCard(new Snakebite());
		deck.addCard(new MoraleFalters());
		deck.addCard(new Rodents());
		deck.addCard(new NativeVillage());
		
		deck.shuffle();
		return deck;
	}
	
	public static void createPurchases(){
		Purchase.addShopItem(ShopBias.NATIVE, 20, new Porter());
	}
}
