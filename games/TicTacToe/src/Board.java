
import java.awt.*;
import java.util.ArrayList;


public class Board {

	int x;
	int y;
	int size;
	int boxSize;
	int[][] boxes= new int[3][3];

	/**
	 * Construct a new Board
	 * @param width - width of the board
	 * @param height - height of the board
	 */
	public Board(int width, int height){
		this.size=300;
		this.x=((int)(width-this.size)/2);
		this.y=((int)(height-this.size)/2);
		this.boxSize=this.size/3;
		for(int rows=0; rows<3; rows++){
			for(int cols=0; cols<3; cols++){
				boxes[rows][cols]=0;
			}
		}
	}
	
	/**
	 * remove all pieces from the board. Sets each value of boxes to 0.
	 */
	public Board clear(){
		for(int rows=0; rows<3; rows++){
			for(int cols=0; cols<3; cols++){
				this.boxes[rows][cols]=0;
			}
		}
		return this;
	}
	
	/**
	 * return the values in the corner boxes
	 * @return returns an array of ints 
	 * representing the values in the corner 
	 * boxes. the values are ordered from
	 * the top-left of the board to the bottom-right.
	 * 
	 * Ex. the third value in the array is the value
	 * in row 2, column 0 of the board
	 */
	public int[] getCorners(){
		return new int[]{boxes[0][0], boxes[0][2], boxes[2][0], boxes[2][2]};
		
	}
	
	/**
	 * return the values in the side boxes
	 * @return returns an array of ints 
	 * representing the values in the side 
	 * boxes. the values are ordered from
	 * the top-left of the board to the bottom-right.
	 * 
	 * Ex. the third value in the array is the value
	 * in row 1, column 2 of the board
	 */
	public int[] getSides(){
		return new int[]{boxes[0][1], boxes[1][0], boxes[1][2], boxes[2][1]};
		
	}
	
	/**
	 * return the values in the center box
	 * @return an int representing
	 * the value in the center of the board
	 */
	public int getCenter(){
		return boxes[1][1];
		
	}
	
	/**
	 * return the value in the given row and column 
	 * of the board
	 * @param row
	 * @param col
	 * @return return an int representing which turn 
	 * has a piece in the box. if the box is empty,
	 * return 0
	 */
	public int getBox(int row, int col ){ 
		return this.boxes[row][col];
	} 
	
	/**
	 * return the number of pieces on
	 * this Board
	 * @return int representing the number 
	 * of pieces
	 */
	public int getNumberOfPieces(){
		int n=0;
		for( int row=0;row<3;row++ ){  
			for( int col=0; col<3; col++ ){  
				if(boxes[row][col]!= 0)
					n++;
			} 
		}
		return n;
	}

	/**
	 * determines whether the given coordinates 
	 * are within the playing area of the Board
	 * @param x - x-coordinate 
	 * @param y - y-coordinate
	 * @return
	 */
	public boolean isWithin(int x, int y){
		return (((x >= this.x) && (x<=(this.x + this.boxSize*3)))
				&& ((y >= this.y) && (y<=(this.y + this.boxSize*3))));
	}

	/**
	 * Given the current turn, determines which
	 * if any boxes could result in a win
	 * @param turn - the turn of the current player
	 * @return
	 */
	public Point getWinningBox(int turn){
		Point p=getRowWin(turn);
		if(p.getX()!=-1 && p.getY()!=-1){
			return p;
		}
		p=getColWin(turn);
		if(p.getX()!=-1 && p.getY()!=-1){
			return p;
		}
		p=getDiagonalWin(turn);

		return p;

	}
	/**
	 * determine which box, if any, would
	 * result in a player getting a win across 
	 * a row
	 * @param turn - the current turn
	 * @return
	 */
	private Point getRowWin(int turn) {
		Point p=new Point(-1,-1);
		Point temp=new Point(-1,-1);
		int count=0;
		for(int r=0; r<3 ;r++){
			for(int c=0; c<3; c++){
				if(this.boxes[r][c]==turn)
					count++;
				if(this.boxes[r][c]==0)
					temp=new Point(r, c);			
			}
			if(count==2 && !temp.equals(p))
				return temp;
			count=0;
			temp=new Point(-1,-1);
		}
		return p;
	}
/**
 * determine which box, if any, would
 * result in a win down a column 
 * 
 * @param turn-the current turn
 * @return
 */
	private Point getColWin(int turn) {
		Point p=new Point(-1,-1);
		Point temp=new Point(-1,-1);
		int count=0;
		for(int c=0; c<3 ;c++){
			for(int r=0; r<3; r++){
				if(this.boxes[r][c]==turn)
					count++;
				if(this.boxes[r][c]==0)
					temp=new Point(r, c);			
			}
			if(count==2 && !temp.equals(p))
				return temp;
			count=0;
			temp=new Point(-1,-1);
		}
		return p;
	}
	
	/**
	 * Returns a list of the boxes that border the given box
	 * @param row - row of the box for which you want to find
	 * the bordering boxes
	 * @param col - column of the box for which you want to find
	 * the bordering boxes
	 * @return an ArrayList of Points representing the bordering boxes
	 */
	public ArrayList<Point> getBorderingBoxes(int row, int col){
		ArrayList<Point> boxes=new ArrayList<Point>();
		if((row>=0 && row<3) && (col>=0 && col<3)){		
			boxes.add(new Point(row-1, col-1));
			boxes.add(new Point(row-1, col));
			boxes.add(new Point(row-1, col+1));			
			boxes.add(new Point(row, col-1));
			boxes.add(new Point(row, col+1));			
			boxes.add(new Point(row+1, col-1));
			boxes.add(new Point(row+1, col));
			boxes.add(new Point(row+1, col+1));
			
		}
		
		for(int index=0; index<boxes.size(); index++){
			Point p=boxes.get(index);
			if((p.x<0 || p.x>2)||
					(p.y<0 || p.y>2)){
				boxes.remove(index);
				index--;
			}
		}
		
		return boxes;
	}

	public ArrayList<Point> getBorderingBoxes(Point p){
		return this.getBorderingBoxes(p.x, p.y);
	}
	
	/**
	 * Returns a list of the boxes that are kitty corner to 
	 * the given box
	 * @param row - row of the box for which you want to find
	 * the bordering boxes
	 * @param col - column of the box for which you want to find
	 * the bordering boxes
	 * @return an ArrayList of Points representing the kitty corner boxes
	 */
	public ArrayList<Point> getKittyCornerBoxes(int row, int col){
		ArrayList<Point> boxes=new ArrayList<Point>();
		if((row>=0 && row<3) && (col>=0 && col<3)){		
			boxes.add(new Point(row-2, col-1));
			boxes.add(new Point(row-2, col+1));
			boxes.add(new Point(row+2, col-1));
			boxes.add(new Point(row+2, col+1));
			
			boxes.add(new Point(row-1, col-2));
			boxes.add(new Point(row-1, col+2));
			boxes.add(new Point(row+1, col-2));
			boxes.add(new Point(row+1, col+2));
			
			
		}
		
		for(int index=0; index<boxes.size(); index++){
			Point p=boxes.get(index);
			if((p.x<0 || p.x>2)||
					(p.y<0 || p.y>2)){
				boxes.remove(index);
				index--;
			}
		}
		
		return boxes;
	}
	
	public ArrayList<Point> getKittyCornerBoxes(Point p){
		return this.getKittyCornerBoxes(p.x, p.y);
	}
	
	/**
	 * Returns a list of the boxes that are adjacent to the given box
	 * @param row - row of the box for which you want to find
	 * the bordering boxes
	 * @param col - column of the box for which you want to find
	 * the bordering boxes
	 * @return an ArrayList of Points representing the bordering boxes
	 */
	public ArrayList<Point> getAdjacentBoxes(int row, int col){
		ArrayList<Point> boxes=new ArrayList<Point>();
		if((row>=0 && row<3) && (col>=0 && col<3)){		
			boxes.add(new Point(row-1, col));					
			boxes.add(new Point(row, col-1));
			boxes.add(new Point(row, col+1));			
			boxes.add(new Point(row+1, col));
			
			
		}
		
		for(int index=0; index<boxes.size(); index++){
			Point p=boxes.get(index);
			if((p.x<0 || p.x>2)||
					(p.y<0 || p.y>2)){
				boxes.remove(index);
				index--;
			}
		}
		
		return boxes;
	}
	
	/**
	 * 
	 * @return An ArrayList of Points representing 
	 * the corners of this Board
	 */
	public ArrayList<Point> getCornerBoxes(){
		ArrayList<Point> corners = new ArrayList<Point>();
		
		corners.add(new Point(0,0));
		corners.add(new Point(2,0));
		corners.add(new Point(0,2));
		corners.add(new Point(2,2));
		
		return corners;
	}
	
	/**
	 * 
	 * @return An ArrayList of Points representing 
	 * the sides of this Board
	 */
	public ArrayList<Point> getSideBoxes(){
		ArrayList<Point> sides = new ArrayList<Point>();
		
		sides.add(new Point(1,0));
		sides.add(new Point(0,1));
		sides.add(new Point(2,1));
		sides.add(new Point(1,2));
		
		return sides;
	}
	
	/**
	 * Returns a list of the boxes that are adjacent to the given box
	 * @param p - Point representing a box
	 * @return an ArrayList of Points representing the bordering boxes
	 */
	public ArrayList<Point> getAdjacentBoxes(Point p){	
		return this.getAdjacentBoxes(p.x, p.y);
	}
	
	/**
	 * Returns the box that is opposite the given box
	 * @param row - row of the box for which you want to find
	 * the opposite box
	 * @param col - column of the box for which you want to find
	 * the opposite box
	 * @return a Point representing the opposite box
	 */
	public Point getOppositeBox(int row, int col){
		return new Point(2-row, 2-col );
		//return new Point((Math.abs((row-3)%3)+1), (Math.abs((col-3)%3)+1) );
	}
	
	public Point getOppositeBox(Point p){
		return this.getOppositeBox(p.x, p.y);
	}
	
	/**
	 * determine if two boxes on this Board are opposite
	 * each other
	 * @param p1 Point representing the first box
	 * @param p2 Point representing the second box
	 * @return True if p1 and p2 are opposite each other. 
	 * Otherwise, returns false.
	 */
	public boolean areOpposite(Point p1, Point p2){
		return getOppositeBox((int)p1.getX(), (int)p1.getY()).equals(p2);
	}
	
	/**
	 * determine if two boxes on this Board are bordering
	 * each other
	 * @param p1 Point representing the first box
	 * @param p2 Point representing the second box
	 * @return True if p1 and p2 are bordering each other. 
	 * Otherwise, returns false.
	 */
	public boolean areBordering(Point p1, Point p2){
		return getBorderingBoxes((int)p1.getX(), (int)p1.getY()).contains(p2);
	}
	
	/**
	 * determine if two boxes on this Board are adjacent 
	 * to each other
	 * @param p1 Point representing the first box
	 * @param p2 Point representing the second box
	 * @return True if p1 and p2 are adjacent to  each other. 
	 * Otherwise, returns false.
	 */
	public boolean areAdjacent(Point p1, Point p2){
		return getAdjacentBoxes((int)p1.getX(), (int)p1.getY()).contains(p2);
	}
	
	/**
	 * determine if two boxes on this Board are kitty corner 
	 * to each other
	 * @param p1 Point representing the first box
	 * @param p2 Point representing the second box
	 * @return True if p1 and p2 are kitty corner to  each other. 
	 * Otherwise, returns false.
	 */
	public boolean areKittyCorner(Point p1, Point p2){
		return getKittyCornerBoxes((int)p1.getX(), (int)p1.getY()).contains(p2);
	}
	
	/**
	 * determine if a Point is the center of the Board
	 * @param p - point representing a box on the Board 
	 * @return true if p is the center, false otherwise
	 */
	public boolean isCenter(Point p){
		return (p.getX()==1 && p.getY()==1);
	}
	
	/**
	 * determine if a Point is a corner on the Board
	 * @param p - point representing a box on the Board 
	 * @return true if p is a corner, false otherwise
	 */
	public boolean isCorner(Point p){
		return (p.getX()==0 && p.getY()==0) ||
				(p.getX()==2 && p.getY()==0) ||
				(p.getX()==0 && p.getY()==2) ||
				(p.getX()==2 && p.getY()==2);
	}
	
	/**
	 * determine if a Point is a side on the Board
	 * @param p - point representing a box on the Board 
	 * @return true if p is a side, false otherwise
	 */
	public boolean isSide(Point p){
		return (p.getX()==1 && p.getY()==0) ||
				(p.getX()==0 && p.getY()==1) ||
				(p.getX()==2 && p.getY()==1) ||
				(p.getX()==1 && p.getY()==2);
	}

	/**
	 * Determine which box, if any, would result in a win
	 * along a diagonal 
	 * @param turn - the current turn
	 * @return - a Point representing the winning box
	 */
	private Point getDiagonalWin(int turn) {

		Point p=new Point(-1,-1);
		Point temp=new Point(-1,-1);
		int count=0;
		//check diagonal from top left to bottom right
		for(int x=0; x<3 ;x++){

			if(this.boxes[x][x]==turn)
				count++;
			if(this.boxes[x][x]==0)
				temp=new Point(x, x);			


		}
		if(count==2 && !temp.equals(p))
			return temp;
		count=0;

		temp=new Point(-1,-1);
		//check diagonal from top right to bottom left
		for(int n=0; n<3 ;n++){

			if(this.boxes[n][2-n]==turn)
				count++;
			if(this.boxes[n][2-n]==0)
				temp=new Point(n, 2-n);			

		}
		if(count==2 && !temp.equals(p))
			return temp;
		return p;
	}

	/**
	 * Add a piece to the Board
	 * @param row - the row to add the piece to
	 * @param col -  the column to add the piece to
	 * @param turn - the turn representing whether the 
	 * added piece is an 'X' of an 'O'
	 * @return return true if a piece is added, otherwise returns false
	 */
	public boolean addPiece(int row, int col, int turn){
		boolean canAdd = this.canAddPiece(row, col);
		if(canAdd)
			boxes[row][col]=turn;
		return canAdd;

	}
	
	/**
	 * Add a piece to the center of the Board
	 * @param turn - the turn representing whether the 
	 * added piece is an 'X' of an 'O'
	 * @return return true if a piece is added, otherwise returns false
	 */
	public boolean addCenter(int turn){
		int row=1;
		int col=1;
		boolean canAdd = this.canAddPiece(row, col);
		if(canAdd)
			boxes[row][col]=turn;
		return canAdd;

	}	
	
	/**
	 * Add a piece to the first open corner of the Board
	 * @param turn - the turn representing whether the 
	 * added piece is an 'X' of an 'O'
	 * @return return true if a piece is added, otherwise returns false
	 */
	public boolean addCorner(int turn){
		ArrayList<Point> corners=this.getCornerBoxes();
		int row, col;
		for(int x=0; x<corners.size(); x++){
			row=corners.get(x).x;
			col=corners.get(x).y;
			if(this.canAddPiece(row, col)){
				this.boxes[row][col]=turn;
				return true;
			}
		}
		
		return false;

	}
	
	/**
	 * Add a piece to the first open side of the Board
	 * @param turn - the turn representing whether the 
	 * added piece is an 'X' of an 'O'
	 * @return return true if a piece is added, otherwise returns false
	 */
	public boolean addSide(int turn){
		ArrayList<Point> sides=this.getSideBoxes();
		int row, col;
		for(int x=0; x<sides.size(); x++){
			row=sides.get(x).x;
			col=sides.get(x).y;
			if(this.canAddPiece(row, col)){
				this.boxes[row][col]=turn;
				return true;
			}
		}
		
		return false;

	}
	
	/**
	 * Find the first open corner of the Board
	 * @param turn - the turn representing whether the 
	 * added piece is an 'X' of an 'O'
	 * @return return he first open corner of the Board,
	 * if no corners are open, return a new Point(-1, -1)
	 */
	public Point findCorner(int turn){
		ArrayList<Point> corners=this.getCornerBoxes();
		int row, col;
		for(int x=0; x<corners.size(); x++){
			row=corners.get(x).x;
			col=corners.get(x).y;
			if(this.canAddPiece(row, col)){
				return new Point(row, col);
				
			}
		}
		
		return new Point(-1, -1);

	}
	
	/**
	 * Find the first open side of the Board
	 * @param turn - the turn representing whether the 
	 * added piece is an 'X' of an 'O'
	 * @return return he first open side of the Board,
	 * if no corners are open, return a new Point(-1, -1)
	 */
	public Point findSide(int turn){
		ArrayList<Point> sides=this.getSideBoxes();
		int row, col;
		for(int x=0; x<sides.size(); x++){
			row=sides.get(x).x;
			col=sides.get(x).y;
			if(this.canAddPiece(row, col)){
				return new Point(row, col);
				
			}
		}
		
		return new Point(-1, -1);

	}

	/**
	 * given a y-coordinate, determines which row you are in
	 * @param y - y-coordinate 
	 * @return int representing the row
	 */
	public int determineRow(int y){
		int n=0;
		for (;n<3; n++){
			if ( this.y<=y && y<= (this.y + this.boxSize*(n+1)))
				return n;
		}
		return -1;

	}
	/**
	 * given an x-coordinate, determines which column you are in
	 * @param x - x-coordinate 
	 * @return int representing the column 
	 */
	public int determineColumn(int x){
		int n=0;
		for (;n<3; n++){
			if ( this.x<x && x<= (this.x + this.boxSize*(n+1)))
				return n;
		}
		return -1;

	}	

/**
 * determine if there is three in a row anywhere on the Board
 * @return true if there is a winner, otherwise false
 */
	public boolean isThereAWinner(){
		int result=(rowWin() + colWin() + diagonalLeftRightWin() + diagonalRightLeftWin());
		return (result>0);

	}

/**
 * determine which turn, if any, has a winner across a row
 * @return - the turn that has the win. if
 * no row has a winner, return 0
 */
	public int rowWin(){
		for(int rows=0; rows<3; rows++){
			if(!rowEmpty(rows))
			{
				if((this.boxes[rows][0]==this.boxes[rows][1])&&	
						(this.boxes[rows][0]==this.boxes[rows][2]))	
					return this.boxes[rows][0];

			}
		}
		return 0;
	}

	/**
	 * determine which turn, if any, has a winner down a column
	 * @return - the turn that has the win. if
	 * no row has a winner, return 0
	 */	public int colWin(){
		for(int cols=0; cols<3; cols++){
			if(!colEmpty(cols))
			{
				if((this.boxes[0][cols]==this.boxes[1][cols])&&	
						(this.boxes[0][cols]==this.boxes[2][cols]))	
					return this.boxes[0][cols];
			}

		}
		return 0;
	}
/**
 * determine which turn, if any has a win
 * along the diagonal from the top left to the 
 * bottom right corner 
 * @return the turn with the win. if there is none, return 0
 */
	public int diagonalLeftRightWin(){
		int center=this.boxes[1][1];
		if(diagonalLeftRightEmpty())
			return 0;
		else if((center==this.boxes[0][0])&&(center==this.boxes[2][2]))
			return center;
		else 
			return 0;
	}
	/**
	 * determine which turn, if any has a win
	 * along the diagonal from the top right to the 
	 * bottom left corner 
	 * @return the turn with the win. if there is none, return 0
	 */
	public int diagonalRightLeftWin(){
		int center=this.boxes[1][1];
		if(diagonalRightLeftEmpty())
			return 0;
		else if((center==this.boxes[0][2])&&(center==this.boxes[2][0]))
			return center;
		else
			return 0;
	}		

	/**
	 * determine if the row is empty
	 * @param row - int row
	 * @return true if it is empty, otherwise false
	 */
	public boolean rowEmpty(int row){
		return ((this.boxes[row][0]==0) &&
				(this.boxes[row][1]==0) &&
				(this.boxes[row][2]==0));
	}

	/**
	 * determine if the column is empty
	 * @param col - int column
	 * @return true if it is empty, otherwise false
	 */
	public boolean colEmpty(int col){
		return ((this.boxes[0][col]==0) &&
				(this.boxes[1][col]==0) &&
				(this.boxes[2][col]==0));
	}

	/**
	 * determine if the diagonal from 
	 * the top left to bottom right is empty
	 * @return true if it is empty, otherwise false
	 */
	public boolean diagonalLeftRightEmpty(){
		return ((this.boxes[0][0]==0) &&
				(this.boxes[1][1]==0) &&
				(this.boxes[2][2]==0));
	}

	/**
	 * determine if the diagonal from 
	 * the top right to bottom left is empty
	 * @return true if it is empty, otherwise false
	 */
	public boolean diagonalRightLeftEmpty(){
		return ((this.boxes[0][2]==0) &&
				(this.boxes[1][1]==0) &&
				(this.boxes[2][0]==0));
	}	

	/**
	 * determine if the board is full
	 * @return true if it is full, otherwise false
	 */
	public boolean isFull(){
		for(int r=0; r<3; r++){
			for(int c=0;c<3;c++){
				if(!this.occupied(r, c))
					return false;
			}
		}
		return true;
	}
/**
 * determine if the specified box on the board is occupied 
 * @param row - int row
 * @param col - int col
 * @return - true if it is occupied, false otherwise
 */
	public boolean occupied(int row, int col){
		return ((this.boxes[row][col]==1) || (this.boxes[row][col]==2));
	}

	public boolean occupied(Point p){
		return this.occupied(p.x, p.y);
	}
	/**
	 * draws an 'x' if turn equals 1 and an 'o' if turn equals 2
	 * @param row
	 * @param col
	 * @param g
	 */
	public void drawBox(int row, int col, Graphics g){
		int boxX=(this.x+this.boxSize*col);
		int boxY=(this.y+this.boxSize*row);
		int xOrO=this.boxes[row][col];
		g.drawRect(boxX, boxY, this.boxSize, this.boxSize);
		if(xOrO==TicTacToeConstants.FIRST_TURN){
			g.drawLine(boxX, boxY, (boxX+this.boxSize), (boxY+this.boxSize));
			g.drawLine((boxX+this.boxSize), boxY, boxX, (boxY+this.boxSize));
		}
		if(xOrO==TicTacToeConstants.SECOND_TURN)
			g.drawOval(boxX, boxY, this.boxSize, this.boxSize);
	}

/**
 * paint this Board
 * @param g - Graphics object to draw 
 */
	public void paint(Graphics g){
		for(int rows=0; rows<3; rows++){
			for(int cols=0; cols<3; cols++){
				drawBox(rows, cols, g);
			}
		}
	}
/**
 * Determine if a piece can be added to the board
 * @param row - int row
 * @param col - int column
 * @return - true if the board is not full, if there
 * is not a winner and the specified box is not occupied. 
 * otherwise, return false
 */
	private boolean canAddPiece(int row, int col) {
		return ((row>=0 && row<=2) && (col>=0 && col<=2) && !this.occupied(row, col)
				&& !this.isThereAWinner() && !this.isFull());
	}


}
