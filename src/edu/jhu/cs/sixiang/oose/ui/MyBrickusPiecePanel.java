package edu.jhu.cs.sixiang.oose.ui;

import javax.swing.JPanel;

import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusEvent;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusIllegalMoveEvent;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusListener;

public class MyBrickusPiecePanel extends JPanel implements BrickusListener{
	// Get pieces list from model(initialization / modelChanged event)
	// Initialize background of PiecePanel
	// Innitialize SelectionModel by the pieces list, and 
	
	@Override
	public void illegalMove(BrickusIllegalMoveEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modelChanged(BrickusEvent event) {
		// TODO Auto-generated method stub
		
	}

}
