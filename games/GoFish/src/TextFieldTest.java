import java.applet.Applet;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class TextFieldTest extends Applet implements Runnable, MouseListener, MouseMotionListener{

	TextField txt;
	
	public void init(){
		this.setSize(600, 600);
		txt=new TextField(50);
		this.add(txt);
		txt.setVisible(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		
	}
	
	public void paint(Graphics g){
		txt.setLocation(100, 225);
		txt.repaint();
		
	}

	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent arg0) {

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
		txt.setVisible(!txt.isVisible());
		System.out.println("txt visibility: "+txt.isVisible());


	}

	public void run() {
		// TODO Auto-generated method stub

	}
}
