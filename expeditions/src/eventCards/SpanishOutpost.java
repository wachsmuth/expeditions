package eventCards;

import gamestate.EventCard;
import gamestate.Purchase;
import helpers.ShopBias;

public class SpanishOutpost implements EventCard {

	@Override
	public String getName() {
		return "Spanish Outpost";
	}

	@Override
	public String getDescription() {
		return "You may purchase European characters.";
	}

	@Override
	public void playEvent() {
		Purchase.shopRandomItems(ShopBias.EUROPEAN, 4);
		
	}

}
