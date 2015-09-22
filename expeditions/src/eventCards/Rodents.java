package eventCards;

import gamestate.EventCard;
import gamestate.Game;

public class Rodents implements EventCard {

	@Override
	public String getName() {
		return "Rodents";
	}

	@Override
	public String getDescription() {
		return "Rations -2";
	}

	@Override
	public void playEvent() {
		Game.changeRations(-2);
		
	}

}
