package m2swing.level1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventProcessor implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println( "keyTyped : " + e.getKeyCode() + " : " + e.getKeyChar() );
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println( "keyPressed : " + e.getKeyCode() + " : " + e.getKeyChar() );
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println( "keyReleased : " + e.getKeyCode() + " : " + e.getKeyChar() );
	}

} // class
