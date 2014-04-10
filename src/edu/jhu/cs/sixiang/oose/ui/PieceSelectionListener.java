package edu.jhu.cs.sixiang.oose.ui;

import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusPiece;

/**
 * To inform:
 * Board: repaint and show the shape along with mouse movement
 * Other pieces: reset their background 
 * @author Angel_Death
 *
 */
public interface PieceSelectionListener {
	/**
	 * Should be called when any piece is selected
	 */
	public void selectionChanged(BrickusPiece piece);
}
