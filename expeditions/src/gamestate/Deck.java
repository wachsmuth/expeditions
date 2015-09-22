package gamestate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Deck<E> implements Iterable{

    private final ArrayList<E> cards = new ArrayList<>();

    public Deck() {
        //Empty constructor, remove DEBUG
    }

//--------------------------------GETTERS-------------------------------------------------------
    public int getSize() {
        return cards.size();
    }
    
    public boolean isEmpty(){
    	return getSize() == 0;
    }
    
    public E getTopCard(){
    	return cards.get(0);
    }
    
//--------------------------------SETTERS-------------------------------------------------------

    public void addCard(E c) {
        cards.add(c);
    }

    public void removeCard(E c) {
        cards.remove(c);
    }

    public boolean hasCard(E c) {
        for (E card : cards) {
            if (card == c) {
                return true;
            }
        }
        return false;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    public ArrayList<E> getDeck(){
        return cards;
    }

	@Override
	public Iterator iterator() {
		return cards.listIterator();
	}

}
