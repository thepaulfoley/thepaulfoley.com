import java.awt.*;
import java.util.*;
import java.applet.*;
import java.text.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
import java.net.*;

public class test extends Applet implements Runnable, MouseMotionListener,MouseListener
{
	private volatile Thread go = null;
	Button startGame;
	Button instructions;
	Button options;
	Button easy;
	Button medium;
	Button hard;
	Ball b1;
	Paddle p1;
	Paddle p2;
	private Image logo;
	private Image difficulty;
	private Image startImg;
	private Image optionsImg;
	private Image easyImg;
	private Image mediumImg;
	private Image hardImg;
	private Image startAltImg;
	private Image optionsAltImg;
	private Image easyAltImg;
	private Image mediumAltImg;
	private Image hardAltImg;
	private int top;
	private int bottom;
	private int width;
	private boolean gameover;
	private int height;
	private int balldirection=1;
	private int leftWall;
	private int rightWall;
	private int times =1;
	private int del = 2;
	private double ps = .75;
	private int xchange=4;
	private int ychange=4;
	private int ylimit=9;
	private boolean change1=false;
	private boolean change2=false;
	private boolean change3=false;
	private boolean change4=false;
	private boolean over = false;
	private boolean main = true;
	private boolean mainbegin = true;
	private boolean play = false;
	private boolean playbegin = false;
	private boolean instscreen = false;
	private boolean opt = false;
	private boolean optbegin = false;
	private AudioClip drop;

public void init()
{
		this.setSize(400, 300);
        drop= getAudioClip(getDocumentBase(), "../drop.wav");
        logo=getImage(getCodeBase(), "../img/logo.GIF");
		difficulty =getImage(getCodeBase(), "../img/difficulty.GIF");
		
		startImg =getImage(getCodeBase(), "../img/button_start.GIF");
		optionsImg =getImage(getCodeBase(), "../img/button_options.GIF");
		easyImg =getImage(getCodeBase(), "../img/button_easy.GIF");
		mediumImg =getImage(getCodeBase(), "../img/button_medium.GIF");
		hardImg =getImage(getCodeBase(), "../img/button_hard.GIF");
		
		startAltImg =getImage(getCodeBase(), "../img/button_start_alt.GIF");
		optionsAltImg =getImage(getCodeBase(), "../img/button_options_alt.GIF");
		easyAltImg =getImage(getCodeBase(), "../img/button_easy_alt.GIF");
		mediumAltImg =getImage(getCodeBase(), "../img/button_medium_alt.GIF");
		hardAltImg =getImage(getCodeBase(), "../img/button_hard_alt.GIF");
		
		setBackground(Color.white);
        top =(int) (getHeight()/10);
        bottom =(int) (getHeight()*.8);
        width = (int) (.8*getWidth ());
		height = (int) (.7*getHeight ());
		leftWall = (int) (getWidth()*.1);
		rightWall = (int) (getWidth()*.9);
		try{
		startGame= Button.create(startImg, startAltImg, 107, 95, this);
		options= Button.create(optionsImg, optionsAltImg, 107, 160, this);
		easy= Button.create(easyImg,easyAltImg, 107, 55, this);
		medium= Button.create(mediumImg, mediumAltImg, 107, 120, this);
		hard= Button.create(hardImg, hardAltImg, 107, 185, this);
		}catch(Exception e){
			System.out.println("***Exception-Button not created.***");
			e.printStackTrace();
		}
		b1= new Ball ((int) (.5*width), (int) (.4*height), (int) (width/30));

		p1= new Paddle ((int) (.08*width+leftWall),(int) (.2*height),10,(int) (.25*height),false);

		p1.printit ();
		p2= new Paddle ((int) (.87*width+leftWall),(int) (.5*height),10,(int) (.25*height),false);
		addMouseMotionListener(this);
		addMouseListener(this);
	main = true;
	mainbegin = true;
	play = false;
	playbegin = false;
	instscreen = false;
	opt = false;
	optbegin = false;
	del = 2;
}

	public void mouseDragged(MouseEvent me)
	{}
	public void mouseReleased(MouseEvent me)
	{
		if(main==true)
		{
			if(startGame.getHighlight()==true)
			{
				main=false;
				play=true;
				playbegin=true;
				startGame.highlight(false);
			}
			/*
			if(instructions.getHighlight()==true)
			{
				main=false;
				instscreen=true;
				instructions.highlight(false);
			}*/
			
			if(options.getHighlight()==true)
			{
				main=false;
				opt=true;
				optbegin=true;
				options.highlight(false);
			}
		}
		if(opt==true)
		{
			if(easy.getHighlight()==true)
			{
				del=3;
				opt=false;
				main=true;
				mainbegin=true;
				easy.highlight(false);
			}
			if(medium.getHighlight()==true)
			{
				del=2;
				opt=false;
				main=true;
				mainbegin=true;
				medium.highlight(false);
			}
			if(hard.getHighlight()==true)
			{
				del=1;
				opt=false;
				main=true;
				mainbegin=true;
				hard.highlight(false);
			}
		}
	}
	public void mouseMoved(MouseEvent me)
	{
		if (play==true)
		{
			int tempy=me.getY();
			if ((tempy-(p2.getHeight()/2))>=top && (tempy+(p2.getHeight()/2)) <=bottom)
			p2.setY(tempy-p2.getHeight()/2);
		}
		if (main==true)
		{
			if (startGame.contains(me.getX(), me.getY()))
			{

				startGame.highlight(true);
			}
			else
			{
				startGame.highlight(false);
			}
			/*
			if ((me.getX() >= instructions.getX() && me.getX() <= (instructions.getX() + instructions.getWidth()))&& (me.getY() >= instructions.getY() && me.getY() <= (instructions.getY() + instructions.getHeight())))
			{

				instructions.highlight(true);
			}
			else
			{
				instructions.highlight(false);
			}*/
			if (options.contains(me.getX(), me.getY()))
			{

				options.highlight(true);
			}
			else
			{
				options.highlight(false);
			}
		}
		if (opt==true)
		{
			if (easy.contains(me.getX(), me.getY()))
			{

				easy.highlight(true);
			}
			else
			{
				easy.highlight(false);
			}
			if (medium.contains(me.getX(), me.getY()))
			{

				medium.highlight(true);
			}
			else
			{
				medium.highlight(false);
			}
			if (hard.contains(me.getX(), me.getY()))
			{

				hard.highlight(true);
			}
			else
			{
				hard.highlight(false);
			}
		}


	}
	public void mouseEntered(MouseEvent me)
	{}
	public void mouseExited(MouseEvent me)
	{}
	public void mousePressed(MouseEvent me)
	{

	}

	public void mouseClicked(MouseEvent me)
	{



	}



    public void start()
    {
		init();
      if (go == null) {
         go = new Thread(this, "Go");
         go.start();
      }
    }
    public void restart()
    {
		init();
		start();
	}

    public void run()
    {
		Thread myThread = Thread.currentThread();
		while (true)
		{
			repaint();
			try {
			        Thread.sleep(del);
				} catch (InterruptedException e){ }


		}
	}

	public boolean collide(Graphics g)
	{
	boolean coll = false;
	change1=false;
	change2=false;
	change3=false;
	change4=false;


	if (balldirection ==1 )
			{

				if (b1.getY()==top+1 )
				{


					balldirection =2;
					return true;
				}
				else if (b1.getX()==leftWall)
				{
					balldirection =4;
					p2.setWin(true);
					return true;
				}
				else if (b1.getX()==p1.getX()+p1.getWidth())
				{
					if(b1.getY()+b1.getRadius()>=p1.getY()&&b1.getY()<=p1.getY()+p1.getHeight())
					{
						drop.play();
						balldirection = 4;
						if(p1.getSection(b1.getY())==1)
						{
							for (int x=1;x<=3;x++)
							{
								if (ychange<ylimit)
								ychange++;
							}
							;
						}
						if(p1.getSection(b1.getY())==2)
						{
							for (int x=1;x<=2;x++)
							{
								if (ychange<ylimit)
								ychange++;
							}
						}
						if(p1.getSection(b1.getY())==3)
						{
							if (ychange<ylimit)
							ychange=ychange+1;
						}
						if(p1.getSection(b1.getY())==5)
						{
							if (ychange>1)
							ychange=ychange-1;
						}
						if(p1.getSection(b1.getY())==6)
						{
							if (ychange >2)
							{
								for (int x=1;x<=2;x++)
								{

									ychange--;
								}
								change1=true;
							}
							if (ychange==2 &&change1==false)
							{
								ychange =1;
								change1= true;
							}
							if (ychange==1 &&change1==false)
							{
								balldirection =3;
								ychange =1;
								change1= true;
							}

						}
						if(p1.getSection(b1.getY())==7)
						{
							if (ychange >3)
							{
								for (int x=1;x<=3;x++)
								{

									ychange--;
								}
							change1=true;
							}
							if (ychange==3 &&change1==false)
							{
								ychange =1;
								change1= true;
							}
							if (ychange==2 &&change1==false)
							{
								balldirection =3;
								ychange =1;
								change1= true;
							}
						}
						return true;
					}


				}

			}
			else if(balldirection ==2)
			{

				if (b1.getY()+b1.getRadius()==bottom)
				{

					balldirection =1;
					return true;
				}
				else if (b1.getX()==leftWall)
				{

					p2.setWin(true);
					return true;
				}
				else if (b1.getX()==p1.getX()+p1.getWidth())
				{
					if(b1.getY()+b1.getRadius()>=p1.getY()&&b1.getY()<=p1.getY()+p1.getHeight())
					{
						drop.play();
						balldirection = 3;
						if(p1.getSection(b1.getY())==1)
						{
							for (int x=1;x<=3;x++)
							{
								if (ychange >1)
								ychange--;
							}

						}
						if(p1.getSection(b1.getY())==2)
						{
							for (int x=1;x<=2;x++)
							{
								if (ychange >1)
								ychange--;
							}
						}
						if(p1.getSection(b1.getY())==3)
						{
							if (ychange>1)
							ychange=ychange-1;
						}
						if(p1.getSection(b1.getY())==5)
						{
							if (ychange<ylimit)
							ychange=ychange+1;
						}
						if(p1.getSection(b1.getY())==6)
						{
							for (int x=1;x<=2;x++)
							{
								if (ychange <ylimit)
								ychange++;
							}
						}
						if(p1.getSection(b1.getY())==7)
						{
							for (int x=1;x<=3;x++)
							{
								if (ychange <ylimit)
								ychange++;
							};
						}
						return true;
					}


				}

			}
			else if(balldirection ==3 )
			{


				if (b1.getY()+b1.getRadius()==bottom )
				{
				;
					balldirection =4;
					return true;
				}
				else if (b1.getX()+b1.getRadius()==rightWall)
				{
					p1.setWin(true);

					return true;
				}
				else if (b1.getX()+b1.getRadius()==p2.getX())
				{
					if(b1.getY()+b1.getRadius()>=p2.getY()&&b1.getY()<=p2.getY()+p2.getHeight())
					{
						drop.play();
						balldirection = 2;
						if(p2.getSection(b1.getY())==1)
						{
							if(ychange>3)
							{
								for (int x=1;x<=3;x++)
								{

									ychange--;
								}
								change3=true;
							}
							if(ychange==3 && change3==false)
							{
								balldirection = 2;
								ychange=1;
								change3=true;
							}
							if(ychange==2 && change3==false)
							{
								balldirection = 1;
								ychange=1;
								change3=true;
							}
							if(ychange==1 && change3==false)
							{
								balldirection = 1;
								ychange=2;
								change3=true;
							}


						}
						if(p2.getSection(b1.getY())==2)
						{
							if(ychange>2)
							{
								for (int x=1;x<=2;x++)
								{

								ychange--;
								}
								change3=true;
							}
							if(ychange==2 && change3==false)
							{

								ychange=1;
								change3=true;
							}
							if(ychange==1 && change3==false)
							{
								balldirection = 1;
								ychange=1;
								change3=true;
							}
						}
						if(p2.getSection(b1.getY())==3)
						{
							if (ychange>1)
							ychange=ychange-1;
						}
						if(p2.getSection(b1.getY())==5)
						{
							if (ychange<ylimit)
							ychange=ychange+1;
						}
						if(p2.getSection(b1.getY())==6)
						{
							for (int x=1;x<=2;x++)
							{
								if (ychange <ylimit)
								ychange++;
							}
						}
						if(p2.getSection(b1.getY())==7)
						{
							for (int x=1;x<=3;x++)
							{
								if (ychange <ylimit)
								ychange++;
							};
						}

						return true;

					}


				}


			}
			else if(balldirection ==4 )
			{

				if (b1.getX()+b1.getRadius()==p2.getX())
				{
					if(b1.getY()+b1.getRadius()>=p2.getY()&&b1.getY()<=p2.getY()+p2.getHeight())
					{
						drop.play();
						balldirection = 1;
						if(p2.getSection(b1.getY())==1)
						{
							for (int x=1;x<=3;x++)
							{
								if (ychange<ylimit)
								ychange++;
							}
							;
						}
						if(p2.getSection(b1.getY())==2)
						{
							for (int x=1;x<=2;x++)
							{
								if (ychange<ylimit)
								ychange++;
							}
						}
						if(p2.getSection(b1.getY())==3)
						{
							if (ychange<ylimit)
							ychange=ychange+1;
						}
						if(p2.getSection(b1.getY())==5)
						{
							if (ychange>1)
							ychange=ychange-1;
						}
						if(p2.getSection(b1.getY())==6)
						{
							if (ychange >2)
							{

								for (int x=1;x<=2;x++)
								{

								ychange--;
								}
								change4= true;
							}
							if (ychange ==2 && change4== false)
							{
								ychange =1;
								change4= true;
							}
							if (ychange ==1 && change4== false)
							{
								balldirection =2;
								ychange =1;
								change4= true;
							}
						}

						if(p2.getSection(b1.getY())==7)
						{
							if (ychange >3)
							{

								for (int x=1;x<=3;x++)
								{

									ychange--;
								}
								change4= true;
							}
							if (ychange ==3 && change4== false)
							{
								ychange =1;
								change4= true;
							}
							if (ychange ==2 && change4== false)
							{
								balldirection =2;
								ychange =1;
								change4= true;
							}
							if (ychange ==1 && change4== false)
							{
								balldirection =2;
								ychange =2;
								change4= true;
							}
						}
						return true;

					}
					//if(del>10)
					//del--;
					;

				}


                    else if (b1.getY()==top)
				{

					balldirection =3;
					return true;
				}

				else if (b1.getX()+b1.getRadius()==rightWall)
				{
					balldirection =1;
					p1.setWin(true);
					return true;
				}


			}
			return false;
		}
	public void move(Graphics g)
		{

			int a=0;
			int b=0;
			b1.setOldX(b1.getX());
			b1.setOldY(b1.getY());
			//b1.setDirection(balldirection);

			if (balldirection==1)
			{
				for (int x =0;x<=(int)(ychange*ps+.5);x++)
				{
					movePaddle1(g);

				}
				while(a<=xchange&&collide(g)==false)
				{
					b1.setX(b1.getX()-1);
					a++;
					try {
								        Thread.sleep(del);
				} catch (InterruptedException e){ }
				}

				while(b<=ychange&&collide(g)==false)
				{
					b1.setY(b1.getY()-1);
					b++;
					try {
								        Thread.sleep(del);
				} catch (InterruptedException e){ }
				}
			}
			else if (balldirection==2)
			{
				for (int x =0;x<=(int)(ychange*ps+.5);x++)
				{
					movePaddle1(g);

				}
				a=0;
				b=0;
				while(a<=xchange&&collide(g)==false)
				{
					b1.setX(b1.getX()-1);
					a++;
					try {
								        Thread.sleep(del);
				} catch (InterruptedException e){ }
				}

				while(b<=ychange&&collide(g)==false)
				{
					b1.setY(b1.getY()+1);
					b++;
					try {
								        Thread.sleep(del);
				} catch (InterruptedException e){ }
				}
			}
			else if (balldirection==3)
			{
				a=0;
				b=0;
				while(a<xchange&&collide(g)==false)
				{
					b1.setX(b1.getX()+1);
					a++;
					try {
								        Thread.sleep(del);
				} catch (InterruptedException e){ }
				}

				while(b<ychange&&collide(g)==false)
				{
					b1.setY(b1.getY()+1);
					b++;
					try {
								        Thread.sleep(del);
				} catch (InterruptedException e){ }
				}
			}
			else if (balldirection==4)
			{
				a=0;
				b=0;
				while(a<xchange&&collide(g)==false)
				{
					b1.setX(b1.getX()+1);
					a++;
					try {
								        Thread.sleep(del);
				} catch (InterruptedException e){ }
				}

				while(b<ychange&&collide(g)==false)
				{
					b1.setY(b1.getY()-1);
					b++;
					try {
								        Thread.sleep(del);
				} catch (InterruptedException e){ }
				}
			}


		b1.paint(g);
	}



	public void movePaddle1(Graphics g)
	{
		if (b1.getY() < (p1.getY() + .5*p1.getHeight()))
		{
			if (p1.getY()> top)
				p1.move(1);
		}
		else if (b1.getY() > (p1.getY() + .5*p1.getHeight()))
		{
			if ((p1.getY() + p1.getHeight()) < bottom)
			p1.move(2);
		}
		p1.paint (g);
		//p2.paint (g);
	}




	public void update(Graphics g)
		{
			paint(g);
		}



	public void paint(Graphics g)
	{
	if (play==true)
	{
		setBackground(Color.white);
		if(playbegin==true)
		{
			g.setColor(Color.white);
			g.fillRect(0, 0, getWidth(),getHeight());
			playbegin=false;
		}

		if (p1.win()==true)
		{
			p1.score ();

			g.setColor(Color.black);
			g.fillRect(getWidth()/2-36, getHeight()/2-25, 60,20);
			g.setColor(Color.yellow);
			g.drawString("Point!!!", getWidth()/2-25, getHeight()/2-10);
			g.setColor(Color.white);
		g.fillOval (b1.getX(), b1.getY(), b1.getRadius(), b1.getRadius());
			over=true;

		}
		if (p2.win()==true)
		{
			p2.score ();
			g.setColor(Color.black);
			g.fillRect(getWidth()/2-36, getHeight()/2-25, 60,20);
			g.setColor(Color.yellow);
			g.drawString("Point!!!", getWidth()/2-25, getHeight()/2-10);
			g.setColor(Color.white);
		g.fillOval (b1.getX(), b1.getY(), b1.getRadius(), b1.getRadius());
			over=true;
			//return;

		}
		if (over ==true)
		{

			g.setColor(Color.white);
			g.fillRect((int)(getWidth()*.85),(int)(getHeight()*.86),15,15);
			g.fillRect((int)(getWidth()*.15),(int)(getHeight()*.86),15,15);
			Integer player1= new Integer (p1.getScore());
			Integer player2= new Integer (p2.getScore());
			if (player1.intValue()>=5&&player1.intValue()-player2.intValue()>=2)
					{
						g.setColor(Color.black);
									g.fillRect(getWidth()/2-36, getHeight()/2-25, 60,20);
			g.setColor(Color.yellow);
						g.drawString("You lose!", getWidth()/2-30, getHeight()/2-10);
						main = true;
						mainbegin = true;
						play=false;
						p1.reset();
						p2.reset();
			try {
					Thread.sleep(1500);
				} catch (InterruptedException e){ }

						return;
					}
			if (player2.intValue()>=5&&player2.intValue()-player1.intValue()>=2)
					{

						g.setColor(Color.black);
									g.fillRect(getWidth()/2-36, getHeight()/2-25, 60,20);
			g.setColor(Color.yellow);
						g.drawString("You win!!", getWidth()/2-28, getHeight()/2-10);
						main = true;
						mainbegin = true;
						play=false;
						p1.reset();
						p2.reset();
			try {
					Thread.sleep(2000);
				} catch (InterruptedException e){ }
						return;
			}
			try {
					Thread.sleep(1000);
				} catch (InterruptedException e){ }

			g.setColor(Color.black);
			g.fillRect(getWidth()/2-36, getHeight()/2-25, 62,20);
			g.setColor(Color.yellow);
			g.drawString("Get Ready", getWidth()/2-32, getHeight()/2-10);
			g.setColor(Color.red);
			g.drawString ("CPU",(int)(getWidth()*.15),(int)(getHeight()*.85));
			g.drawString(player1.toString(),(int)(getWidth()*.15),(int)(getHeight()*.9));
			g.drawString ("You",(int)(getWidth()*.85),(int)(getHeight()*.85));
			g.drawString(player2.toString(),(int)(getWidth()*.85),(int)(getHeight()*.9));

			try {
					Thread.sleep(1500);
				} catch (InterruptedException e){ }
			g.setColor(Color.white);
			g.fillRect(getWidth()/2-36, getHeight()/2-25, 62,20);
			try {
					Thread.sleep(1500);
				} catch (InterruptedException e){ }
			b1.restart((int) (.5*width), (int) (.4*height), (int) (width/30));
			b1.paint (g);
			over = false;
			p1.setWin (false);
			p2.setWin (false);

			if (balldirection==3)
				balldirection=4;
			if (balldirection==4)
				balldirection=3;
			if (balldirection==1)
				balldirection=3;
			if (balldirection==2)
				balldirection=4;
			this.ychange=0;
			return;


		}


 		g.setColor(getBackground());
		g.setColor(Color.black);
		g.drawRect(((int) (getWidth()*.1)),top,width,height);
		g.setColor(Color.red);
		g.drawString ("CPU",(int)(getWidth()*.15),(int)(getHeight()*.85));
		g.drawString ("You",(int)(getWidth()*.85),(int)(getHeight()*.85));

		p1.paint(g);
		p2.paint(g);


		move(g);

		int ycor= p2.getY();
		p2.setOldY(ycor);
	}
	if (main ==true)
	{
		setBackground(Color.white);
		if(mainbegin==true)
		{
			g.setColor(Color.white);
			g.fillRect(0, 0, getWidth(),getHeight());
			mainbegin=false;
		}
		g.drawImage(logo, 107, 0, this);
		startGame.draw(g);
		options.draw(g);
	}
	if (opt ==true)
	{
		setBackground(Color.white);
		if(optbegin==true)
		{
			g.setColor(Color.white);
			g.fillRect(0, 0, getWidth(),getHeight());
			optbegin=false;
		}
		g.drawImage (difficulty,107, 0,this);
		easy.draw(g);
		medium.draw(g);
		hard.draw(g);
	}
}
}