package eventCards;

import gamestate.EventCard;
import gamestate.Game;
import expeditionCards.Poison;

public class Snakebite implements EventCard {

	@Override
	public String getName() {
		return "Snakebite";
	}

	@Override
	public String getDescription() {
		return "Gain 1 Mild Poisoning.";
	}

	@Override
	public void playEvent() {
		Game.gainCard(new Poison());
		
	}

}
