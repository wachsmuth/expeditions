package eventCards;

import gamestate.EventCard;

public class Respite implements EventCard {

	@Override
	public String getName() {
		return "Respite";
	}

	@Override
	public String getDescription() {
		return "No effect.";
	}

	@Override
	public void playEvent() {
		
	}

}
