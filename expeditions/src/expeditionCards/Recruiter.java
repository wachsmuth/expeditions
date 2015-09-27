package expeditionCards;

import gamestate.ExpeditionCard;
import gamestate.Game;
import helpers.CardType;

public class Recruiter implements ExpeditionCard {

	@Override
	public String getName() {
		return "Recruiter";
	}

	@Override
	public String getDescription() {
		return "+2 appeal";
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
		return new Recruiter();
	}

}
