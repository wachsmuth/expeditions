package gamestate;

import helpers.CardType;

public interface ExpeditionCard extends Card{

	public CardType getType();
	
	public void play();
	
	public int getCost();
	
	public ExpeditionCard create();
}
