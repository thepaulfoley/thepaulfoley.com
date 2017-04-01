import java.applet.Applet;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.*;
import java.util.*;

/**
 * 
 * @author Paul
 *Represents a player's hand of cards
 */
public class Hand {
	
	private ArrayList<Card> cards;
	private int oldSize;
	
	/**
	 * Initializes the player's hand with 0 cards
	 * @param no arguments
	 * @return new Hand instance
	 */
	public Hand(){
		this.cards=new ArrayList<Card>();
		this.oldSize=this.size();
	}
	
	public Card getCard(int index){
		return this.cards.get(index);
	}
	
	/**
	 * Adds the given Card to this Hand
	 * @param c: Card to be added to this hand
	 */
	public Card addCard(Card c){
		this.oldSize=this.size();
		this.cards.add(c);
		return c;
	}
	
	
	/**
	 * Removes the given Card from this Hand
	 * @param c: Card to be removed
	 * @return Returns true if the given Card is removed, 
	 * returns false otherwise 
	 */
	public boolean removeCard(Card c){
		this.oldSize=this.size();
		return this.cards.remove(c);
	}
	
	public boolean removePair(Card c1, Card c2){
		this.oldSize=this.size();
		return (this.cards.remove(c1) && this.cards.remove(c2));
	}
	
	/**
	 * Adds the given Card to this Hand at the given index
	 * @param c: Card to be added to this hand
	 * @param i: index in array of cards to add the given Card
	 */
	public void addCard(Card c, int index){
		this.oldSize=this.size();
		this.cards.add(index, c);
	}
	
	
	/**
	 * Removes the Card at the given index from this Hand 
	 * @param i: index of Card to be removed
	 * @return Returns the Card that is removed
	 */
	public Card removeCard(int index){
		this.oldSize=this.size();
		return this.cards.remove(index);
	}
	
	public int size(){
		return this.cards.size();
	}
	
	public boolean isEmpty(){
		return this.cards.isEmpty();
	}
	
	/**
	 * Determines if this hand has a card that has the 
	 * same value but different suit as the give Card
	 * @param c: a Card
	 * @return Returns the index in the cards field where the match is found,
	 * returns -1 if no match is found
	 */
	public int hasMatch(Card c){
		int result=-1;
		
		for(int index =0;index<this.cards.size();index++){
			if((c.getValue()==this.cards.get(index).getValue())
					&& (!c.getSuit().equals(this.cards.get(index).getSuit())))
				return index;
			}
		return result;
	}
	
	
	

	
	public void draw(int x, int y, boolean visible, Graphics g, ImageObserver io){
		int change=this.oldSize-this.size();
		int offset=71/4;
		if(change>0){
			//int xCoord=x+offset*(this.size()-1);
			int w=offset*(this.oldSize-1) + 71;			
			g.setColor(((Component)io).getBackground());
			g.fillRect(x, y, w, 96);
			
		}
		if(!this.cards.isEmpty()){
			
			for(int index=0; index<this.cards.size(); index++){
				this.cards.get(index).draw((x+offset*index), y, visible, g, io);
			}
		}
		
		
	}
	
	

}
