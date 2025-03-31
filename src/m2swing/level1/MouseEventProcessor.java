package m2swing.level1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseEventProcessor implements MouseListener, MouseMotionListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Clicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Pressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Released");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Entered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Exited");
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println( "Dragged : " + e.getX() + " : " + e.getY() );
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println( "Moved : " + e.getX() + " : " + e.getY() );
	}

} // class
