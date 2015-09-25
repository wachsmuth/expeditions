package gamestate;

import java.util.ArrayList;
import helpers.CardType;
import helpers.InputLoop;

public class Turn {

	public static void conductTurn(){
		// play event
		Game.playEvent();
		// play hand
		Game.setActions(1);
		playActions();
		Game.discardCardsOfTypeInPlay(CardType.ACTION);
		if (Game.getRations() == 0){
			//TODO
		}
		
		Game.changeRations(-1); //change rations at end of turn
		System.out.println("The expedition members consume 1 ration.");
		Game.printState();
		Game.discardHand();
		System.out.println("Hand discarded");
		for (int i = 0; i < 5; i++){
			Game.drawCard();
		}
		conductTurn();
	}
	
	/*
	 * Method that allows playing actions until no more can be played
	 */
	public static void playActions(){
		while (Game.getActions() > 0 && Game.getCardsOfTypeInHand(CardType.ACTION).size() > 0){
			ArrayList<ExpeditionCard> possibleCards = Game.getCardsOfTypeInHand(CardType.ACTION);
			ArrayList<String> options = new ArrayList<>();
			for (ExpeditionCard ec : possibleCards){
				options.add(ec.getName() + " - " + ec.getDescription());
			}
			options.add("End actions.");
			int userInput = InputLoop.inputLoop("Choose a card to play or end actions.", options);
			if (userInput == options.size()-1){
				Game.setActions(0);
			}
			else {
				ExpeditionCard c = possibleCards.get(userInput);
				c.play();
				Game.addCardToPlay(c);
				Game.modifyActions(-1);
				Game.printState();
			}
		}
		System.out.println("Action phase is over.");
	}
}
