import java.awt.*;
import java.util.*;
import java.applet.*;
import java.text.*;

public class Paddle
{
	//g.drawRect(x,y,width,height);
	private int x;
	private int y;
	private int width;
	private int height;
	private int direction;
	private int oldX;
	private int oldY;
	private int sheight;
	private boolean winner;

	private int sections[]= new int[8];
	private int score;
	public Paddle (int xcord,int ycord,int w, int h, boolean winn)
	{
		score =0;
		x=xcord;
		y=ycord;
		width=w;
		height=h;
		direction =1;
		winner=winn;
		sheight=(int)(height/7);
		int magic= 0;
		for (int x=1; x<8; x++)
		{

			sections[x]=magic+sheight;
			magic=sections[x];
		}
	}
	public void printit ()
	{
		System.out.println("paddle height = " + height);
		System.out.println("section height = " + sheight);
		for (int x=1; x<8; x++)
		{

			System.out.println("Section " +x+ " = " +sections[x]);
		}
	}

	public int getSection(int ycor)
	{
		int sect=0;
		int d;
		int limit= y;
		for(d=1; d<8; d++)
		{
		if (ycor>=limit&& ycor<y+sections[d])
		{
		System.out.println(d);
		return d;
		}

	     	limit= y+sections[d];

		}


	return d;
	}
	public void setWin(boolean w1)
	{
		winner=w1;

	}
	public int getScore ()
	{
		return score;
	}
	public void score ()
	{
		score++;
	}
	public boolean win()
	{
		return winner;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void setX(int mx)
	{
		x=mx;
	}
	public int getOldY()
	{
		return oldY;
	}
	public void setOldY(int oy)
	{
		oldY=oy;
	}
	public void setY(int my)
	{
		y=my;
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
		{
			return height;
	}
	public int getDirection ()
	{
		return direction;
	}
	public void reset ()
	{
		score=0;
		winner=false;
	}
	public void move(int dir)
	{

		oldX=x;
		oldY=y;
		direction = dir;
		if (direction==1)
		{

			y--;
		}
		else if (direction==2)
		{

			y++;
		}
		/*else if (direction==3)
		{
			x++;
			y++;
		}
		else if (direction==4)
		{
			x++;
			y--;
		}
		*/

	}
	public void paint (Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect (x, oldY, width, height);
		g.setColor(Color.blue);
		g.fillRect (x, y, width, height);
	}
}