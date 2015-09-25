package gamestate;

import java.util.ArrayList;
import helpers.CardType;

public class Turn {

	public static void conductTurn(){
		// play event
		Game.playEvent();
		
		
		if (Game.getRations() == 0){
			
		}
		//change rations
		Game.changeRations(-1);
	}
	
	public static void playActions(){
		while (Game.getActions() > 0 && Game.getCardsOfTypeInHand(CardType.ACTION).size() > 0){
			ArrayList<ExpeditionCard> possibleCards = Game.getCardsOfTypeInHand(CardType.ACTION);
			ArrayList<String> options = new ArrayList<>();
			for (ExpeditionCard ec : possibleCards){
				
			}
		}
	}
}
