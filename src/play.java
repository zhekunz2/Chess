public class play {
	
	public static void main(String[] args) {
			// TODO Auto-generated method stub
			Board myBoard =new Board();
//			Scanner reader = new Scanner(System.in);
//			myBoard.chess_move(10, 0, 1);
//			myBoard.chess_move(10, 0, 1);
//			myBoard.chess_move(10, 0, 1);
//			myBoard.chess_move(10, 0, 1);
//			myBoard.chess_move(10, 1, -1);
//			myBoard.chess_move(10, 1, 1);
			for(int i=0; i<8; i++){
				for(int j=0; j<8; j++){
					System.out.print(myBoard.boardArray[j][7-i].type);
					System.out.print(" ");
				}
				System.out.println("");
			}
			System.out.println("");
			for(int i=0; i<8; i++){
				for(int j=0; j<8; j++){
					System.out.print(myBoard.boardArray[j][7-i].chessID);
					System.out.print(" ");
				}
				System.out.println("");
			}
			System.out.println("");
			for(int i=0; i<8; i++){
				for(int j=0; j<8; j++){
					System.out.print(myBoard.boardArray[j][7-i].playerSide);
					System.out.print(" ");
				}
				System.out.println("");
			}
//			if(myBoard.boardArray[3][7].chessID==10)
//				System.out.println("Success test 1");
//			reader.close();
//			return;
		}
}
