package expeditionCards;

import gamestate.ExpeditionCard;
import gamestate.Game;
import helpers.CardType;

public class Trapper implements ExpeditionCard {

	@Override
	public String getName() {
		return "Trapper";
	}

	@Override
	public String getDescription() {
		return "+4 rations";
	}

	@Override
	public CardType getType() {
		return CardType.ACTION;
	}

	@Override
	public void play() {
		Game.changeRations(4);
	}

	@Override
	public int getCost() {
		return 5;
	}

	@Override
	public ExpeditionCard create() {
		return new Trapper();
	}

}
