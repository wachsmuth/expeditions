package eventCards;

import gamestate.EventCard;
import gamestate.Purchase;
import helpers.ShopBias;

public class NativeVillage implements EventCard {

	@Override
	public String getName() {
		return "Native Village";
	}

	@Override
	public String getDescription() {
		return "You may purchase native characters.";
	}

	@Override
	public void playEvent() {
		Purchase.shopRandomItems(ShopBias.NATIVE, 5);
		
	}

}
