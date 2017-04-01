import java.applet.Applet;
import java.awt.*;
import java.net.*;
import java.util.*;

/**
 * 
 * @author Paul
 *Creates a Deck of Cards
 */
public class Deck {
	
	private ArrayList<Card> cards;
	
	/**
	 * Creates new instance of a Deck, adds elements of c to the cards field
	 * @param c: an ArrayList of Cards
	 */
	private Deck(ArrayList<Card> c){
		this.cards = new ArrayList<Card>();
		for(int x=0; x<c.size(); x++){
		this.cards.add(c.get(x));
		//System.out.println("Constructor, size =" + this.cards.size());
		}
	}
	
	/**
	 * creates a Deck consisting of 52 Cards
	 * @param app: the applet that utilizes the Deck
	 * @return Returns the new Deck
	 */
	public static Deck create(Applet app){
		int value;
		String suit;
		ArrayList<Card> cards = new ArrayList<Card>();
		for(int x=1; x<=52; x++){
			value = x%13 + 1;
			if(x<=13)
				suit="c";
			else if(x<=26)
				suit="d";
			else if(x<=39)
				suit="h";
			else 
				suit ="s";
			try {
				cards.add(Card.create(value, suit, app));
			} catch (Exception e) {
				System.out.println("\ncard not added");
			}			
		}
		
		return new Deck(cards);
	}
	/**
	 * Returns the contents of the cards field for this Deck
	 * @return Returns the ArrayList of Cards contained 
	 * in the cards field of this Deck
	 */
	public ArrayList<Card> getCards(){
		return this.cards;
		
	}

	/**
	 * Removes the Card at the given index from this Hand 
	 * @param i: index of Card to be removed
	 * @return Returns the Card that is removed
	 */
	public Card removeCard(int index){
		return this.cards.remove(index);
	}
	
	public void shuffle(){
		Random choice = new Random();
		int pos1, pos2, size;
		size=this.cards.size();
		//System.out.println("Size of deck = " + size);
		pos1=choice.nextInt(52);
		pos2=choice.nextInt(52);
		
		for(int x=1; x<=5200; x++){
			swap(pos1, pos2);
			pos1=choice.nextInt(52);
			pos2=choice.nextInt(52);
			//System.out.println("p1: " + pos1);
			//System.out.println("p2: " + pos2);
		}		
	}
	
	public void swap(int pos1, int pos2){
		Card temp = this.cards.get(pos1);
		this.cards.set(pos1, this.cards.get(pos2));
		this.cards.set(pos2, temp);
	}
	
	/**
	 * Returns a string representation of this Deck
	 */
	public String toString(){
		String result="End of deck";
		int size = this.cards.size();
		System.out.println("Size of cards = " + size);
		int index=0;
		Card temp;
		if (!this.cards.isEmpty()){
			//System.out.println("\nDeck is not empty");
		while(index<size){
			temp=this.cards.get((size-1)-index);
			result=temp.toString().concat("\n").concat(result);
			index++;
		}
		}
		
		return result;
			
			
		
	}
	

}
