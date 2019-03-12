import static org.junit.Assert.*;

import org.junit.Test;

public class test_board {

	@Test
	public void test1() {
		Board myBoard =new Board();
//		Scanner reader = new Scanner(System.in);
		myBoard.chessMove(10, 0, 1);
		myBoard.chessMove(10, 0, 1);
		myBoard.chessMove(10, 0, 1);
		myBoard.chessMove(10, 0, 1);
		myBoard.chessMove(10, 1, -1);
		myBoard.chessMove(10, 1, 1);
		myBoard.chessMove(9, 0, 2);
		myBoard.chessMove(1, 0, 2);
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				System.out.print(myBoard.boardArray[j][7-i].chessID);
				System.out.print(" ");
			}
			System.out.println("");
		}
		if(myBoard.boardArray[2][6].chessID==10)
			System.out.println("Success test 1");
		assertEquals(myBoard.boardArray[2][6].chessID, 10);
			}
//	@Test
//	public void test2() {
//		Board myBoard =new Board();
//		myBoard.chessMove(10, 0, 11);
//		for(int i=0; i<8; i++){
//			for(int j=0; j<8; j++){
//				System.out.print(myBoard.boardArray[j][7-i].chessID);
//				System.out.print(" ");
//			}
//			System.out.println("");
//		}
//		if(myBoard.boardArray[1][1].chessID==10)
//			System.out.println("Success test 2");	}
//	@Test
//	public void test3() {
//		Board myBoard =new Board();
//		myBoard.chessMove(0, 0, 11);
//		for(int i=0; i<8; i++){
//			for(int j=0; j<8; j++){
//				System.out.print(myBoard.boardArray[j][7-i].chessID);
//				System.out.print(" ");
//			}
//			System.out.println("");
//		}
//		if(myBoard.boardArray[1][1].chessID==10)
//			System.out.println("Success test 3");	}
//	
//	@Test
//	public void test4() {
//		Board myBoard =new Board();
//		myBoard.chessMove(10, 0, 2);
//		myBoard.chessMove(10, 0, 1);
//		myBoard.chessMove(10, 0, 1);
//		myBoard.chessMove(2, 1, 2);
//		myBoard.chessMove(2, 2, 2);
//		for(int i=0; i<8; i++){
//			for(int j=0; j<8; j++){
//				System.out.print(myBoard.boardArray[j][7-i].chessID);
//				System.out.print(" ");
//			}
//			System.out.println("");
//		}
//		if(myBoard.boardArray[2][2].chessID==2)
//			System.out.println("Success test 4");
//		assertEquals(myBoard.boardArray[2][2].chessID, 2);
//		}
//	@Test
//	public void test5() {
//		Board myBoard =new Board();
//		myBoard.chessMove(10, 0, 2);
//		myBoard.chessMove(10, 0, 1);
//		myBoard.chessMove(10, 0, 1);
//		myBoard.chessMove(2, 1, 2);
//		myBoard.chessMove(2, 2, 2);
//		myBoard.chessMove(3, -2, 2);
//		for(int i=0; i<8; i++){
//			for(int j=0; j<8; j++){
//				System.out.print(myBoard.boardArray[j][7-i].chessID);
//				System.out.print(" ");
//			}
//			System.out.println("");
//		}
//		if(myBoard.boardArray[0][2].chessID==3)
//			System.out.println("Success test 5");
//		assertEquals(myBoard.boardArray[0][2].chessID, 3);
//		}
//	
}
