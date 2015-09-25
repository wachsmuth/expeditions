package expeditionCards;

import gamestate.ExpeditionCard;
import gamestate.Game;
import helpers.CardType;

public class Porter implements ExpeditionCard {

	@Override
	public String getName() {
		return "Porter";
	}

	@Override
	public String getDescription() {
		return "+2 actions";
	}

	@Override
	public CardType getType() {
		return CardType.ACTION;
	}

	@Override
	public void play() {
		Game.gainAction();
		Game.gainAction();
	}

	@Override
	public int getCost() {
		return 1;
	}

}
