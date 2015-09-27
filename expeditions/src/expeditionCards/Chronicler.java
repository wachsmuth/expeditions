package expeditionCards;

import gamestate.ExpeditionCard;
import gamestate.Game;
import helpers.CardType;

public class Chronicler implements ExpeditionCard {

	@Override
	public String getName() {
		return "Chronicler";
	}

	@Override
	public String getDescription() {
		return "Gain 1 Appeal for each event in play (including this one).";
	}

	@Override
	public CardType getType() {
		return CardType.ACTION;
	}

	@Override
	public void play() {
		Game.changeAppeal(Game.getCardsInPlay().size());
	}

	@Override
	public int getCost() {
		return 4;
	}

	@Override
	public ExpeditionCard create() {
		return new Chronicler();
	}

}
