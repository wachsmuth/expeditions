package gamestate;

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
		while (Game.getActions > 0 && Game.getCardsOfTypeInHand(Action) > 0){
			ArrayList<String> options = new ArrayList<>();
		}
	}
}
