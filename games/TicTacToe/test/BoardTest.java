import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;


public class BoardTest {

	private static void confirm(Object actual, Object expected){
		if(actual.equals(expected)){
			System.out.println("true");
		}
		else{
			System.out.println("\nTest failed:\nExpected:" + expected.toString()+
								"\nbut was " + actual);
			
		}
		
	}
	
	/**
	 * test the getWinningBox function
	 * @param b
	 */
	private static void testGetWinningBox(Board b){
		System.out.println("***Testing GetWinningBox***");
		//test when there is a winning box for a row win
		for (int row=0; row<3; row++){
			for(int count = 0; count<3; count++){
				for(int col=0; col<3; col++){
					if(col!=count){
						b.addPiece(row, col, TicTacToeConstants.FIRST_TURN);
					}
				}
				confirm(b.getWinningBox(TicTacToeConstants.FIRST_TURN),(new Point(row, count)));
				b.clear();
			}
		}
		//test when there is a winning box for a column win
		for (int col=0; col<3; col++){
			for(int count = 0; count<3; count++){
				for(int row=0; row<3; row++){
					if(row!=count){
						b.addPiece(row, col, TicTacToeConstants.FIRST_TURN);
					}
				}
				confirm(b.getWinningBox(TicTacToeConstants.FIRST_TURN),(new Point(count, col)));
				b.clear();
			}
		}
		
		//test when there is a winning box for a diagonal win
		//from top left to bottom right
			for(int count = 0; count<3; count++){
				for(int col=0; col<3; col++){
					if(col!=count){
						b.addPiece(col, col, TicTacToeConstants.FIRST_TURN);
					}
				}
				confirm(b.getWinningBox(TicTacToeConstants.FIRST_TURN),(new Point(count, count)));
				b.clear();
			}
			
			//test when there is a winning box for a diagonal win
			//from top right to bottom left
			for(int count = 0; count<3; count++){
				for(int col=0; col<3; col++){
					if(col!=count){
						b.addPiece(col, 2-col, TicTacToeConstants.FIRST_TURN);
					}
				}
				confirm(b.getWinningBox(TicTacToeConstants.FIRST_TURN),(new Point(count, 2-count)));
				b.clear();
			}
			
			//test that no getWinningBox does not return any false positives
			for(int row=0; row<3; row++){ 
				for(int col=0;col<3;col ++ ){  
					b.addPiece(row, col, TicTacToeConstants.FIRST_TURN);
					confirm(b.getWinningBox(TicTacToeConstants.FIRST_TURN),(new Point(-1, -1)));
					b.clear();
				} 
			} 
			
			//test that getWinningBox does not return false positives
			//when two pieces are kitty corner 
			b.addPiece(0, 0, TicTacToeConstants.FIRST_TURN);
			b.addPiece(1, 2, TicTacToeConstants.FIRST_TURN);
			confirm(b.getWinningBox(TicTacToeConstants.FIRST_TURN),(new Point(-1, -1)));
			b.clear();
			
			b.addPiece(0, 0, TicTacToeConstants.FIRST_TURN);
			b.addPiece(2, 1, TicTacToeConstants.FIRST_TURN);
			confirm(b.getWinningBox(TicTacToeConstants.FIRST_TURN),(new Point(-1, -1)));
			b.clear();
			
			b.addPiece(0, 1, TicTacToeConstants.FIRST_TURN);
			b.addPiece(2, 0, TicTacToeConstants.FIRST_TURN);
			confirm(b.getWinningBox(TicTacToeConstants.FIRST_TURN),(new Point(-1, -1)));
			b.clear();
			
			b.addPiece(0, 1, TicTacToeConstants.FIRST_TURN);
			b.addPiece(2, 2, TicTacToeConstants.FIRST_TURN);
			confirm(b.getWinningBox(TicTacToeConstants.FIRST_TURN),(new Point(-1, -1)));
			b.clear();	
			
			b.addPiece(0, 2, TicTacToeConstants.FIRST_TURN);
			b.addPiece(1, 0, TicTacToeConstants.FIRST_TURN);
			confirm(b.getWinningBox(TicTacToeConstants.FIRST_TURN),(new Point(-1, -1)));
			b.clear();
			
			b.addPiece(0, 2, TicTacToeConstants.FIRST_TURN);
			b.addPiece(2, 1, TicTacToeConstants.FIRST_TURN);
			confirm(b.getWinningBox(TicTacToeConstants.FIRST_TURN),(new Point(-1, -1)));
			b.clear();			
			
			
		
	}
	/**
	 * test the getBorderingBoxes function
	 * @param b
	 */
	private static void testGetBorderingBoxes(Board b) {
		System.out.println("***Testing GetBorderingBoxes***");
		ArrayList<Point> expected = new ArrayList<Point>();
		ArrayList expectedList = new ArrayList(); 
		//add bordering boxes for 0,0
		expected.add(new Point(0, 1));
		expected.add(new Point(1, 0));
		expected.add(new Point(1, 1));
		expectedList.add(expected);
		//add bordering boxes for 0,1
		expected = new ArrayList<Point>();
		expected.add(new Point(0, 0));
		expected.add(new Point(0, 2));
		expected.add(new Point(1, 0));
		expected.add(new Point(1, 1));
		expected.add(new Point(1, 2));
		expectedList.add(expected);
		//add bordering boxes for 0,2
		expected = new ArrayList<Point>();
		expected.add(new Point(0, 1));
		expected.add(new Point(1, 1));
		expected.add(new Point(1, 2));
		expectedList.add(expected);
		
		//add bordering boxes for 1,0
		expected = new ArrayList<Point>();
		expected.add(new Point(0, 0));
		expected.add(new Point(0, 1));
		expected.add(new Point(1, 1));
		expected.add(new Point(2, 0));
		expected.add(new Point(2, 1));
		expectedList.add(expected);
		//add bordering boxes for 1,1
		expected = new ArrayList<Point>();
		expected.add(new Point(0, 0));
		expected.add(new Point(0, 1));
		expected.add(new Point(0, 2));
		expected.add(new Point(1, 0));
		expected.add(new Point(1, 2));
		expected.add(new Point(2, 0));
		expected.add(new Point(2, 1));
		expected.add(new Point(2, 2));
		expectedList.add(expected);
		//add bordering boxes for 1,2
		expected = new ArrayList<Point>();
		expected.add(new Point(0, 1));
		expected.add(new Point(0, 2));
		expected.add(new Point(1, 1));
		expected.add(new Point(2, 1));
		expected.add(new Point(2, 2));		
		expectedList.add(expected);
		
		//add bordering boxes for 2,0
		expected = new ArrayList<Point>();
		expected.add(new Point(1, 0));
		expected.add(new Point(1, 1));
		expected.add(new Point(2, 1));
		expectedList.add(expected);
		//add bordering boxes for 2,1
		expected = new ArrayList<Point>();
		expected.add(new Point(1, 0));
		expected.add(new Point(1, 1));
		expected.add(new Point(1, 2));
		expected.add(new Point(2, 0));
		expected.add(new Point(2, 2));
		expectedList.add(expected);
		//add bordering boxes for 2,2
		expected = new ArrayList<Point>();
		expected.add(new Point(1, 1));
		expected.add(new Point(1, 2));
		expected.add(new Point(2, 1));
		expectedList.add(expected);
		
		
		for(int row=0; row<3; row++ ){  
			for( int col=0; col<3;col++){ 
				confirm(b.getBorderingBoxes(row, col),expectedList.get(col+row*3));
			} 
		} 
		
		for(int row=0; row<3; row++ ){  
			for( int col=0; col<3;col++){ 
				confirm(b.getBorderingBoxes(new Point(row, col)),expectedList.get(col+row*3));
			} 
		} 
		
		
		
	}
	
	/**
	 * test the getAdjacentBoxes function
	 * @param b
	 */
	private static void testGetAdjacentBoxes(Board b) {
		System.out.println("***Testing GetAdjacentBoxes***");
		ArrayList<Point> expected = new ArrayList<Point>();
		ArrayList expectedList = new ArrayList(); 
		//add adjacent boxes for 0,0
		expected.add(new Point(0, 1));
		expected.add(new Point(1, 0));
		expectedList.add(expected);
		//add adjacent boxes for 0,1
		expected = new ArrayList<Point>();
		expected.add(new Point(0, 0));
		expected.add(new Point(0, 2));
		expected.add(new Point(1, 1));
		expectedList.add(expected);
		//add adjacent boxes for 0,2
		expected = new ArrayList<Point>();
		expected.add(new Point(0, 1));
		expected.add(new Point(1, 2));
		expectedList.add(expected);
		//add adjacent boxes for 1,0
		expected = new ArrayList<Point>();
		expected.add(new Point(0, 0));
		expected.add(new Point(1, 1));
		expected.add(new Point(2, 0));
		expectedList.add(expected);
		//add adjacent boxes for 1,1
		expected = new ArrayList<Point>();
		expected.add(new Point(0, 1));
		expected.add(new Point(1, 0));
		expected.add(new Point(1, 2));
		expected.add(new Point(2, 1));
		expectedList.add(expected);
		//add adjacent boxes for 1,2
		expected = new ArrayList<Point>();
		expected.add(new Point(0, 2));
		expected.add(new Point(1, 1));
		expected.add(new Point(2, 2));		
		expectedList.add(expected);
		//add adjacent boxes for 2,0
		expected = new ArrayList<Point>();
		expected.add(new Point(1, 0));
		expected.add(new Point(2, 1));
		expectedList.add(expected);
		//add adjacent boxes for 2,1
		expected = new ArrayList<Point>();
		expected.add(new Point(1, 1));
		expected.add(new Point(2, 0));
		expected.add(new Point(2, 2));
		expectedList.add(expected);
		//add adjacent boxes for 2,2
		expected = new ArrayList<Point>();
		expected.add(new Point(1, 2));
		expected.add(new Point(2, 1));
		expectedList.add(expected);
		
		
		for(int row=0; row<3; row++ ){  
			for( int col=0; col<3;col++){ 
				confirm(b.getAdjacentBoxes(row, col),expectedList.get(col+row*3));
			} 
		} 
		
		for(int row=0; row<3; row++ ){  
			for( int col=0; col<3;col++){ 
				confirm(b.getAdjacentBoxes(new Point(row, col)),expectedList.get(col+row*3));
			} 
		} 
		
		
		
	}
	
	private static void testIsFull(Board b) {
		System.out.println("***Testing IsFull***");
		for( int index=0;index<8; index++ ){  
			for( int row=0; row<3; row++  ){
				for( int col=0; col<3; col++ ){ 
					if(index!=(col+row*3))
					b.addPiece(row, col, TicTacToeConstants.FIRST_TURN);
				} 
			}
			confirm(b.isFull(), false);
			b.clear();
		} 
		
	}
	
	private static void testOccupied(Board b) {
		System.out.println("***Testing Occupied***");
		for( int row=0; row<3; row++ ){  
			for( int col=0; col<3; col++ ){ 
				confirm(b.occupied(row, col), false);
				b.addPiece(row, col, TicTacToeConstants.FIRST_TURN);
				confirm(b.occupied(row, col), true);
				b.clear();
			} 
		} 
		
	}

	private static void testIsThereAWinner(Board b) {
		System.out.println("***Testing IsThereAWinner***");
		//test for row wins
		for( int row=0; row<3; row++ ){  
			for( int col=0; col<3; col++ ){  
				b.addPiece(row, col, TicTacToeConstants.FIRST_TURN);
				confirm(b.isThereAWinner(), ((col+1)%3)==0);
			} 
			b.clear();
			
		} 
		
		//test for column wins
		for( int col=0; col<3; col++ ){  
			for( int row=0; row<3; row++ ){  
				b.addPiece(row, col, TicTacToeConstants.FIRST_TURN);
				confirm(b.isThereAWinner(), ((row+1)%3)==0);
			} 
			b.clear();
			
		}
		
		//test for diagonal win from top-left to
		//bottom-right
		for(int n=0; n<3; n++ ){  
			b.addPiece(n, n, TicTacToeConstants.FIRST_TURN);
			confirm(b.isThereAWinner(), ((n+1)%3)==0);
		} 
		b.clear();
		
		//test for diagonal win from top-left to
		//bottom-right
		for(int n=2; n>=0; n-- ){  
			b.addPiece(n, n, TicTacToeConstants.FIRST_TURN);
			confirm(b.isThereAWinner(), ((3-n)%3)==0);
		} 
		
	}
	
	private static void testGetCorners(Board b) {
		int f = TicTacToeConstants.FIRST_TURN;
		System.out.println("***Testing GetCorners***");
		int[] expected={0,0,0,0};
		int[] actual = b.getCorners();
		for(int x=0;x<actual.length; x++ ){  
			confirm(actual[x], expected[x]);
		} 
		
		b.addPiece(0, 0, f);
		expected[0]=f;
		actual = b.getCorners();
		for(int x=0;x<actual.length; x++ ){  
			confirm(actual[x], expected[x]);
		} 
		
		b.addPiece(0, 2, f);
		expected[1]=f;
		actual = b.getCorners();
		for(int x=0;x<actual.length; x++ ){  
			confirm(actual[x], expected[x]);
		} 
		
		b.addPiece(2, 0, f);
		expected[2]=f;
		actual = b.getCorners();
		for(int x=0;x<actual.length; x++ ){  
			confirm(actual[x], expected[x]);
		} 
		
		b.addPiece(2, 2, f);
		expected[3]=f;
		actual = b.getCorners();
		for(int x=0;x<actual.length; x++ ){  
			confirm(actual[x], expected[x]);
		} 
		
	}
	
	private static void testGetSides(Board b) {
		int f = TicTacToeConstants.FIRST_TURN;
		System.out.println("***Testing GetSides***");
		int[] expected={0,0,0,0};
		int[] actual = b.getSides();
		for(int x=0;x<actual.length; x++ ){  
			confirm(actual[x], expected[x]);
		} 
		
		b.addPiece(0, 1, f);
		expected[0]=f;
		actual = b.getSides();
		for(int x=0;x<actual.length; x++ ){  
			confirm(actual[x], expected[x]);
		} 
		
		b.addPiece(1, 0, f);
		expected[1]=f;
		actual = b.getSides();
		for(int x=0;x<actual.length; x++ ){  
			confirm(actual[x], expected[x]);
		} 
		
		b.addPiece(1, 2, f);
		expected[2]=f;
		actual = b.getSides();
		for(int x=0;x<actual.length; x++ ){  
			confirm(actual[x], expected[x]);
		} 
		
		b.addPiece(2, 1, f);
		expected[3]=f;
		actual = b.getSides();
		for(int x=0;x<actual.length; x++ ){  
			confirm(actual[x], expected[x]);
		} 
		
	}
	
	private static void testGetNumberOfPieces(Board b) {
		System.out.println("***Testing GetNumberOfPieces***");
		int f = TicTacToeConstants.FIRST_TURN;
		int s = TicTacToeConstants.SECOND_TURN;
		confirm(b.getNumberOfPieces(), 0);
		b.addPiece(2, 0, f);
		confirm(b.getNumberOfPieces(), 1);
		b.addPiece(0, 0, s);
		confirm(b.getNumberOfPieces(), 2);
		b.addPiece(0, 1, f);
		confirm(b.getNumberOfPieces(), 3);
		b.addPiece(1, 0, s);
		confirm(b.getNumberOfPieces(), 4);
		b.addPiece(1, 1, f);
		confirm(b.getNumberOfPieces(), 5);
		b.addPiece(2, 1, s);
		confirm(b.getNumberOfPieces(), 6);
		b.addPiece(1, 2, f);
		confirm(b.getNumberOfPieces(), 7);
		b.addPiece(0, 2, s);
		confirm(b.getNumberOfPieces(), 8);
		b.addPiece(2, 2, f);
		confirm(b.getNumberOfPieces(), 9);
		
		
		
	}
	
	private static void testGetOppositeBox(Board b){
		System.out.println("\n\n****** Testing getOppositeBox ********");
		ArrayList<Point> expected = new ArrayList<Point>(9); 
		ArrayList<Point> actual = new ArrayList<Point>(9);
		for (int row=2; row>=0; row--){
			for(int col=2; col>=0; col--){
				expected.add(new Point(row, col));
			
			}
		}
		
		for(int row=0; row<=2; row++){
			for (int col=0; col<=2; col++){
				actual.add(b.getOppositeBox(row, col));
			}
		}
		
		confirm(actual, expected);
		
		actual = new ArrayList<Point>(9);
		for(int row=0; row<=2; row++){
			for (int col=0; col<=2; col++){
				actual.add(b.getOppositeBox(new Point(row, col)));
			}
		}
		
		confirm(actual, expected);
		
		
	}
	
	private static void testAreOpposite(Board b){
		System.out.println("***** Testing areOpposite *****");
		boolean[] actual= new boolean[9];
		for(int x=0; x<=8; x++){
			actual[x]=false;
		}
		int trueVal=8;
		//for each box
		for(int r=0; r<=2; r++){
			for(int c=0; c<=2; c++){
				//check if it is opposite the other boxes
				for(int r2=0; r2<=2; r2++){
					for(int c2=0; c2<=2; c2++){
						actual[r2*3+c2]=b.areOpposite(new Point(r,c), new Point(r2,c2));
					}
				}
				for(int x=0;x<=8;x++){
					if(x==trueVal)
						confirm(new Boolean(actual[x]), new Boolean(true));
					else 
						confirm(new Boolean(actual[x]), new Boolean(false));
				}
				trueVal--;
			}
		}
		
		
	}
	
	/**
	 * test the areBordering function
	 * @param b
	 */
	private static void testAreBordering(Board b) {
		System.out.println("***** Testing areBordering *****");
		
		Boolean[][] expected = {
				{   Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
					Boolean.TRUE, Boolean.TRUE, Boolean.FALSE,
					Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
				},
				{   Boolean.TRUE, Boolean.FALSE, Boolean.TRUE,
					Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
					Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
				},
				{   Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
					Boolean.FALSE, Boolean.TRUE, Boolean.TRUE,
					Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
				},
				{   Boolean.TRUE, Boolean.TRUE, Boolean.FALSE,
					Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
					Boolean.TRUE, Boolean.TRUE, Boolean.FALSE
				},
				{   Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
					Boolean.TRUE, Boolean.FALSE, Boolean.TRUE,
					Boolean.TRUE, Boolean.TRUE, Boolean.TRUE
				},
				{   Boolean.FALSE, Boolean.TRUE, Boolean.TRUE,
					Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
					Boolean.FALSE, Boolean.TRUE, Boolean.TRUE
				},
				{   Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
					Boolean.TRUE, Boolean.TRUE, Boolean.FALSE,
					Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
				},
				{   Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
					Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
					Boolean.TRUE, Boolean.FALSE, Boolean.TRUE
				},
				{   Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
					Boolean.FALSE, Boolean.TRUE, Boolean.TRUE,
					Boolean.FALSE, Boolean.TRUE, Boolean.FALSE
				}
		};
		
		for(int r=0; r<=2; r++){
			for(int c=0; c<=2; c++){
				
				for(int r2=0; r2<=2; r2++){
					for(int c2=0; c2<=2; c2++){
						confirm(new Boolean(b.areBordering(new Point(r,c), new Point(r2, c2))), 
								expected[r*3+c][r2*3+c2]);
					
					}
				}
				
			}
		}
		
		
		
	}
	
	/**
	 * test the areAdjacent function
	 * @param b
	 */
	private static void testAreAdjacent(Board b) {
		System.out.println("***** Testing areAdjacent *****");
		
		Boolean[][] expected = {
				{   Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
					Boolean.TRUE, Boolean.FALSE, Boolean.FALSE,
					Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
				},
				{   Boolean.TRUE, Boolean.FALSE, Boolean.TRUE,
					Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
					Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
				},
				{   Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
					Boolean.FALSE, Boolean.FALSE, Boolean.TRUE,
					Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
				},
				{   Boolean.TRUE, Boolean.FALSE, Boolean.FALSE,
					Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
					Boolean.TRUE, Boolean.FALSE, Boolean.FALSE
				},
				{   Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
					Boolean.TRUE, Boolean.FALSE, Boolean.TRUE,
					Boolean.FALSE, Boolean.TRUE, Boolean.FALSE
				},
				{   Boolean.FALSE, Boolean.FALSE, Boolean.TRUE,
					Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
					Boolean.FALSE, Boolean.FALSE, Boolean.TRUE
				},
				{   Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
					Boolean.TRUE, Boolean.FALSE, Boolean.FALSE,
					Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
				},
				{   Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
					Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
					Boolean.TRUE, Boolean.FALSE, Boolean.TRUE
				},
				{   Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
					Boolean.FALSE, Boolean.FALSE, Boolean.TRUE,
					Boolean.FALSE, Boolean.TRUE, Boolean.FALSE
				}
		};
		
		for(int r=0; r<=2; r++){
			for(int c=0; c<=2; c++){
				
				for(int r2=0; r2<=2; r2++){
					for(int c2=0; c2<=2; c2++){
						confirm(new Boolean(b.areAdjacent(new Point(r,c), new Point(r2, c2))), 
								expected[r*3+c][r2*3+c2]);
					
					}
				}
				
			}
		}
		
		
		
	}
	/**
	 * test the areAdjacent function
	 * @param b
	 */
	private static void testAreKittyCorner(Board b) {
		System.out.println("***** Testing areKittyCorner *****");
		
		Boolean[][] expected = {
				{   Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
					Boolean.FALSE, Boolean.FALSE, Boolean.TRUE,
					Boolean.FALSE, Boolean.TRUE, Boolean.FALSE
				},
				{   Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
					Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
					Boolean.TRUE, Boolean.FALSE, Boolean.TRUE
				},
				{   Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
					Boolean.TRUE, Boolean.FALSE, Boolean.FALSE,
					Boolean.FALSE, Boolean.TRUE, Boolean.FALSE
				},
				{   Boolean.FALSE, Boolean.FALSE, Boolean.TRUE,
					Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
					Boolean.FALSE, Boolean.FALSE, Boolean.TRUE
				},
				{   Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
					Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
					Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
				},
				{   Boolean.TRUE, Boolean.FALSE, Boolean.FALSE,
					Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
					Boolean.TRUE, Boolean.FALSE, Boolean.FALSE
				},
				{   Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
					Boolean.FALSE, Boolean.FALSE, Boolean.TRUE,
					Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
				},
				{   Boolean.TRUE, Boolean.FALSE, Boolean.TRUE,
					Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
					Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
				},
				{   Boolean.FALSE, Boolean.TRUE, Boolean.FALSE,
					Boolean.TRUE, Boolean.FALSE, Boolean.FALSE,
					Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
				}
		};
		
		for(int r=0; r<=2; r++){
			for(int c=0; c<=2; c++){
				
				for(int r2=0; r2<=2; r2++){
					for(int c2=0; c2<=2; c2++){
						confirm(new Boolean(b.areKittyCorner(new Point(r,c), new Point(r2, c2))), 
								expected[r*3+c][r2*3+c2]);
					
					}
				}
				
			}
		}
		
		
		
	}	
	public static void testIsCorner(Board b){
		System.out.println("***** Testing isCorner *****");
		boolean[][] expected = {
				{true, false, true},
				{false, false, false},
				{true, false, true}};
		
		
		for(int r=0;r<3;r++){
			for(int c=0; c<3; c++){
				confirm(new Boolean(b.isCorner(new Point(r, c) ) ),
						new Boolean(expected[r][c]) ); 
			}
		}
		
	}
	
	public static void testIsSide(Board b){
		System.out.println("***** Testing isSide *****");
		boolean[][] expected = {
				{false, true, false},
				{true, false, true},
				{false, true, false}};
		
		
		for(int r=0;r<3;r++){
			for(int c=0; c<3; c++){
				confirm(new Boolean(b.isSide(new Point(r, c) ) ),
						new Boolean(expected[r][c]) ); 
			}
		}
		
	}
			
	
	
	
	
	public static void main(String[] args){
		Board b = new Board(300, 300);
		testGetWinningBox(b.clear());
		testGetBorderingBoxes(b.clear());
		//testAreBordering(b.clear());
		testGetAdjacentBoxes(b.clear());
		testIsFull(b.clear());
		testOccupied(b.clear());
		testIsThereAWinner(b.clear());
		testGetCorners(b.clear());
		testGetSides(b.clear());
		testGetNumberOfPieces(b.clear());
		testGetOppositeBox(b.clear());
		testAreOpposite(b.clear());
		testAreAdjacent(b.clear());
		testAreBordering(b.clear());
		testAreKittyCorner(b.clear());		
		testIsCorner(b.clear());
		testIsSide(b.clear());
	}
	
	







	
	

}
