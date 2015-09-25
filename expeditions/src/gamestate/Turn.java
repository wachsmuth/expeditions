package gamestate;

import java.util.ArrayList;
import helpers.CardType;
import helpers.InputLoop;

public class Turn {

	public static void conductTurn(){
		// play event
		Game.playEvent();
		
		
		if (Game.getRations() == 0){
			
		}
		//change rations at end of turn
		Game.changeRations(-1);
	}
	
	/*
	 * Method that allows playing actions until no more can be played
	 */
	public static void playActions(){
		while (Game.getActions() > 0 && Game.getCardsOfTypeInHand(CardType.ACTION).size() > 0){
			ArrayList<ExpeditionCard> possibleCards = Game.getCardsOfTypeInHand(CardType.ACTION);
			ArrayList<String> options = new ArrayList<>();
			for (ExpeditionCard ec : possibleCards){
				options.add(ec.getName());
			}
			options.add("End actions.");
			InputLoop.inputLoop("Choose a card to play or end actions.", options);
		}
	}
}
