
public class Chess {
	
	public int positionX;
	public int positionY;
	public int type; // 1 for King, 2 for Rook, 3 for bishop, 4 for queen, 5 for knight, 6 for pawn 
	public int playerSide;// 1 for white, -1 for black, 0 for unoccupied
	public int chessID;// 1-16 for white, -1- -16 for black, 0 for unoccupied, 1, 8 rook; 2, 7 knight; 3 6 bishop; 4 -5 Queen; 5 -4 King;
	public boolean access; // true for accessible 
	
	public Chess(int positionX, int positionY, int type, int playerSide, int chessID) {
		//default constructor
		this.positionX = positionX;
		this.positionY = positionY;
		this.type = type;
		this.playerSide = playerSide;
		this.chessID = chessID;
		this.access = false;
	}

}
