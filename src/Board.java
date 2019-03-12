
public class Board {

	public Chess[][] boardArray;

	public Board() {
		this.boardArray = new Chess[8][8];
		int idAssign = 0;
		for (int j = 0; j < 8; j++) {
			for (int i = 0; i < 8; i++) {
				if (j == 0 || j == 1) {
					if (idAssign <= 16) {
						idAssign++;
					}
					boardArray[i][j] = new Chess(i, j, 0, 1, idAssign);
				} else if (j == 6 || j == 7) {
					if (idAssign <= 0) {
						idAssign++;
					}
					boardArray[i][j] = new Chess(i, j, 0, -1, idAssign);
				} else {
					idAssign = -17;
					boardArray[i][j] = new Chess(i, j, 0, 0, 0);
				}
			}
		}
		this.assignType();
	}

	public void assignType() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((boardArray[i][j].chessID <= -9 && boardArray[i][j].chessID >= -16)
						|| (boardArray[i][j].chessID >= 9 && boardArray[i][j].chessID <= 16)) {
					boardArray[i][j].type = 6; // set pawn
				} else if (boardArray[i][j].chessID == 1 || boardArray[i][j].chessID == 8
						|| boardArray[i][j].chessID == -1 || boardArray[i][j].chessID == -8) {
					boardArray[i][j].type = 2;// set rook
				} else if (boardArray[i][j].chessID == 7 || boardArray[i][j].chessID == 2
						|| boardArray[i][j].chessID == -2 || boardArray[i][j].chessID == -7) {
					boardArray[i][j].type = 5;// set knight
				} else if (boardArray[i][j].chessID == 3 || boardArray[i][j].chessID == 6
						|| boardArray[i][j].chessID == -6 || boardArray[i][j].chessID == -3) {
					boardArray[i][j].type = 3;// set bishop
				} else if (boardArray[i][j].chessID == 4 || boardArray[i][j].chessID == -5) {
					boardArray[i][j].type = 1;// set king
				} else if (boardArray[i][j].chessID == 5 || boardArray[i][j].chessID == -4) {
					boardArray[i][j].type = 4;// set queen
				} else {
					boardArray[i][j].type = 0;
				}
			}
		}
	}

	public int chessMove(int chessID, int moveX, int moveY) {
		if (chessID == 0) {
			System.out.println("You choose wrong chess! Please choose another");
			return -1;
		}
		if (moveX == 0 && moveY == 0) {
			System.out.println("At least move one step!");
			return -1;
		}
		int currX = -1;
		int currY = -1;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (boardArray[i][j].chessID == chessID) {// find the chess!
					currX = i;
					currY = j;
				}
			}
		}
		if (currX < 0 || currY < 0) {
			System.out.println("This chess not found! Please choose another");
			return -1;
		}
		if (moveX + currX < 0 || moveX + currX > 7 || moveY + currY < 0 || moveY + currY > 7) {
			System.out.println("Move out range! Please choose another");
			return -1;
		}
		if (boardArray[moveX + currX][moveY + currY].playerSide == boardArray[currX][currY].playerSide) {
			System.out.println("Move to occuied cell! Please choose another");
			return -1;
		}
		check_access(currX, currY, currX + moveX, currY + moveY);
		if (!boardArray[currX + moveX][currY + moveY].access) {
			System.out.println("Can not move that way!");
			return -1;
		}
		move_access();
		deal_move(currX, currY, currX + moveX, currY + moveY);
		checkwin();
		return 1;
	}

	public void deal_move(int currX, int currY, int finalX, int finalY) {
		boardArray[finalX][finalY].type = boardArray[currX][currY].type;
		boardArray[finalX][finalY].chessID = boardArray[currX][currY].chessID;
		boardArray[finalX][finalY].playerSide = boardArray[currX][currY].playerSide;

		boardArray[currX][currY].type = 0;
		boardArray[currX][currY].chessID = 0;
		boardArray[currX][currY].playerSide = 0;
	}

	public void check_access(int currX, int currY, int finalX, int finalY) {
		int cur_type = boardArray[currX][currY].type;
		int curSide = boardArray[currX][currY].playerSide;
		// System.out.println(boardArray[currX][currY].type);
		if (cur_type == 2) {
			// rook move check
			boardArray[finalX][finalY].access = rook_move_check(currX, currY, finalX, finalY);
		} else if (cur_type == 3) {
			// bishop move check
			boardArray[finalX][finalY].access = bishop_move_check(currX, currY, finalX, finalY);
		} else if (cur_type == 4) {
			// queen move check
			boardArray[finalX][finalY].access = queen_move_check(currX, currY, finalX, finalY);
		} else if (cur_type == 5) {
			// knight move check
			boardArray[finalX][finalY].access = knight_move_check(currX, currY, finalX, finalY);
		} else if (cur_type == 6) {
			// Pawn move check
			// System.out.println("achieve here");
			boardArray[finalX][finalY].access = pawn_move_check(currX, currY, finalX, finalY, curSide);
		} else {
			// King's turn!!!!
			boardArray[finalX][finalY].access = king_move_check(currX, currY, finalX, finalY, curSide);
		}
	}

	public boolean rook_move_check(int currX, int currY, int finalX, int finalY) {
		if (finalX - currX != 0 && finalY - currY != 0) {
			return false;
		}
		if (finalX - currX == 0) {
			if (finalY < currY) {
				for (int i = finalY + 1; i < currY; i++) {
					if (boardArray[currX][i].type != 0)
						return false;
				}
			} else {
				for (int i = currY + 1; i < finalY; i++) {
					if (boardArray[currX][i].type != 0)
						return false;
				}
			}
		} else {
			if (finalX < currX) {
				for (int i = finalX + 1; i < currX; i++) {
					if (boardArray[i][currY].type != 0)
						return false;
				}
			} else {
				for (int i = currX + 1; i < finalX; i++) {
					if (boardArray[i][currY].type != 0)
						return false;
				}
			}
		}
		return true;
	}

	public boolean bishop_move_check(int currX, int currY, int finalX, int finalY) {
		if (Math.abs(currX - finalX) != Math.abs(currY - finalY)) {
			return false;
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (boardArray[i][j].type != 0) {
					if (Math.abs(i - currX) != 0 && Math.abs(i - finalX) != 0) {
						if (currX > finalX) {
							if (i > finalX && i < currX) {
								if (Math.abs(i - finalX) == Math.abs(j - finalY))
									return false;
							}
						} else {
							if (i < finalX && i > currX) {
								if (Math.abs(i - finalX) == Math.abs(j - finalY))
									return false;
							}
						}
					}
				}
			}
		}
		return true;
	}

	public boolean queen_move_check(int currX, int currY, int finalX, int finalY) {
		return rook_move_check(currX, currY, finalX, finalY) || bishop_move_check(currX, currY, finalX, finalY);
	}

	public boolean knight_move_check(int currX, int currY, int finalX, int finalY) {
		if (Math.abs(currY - finalY) == 2 && Math.abs(currX - finalX) == 1) {
			return true;
		}
		if (Math.abs(currY - finalY) == 1 && Math.abs(currX - finalX) == 2) {
			return true;
		}
		return false;
	}

	public boolean pawn_move_check(int currX, int currY, int finalX, int finalY, int curSide) {
		if (curSide == 1) {
			if (currY != 1) {
				if (finalY - currY != 1) {
					return false;
				} else if (finalX - currX != 0) {
					if (Math.abs(finalX - currX) != 1) {
						return false;
					} else if (boardArray[finalX][finalY].playerSide != -1) {
						return false;
					}
				} else {
					if (boardArray[finalX][finalY].playerSide != 0) {
						return false;
					}
				}
			} else {
				// System.out.println("This is 218");
				if (finalY - currY != 1 && finalY - currY != 2) {
					return false;
				} else if (finalX - currX != 0) {
					// System.out.println("This is 228");
					if (finalY - currY != 1)
						return false;
					if (Math.abs(finalX - currX) != 1) {
						return false;
					} else if (boardArray[finalX][finalY].playerSide != -1) {
						return false;
					}
				} else {

					if (boardArray[finalX][finalY].playerSide != 0)
						return false;

					if (boardArray[currX][currY + 1].playerSide != 0)
						return false;
					// System.out.println("This is 228");
				}
			}
		} else {
			if (currY != 6) {
				if (finalY - currY != -1) {
					return false;
				} else if (finalX - currX != 0) {
					if (Math.abs(finalX - currX) != 1) {
						return false;
					} else if (boardArray[finalX][finalY].playerSide != 1) {
						return false;
					}
				} else {
					if (boardArray[finalX][finalY].playerSide != 0) {
						return false;
					}
				}
			} else {
				if (finalY - currY != -1 && finalY - currY != -2) {
					return false;
				} else if (finalX - currX != 0) {
					if (finalY - currY != -1)
						return false;
					if (Math.abs(finalX - currX) != 1) {
						return false;
					} else if (boardArray[finalX][finalY].playerSide != 1) {
						return false;
					}
				} else {
					if (boardArray[finalX][finalY].playerSide != 0)
						return false;

					if (boardArray[currX][currY - 1].playerSide != 0)
						return false;
				}
			}
		}
		return true;
	}

	public void move_access() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				boardArray[i][j].access = false;
			}
		}
	}

	public boolean king_move_check(int currX, int currY, int finalX, int finalY, int curSide) {
		int moveX = Math.abs(currX - finalX);
		int moveY = Math.abs(currY - finalY);
		if (moveX != 1) {
			if (moveX != 0 || moveY != 1)
				return false;
		}
		if (moveY != 1) {
			if (moveY != 0 || moveX != 1)
				return false;
		}
		return true;
	}

	public int checkwin() {
		int[] whiteKingPos = findChessPosition(5);

		return 0;
	}
	public int[] findChessPosition(int ID){
		int[] result = new int[2];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (boardArray[i][j].chessID == ID) {
					result[0] = boardArray[i][j].positionX;
					result[1] = boardArray[i][j].positionY;
				}
			}
		}
		return result;
	}
}
