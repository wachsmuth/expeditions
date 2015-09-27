package expeditionCards;

import gamestate.ExpeditionCard;
import gamestate.Game;
import helpers.CardType;
import helpers.InputLoop;

import java.util.ArrayList;

public class ExpeditionLeader implements ExpeditionCard {

	private final String trash = "Trash a card on your hand.";
	private final String walk = "Gain 1 Walk card.";
	private final String rations = "+1 rations.";
	private final String appeal = "+1 appeal.";
	private final String morale = "+1 morale";
	private final String action = "+1 action.";

	@Override
	public String getName() {
		return "Expedition Leader";
	}

	@Override
	public String getDescription() {
		return "Choose 2: Trash any card on your hand, gain Walk card, +1 rations, +1 appeal, +1 morale, +1 action.";
	}

	@Override
	public CardType getType() {
		return CardType.ACTION;
	}

	@Override
	public void play() {
		ArrayList<String> options = new ArrayList<>();
		options.add(trash);
		options.add(walk);
		options.add(rations);
		options.add(appeal);
		options.add(morale);
		options.add(action);
		for (int i = 0; i < 2; i++) {
			System.out.println("Choose " + (2 - i));
			String choice = InputLoop.inputLoop(options);
			options.remove(choice);
			if (choice.equals(trash)){
				Game.trashCard(InputLoop.cardInputLoop("Choose a card to trash.", Game.getHand()));
			}
			else if (choice.equals(walk)){
				Game.gainCard(new Walk());
			}
			else if (choice.equals(rations)) {
				Game.changeRations(1);
			}
			else if (choice.equals(appeal)){
				Game.changeAppeal(1);
			}
			else if (choice.equals(morale)){
				Game.changeMorale(1);
			}
			else if (choice.equals(action)){
				Game.gainAction();
			}
		}
	}

	@Override
	public int getCost() {
		return 8;
	}

	@Override
	public ExpeditionCard create() {
		return new ExpeditionLeader();
		
	}

}
