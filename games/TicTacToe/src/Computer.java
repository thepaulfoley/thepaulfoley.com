

import java.util.ArrayList;
import java.util.Random;
import java.awt.*;




public class Computer extends Player{

	int turn;
	ArrayList<Point> moves;
	String moveSummary;

	public Computer(int turn){
		setTurn(turn);
		moves=new ArrayList<Point>();
		moveSummary="";
	}

	public Computer reset(){
		return new Computer(this.turn);

	}

	public void setTurn(int n){
		turn=n;

	}

	@Override
	public boolean takeTurn(int row, int col, Board board) {
		Debugger.debug("Computer is taking turn!");
		Debugger.debug("Original (row, col) is ("+row+", "+col+")");
		addOpponentsLastMove(board);
		Point p;
		p=board.getWinningBox(turn);
		if(!board.isFull()){
			if(p.getX()!=-1 && p.getY()!=-1){
				Debugger.debug("Found winning box.");
				Debugger.debug("Adding piece at" + p.getX()+","+p.getY());
				this.moves.add(p);
				Debugger.debug("Moves:"+moves);
				return board.addPiece((int)p.getX(), (int)p.getY(), turn);
			}
			p=board.getWinningBox(turn%2+1);
			if(p.getX()!=-1 && p.getY()!=-1){
				Debugger.debug("Blocking win for opponent");
				Debugger.debug("Adding piece at" + p.getX()+","+p.getY());
				this.moves.add(p);
				Debugger.debug("Moves:"+moves);
				return board.addPiece((int)p.getX(), (int)p.getY(), turn);
			}

			//find an open box if the box specified 
			//by row and col is full
			for( int r=0; r<3; r++ ){ 

				for( int c=0; c<3; c++ ){  

					if(!board.occupied(row%3, col%3)){
						Debugger.debug("Adding piece at" + row+","+col);
						this.moves.add(new Point(row, col));
						Debugger.debug("Moves:"+moves);
						return board.addPiece(row, col, turn);
					}
					col=(col+1)%3;

				} 
				row=(row+1)%3;
			} 

			return false;


		}
		else return false;
	}



	private void addOpponentsLastMove(Board b) {
		Debugger.debug("**** addOpponentsLastMove ****");
		for( int row=0; row<3; row++ ){  
			for( int col=0; col<3; col++ ){  
				Debugger.debug("Checking ["+row+"]["+col+"] = "+b.getBox(row, col));
				if((b.getBox(row, col)==this.turn%2+1) && 
						!this.moves.contains(new Point(row, col))){
					this.moves.add(new Point(row, col));
					Debugger.debug("Opponent's last move was in "+row+", "+col);
				}
			} 
		}
		Debugger.debug("Moves:"+moves);

	}

	/**
	 * Make the right move every time
	 * select winning box if you can win
	 * block opponents win if they can win
	 * generate moves summary, choose best
	 * move based on move summary
	 * @param row
	 * @param col
	 * @param board
	 * @return
	 */
	public boolean smartTurn(int row, int col, Board board) {
		Debugger.debug("Computer is taking smartTurn!");
		Debugger.debug("Original (row, col) is ("+row+", "+col+")");
		addOpponentsLastMove(board);
		Point p;
		//find potential winning move
		p=board.getWinningBox(turn);
		if(!board.isFull()){
			if(p.getX()!=-1 && p.getY()!=-1){
				Debugger.debug("Found winning box.");
				Debugger.debug("Adding piece at" + p.getX()+","+p.getY());
				this.moves.add(p);
				Debugger.debug("Moves:"+moves);
				return board.addPiece((int)p.getX(), (int)p.getY(), turn);
			}
			//find potential winning move for opponent 
			//and block it
			p=board.getWinningBox(turn%2+1);
			if(p.getX()!=-1 && p.getY()!=-1){
				Debugger.debug("Blocking win for opponent");
				Debugger.debug("Adding piece at" + p.getX()+","+p.getY());
				this.moves.add(p);
				this.moveSummary = this.moveSummary.concat("1");
				Debugger.debug("Moves:"+moves);
				return board.addPiece((int)p.getX(), (int)p.getY(), turn);
			}

			if(!makeRightMove(board)){

				//find an open box if the box specified 
				//by row and col is full
				for( int r=0; r<3; r++ ){ 

					for( int c=0; c<3; c++ ){  

						if(!board.occupied(row%3, col%3)){
							Debugger.debug("Adding piece at" + row+","+col);
							this.moves.add(new Point(row, col));
							Debugger.debug("Moves:"+moves);
							return board.addPiece(row, col, turn);
						}
						col=(col+1)%3;
					} 
					row=(row+1)%3;
				}
				return false;
			}
			else return true;
		}
		else return false;
	}

	private boolean makeRightMove(Board board){
		Debugger.debug("**** makeRightMove *****");
		Debugger.debug("moveSummary = "+this.moveSummary);
		Point[] mvs = new Point[10];
		for(int x=1; x<=this.moves.size(); x++){
			mvs[x]=this.moves.get(x-1);
		}
		
		if(this.moves.size()==0){
			this.moveSummary="11";
			Debugger.debug("moveSummary(11) = "+this.moveSummary);
			this.moves.add(new Point(1,1));
			return board.addCenter(turn);
		}
		else if(this.moves.size()==1){
			this.moveSummary="2";
			Debugger.debug("moveSummary(2) = "+this.moveSummary);
			if(board.isCenter(mvs[1])){
				this.moveSummary = this.moveSummary.concat("12");
				Debugger.debug("moveSummary(212) = "+this.moveSummary);
				this.moves.add(new Point(0,0));
				return board.addPiece(0, 0, turn);
			}
			else if(board.isSide(mvs[1])){
				this.moveSummary = this.moveSummary.concat("22");
				Debugger.debug("moveSummary(222) = "+this.moveSummary);
				this.moves.add(new Point(1,1));
				return board.addCenter(this.turn);
			}
			else if(board.isCorner(mvs[1])){
				this.moveSummary = this.moveSummary.concat("32");
				Debugger.debug("moveSummary(232) = "+this.moveSummary);
				this.moves.add(new Point(1,1));
				return board.addCenter(this.turn);
			}
					
		}
		else if(this.moves.size()==2){
			if(board.isCorner(mvs[2] ) ){
				Point opp=board.getOppositeBox(mvs[2]);
				this.moveSummary = this.moveSummary.concat("11");
				Debugger.debug("moveSummary = "+this.moveSummary);
				this.moves.add(opp);
				return board.addPiece(opp.x, opp.y, this.turn);
			}
			else if(board.isSide(mvs[2])){
				ArrayList<Point> adj = board.getAdjacentBoxes(mvs[2]);
				Point adjCorn = new Point(0,0);
				for(int x=0; x<adj.size(); x++){
					if(board.isCorner(adj.get(x))){
						adjCorn=adj.get(x);
						this.moveSummary = this.moveSummary.concat("22");
						Debugger.debug("moveSummary = "+this.moveSummary);
						this.moves.add(adjCorn);
						return board.addPiece(adjCorn.x, adjCorn.y, this.turn);
					}
				}
				
				
				
			}
		}
		
		else if(this.moves.size()==3){
			if(this.moveSummary.equals("212")){
				if(board.areOpposite(mvs[2], mvs[3])){
					this.moveSummary = this.moveSummary.concat("4");
					Debugger.debug("moveSummary = "+this.moveSummary);
					ArrayList<Point> corners= board.getCornerBoxes();
					for(int x=0; x<corners.size(); x++){
						if(!board.occupied(corners.get(x))){
							this.moveSummary = this.moveSummary.concat("2");
							Debugger.debug("moveSummary = "+this.moveSummary);
							this.moves.add(corners.get(x));
							return board.addPiece(corners.get(x).x, corners.get(x).y, this.turn );
						}
					}
					
				}
				
			}
			
			else if(this.moveSummary.equals("222")){
				if(board.isSide(mvs[3]) && 
						!board.areOpposite(mvs[3], mvs[1] )){
					this.moveSummary = this.moveSummary.concat("2");
					ArrayList<Point> adj = board.getAdjacentBoxes(mvs[3]);
					for(int x=0; x<adj.size(); x++){
						if(!board.occupied(adj.get(x))){
							this.moveSummary = this.moveSummary.concat("3");
							this.moves.add(adj.get(x));
							return board.addPiece(adj.get(x).x, adj.get(x).y, this.turn);
						}
					}
					
				}
				
				else if(board.areKittyCorner(mvs[3], mvs[1]) ){
					this.moveSummary = this.moveSummary.concat("3");
					ArrayList<Point> sides = board.getSideBoxes();
					for(int x=0; x<sides.size(); x++){
						if(!board.occupied(sides.get(x)) &&
								!board.areAdjacent(sides.get(x), mvs[3])){
							this.moveSummary = this.moveSummary.concat("1");
							this.moves.add(sides.get(x));
							return board.addPiece(sides.get(x).x, sides.get(x).y, this.turn);
						}
					}
				}
				
				else if(board.areOpposite(mvs[3], mvs[1])){
					this.moveSummary = this.moveSummary.concat("41");
					Point mv = board.findCorner(this.turn);
					this.moves.add(mv);
					return board.addPiece(mv.x, mv.y, this.turn);
					
				}
			}
			
			else if(this.moveSummary.equals("232")){
				if(board.areOpposite(mvs[3], mvs[1])){
					this.moveSummary = this.moveSummary.concat("31");
					Point mv = board.findSide(this.turn);
					this.moves.add(mv);
					return board.addPiece(mv.x, mv.y, this.turn);
				}
				
				else if(board.areKittyCorner(mvs[3], mvs[1])){
					this.moveSummary = this.moveSummary.concat("41");
					ArrayList<Point> corners = board.getCornerBoxes();
					for(int x=0; x<corners.size(); x++){
						Point p=corners.get(x);
						if(!board.occupied(p) && 
								board.areAdjacent(p, mvs[3]) &&
								!board.areOpposite(p, mvs[1])){
							this.moves.add(p);
							return board.addPiece(p.x, p.y, this.turn);
						}
					}
				}
			}
		}
		
		else if(this.moves.size()==4){
			if(this.moveSummary.equals("1111")){
				if(board.areKittyCorner(mvs[4], mvs[2])){
					ArrayList<Point> sides= board.getSideBoxes();
					
					for(int x=0; x<sides.size(); x++){
						Point p = sides.get(x);
						if(!board.occupied(p) &&
								board.areAdjacent(p, mvs[1]) &&
								board.areAdjacent(p, mvs[3])){
							this.moveSummary = this.moveSummary.concat("31");
							this.moves.add(p);
							return board.addPiece(p.x, p.y, this.turn);
						}
					}
				}
			}
			
			else if(this.moveSummary.equals("1122")){
				ArrayList<Point> kc = board.getKittyCornerBoxes(mvs[2]);
				for(int x=0; x<kc.size(); x++){
					Point p=kc.get(x);
					if(!board.occupied(p)){
						this.moveSummary = this.moveSummary.concat("11");
						this.moves.add(p);
						return board.addPiece(p.x, p.y, this.turn);
					}
				}
			}
		}
		
		return false;

	}


}