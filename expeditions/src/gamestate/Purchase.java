package gamestate;

import helpers.CardType;
import helpers.InputLoop;
import helpers.ShopBias;
import helpers.ShopItem;

import java.util.ArrayList;
import java.util.TreeSet;

public class Purchase {

	private final static TreeSet<ShopItem> characters = new TreeSet<>();
	private static boolean shopTurn = false;
	private static ArrayList<ExpeditionCard> shop = new ArrayList<>();

	public static void addShopItem(ShopBias bias, int weight,
			ExpeditionCard character) {
		characters.add(new ShopItem(bias, weight, character));
	}

	public static void chooseRandomItems(ShopBias bias, int amount) {
		for (int i = 0;i < amount;i++){
			shop.add(chooseRandomItem(bias).getCharacter());
		}
	}

	private static ShopItem chooseRandomItem(ShopBias bias) {
		int totalSeed = 0;

		for (ShopItem s : characters) {
			totalSeed = totalSeed + s.getWeight();
		}
		int seed = (int) Math.ceil(Math.random() * totalSeed);
		int count = 0;
		for (ShopItem s : characters) {
			count = count + s.getWeight();
			if (count > seed) {
				Class cls = s.getClass();
				try {
					ShopItem obj = (ShopItem) cls.newInstance();
					return obj;
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
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

	public static void buyStuff(){
		while (shop.size() > 0){
			ArrayList<ExpeditionCard> possibleCards = shop;
			ArrayList<String> options = new ArrayList<>();
			for (ExpeditionCard ec : possibleCards){
				options.add(ec.getName() + " (" + ec.getCost() + ") "+ " - " +ec.getDescription());
			}
			options.add("End actions.");
			int userInput = InputLoop.inputLoop("Choose a card to purchase or end actions.", options);
			if (userInput == options.size()-1){
				Game.setActions(0);
			}
			else {
				ExpeditionCard c = possibleCards.get(userInput);
				Game.gainCard(c);
				Game.printState();
			}
		}
		System.out.println("Buy phase is over.");
		shop = new ArrayList<>();
	}

}
