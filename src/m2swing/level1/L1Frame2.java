package m2swing.level1;

import javax.swing.JFrame;

/*
 * addEvent 개선의 예.
 */
public class L1Frame2 {

	private JFrame frm;
	private WindowEventProcessor winEventProc;

	public L1Frame2() {
		frm = new JFrame("제목은 여기에 쓰시면 됩니다.");
		winEventProc = new WindowEventProcessor();
	}

	public void makeGui() {
		frm.setSize(500, 500);
		frm.setVisible(true);
	}

	public void addEvent() {
		frm.addWindowListener(winEventProc);
	} // addEvent

	public static void main(String[] args) {
		L1Frame2 test = new L1Frame2();
		test.makeGui();
		test.addEvent();
	} // main

} // class
