package eventCards;

import expeditionCards.Illness;
import gamestate.EventCard;
import gamestate.Game;

public class Fever implements EventCard {

	@Override
	public String getName() {
		return "Fever";
	}

	@Override
	public String getDescription() {
		return "Gain 1 Illness.";
	}

	@Override
	public void playEvent() {
		Game.gainCard(new Illness());
		
	}

}
