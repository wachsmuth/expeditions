package expeditionCards;

import gamestate.ExpeditionCard;
import gamestate.Game;
import helpers.CardType;
import helpers.Die;

public class Injury implements ExpeditionCard{
	
	private int severity;
	
	public Injury(){
		severity = 0;
	}
	
	public Injury(int severity){
		if (this.severity >= 0 && this.severity <= 1){
			severity = this.severity;
		}
		else {
			severity = 0;
		}
	}

	@Override
	public String getName() {
		if (severity == 0){
			return "Injury";
		}
		return "Severe Injury";
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
		if (severity < 1){
			if (Die.rollDie() < 3){
				severity++;
				System.out.println("The injury gets worse!");
			}
			else {
				System.out.println("The injury remains in stable condition.");
			}
		}
		else {
			if (Die.rollDie() < 3){
				severity++;
				System.out.println("The injury is lethal!");
				Game.killCharacter();
				Game.trashCard(this);
			}
			else {
				System.out.println("The injury remains in stable condition.");
			}
		}
	}

	@Override
	public int getCost() {
		return 0;
	}

	@Override
	public ExpeditionCard create() {
		return new Injury();
	}

}
