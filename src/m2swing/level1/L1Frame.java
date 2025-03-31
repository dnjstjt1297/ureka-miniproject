package m2swing.level1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/*
 * AWT : Abstract Window Toolkit : GUI 프로그램을 만드는 도구. : 장점은 쉽다. 단점은 안이쁘다.
 * SWING : AWT의 단점을 보완.
 * Frame : GUI 화면을 만들기 위한 바탕.
 */
public class L1Frame {

	private JFrame frm;

	public L1Frame() {
		frm = new JFrame("제목은 여기에 쓰시면 됩니다.");
	}

	public void makeGui() {
		frm.setSize(500, 500);
		frm.setVisible(true);
	}

	public void addEvent() {
		frm.addWindowListener(
				new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					} // windowClosing
				} // new WindowAdapter
		); // addWindowListener
	} // addEvent

	public static void main(String[] args) {
		L1Frame test = new L1Frame();
		test.makeGui();
		test.addEvent();
	} // main

} // class
