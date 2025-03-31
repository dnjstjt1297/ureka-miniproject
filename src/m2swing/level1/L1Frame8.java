package m2swing.level1;

import javax.swing.JFrame;
import javax.swing.JTextField;

/*
 * Event : Key Event 처리
 */
public class L1Frame8 {

	private JFrame frm;
	private JTextField tf1;
	private WindowEventProcessor winEventProc;
	private KeyEventProcessor keyEventProc;

	public L1Frame8() {
		frm = new JFrame("제목은 여기에 쓰시면 됩니다.");
		tf1 = new JTextField();
		winEventProc = new WindowEventProcessor();
		keyEventProc = new KeyEventProcessor();
	}

	public void makeGui() {
		frm.setSize(500, 500);
		frm.setLayout(null);
		tf1.setBounds(10, 20, 200, 30);
		frm.add(tf1);
		frm.setVisible(true);
	}

	public void addEvent() {
		frm.addWindowListener(winEventProc);
		tf1.addKeyListener(keyEventProc);
	} // addEvent

	public static void main(String[] args) {
		L1Frame8 test = new L1Frame8();
		test.makeGui();
		test.addEvent();
	} // main

} // class
