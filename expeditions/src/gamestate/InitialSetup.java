package gamestate;

import helpers.ShopBias;
import eventCards.Fall;
import eventCards.Fever;
import eventCards.MoraleFalters;
import eventCards.Mosquitoes;
import eventCards.NativeVillage;
import eventCards.Respite;
import eventCards.Rodents;
import eventCards.Snakebite;
import eventCards.SpanishOutpost;
import expeditionCards.Captain;
import expeditionCards.Chronicler;
import expeditionCards.ExpeditionLeader;
import expeditionCards.Explorer;
import expeditionCards.Hunter;
import expeditionCards.Porter;
import expeditionCards.Recruiter;
import expeditionCards.Trapper;
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
		deck.addCard(new Fall());
		deck.addCard(new Fall());
		deck.addCard(new Fall());
		deck.addCard(new Fever());
		deck.addCard(new Fever());
		deck.addCard(new Fever());
		deck.addCard(new Mosquitoes());
		deck.addCard(new Mosquitoes());
		deck.addCard(new NativeVillage());
		deck.addCard(new SpanishOutpost());
		
		deck.shuffle();
		return deck;
	}
	
	public static void createPurchases(){
		Purchase.addShopItem(ShopBias.NATIVE, 20, new Porter());
		Purchase.addShopItem(ShopBias.BOTH, 4, new Explorer());
		Purchase.addShopItem(ShopBias.BOTH, 5, new Hunter());
		Purchase.addShopItem(ShopBias.NATIVE, 6, new Trapper());
		Purchase.addShopItem(ShopBias.EUROPEAN, 10, new Captain());
		Purchase.addShopItem(ShopBias.BOTH, 4, new Recruiter());
		Purchase.addShopItem(ShopBias.EUROPEAN, 2, new Chronicler());
	}
}
