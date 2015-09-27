package eventCards;

import expeditionCards.Injury;
import gamestate.EventCard;
import gamestate.Game;

public class Fall implements EventCard {

	@Override
	public String getName() {
		return "Fall";
	}

	@Override
	public String getDescription() {
		return "Gain 1 Injury.";
	}

	@Override
	public void playEvent() {
		Game.gainCard(new Injury());
	}

}
