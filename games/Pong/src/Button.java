import java.awt.*;
import java.applet.*;
import java.awt.image.ImageObserver;
import java.net.*;

public class Button
{
	private int x;
	private int y;
	private static int width=175;
	private static int height = 50;
	private boolean highlight=false;
	private Image img, imgAlt;
	private Applet app;

	private Button (int xcord,int ycord, Image img, Image imgAlt, Applet app)
	{
		x=xcord;
		y=ycord;
		this.img=img;
		this.imgAlt=imgAlt;
		this.app=app;

	}
	
	public static Button create(Image img, Image imgAlt, int x, int y, Applet app) throws Exception{
		return new Button(x, y, img, imgAlt, app);
		
	}
	
	public Image getImage(){
		if(this.highlight)
			return imgAlt;
		else
			return img;	
	}


	public void setX(int blax)
	{
		x=blax;
	}
	public void setY(int blay)
	{
		y=blay;
	}

	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public boolean contains(int x, int y){
		return (x>=this.x && x<=(this.x+Button.width))&&(y>=this.y && y<=(this.y+Button.height));
	}


	public void highlight(boolean hl)
	{
			highlight=hl;
	}
	public boolean getHighlight()
	{
			return highlight;
	}


	
	public void draw (Graphics g, ImageObserver io)
	{
		
		if(highlight==true)
			g.drawImage(this.imgAlt,x,y,io);
		else
			g.drawImage(this.img,x,y,io);
	}
	
	public void draw (Graphics g)
	{
		
		if(highlight==true)
			g.drawImage(this.imgAlt,x,y,this.app);
		else
			g.drawImage(this.img,x,y,this.app);
	}
	/*public void erase (Graphics g)
	{
		g.setColor(Color.white);
		g.fillOval (oldX, oldY, radius, radius);
	}*/
}