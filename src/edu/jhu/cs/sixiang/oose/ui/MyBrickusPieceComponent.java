package edu.jhu.cs.sixiang.oose.ui;

import java.awt.Graphics;

import javax.swing.JPanel;

import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusPiece;

/**
 * Similar as BrickusPiece, it is initialized in SelectionModel by a specific piece
 * @author Angel_Death
 *
 */
public class MyBrickusPieceComponent extends JPanel implements PieceSelectionListener {

	@Override
	public void selectionChanged(BrickusPiece piece) {
		// set a boolean to judge whether this component's piece == piece
		repaint();
	}
	
	@Override
	public void paint(Graphics g){
		// if that boolean is true, this one is the selected, then paint the background
		// else reset the background to default
	}

}
