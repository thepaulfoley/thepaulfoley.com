import java.awt.*; 
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.applet.*;
import java.net.*;
import java.util.ArrayList;

public class ButtonTest extends Applet implements Runnable, MouseListener, MouseMotionListener{
	
	private Button startButton;
	private Button instructionsButton;
	private Button backButton;
	private Menu startMenu;
	private Menu instructionsMenu;
	private Menu gameMenu;
	private Thread action;
	
	public ButtonTest(){}
	
	public void init(){
		this.setSize(600, 600);
		try {
			startMenu=Menu.create("start", this);
			instructionsMenu=Menu.create("instructions", this);
			gameMenu=Menu.create("game", this);
		} catch (Exception e) {}
		
		try {
			startButton=Button.create("start", gameMenu, this, 156, 190);
			instructionsButton=Button.create("instructions", instructionsMenu, this, 156, 300);
			backButton=Button.create("back", startMenu, this, 156, 250);
		} catch (Exception e) {}
		addMouseListener(this);
		addMouseMotionListener(this);
		action=new Thread(this);
		action.start();
		
		
	}
	
	public void run(){
		try{
			Thread.sleep(2000);
		}
		catch(Exception e){}
		containsTest(startButton);
		//containsTest(instructionsButton);
		//containsTest(backButton);
		
	}
	
	public void paint(Graphics g){
		//containsTest(startButton);
		//containsTest(instructionsButton);
		//containsTest(backButton);
	}
	
	public void containsTest(Button b){
		int x=b.getX();
		int y=b.getY();
		int w=b.getWidth();
		int h=b.getHeight();
		int rightBorder=x+w;
		int bottomBorder=y+h;
		
		System.out.println("X = " + x);
		System.out.println("Y = " + y);
		System.out.println("W = " + w);
		System.out.println("H = " + h);
		System.out.println("rB = " + rightBorder);
		System.out.println("bB = " + bottomBorder);
		/*for(; x<=rightBorder; x++){
			for(; y<=bottomBorder; y++){
				System.out.print(x + "," + y + "  " + b.contains(x,y) + ": ");
				
			}
			System.out.println();
		}/*
		
		/*for(int xx=0; xx<=600; xx++){
			for(int yy=0; yy<=600; yy++){
				if(b.contains(xx, yy)){
					System.out.print(xx);
				}
				else{
					System.out.print(xx);	
				}
			}
			System.out.println();
		}*/
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	


}
