package expeditionCards;

import gamestate.ExpeditionCard;
import gamestate.Game;
import helpers.CardType;

public class Captain implements ExpeditionCard {

	@Override
	public String getName() {
		return "Captain";
	}

	@Override
	public String getDescription() {
		return "+2 actions. +1 card.";
	}

	@Override
	public CardType getType() {
		return CardType.ACTION;
	}

	@Override
	public void play() {
		Game.drawCard();
		Game.gainAction();
		Game.gainAction();
	}

	@Override
	public int getCost() {
		return 3;
	}

	@Override
	public ExpeditionCard create() {
		return new Captain();
	}

}
