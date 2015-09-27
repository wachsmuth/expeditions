package gamestate;

import helpers.InputLoop;
import helpers.ShopBias;
import helpers.ShopItem;

import java.util.ArrayList;

public class Purchase {

	private final static ArrayList<ShopItem> characters = new ArrayList<>();
	private static boolean shopTurn = false;
	private static ArrayList<ExpeditionCard> shop = new ArrayList<>();

	public static void addShopItem(ShopBias bias, int weight,
			ExpeditionCard character) {
		characters.add(new ShopItem(bias, weight, character));
	}

	public static void shopRandomItems(ShopBias bias, int amount) {
		for (int i = 0; i < amount; i++) {
			shop.add(chooseRandomItem(bias).getCharacter());
		}
		buyStuff();
	}

	private static ShopItem chooseRandomItem(ShopBias bias) {
		int totalSeed = 0;
		ArrayList<ShopItem> fittingBias = new ArrayList<>();

		for (ShopItem s : characters) {
			if (bias == ShopBias.BOTH) {
				totalSeed = totalSeed + s.getWeight();
				fittingBias.add(s);
			}
			else {
				if (bias == s.getBias() || s.getBias() == ShopBias.BOTH){
					totalSeed = totalSeed + s.getWeight();
					fittingBias.add(s);
				}
			}
		}
		int seed = (int) Math.ceil(Math.random() * totalSeed);
		int count = 0;
		for (ShopItem s : fittingBias) {
			count = count + s.getWeight();
			if (count >= seed) {
				return s;
			}
		}
		// This code should never be reached
		return null;
	}

	public static boolean isShopTurn() {
		return shopTurn;
	}

	public static void setShopTurn(boolean shopTurn) {
		Purchase.shopTurn = shopTurn;
	}

	public static void buyStuff() {
		boolean shoppingTime = true;
		while (shop.size() > 0 && shoppingTime) {
			ArrayList<ExpeditionCard> possibleCards = shop;
			ArrayList<String> options = new ArrayList<>();
			for (ExpeditionCard ec : possibleCards) {
				if (Game.getAppeal() >= ec.getCost()) { // ensure that we can
														// afford it
					options.add(ec.getName() + " (" + ec.getCost() + ") "
							+ " - " + ec.getDescription());
				}
			}
			options.add("End buy phase.");
			int userInput = InputLoop.inputLoop(
					"Choose a card to purchase or end buy phase.", options);
			if (userInput == options.size() - 1) {
				shoppingTime = false;
			} else {
				ExpeditionCard c = possibleCards.get(userInput);
				Game.changeAppeal(-c.getCost());
				possibleCards.remove(c);
				Game.gainCard(c.create());
				Game.printState();
			}
		}
		System.out.println("Buy phase is over.");
		shop = new ArrayList<>();
	}

}
