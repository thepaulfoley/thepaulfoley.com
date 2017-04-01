import java.awt.*;
import java.util.*;
import java.applet.*;
import java.text.*;

public class Ball 
{
	private int x;
	private int y;
	private int radius;
	private int direction;
	private int oldX;
	private int oldY;

	public Ball (int xcord,int ycord,int r)
	{
		x=xcord;
		y=ycord;
		radius =r;
		direction =1;
	}
	public Ball (int xcord,int ycord,int r,int dir)
	{
		x=xcord;
		y=ycord;
		radius =r;
		direction = dir;
	}
	public void restart (int xcord,int ycord,int r)
	{
		x=xcord;
		y=ycord;
		radius =r;
		direction =1;
	}
	public void setDirection(int abrakadabra)
	{
		direction=abrakadabra;
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
	public void setOldX(int zoox)
	{
		oldX=zoox;
	}
	public void setOldY(int zooy)
		{
			oldY=zooy;
	}
	public int getOldX()
	{
		return oldX;
	}
	public int getOldY()
	{
		return oldY;
	}
	public int getY()
	{
		return y;
	}
	public int getRadius()
	{
		return radius;
	}
	public int getDirection ()
	{
		return direction;
	}

	public void paint (Graphics g)
	{
		g.setColor(Color.white);
		g.fillOval (oldX, oldY, radius, radius);
		g.setColor(Color.black);
		g.fillOval (x, y, radius, radius);
	}
	public void erase (Graphics g)
	{
		g.setColor(Color.white);
		g.fillOval (oldX, oldY, radius, radius);
	}
}