import java.awt.*; 
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.applet.*;
import java.net.*;
import java.util.ArrayList;
public class GoFish extends Applet implements Runnable, MouseListener, MouseMotionListener{

	Deck d1;
	Player p1;
	Graphics g;
	int turn;
	Computer cpu;
	Thread action;
	String message;
	int cpuTurn=0;
	int p1Turn=1;
	private Menu mainMenu, instructionsMenu, gameMenu, setupMenu, activeMenu;
	private Button startButton, playButton, instructionsButton, backButton;
	TextField name;






	public void init(){
		g=this.getGraphics();
		this.setSize(600, 600);	
		this.setBackground(new Color(70, 128, 60));
		p1 = new Human("", new Hand(), new Hand(), 50, 50);
		cpu = new Computer("CPU", new Hand(), new Hand(), 50, 320);
		name=new TextField(50);
		this.add(name);
		name.setVisible(true);
		initMenus();
		initButtons();
		addButtonsToMenus();
		activeMenu=mainMenu.setActive();
		turn=0;
		action = new Thread(this);
		d1=Deck.create(this);
		d1.shuffle();
		message="";

		//deal();
		addMouseListener(this);
		addMouseMotionListener(this);
		action.start();

	}
	
	public void reset(){
		p1 = new Human("", new Hand(), new Hand(), 50, 50);
		cpu = new Computer("CPU", new Hand(), new Hand(), 50, 320);
		name.setText("");
		activeMenu=mainMenu.setActive();
		turn=0;
		d1=Deck.create(this);
		d1.shuffle();
		message="";
		repaint();

	}

	public void run(){
		name.setLocation(100, 225);
		
		while(true){
			
			//
			if(activeMenu.equals(gameMenu)){
				
				Card c;
				paintScores();
				this.message="Please wait while the cards are dealt.";
				showMessage(message, true);
				deal();
				while(!gameOver()){
					if(turn==0){


						paintHand(p1);	

						paintHand(cpu);

						removePairs(p1);
						removePairs(cpu);
					}
					if((turn+2)%2==cpuTurn){
						c=cpu.select(d1); //CPU selects Card to ask for
						runTurn(cpu, c, p1);
						//removePairs(cpu);
						//paintHand(cpu);
					}       			
				}
				message ="Game Over";
				showMessage(message, true);
				if(p1.getScore()>cpu.getScore()){
					message=p1.getName()+" won!";
				}
				else if(p1.getScore()==cpu.getScore()){
					message="Tie game.";
				}
				else{
					message=cpu.getName()+" won!";
				}
				showMessage(message, true);
				reset();
			}
		}
	}






	public void paint(Graphics g){
		name.setLocation(100, 225);
		
		activeMenu.draw(g);
		name.setVisible(activeMenu.equals(setupMenu));
		if(activeMenu.equals(gameMenu)){
			paintScores();
			paintHand(cpu);
			paintHand(p1);
			showMessage(this.message, false);
		}
		name.repaint();



	}

	public void showMessage(String message, boolean pause){
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(200, 195, 250, 20);
		g.setColor(Color.black);
		g.drawString(message, 205, 209);
		if(pause)
			pause(2000);

	}

	public void paintScores(){
		p1.drawScore(20,20,g, this);
		cpu.drawScore(20, 460, g, this);
	}

	public void paintHand(Player p){
		p.getCards().draw(p.getX(), p.getY(),p.isVisible(), g, this);
	}

	public void paintMenu(Menu m){
		m.draw(g);
	}

	public boolean gameOver(){
		return p1.getCards().isEmpty()&&
		cpu.getCards().isEmpty()&&
		d1.getCards().isEmpty();
	}
	


	public void mouseClicked(MouseEvent me) {
		System.out.println("Mouse Clicked");
		int index=activeMenu.buttonClicked(me.getX(), me.getY());
		System.out.println("Index = " +index);
		if(index>=0){
			Button b=activeMenu.getButton(index);
			System.out.println("Button clicked: " + b);
			System.out.println("old menu:" + activeMenu);
			if(b.goTo().equals(gameMenu)){
				if(name.getText().trim().equals("")){
					p1.setName("You");
				}
				else{
				p1.setName(name.getText());
				}
			}
			if(b.goTo().equals(setupMenu)){
				//name.setVisible(true);
				System.out.println("Textfield visibility:"+name.isVisible());
			}
			activeMenu=b.goTo().setActive();
			System.out.println("new menu: " + activeMenu);
			repaint();
			/*try{
				Thread.sleep(500);
			}
			catch(Exception e){}*/
		}
		if(activeMenu.equals(gameMenu)){
			if(((turn+2)%2==p1Turn)&&!gameOver()){
				Card c = ((Human)p1).select(me.getX(), me.getY(), d1);
				runTurn(p1,c,cpu);
				//removePairs(p1);
				//paintHand(p1);
			}
		}
//		
	}

	public void removePairs(Player p){
		Card c=p.removePairs();
		while(c.getValue()!=0){
			paintHand(p);
			this.message=p.getName().concat(" removed a pair of ").concat(c.valString()).concat("s.");
			showMessage(message, true);
			c=p.removePairs();
			paintScores();

		}
	}

	public void runTurn(Player asking, Card selected, Player asked){
		String val=selected.valString(); //value of Card selected
		String suit=selected.suitString(); //suit of Card selected
		String askingName=asking.getName();
		String askedName=asked.getName();
		//if(!suit.equals("e")){
		if(!val.equals("0")){
			if(selected.getValue()==1 || selected.getValue()==8)
				this.message=askingName.concat(" asked ").concat(askedName).concat(" for an ").concat(val);
			else
				this.message=askingName.concat(" asked ").concat(askedName).concat(" for a ").concat(val);
			showMessage(this.message, true);

		}

		int turnResult=asking.takeTurn(selected, asked, d1); //the asking Player takes their turn
		/*paintHand(asking);	
		paintHand(asked);
		paintScores();*/
		//The following code determines what action the game should take
		// based on the result of the Player's turn. see takeTurn method 
		//of the Player class
		if(turnResult==1){
			paintHand(asking);	
			paintHand(asked);
			paintScores();
			this.message = askingName.concat(" took the ").concat(val).concat(" from ").concat(askedName);
			showMessage(this.message, true);
			if(askingName.equalsIgnoreCase("You"))
				this.message=askingName.concat("r turn again.");
			else
				this.message=askingName.concat("'s turn again.");
			showMessage(message,((turn+2)%2==cpuTurn));
		}

		if(turnResult==2){
			paintHand(asking);	
			paintScores();
			this.message=askingName.concat(" fished the wish!");
			showMessage(this.message, true);
			if(askingName.equalsIgnoreCase("You"))
				this.message=askingName.concat("r turn again.");
			else
				this.message=askingName.concat("'s turn again.");
			showMessage(message,((turn+2)%2==cpuTurn));
		}

		if(turnResult==3){
			paintHand(asking);
			this.message=askingName.concat(" went fishing. ");
			showMessage(this.message, true);
			removePairs(asking);
			paintHand(asking);
			if(askedName.equalsIgnoreCase("You"))
				this.message=askedName.concat("r turn.");
			else
				this.message=askedName.concat("'s turn.");
			showMessage(this.message, ((turn+2)%2==p1Turn));
			turn++;
		}

		if(turnResult==4){
			this.message=askingName.concat(" couldn't go fishing because\nthe deck is empty.");
			showMessage(this.message, true);
			turn++;
		}
		if(asking.getCards().isEmpty()&& !d1.getCards().isEmpty()){
			asking.getCards().addCard(d1.removeCard(0));
			paintHand(asking);
			this.message=askingName.concat(" took a card from the deck.");
			showMessage(this.message, true);
		}
		if(asked.getCards().isEmpty()&& !d1.getCards().isEmpty()){
			asked.getCards().addCard(d1.removeCard(0));
			paintHand(asked);
			this.message=askedName.concat(" took a card from the deck.");
			showMessage(this.message, true);			
		}


	}

	public void pause(int delay){
		try
		{
			Thread.sleep(delay);
		} catch (InterruptedException e){
			System.out.println("Pause: game did not pause");
		}
	}

	public void deal(){
		for(int x=1; x<=14; x++){
			if(x%2==1){
				try {
					p1.getCards().addCard(d1.removeCard(0));

				} catch (Exception e) {}
				paintHand(p1);
			}
			else{
				try {
					cpu.getCards().addCard(d1.removeCard(0));

				} catch (Exception e) {}
				paintHand(cpu);
			}
			pause(250);
		}
	}

	public void initMenus(){
		try{
			instructionsMenu= Menu.create("instructions", this);
			mainMenu = Menu.create("main", this);
			gameMenu = Menu.create("game", this);
			setupMenu = Menu.create("setup", this);
		}
		catch (Exception e){}
	}

	public void initButtons(){
		try{
			startButton=Button.create("start", setupMenu, this);//, 156, 190);
			playButton=Button.create("start", gameMenu, this);//, 310, 535);
			instructionsButton= Button.create("instructions", instructionsMenu, this);//, 156, 300);
			backButton = Button.create("back", mainMenu, this);//, 310, 535);
		}
		catch (Exception e){}
	}

	public void addButtonsToMenus(){
		mainMenu.addButton(instructionsButton, 156, 300);
		mainMenu.addButton(startButton, 156, 190);
		instructionsMenu.addButton(backButton, 310, 535);
		instructionsMenu.addButton(startButton, 7, 535);
		setupMenu.addButton(backButton, 310, 535);
		setupMenu.addButton(playButton, 7, 535);		
	}


	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseMoved(MouseEvent me) {
		activeMenu.refresh(me.getX(), me.getY());

	}



}
