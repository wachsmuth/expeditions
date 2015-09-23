package eventCards;

import gamestate.EventCard;
import gamestate.Game;

public class MoraleFalters implements EventCard {

	@Override
	public String getName() {
		return "Morale Falters";
	}

	@Override
	public String getDescription() {
		return "Morale -2.";
	}

	@Override
	public void playEvent() {
		Game.changeMorale(-2);
		
	}

}
