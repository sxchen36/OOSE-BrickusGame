package edu.jhu.cs.sixiang.oose.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusEvent;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusIllegalMoveEvent;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusListener;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusModel;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusPiece;

public class MyBrickusBoardPanel extends JPanel implements PieceSelectionListener, BrickusListener{
	
	BrickusModel model; // For calling 'place' method in model when mouse click
	
	public MyBrickusBoardPanel(){
		// Let the actions taken on this board 
		// inform its listeners, which is defined in 
		// in a inner class below
		this.addMouseListener(new MouseHandler()); 
	}

	@Override
	public void selectionChanged(BrickusPiece piece) { //to repaint according to selected piece
		repaint();
	}

	@Override
	public void illegalMove(BrickusIllegalMoveEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modelChanged(BrickusEvent arg0) { // to repaint whenever model changes
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void paint(Graphics g){
		
		
	}
	
	class MouseHandler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	}
	
}
