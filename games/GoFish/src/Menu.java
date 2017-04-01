import java.applet.Applet;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.*;
import java.util.*;
/**
 * Creates a new Menu
 * @author Paul Foley
 *
 */
public class Menu {
	
	private Image img;
	private ArrayList<Button> buttons;
	private ArrayList<Point> buttonCoordinates;
	private Applet app;
	boolean isActive;
	String type;
	
	
	/**
	 * creates a new Menu object with the given
	 * image and applet, the list of buttons is 
	 * initialized as an empty list
	 * @param img - the background Image of this Menu
	 * @param app - the Applet containing this Menu
	 */
	private Menu (Image img, Applet app, String type){
		this.img=img;
		this.buttons=new ArrayList<Button>();
		this.buttonCoordinates=new ArrayList<Point>();		
		this.app=app;
		this.type=type;
		isActive=false;
	}
	
	public static Menu create(String type, Applet app) throws Exception{
		String prefix = app.getCodeBase().toString().concat("../img/menus/");
		String file = type;
		String suffix = ".gif";
		URL imgURL = new URL(prefix.concat(file).concat(suffix));
		Image img = app.getImage(imgURL);
		return new Menu(img, app, type);
	}
	
	
	/**
	 * adds a Button to this Menu
	 * @param b - Button to be added to this Menu
	 * @param x - x-coordinate of location of Button b in this Menu
	 * @param y - y-coordinate of location of Button b in this Menu
	 */
	public void addButton(Button b, int x, int y){
		this.buttons.add(b);
		this.buttonCoordinates.add(new Point(x,y));
	}
	
	public ArrayList<Button> getButtons(){
		return this.buttons;
	}
	
	public Button getButton(int index){
		if(index>=0 && index<this.buttons.size())
			return this.buttons.get(index);
		else return new Button();
	}
	
	public Menu setActive(){
		int size = this.buttons.size();
		int index = 0;
		for (; index<size; index++){
			this.buttons.get(index).setCoords(this.buttonCoordinates.get(index));
		}
		this.isActive=true;
		return this;
	}
	
	public int buttonClicked(int x, int y){
		int size = this.buttons.size();
		for(int index=0; index<size; index ++){
			if(this.buttons.get(index).contains(x, y))
				return index;
		}
		return -1;
	}
	
	public void refresh(int x, int y){
		int size=this.buttons.size();
		Button b;
		for(int index = 0; index<size; index++){
			this.getButton(index).refresh(x, y);
		}
		
	}
	
	
	
	/**
	 * draws this Menu
	 * @param g - the Graphics object that will 
	 * draw this Menu
	 */
	public void draw(Graphics g){
		g.drawImage(this.img, 0, 0, (ImageObserver)this.app);
		int size=this.buttons.size();
		for(int i=0; i<size; i++){
			this.buttons.get(i).draw(g);
		}
	}
	
	public String toString(){
		return "Menu: ".concat(this.type);
		
	}
	
	
}
