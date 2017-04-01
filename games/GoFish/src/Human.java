import java.applet.Applet;
import java.awt.*;
import java.net.*;
import java.util.*;
public class Human extends Player{


	//public Human (){}
	public Human(String name, Hand cards, Hand pairs, int x, int y){
		super(name, cards, pairs, x, y);
	}
	
	public boolean isVisible(){
		return true;
	}
	/**
	 * determines which of this Player's cards is selected by 
	 * the user
	 * @param mX - x-coordinate of Mouse when clicked
	 * @param mY - y-coordinate of Mouse when clicked
	 * @param d1 - Deck of Cards being played with
	 * @return Returns the selected Card, if no Card can be Selected,
	 * a generic Card with suit e and value 0 is returned, if
	 * the Mouse coordinates are not within the boundary of any Card 
	 * in this Player's cards, a generic Card with suit x and value 0 is returned
	 */
	public Card select(int mX, int mY, Deck d1){
		int size=this.cards.size();
		boolean b1, b2;
		for(int index=0; index<size; index++){
			if((size-index)>1){
				//System.out.println("\nSelect: " + (size-index) +" cards");
				b1=this.cards.getCard(index).contains(mX,mY);
				b2=!this.cards.getCard(index+1).contains(mX,mY);
				//System.out.println("b1 = " +b1);
				//System.out.println("b2 = " +b2);
				if(b1 && b2){
					System.out.println("\nSelect: condition true");
					return this.cards.getCard(index);
				}
			}
			if((size-index)==1){
			if(this.cards.getCard(index).contains(mX,mY))
				return this.cards.getCard(index);
			}
		}
		
		if(size==0){
			if(!d1.getCards().isEmpty()){
				return this.cards.addCard(d1.removeCard(0));
			}
			else return new Card("e");
		}
		return new Card("x");
	}
}
