package m2swing.level1;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowEventProcessor implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
//		System.out.println("Opened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
//		System.out.println("Closed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
//		System.out.println("Iconified");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
//		System.out.println("Deiconified");
	}

	@Override
	public void windowActivated(WindowEvent e) {
//		System.out.println("Activated - focus 획득");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
//		System.out.println("Deactivated - focus 상실");
	}

} // class
