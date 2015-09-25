package expeditionCards;

import gamestate.ExpeditionCard;
import gamestate.Game;
import helpers.CardType;

public class Walk implements ExpeditionCard{

	@Override
	public String getName() {
		return "Walk";
	}

	@Override
	public String getDescription() {
		return "Travel 1";
	}

	@Override
	public CardType getType() {
		return CardType.TRAVEL;
	}

	@Override
	public void play() {
		Game.changeTravel(1);
	}

	@Override
	public int getCost() {
		return 0;
	}

}
