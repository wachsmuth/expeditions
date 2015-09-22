package gamestate;

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
	
}
