package eventCards;

import expeditionCards.Illness;
import gamestate.EventCard;
import gamestate.Game;

public class Mosquitoes implements EventCard {

	@Override
	public String getName() {
		return "Mosquitoes";
	}

	@Override
	public String getDescription() {
		return "Gain 3 Illness.";
	}

	@Override
	public void playEvent() {
		Game.gainCard(new Illness());
		Game.gainCard(new Illness());
		Game.gainCard(new Illness());
	}

}
