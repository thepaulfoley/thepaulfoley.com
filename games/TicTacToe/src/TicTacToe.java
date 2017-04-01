



import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;

public class TicTacToe extends Applet implements KeyListener, MouseMotionListener, MouseListener, Runnable{

	Board board;
	int turn;
	int width;
	int height;
	int delay;
	Player human1;
	Player human2;
	Player computer;
	Menu welcomeMenu, gameMenu, activeMenu;
	Button youButton, cpuButton, restartButton;
	Thread manager;
	Random generator;
	String mode;
	Graphics g;

	public void init(){
		String debug = getParameter("debug");
		Debugger.init(debug);
		g=this.getGraphics();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		width=600;
		height=600;
		this.turn=2;
		this.delay=2000;
		this.setSize(width, height);
		board = new Board(this.width, this.height);
		this.human1 = new Human(TicTacToeConstants.FIRST_TURN);
		this.human2 = new Human(TicTacToeConstants.SECOND_TURN);
		this.computer= new Computer(TicTacToeConstants.SECOND_TURN);
		generator= new Random();
		mode=TicTacToeConstants.SINGLE_PLAYER_MODE;
		initMenus();
		initButtons();
		addButtonsToMenus();
		activeMenu=welcomeMenu.setActive();
		manager= new Thread(this);
		manager.start();
	}

	private void reset(){
		Debugger.debug("*** Resetting ***");
		this.turn=2;
		board = new Board(this.width, this.height);
		this.human1 = ((Human)human1).reset();
		this.human2 = ((Human)human2).reset();
		this.computer = ((Computer)computer).reset();		

	}



	public void run() {
		while(true){
			if(activeMenu.type.equals("game")){
				while(!gameOver() && activeMenu.type.equals("game")){
					if(mode==TicTacToeConstants.SINGLE_PLAYER_MODE){
						if(turn%2==((Computer)computer).turn-1){
							pause(delay);
							if(computer.smartTurn(generator.nextInt(3), generator.nextInt(3), board))
								this.turn++;
							paintBoard();
						}

					}
				}
				Debugger.debug("*** Exited game loop ***");
				if(board.isThereAWinner()){
					if(turn%2==((Computer)computer).turn-1)
						showMessage("You win!!!", true);
					else
						showMessage("CPU wins!!!", true);
				}
				else if(board.isFull()){
					showMessage("Tie game.", true);
				}
				reset();
				repaint();
			}
		}
	}

	public void pause(int delay){
		try
		{
			Thread.sleep(delay);
		} catch (InterruptedException e){
			Debugger.print("Pause: game did not pause");
		}
	}

	public void showMessage(String message, boolean pause){
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(200, 290, 250, 20);
		g.setColor(Color.black);
		g.drawString(message, 205, 299);
		if(pause)
			pause(5000);

	}

	private void paintBoard() {
		board.paint(g);

	}



	private boolean gameOver() {	
		return this.board.isFull() || this.board.isThereAWinner();
	}

	private void handleGameClick(MouseEvent me){
		Debugger.debug("turn="+turn);
		if(this.turn%2==((Human) human1).turn-1){
			if(this.human1.takeTurn(me.getX(), me.getY(), this.board)){		
				this.turn++;
				paintBoard();
			}
		}
		if(this.mode.equals(TicTacToeConstants.TWO_PLAYER_MODE)){
			if(this.turn%2==((Human) human2).turn-1){
				if(this.human2.takeTurn(me.getX(), me.getY(), this.board)){		
					this.turn++;
					paintBoard();
				}
			}
		}

	}

	public void keyReleased(KeyEvent ke) {
		
		if(!Debugger.getMode().equals("n") &&
				mode==TicTacToeConstants.TWO_PLAYER_MODE &&
				ke.getKeyCode()==KeyEvent.VK_SPACE){
			
			//computer.takeTurn(1, 1, this.board);
			computer.smartTurn(1, 1, this.board);
			this.turn++;
			paintBoard();
		}
	}
	private void handleButtonClick(MouseEvent me){
		int index=activeMenu.buttonClicked(me.getX(), me.getY());
		Debugger.debug("Index = " +index);
		if(index>=0){
			Button b=activeMenu.getButton(index);
			Debugger.debug("Button clicked: " + b);
			Debugger.debug("old menu:" + activeMenu);
			if(b.type.equals("you")){
				((Human)human1).setTurn(TicTacToeConstants.FIRST_TURN);
				((Human)human2).setTurn(TicTacToeConstants.SECOND_TURN);
				((Computer)computer).setTurn(TicTacToeConstants.SECOND_TURN);
			}
			if(b.type.equals("cpu")){
				((Human)human1).setTurn(TicTacToeConstants.SECOND_TURN);
				((Human)human2).setTurn(TicTacToeConstants.FIRST_TURN);
				((Computer)computer).setTurn(TicTacToeConstants.FIRST_TURN);
			}

			activeMenu=b.goTo().setActive();
			Debugger.debug("new menu: " + activeMenu);
			repaint();
		}

	}
	public void mouseReleased(MouseEvent me) {
		Debugger.debug("Mouse Clicked");

		if(activeMenu.type.equals("game")){
			handleGameClick(me);

		}
		handleButtonClick(me);




	}

	public void paint(Graphics g){
		activeMenu.draw(g);
		if(activeMenu.type.equals("game"))
			board.paint(g);

	}

	public void initMenus(){
		try{
			welcomeMenu= Menu.create("welcome", this);
			gameMenu = Menu.create("game", this);
		}
		catch (Exception e){}
	}

	public void initButtons(){
		try{
			youButton=Button.create("you", gameMenu, this);//, 156, 190);
			cpuButton=Button.create("cpu", gameMenu, this);//, 310, 535);
			restartButton= Button.create("restart", welcomeMenu, this);//, 156, 300);

		}
		catch (Exception e){}
	}

	public void addButtonsToMenus(){
		welcomeMenu.addButton(youButton, 50, 215);
		welcomeMenu.addButton(cpuButton, 325, 215);	
		gameMenu.addButton(restartButton, 187, 500);
	}





	public void mouseClicked(MouseEvent e) {

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





	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}





	public void mouseMoved(MouseEvent me) {
		activeMenu.refresh(me.getX(), me.getY());

	}



	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}






}
