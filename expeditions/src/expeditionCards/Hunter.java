package expeditionCards;

import gamestate.ExpeditionCard;
import gamestate.Game;
import helpers.CardType;

public class Hunter implements ExpeditionCard {

	@Override
	public String getName() {
		return "Hunter";
	}

	@Override
	public String getDescription() {
		return "+2 rations";
	}

	@Override
	public CardType getType() {
		return CardType.ACTION;
	}

	@Override
	public void play() {
		Game.changeRations(2);
	}

	@Override
	public int getCost() {
		return 3;
	}

	@Override
	public ExpeditionCard create() {
		return new Hunter();
	}

}
