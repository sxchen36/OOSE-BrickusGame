package edu.jhu.cs.sixiang.oose.ui;

import java.util.List;

import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusEvent;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusIllegalMoveEvent;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusListener;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusModel;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusPiece;

// Get pieces list from model(initialization / modelChanged event)
// inform all the pieceComponents to redraw themselves


public class SelectionModel implements BrickusListener{
	BrickusModel model; // For calling pass method in model when mouse click
	List<PieceSelectionListener> listener;
	List<MyBrickusPieceComponent> pieceComponents;
	
	//add listener
	
	//remove listener
	
	
	// Call by a pieceComponent when it is clicked by mouse
	// inform all the pieceComponents about this change.
	public void setSelectedPiece(BrickusPiece piece) {
		
	}
	
	@Override
	public void illegalMove(BrickusIllegalMoveEvent event) {
		// TODO Auto-generated method stub
		
	}

	// update piece list from model
	@Override
	public void modelChanged(BrickusEvent event) {
		// TODO Auto-generated method stub
		
	}
}
