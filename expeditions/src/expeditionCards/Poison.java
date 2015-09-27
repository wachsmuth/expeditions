package expeditionCards;

import gamestate.ExpeditionCard;
import gamestate.Game;
import helpers.CardType;

public class Poison implements ExpeditionCard{
	
	private int severity;
	
	public Poison(){
		
	}
	
	public Poison(int severity){
		if (this.severity >= 0 && this.severity <= 2){
			severity = this.severity;
		}
		else {
			severity = 0;
		}
	}

	@Override
	public String getName() {
		if (severity == 0){
			return "Mild Poisoning";
		}
		else if (severity == 1){
			return "Moderate Poisoning";
		}
		return "Severe Poisoning";
	}

	@Override
	public String getDescription() {
		if (severity == 0){
			return "Replace this card with Moderate Poisoning.";
		}
		else if (severity == 1){
			return "Replace this card with Severe Poisoning.";
		}
		return "One character dies.";
	}

	@Override
	public CardType getType() {
		return CardType.TROUBLE;
	}

	@Override
	public void play() {
		if (severity < 2){
			severity++;
			System.out.println("The poisoning gets worse!");
		}
		else {
			System.out.println("The poisoning is lethal!");
			Game.killCharacter();
			Game.trashCard(this);
		}
	}

	@Override
	public int getCost() {
		return 0;
	}

	@Override
	public ExpeditionCard create() {
		return new Poison();
	}

}
