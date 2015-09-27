package expeditionCards;

import gamestate.ExpeditionCard;
import gamestate.Game;
import helpers.CardType;

public class Explorer implements ExpeditionCard {

	@Override
	public String getName() {
		return "Explorer";
	}

	@Override
	public String getDescription() {
		return "Gain a Walk card.";
	}

	@Override
	public CardType getType() {
		return CardType.ACTION;
	}

	@Override
	public void play() {
		Game.gainCard(new Walk());
	}

	@Override
	public int getCost() {
		return 4;
	}

	@Override
	public ExpeditionCard create() {
		return new Explorer();
	}

}
