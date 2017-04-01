
import java.applet.Applet;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.*;

/**
 * Creates a new button
 * @author Paul Foley
 *
 */
public class Button {

	private Image img;
	private Image alt;
	private int x;
	private int y;
	private Applet app;
	private boolean highlighted;
	private Menu goTo;
	String type;
	
	public Button(){
		this.type="null";
	}
	
	private Button(Image img, Image alt, Menu goTo, Applet app, String type){
		this.img=img;
		this.alt=alt;
		this.x=0;
		this.y=0;
		this.goTo=goTo;
		this.app=app;
		this.highlighted=false;
		this.type=type;
	}
	
	private Button(Image img, Image alt, Menu goTo, Applet app, int x, int y, String type){
		this.img=img;
		this.alt=alt;
		this.x=x;
		this.y=y;
		this.goTo=goTo;
		this.app=app;
		this.highlighted=false;
		this.type=type;
	}
	
	public static Button create(String type, Menu goTo, Applet app)throws Exception{
		String prefix = app.getCodeBase().toString().concat("../img/buttons/");
		String file = type;
		String fileAlt = type.concat(".alt");
		String suffix = ".gif";
		URL imgURL=new URL(prefix.concat(file).concat(suffix));
		URL altURL= new URL(prefix.concat(fileAlt).concat(suffix));
		Image img=app.getImage(imgURL);
		Image alt=app.getImage(altURL);
		return new Button(img, alt, goTo, app, type);
		
		
	}
	
	public static Button create(String type, Menu goTo, Applet app, int x, int y)throws Exception{
		String prefix = app.getCodeBase().toString().concat("../img/buttons/");
		String file = type;
		String fileAlt = type.concat(".alt");
		String suffix = ".gif";
		URL imgURL=new URL(prefix.concat(file).concat(suffix));
		URL altURL= new URL(prefix.concat(fileAlt).concat(suffix));
		Image img=app.getImage(imgURL);
		Image alt=app.getImage(altURL);
		return new Button(img, alt, goTo, app, x, y, type);
		
		
	}

	
	/**
	 * 
	 * @param io: ImageObserver utilizing this Card
	 * @return returns the width of the img field
	 */
	public int getWidth(){
		return this.img.getWidth(this.app);
	}
	
	/**
	 * 
	 * @param io: ImageObserver utilizing this Card
	 * @return returns the height of the img field
	 */
	public int getHeight(){
		return this.img.getHeight(this.app);
	}
	
	/**
	 * gets the x-coordinate of this Button
	 * @return the x coordinate of this Button
	 */
	public int getX(){
		return this.x; 
	}
	
	/**
	 * gets the y-coordinate of this Button
	 * @return the y-coordinate of this Button
	 */
	public int getY(){
		return this.y;
	}
	
	/**
	 * sets the x-coordinate of this Button 
	 * to the given int
	 * @param x - an int to set the the x-coordinate 
	 * of this Button to
	 */
	public void setX(int x){
		this.x = x; 
	}
	
	/**
	 * sets the y-coordinate of this Button 
	 * to the given int
	 * @param y - an int to set the the x-coordinate 
	 * of this Button to
	 */
	public void setY(int y){
		this.y = y; 
	}
	
	public void setCoords(Point p){
		this.setX((int)p.getX());
		this.setY((int)p.getY());		
	}
	
	/**
	 * determines if this Button contains the given point
	 * @param mX - x-coordinate 
	 * @param mY - y-coordinate 
	 * @return - returns true if the given points are in
	 * this Button, otherwise returns false
	 */
	public boolean contains(int mX, int mY){
		this.highlighted = (( (mX>=this.x) && mX<=(this.x+this.getWidth())) &&
				   ( (mY>=this.y) && mY<=(this.y+this.getHeight())));
		return this.highlighted;			
		
	}
	
	public void refresh(int x, int y){
		boolean wasHighlighted=this.highlighted;
		if(!this.contains(x,y)==wasHighlighted)
			this.draw(this.app.getGraphics());
		
	}
	
	/**
	 * returns the goTo field of this Button
	 * @return - returns the goTo field of this Button
	 */
	public Menu goTo(){
		return this.goTo;
	}
	
	/**
	 * draws this Button 
	 * @param g - the Graphics object used to draw this Button
	 */
	public void draw(Graphics g){
		if(this.highlighted)
			g.drawImage(this.alt, this.x, this.y, (ImageObserver)this.app);
		else
			g.drawImage(this.img, this.x, this.y, (ImageObserver)this.app);
	}
	
	
	public String toString(){
		return "Button: ".concat(this.type);
	}
	
	
}
