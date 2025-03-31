package m2swing.level1;

import javax.swing.JFrame;

/*
 * MouseEvent의 예.
 */
public class L1Frame7 {

	private JFrame frm;
	private WindowEventProcessor winEventProc;
	private MouseEventProcessor mouseEventProc;

	public L1Frame7() {
		frm = new JFrame("제목은 여기에 쓰시면 됩니다.");
		winEventProc = new WindowEventProcessor();
		mouseEventProc = new MouseEventProcessor();
	}

	public void makeGui() {
		frm.setSize(500, 500);
		frm.setVisible(true);
	}

	public void addEvent() {
		frm.addWindowListener(winEventProc);
		frm.addMouseListener(mouseEventProc);
		frm.addMouseMotionListener(mouseEventProc);
	} // addEvent

	public static void main(String[] args) {
		L1Frame7 test = new L1Frame7();
		test.makeGui();
		test.addEvent();
	} // main

} // class
