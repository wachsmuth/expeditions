package expeditionCards;

import gamestate.ExpeditionCard;
import gamestate.Game;
import helpers.CardType;
import helpers.Die;

public class Illness implements ExpeditionCard{
	
	private int severity;
	
	public Illness(){
		severity = 0;
	}
	
	public Illness(int severity){
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
			return "Illness";
		}
		return "Severe Illness";
	}

	@Override
	public String getDescription() {
		if (severity == 0){
			return "Roll a die. On 1, add another Ilness card to the deck. On 2-3, replace this card with Severe Illness. On 4-5, remove this card.";
		}
		else {
			return "Roll a die. On 1-2, one character dies. On 3-4, gain 1 Illness. On 5, replace this card with Illness.";
		}
	}

	@Override
	public CardType getType() {
		return CardType.TROUBLE;
	}

	@Override
	public void play() {
		int die = Die.rollDie();
		if (severity < 1){
			if (die == 1){
				System.out.println("The disease is spreading!");
				Game.gainCard(new Illness());
			}
			else if (die < 4){
				System.out.println("The illness worsens.");
				severity++;
			}
			else if (die < 6){
				Game.trashCard(this);
				System.out.println("The illness is miraculously cured!");
			}
			else {
				System.out.println("The illness remains stable");
			}
		}
		else {
			if (die < 3){
				System.out.println("The illness is lethal!");
				Game.killCharacter();
				Game.trashCard(this);
			}
			else if (die < 5){
				System.out.println("The illness spreads!");
				Game.gainCard(new Illness());				
			}
			else if (die == 5){
				System.out.println("The illness is getting in better condition.");
				severity--;
			}
			else {
				System.out.println("The illness remains stable");
			}
		}
	}

	@Override
	public int getCost() {
		return 0;
	}

	@Override
	public ExpeditionCard create() {
		return new Illness();
	}

}
