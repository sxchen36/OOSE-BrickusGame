package edu.jhu.cs.sixiang.oose;

import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusPiece;

public class MyBrickusPiece implements BrickusPiece{
	boolean[][] grid;
	MyBrickusModel model;
	
	public MyBrickusPiece(MyBrickusModel model, boolean[][] grid){
		this.model = model;
		this.grid = grid;
	}
	
	@Override
	public void flipHorizontally() {
		int line = grid.length;
		int column = grid[0].length;
		for (int i=0; i<line; i++){
			for (int j=0; j<column/2; j++){
				boolean temp = grid[i][j];
				grid[i][j] = grid[i][column-1-j];
				grid[i][column-1-j] = temp;
			}
		}
		model.pieceChanged();
	}

	@Override
	public void flipVertically() {
		int line = grid.length;
		int column = grid[0].length;
		for (int j=0; j<column; j++){
			for (int i=0; i<line/2; i++){
				boolean temp = grid[i][j];
				grid[i][j] = grid[line-1-i][j];
				grid[line-1-i][j] = temp;
			}
		}
		model.pieceChanged();
		
	}

	@Override
	public int getHeight() {
		return grid.length;
	}

	@Override
	public int getWidth() {
		return grid[0].length;
	}

	@Override
	public boolean isOccupied(int x, int y) {
		return grid[y][x];
	}

	@Override
	public void rotateClockwise() {
		int wid = grid[0].length; //old one
		int hei = grid.length;
		boolean[][] newGrid = new boolean[wid][hei];
		for (int i=0; i<wid; i++){ // i is new height
			for (int j=0; j<hei; j++){
				newGrid[i][j] = grid[hei-1-j][i]; 
			}
		}
		grid = newGrid;
		model.pieceChanged();
	}

	@Override
	public void rotateCounterClockwise() {
		int wid = grid[0].length; //old one
		int hei = grid.length;
		boolean[][] newGrid = new boolean[wid][hei];
		for (int i=0; i<wid; i++){ // i is new height
			for (int j=0; j<hei; j++){
				newGrid[i][j] = grid[j][wid-1-i]; 
			}
		}
		grid = newGrid;
		model.pieceChanged();
	}

}
