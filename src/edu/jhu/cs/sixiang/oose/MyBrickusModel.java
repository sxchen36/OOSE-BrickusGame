package edu.jhu.cs.sixiang.oose;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusEvent;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusIllegalMoveEvent;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusListener;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusModel;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusPiece;
import edu.jhu.cs.oose.fall2013.brickus.iface.Player;

public class MyBrickusModel implements BrickusModel {

	private static final boolean F = false;
	private static final boolean T = true;
	private static final int WIDTH = 14;
	private static final int HEIGHT = 14;

	private Player[][] board;
	private Player currentPlayer;
	protected List<BrickusListener> listenerList;
	private Hashtable<Player, List<BrickusPiece>> table;
	private boolean firstPass;

	public MyBrickusModel() {
		board = new Player[WIDTH][HEIGHT];
		currentPlayer = Player.PLAYER1;
		listenerList = new ArrayList<BrickusListener>();
		table = new Hashtable<Player, List<BrickusPiece>>();
		table.put(Player.PLAYER1, generateList());
		table.put(Player.PLAYER2, generateList());
		firstPass = false;
	}

	// Create a whole list of all the pieces
	private List<BrickusPiece> generateList() {
		List<BrickusPiece> list = new ArrayList<BrickusPiece>();
		boolean[][] piece1 = { { F, T, F }, { T, T, T }, { F, T, F } };
		boolean[][] piece2 = { { T, F, F }, { T, T, T }, { F, T, F } };
		boolean[][] piece3 = { { T, T, T }, { F, T, F }, { F, T, F } };
		boolean[][] piece4 = { { T, T, T, T }, { F, F, F, T } };
		boolean[][] piece5 = { { T, T, T, T, T } };
		boolean[][] piece6 = { { T, T, F }, { F, T, F }, { F, T, T } };
		boolean[][] piece7 = { { T, T }, { F, T }, { T, T } };
		list.add(new MyBrickusPiece(this, piece1));
		list.add(new MyBrickusPiece(this, piece2));
		list.add(new MyBrickusPiece(this, piece3));
		list.add(new MyBrickusPiece(this, piece4));
		list.add(new MyBrickusPiece(this, piece5));
		list.add(new MyBrickusPiece(this, piece6));
		list.add(new MyBrickusPiece(this, piece7));

		boolean[][] piece8 = { { T, T }, { T, T }, { F, T } };
		boolean[][] piece9 = { { T, F, F }, { T, T, F }, { F, T, T } };
		boolean[][] piece10 = { { T, T, F, F }, { F, T, T, T } };
		boolean[][] piece11 = { { T, T, T, T }, { F, T, F, F } };
		boolean[][] piece12 = { { T, T, T }, { F, F, T }, { F, F, T } };
		boolean[][] piece13 = { { T, T, T, T } };
		boolean[][] piece14 = { { T, T, T }, { F, F, T } };

		list.add(new MyBrickusPiece(this, piece8));
		list.add(new MyBrickusPiece(this, piece9));
		list.add(new MyBrickusPiece(this, piece10));
		list.add(new MyBrickusPiece(this, piece11));
		list.add(new MyBrickusPiece(this, piece12));
		list.add(new MyBrickusPiece(this, piece13));
		list.add(new MyBrickusPiece(this, piece14));
		boolean[][] piece15 = { { T, T, T }, { F, T, F } };
		boolean[][] piece16 = { { T, T, F }, { F, T, T } };
		boolean[][] piece17 = { { T, T }, { T, T } };
		boolean[][] piece18 = { { T, T, T } };
		boolean[][] piece19 = { { T, T }, { F, T } };
		boolean[][] piece20 = { { T, T } };
		boolean[][] piece21 = { { T } };
		list.add(new MyBrickusPiece(this, piece15));
		list.add(new MyBrickusPiece(this, piece16));
		list.add(new MyBrickusPiece(this, piece17));
		list.add(new MyBrickusPiece(this, piece18));
		list.add(new MyBrickusPiece(this, piece19));
		list.add(new MyBrickusPiece(this, piece20));
		list.add(new MyBrickusPiece(this, piece21));

		return list;
	}

	// Notify listeners about the change of the pieces, used by pieces
	protected void pieceChanged() {
		for (BrickusListener l : listenerList) {
			l.modelChanged(new BrickusEvent(this, false, false));
		}
	}

	@Override
	public void addBrickusListener(BrickusListener listener) {
		listenerList.add(listener);
	}

	@Override
	public int calculateScore(Player player) {
		int sum = 0;
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				if (board[i][j] == player)
					sum++;
			}
		}
		return sum;
	}

	@Override
	public Player getActivePlayer() {
		return currentPlayer;
	}

	@Override
	public Player getContents(int x, int y) throws IndexOutOfBoundsException {
		return board[y][x]; // x is the column and y is the line
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}

	@Override
	public List<BrickusPiece> getPieces(Player player) {
		return table.get(player);
	}

	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public void pass(Player player) {
		currentPlayer = (player == Player.PLAYER1) ? Player.PLAYER2
				: Player.PLAYER1;

		for (BrickusListener l : listenerList) {
			if (firstPass) {
				l.modelChanged(new BrickusEvent(this, false, true));
			} else {
				l.modelChanged(new BrickusEvent(this, true, false));
				firstPass = true;
			}

		}
	}

	@Override
	public void placePiece(Player player, int x, int y, BrickusPiece piece) {

		int h = piece.getHeight();
		int w = piece.getWidth();
		
		// whether is out of bound
		if (x < 0 || y < 0 || x + w > WIDTH || y + h > HEIGHT) {
			for (BrickusListener l : listenerList) {
				l.illegalMove(new BrickusIllegalMoveEvent(
						"Pieces must be placed entirely on the board."));
			}
		} else if (onTopOfPiece(x,w,y,h,piece)){
			for (BrickusListener l : listenerList) {
				l.illegalMove(new BrickusIllegalMoveEvent(
						"Pieces may not be placed on top of other pieces."));
			}
		} else if (touchOrth(x,w,y,h,piece, player)) {
			for (BrickusListener l : listenerList) {
				l.illegalMove(new BrickusIllegalMoveEvent(
						"Pieces of the same color may never touch orthogonally."));
			}
		} else {
			if (table.get(player).size() == 21){// The first placement
				if (!inCorner(x,w,y,h, piece)){
					for (BrickusListener l : listenerList) {
						l.illegalMove(new BrickusIllegalMoveEvent(
								"first piece must be placed in an open corner"));
					}
				} else {
					placePiece(x,w,y,h,piece,player);
				}
			} else if (!touchDiag(x,w,y,h,piece, player)) {
				for (BrickusListener l : listenerList) {
					l.illegalMove(new BrickusIllegalMoveEvent(
							"Each new piece must touch at least one existing piece diagonally."));
				}
			} else { // Successfully placed
				placePiece(x,w,y,h,piece,player);
			}
				
		}
			
		


	}
	
	/*Successfully place the piece*/
	private void placePiece(int x, int w, int y, int h, BrickusPiece piece, Player player){
		for (int i=0; i< h; i++){
			for (int j=0; j<w; j++){
				if (piece.isOccupied(j, i)){
						board[y+i][x+j] = player;
				}
			}
		}
		// if success, reset firstPass;
		firstPass = false;
		for (BrickusListener l : listenerList) {
			l.modelChanged(new BrickusEvent(this, true, false));
		}
		currentPlayer = (player == Player.PLAYER1) ? Player.PLAYER2
				: Player.PLAYER1;
		List<BrickusPiece> l = table.get(player);
		l.remove(piece);
	}
	
	private boolean onTopOfPiece(int x, int w, int y, int h, BrickusPiece piece){
		for (int i=0; i< h; i++){
			for (int j=0; j<w; j++){
				if (piece.isOccupied(j, i) && board[y+i][x+j] != null){
						return true;
				}
			}
		}
		return false;
	}
	
	private boolean inCorner(int x, int w, int y, int h, BrickusPiece piece){
		for (int i=0; i< h; i++){
			for (int j=0; j<w; j++){
				if (piece.isOccupied(j, i)){
					if ((x+j==0 && y+i==0) || (y+i==HEIGHT-1 && x+j==0)
							|| (y+i==0 && x+j==WIDTH-1) || (y+i==HEIGHT-1 && x+j==WIDTH-1)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean touchOrth(int x, int w, int y, int h, BrickusPiece piece, Player player){
		for (int i=0; i< h; i++){
			for (int j=0; j<w; j++){
				if (piece.isOccupied(j, i)){
						if (
								isPlayer(y+i-1,x+j,player) ||
								isPlayer(y+i+1,x+j,player) ||
								isPlayer(y+i,x+j+1,player) ||
								isPlayer(y+i,x+j-1,player) )
							return true;
				}
			}
		}
		return false;
	}
	
	private boolean isPlayer(int line, int column, Player player){
		if (line >= HEIGHT || column >= WIDTH || line <0 || column <0){
			return false;
		}
		if (board[line][column] == player) return true;
		return false;
	}
	
	private boolean touchDiag(int x, int w, int y, int h, BrickusPiece piece, Player player){
		for (int i=0; i< h; i++){
			for (int j=0; j<w; j++){
				if (piece.isOccupied(j, i)){
						if (
								isPlayer(y+i-1,x+j-1,player) ||
								isPlayer(y+i+1,x+j-1,player) ||
								isPlayer(y+i+1,x+j+1,player) ||
								isPlayer(y+i-1,x+j+1,player) ) {
							return true;
						}
				}
			}
		}
		return false;
	}

	@Override
	public void removeBrickusListener(BrickusListener listener) {
		listenerList.remove(listener);
	}

}
