import java.applet.Applet;
import java.awt.*;
import java.net.*;
import java.util.*;

/**
 * 
 * @author Paul
 *Represents a player in a game of GoFish, contains a name, 
 * two Hands, and a score
 */
public class Player {
	
	protected String name;
	protected Hand cards;
	protected Hand pairs;
	protected int score;
	protected int x, y;
	
	//public Player(){}

	public Player(String name, Hand cards, Hand pairs, int x, int y){
		this.name=name;
		this.cards=cards;
		this.pairs=pairs;
		this.x=x;
		this.y=y;
		this.score=0;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Hand getCards(){
		return this.cards;
	}
	
	public Hand getPairs(){
		return this.pairs;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public void setX(int n){
		this.x=n;
	}
	public void setY(int n){
		this.y=n;
	}
	
	public void setName(String s){
		this.name=s;
	}
	
	public int addScore(){
		return this.score+=2;
	}
	
	/**
	 * 
	 * @param selected -Card that the player is looking for
	 * @param asked - Player that this Player is asking
	 * @param d - Deck of Cards to go fish from
	 * @return Returns an integer depending on the result of the turn.
	 * 	return values: 
	 * 1 - this Player got the selected Card from the Player they were asking
	 * 2 - this Player Fished their wish
	 * 3 - this Player did not get the selected Card and did not fish their wish
	 * 4 - this Player did not get the selected Card and could not fish because 
	 * 	   the Deck is empty
	 * 5 - the selected Card is a bad Card
	 */
	public int takeTurn(Card selected, Player asked, Deck d){
		if(selected.getSuit().equals("x"))
			return 5;
		int match=asked.getCards().hasMatch(selected);
		if(match>=0){
			this.pairs.addCard(asked.getCards().removeCard(match));
			this.pairs.addCard(selected);
			this.cards.removeCard(selected);
			this.addScore();
			return 1;
			
		}
		if (!d.getCards().isEmpty()){
			Card fish = this.cards.addCard(d.removeCard(0));
			if(fish.getValue()==selected.getValue()){
				this.pairs.addCard(selected);
				this.pairs.addCard(fish);
				this.cards.removeCard(selected);
				this.cards.removeCard(fish);
				this.addScore();
				return 2;
			}
			else return 3;
			
		}
		return 4;
	}
	
	public Card removePairs(){
			int index;
			Card temp, temp2;
			for(int x=0; x<=this.cards.size()-1;x++){
				temp=this.cards.getCard(x);
				index=this.cards.hasMatch(temp);
				
				if(index>=0){
					temp2=this.cards.getCard(index);
					this.cards.removePair(temp, temp2);
					this.pairs.addCard(temp);
					this.pairs.addCard(temp2);
					this.addScore();
					return temp;					
				}
			}
			return new Card("x");
		
	}
	
	
	public void drawScore(int x, int y, Graphics g, Component c){
		Integer sc=new Integer(this.score);
		String s1 = this.name.concat(": ").concat(sc.toString());
		g.setColor(c.getBackground());
		g.fillRect(x, y-20, 100, 30);
		g.setColor(Color.black);
		g.drawString(s1, x, y);
	}
	
	public boolean isVisible(){
		return true;
	}
}
