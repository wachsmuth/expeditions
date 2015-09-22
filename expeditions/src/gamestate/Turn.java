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
}
