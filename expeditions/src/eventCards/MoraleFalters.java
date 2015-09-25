package eventCards;

import gamestate.EventCard;
import gamestate.Game;

public class MoraleFalters implements EventCard {

	@Override
	public String getName() {
		return "Morale Dips";
	}

	@Override
	public String getDescription() {
		return "Morale -3.";
	}

	@Override
	public void playEvent() {
		Game.changeMorale(-3);
		
	}

}
