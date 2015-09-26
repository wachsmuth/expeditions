package gamestate;

import helpers.ShopBias;
import helpers.ShopItem;

import java.util.ArrayList;
import java.util.TreeSet;

public class Purchase {

	private final static TreeSet<ShopItem> characters = new TreeSet<>();
	private static boolean shopTurn = false;
	private static ArrayList<ExpeditionCard> shop = new ArrayList<>();
	
	public static void addShopItem(ShopBias bias, int weight, ExpeditionCard character){
		characters.add(new ShopItem(bias, weight, character));
	}
	
	public static ShopItem chooseRandomItem(ShopBias bias){
		int totalSeed = 0;
		
		for (ShopItem s : characters){
			totalSeed = totalSeed + s.getWeight();
		}
		int seed = (int) Math.ceil(Math.random()*totalSeed);
		int count = 0;
		for (ShopItem s : characters){
			count = count + s.getWeight();
			if (count > seed){
				return s;
			}
		}
		//This code should never be reached
		return null;
	}

	public static boolean isShopTurn() {
		return shopTurn;
	}

	public static void setShopTurn(boolean shopTurn) {
		Purchase.shopTurn = shopTurn;
	}
	
	
	/*
	 * 			Class cls = s.getClass();
			Object obj = cls.newInstance();
	 */
	
}
