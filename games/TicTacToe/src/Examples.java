

import java.awt.*;


public class Examples {
	
	
	public Examples(){}
	
	public  static void init(Board b1){
		b1=new Board(600, 600);
	}
	
	public  static void rowEmptyTests(Board b1, int r, boolean exp){
		boolean re= b1.rowEmpty(r);
		
		System.out.println("re = " + (re==exp));
		
	}
	
	public  static void colEmptyTests(Board b1, int c, boolean exp){
		boolean ce= b1.colEmpty(c);
		System.out.println("ce = " + (ce==exp));		
	}
	
	public static void diagonalEmptyTests(Board b1, boolean exp){
		boolean de=(b1.diagonalLeftRightEmpty()||b1.diagonalRightLeftEmpty());
		System.out.println("de = " + (de==exp));
	}
	
	public  static void rowWinTests(Board b1, int exp){
		boolean rw= b1.rowWin()==exp;
		System.out.println("rw = " + rw);
		
	}
	
	public  static void colWinTests(Board b1, int exp){
		boolean cw= b1.colWin()==exp;
		System.out.println("cw = " + cw);
		
	}
	
	public  static void diagonalWinTests(Board b1,  int exp){
		boolean dw= (b1.diagonalLeftRightWin()==exp
				||b1.diagonalRightLeftWin()==exp);
		System.out.println("dw = " + dw);
		
	}
	
	private static void confirm(Object actual, Object expected){
		if(actual.equals(expected)){
			System.out.println("true");
		}
		else{
			System.out.println("\nTest failed:\nExpected:" + expected.toString()+
								"\nbut was " + actual);
			
		}
		
	}
	
	private static void testGetWinningBox(Board b){
		for (int row=0; row<3; row++){
			for(int count = 0; count<3; count++){
				for(int col=0; col<3; col++){
					if(col!=count){
						b.addPiece(row, col, TicTacToeConstants.FIRST_TURN);
					}
				}
				confirm(b.getWinningBox(TicTacToeConstants.FIRST_TURN),(new Point(row, count)));
				b= new Board(300, 300);
			}
		}
		
		for (int col=0; col<3; col++){
			for(int count = 0; count<3; count++){
				for(int row=0; row<3; row++){
					if(row!=count){
						b.addPiece(row, col, TicTacToeConstants.FIRST_TURN);
					}
				}
				confirm(b.getWinningBox(TicTacToeConstants.FIRST_TURN),(new Point(count, col)));
				b= new Board(300, 300);
			}
		}
		
		
			for(int count = 0; count<3; count++){
				for(int col=0; col<3; col++){
					if(col!=count){
						b.addPiece(col, col, TicTacToeConstants.FIRST_TURN);
					}
				}
				confirm(b.getWinningBox(TicTacToeConstants.FIRST_TURN),(new Point(count, count)));
				b= new Board(300, 300);
			}
			
			for(int count = 0; count<3; count++){
				for(int col=0; col<3; col++){
					if(col!=count){
						b.addPiece(col, 2-col, TicTacToeConstants.FIRST_TURN);
					}
				}
				confirm(b.getWinningBox(TicTacToeConstants.FIRST_TURN),(new Point(count, 2-count)));
				b= new Board(300, 300);
			}
		
	}
	
	public static void main(String[] args){
		Board b = new Board(300, 300);
		testGetWinningBox(b);
	}

}
