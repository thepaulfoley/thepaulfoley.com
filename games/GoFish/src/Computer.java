import java.applet.Applet;
import java.awt.*;
import java.net.*;
import java.util.*;

/**
 * Represents an autonomous Computer Player, extends the Player class,
 * also contains a memory of the cards the other Player has asked for 
 * @author Paul Foley
 *
 */
public class Computer extends Player{

	Hand memory;
	

	/**
	 * Constructs a new instance of a Computer
	 * @param name - String representing the name
	 * @param cards - a Hand representing their Cards that thaey're playing with
	 * @param pairs - a Hand representing the pairs that they have gathered
	 * @param x - x coordinate for drawing
	 * @param y - y coordinate for drawing
	 */
	public Computer(String name, Hand cards, Hand pairs, int x, int y){
		super(name, cards, pairs, x, y);
		this.memory=new Hand();
		
	}
	

	/**
	 * Selects a random card from the Hand of this Computer
	 * @param d1 - the Deck of Cards that the game is being played with
	 * @return Returns the selected Card, if no Card can be Selected,
	 * a generic Card with suit e and value 0 is returned 
	 */
	public Card select(Deck d1){
		int remember;
		Random choice = new Random();
		if((remember = this.remember())>=0){
			return this.cards.getCard(remember);
		}
		
		if(this.cards.size() >0)
		return this.cards.getCard(choice.nextInt(this.cards.size()));
		
		else if(d1.getCards().size()>0){
				return this.cards.addCard(d1.removeCard(0));
			}
		else return new Card("e");
	}
	
	public boolean isVisible(){
		return false;
	}
	
	/**
	 * determines whether any of the Cards asked for by the
	 * other player are in this Player's cards
	 * @return returns the index of the remembered Card, if no remembered 
	 * Cards are in this Player's hand, -1 is returned
	 */
	public int remember(){
		int indexHand =0;
		int indexMemory=0;
		int handSize=this.cards.size();
		int memorySize=this.memory.size();
		int result=-1;
		int temp=0;
		while(handSize-indexHand >=1){
			while(memorySize-indexMemory>=1){
				result=this.cards.hasMatch(this.memory.getCard(indexMemory));
				if( result>=0){
					return result;
				}
				indexMemory++;
			}
			indexHand++;
		}
		return result;

	}
}
