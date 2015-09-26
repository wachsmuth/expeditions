package helpers;

import gamestate.ExpeditionCard;

public class ShopItem {

	private final ShopBias bias;
	private final int weight;
	private final ExpeditionCard character;

	public ShopItem(ShopBias bias, int weight,
			ExpeditionCard character) {
		this.bias = bias;
		this.weight = weight;
		this.character = character;
	}

	public ShopBias getBias() {
		return bias;
	}

	public int getWeight() {
		return weight;
	}

}
