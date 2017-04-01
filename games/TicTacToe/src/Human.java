


public class Human extends Player{

	int turn;
	public Human(int turn){
		this.turn=turn;
	}
	
	public void setTurn(int n){
		turn=n;
		
	}
	
	public Human reset(){
		return new Human(this.turn);
		
	}
	
	
	@Override
	public boolean takeTurn(int x, int y, Board board) {
		Debugger.debug("Human is taking turn!");
		int row=board.determineRow(y);
		int col=board.determineColumn(x);
		if(row!=-1 && col!=-1){
			return board.addPiece(row, col, turn);
			

		}
		return false;
	}
	
	@Override
	public boolean smartTurn(int x, int y, Board board) {
		return this.takeTurn(x, y, board);
	}

}

