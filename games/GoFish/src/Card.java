import java.applet.Applet;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.*;

/**
 * 
 * @author Paul
 *@Represents a playing card consisting of an Image, int value, 
 *String suit, and a URL location of the Image
 */
public class Card {
	
	private Image upSide;
	private Image downSide;
	private int value;
	private String suit;
	private Applet app;
	private int x;
	private int y;
	
	
	public Card(String suit){
		this.suit=suit;
		this.value=0;
	}
	
	/**
	 * creates a new instance of a Card
	 * @param img:the Image to be used to represent the card
	 * @param value: the number value of the card
	 * @param suit: the String representing the suit of the Card
	 * @param loc: the URL location of the Image
	 */
	private Card(Image upside, Image downSide, int value, String suit, Applet app){
		this.upSide=upside;
		this.downSide=downSide;
		this.value=value;
		this.suit=suit;
		this.app=app;
	}
	
	/**
	 * Passes the proper Image, value, suit and loc to the constructor
	 * @param value: the number value of the card
	 * @param suit: the String representing the suit of the Card
	 * @param app: the applet, that will utilize this card
	 * @return returns a new instance of a Card
	 * @throws Exception throws an exception if the Image field 
	 * cannot be initialized properly
	 */
	public static Card create(int value, String suit, Applet app) throws Exception{
		String prefix = app.getCodeBase().toString().concat("../img/cards/");
		//System.out.println("Prefix = " + prefix);
		String suffix = ".gif";
		Integer v = new Integer(value);
		String fileName = suit.concat(v.toString());
		
		String urlUpSide = prefix.concat(fileName).concat(suffix);
		String urlDownSide= prefix.concat("rbv").concat(suffix);
		//System.out.println("Card string url = \n" + url);
		URL locUpSide = new URL(urlUpSide);
		URL locDownSide = new URL(urlDownSide);

		//System.out.println("Card url =" + loc.toString());
		
		
		Image upSide=app.getImage(locUpSide);
		Image downSide=app.getImage(locDownSide);
		//app.getMT().addImage(img, 1);
		
		return new Card(upSide, downSide, value, suit, app);
		
		
		
		
	}
	/**
	 * 
	 * @return returns the value of this Card
	 */
	public int getValue(){
		return this.value;
	}
	
	/**
	 * 
	 * @return returns the suit of this Card
	 */
	public String getSuit(){
		return this.suit;
	}
	
	/**
	 * Flips a card so that it downSide becomes its upSide and vice versa
	 */
	public Card flip(){
		Image temp;
		temp=this.upSide;
		this.upSide=this.downSide;
		this.downSide=temp;
		return this;
	}
	
	/**
	 * 
	 * @param io: ImageObserver utilizing this Card
	 * @return returns the width of the img field
	 */
	public int getWidth(){
		return this.upSide.getWidth(this.app);
	}
	
	/**
	 * 
	 * @param io: ImageObserver utilizing this Card
	 * @return returns the height of the img field
	 */
	public int getHeight(){
		return this.upSide.getHeight(this.app);
	}
	
	public boolean contains(int mX, int mY){
		/*System.out.println("Contains:\n mx=" + mX +" my=" + mY);
		System.out.println("img: w=" + this.getWidth()+ " h=" + this.getHeight());
		System.out.println("img: x=" + this.x + " y=" + this.y);*/
		boolean result= (( (mX>=this.x) && mX<=(this.x+this.getWidth())) &&
			   ( (mY>=this.y) && mY<=(this.y+this.getHeight())));
		//System.out.println("Result = " + result);
		return result;
	}
	
	/**
	 * Draws this card at the x and y coordinates using
	 * g and io
	 * @param x: the x-coordinate 
	 * @param y: the y-coordinate 
	 * @param g: Graphics object to be used
	 * @param io: ImageObserver object to be used
	 */
	
	public void draw(int x, int y, boolean visible, Graphics g, ImageObserver io){
		this.x=x;
		this.y=y;
		if(visible)
			g.drawImage(this.upSide,x,y,io);
		else
			g.drawImage(this.downSide,x,y,io);
	}
	
	public String suitString(){
		String suit;
		if(this.suit.equals("c")){
			suit="Clubs";
		}
		else if(this.suit.equals("d")){
			suit="Diamonds";
		}
		else if(this.suit.equals("h")){
			suit="Hearts";
		}
		else if(this.suit.equals("s")){
			suit="Spades";
		}
		else{
			suit=this.suit;
		}
		return suit;
		
	}
	
	/**
	 * 
	 * @return returns a String representation of the 
	 * value of this Card
	 */
	public String valString(){
		Integer v = new Integer(this.value);
		String  value;
		if(this.value==1){
			value="Ace";
		}
		else if(this.value==11){
			value="Jack";
		}
		else if(this.value==12){
			value="Queen";
		}
		else if(this.value==13){
			value="King";
		}
		else{
			value=v.toString();
		}
		
		return value;
	}
	
	/**
	 * returns a String representation of this Card
	 */
	public String toString(){
		
		return this.valString().concat(" of ").concat(this.suitString());
	}


}
