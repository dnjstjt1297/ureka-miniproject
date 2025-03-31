package m2swing.level1;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * Layout : 컴포넌트 배치를 위한 디자인 가이드.
 * GridLayout의 예.
 * GridLayout : 바둑판 형태로 공간을 분할하여 컴포넌트 배치.
 */
public class L1Frame5 {

	private JFrame frm;
	private GridLayout grid;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6;
	private WindowEventProcessor winEventProc;

	public L1Frame5() {
		frm = new JFrame("제목은 여기에 쓰시면 됩니다.");
		grid = new GridLayout(2,3);
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		winEventProc = new WindowEventProcessor();
	}

	public void makeGui() {
		frm.setSize(500, 500);
		frm.setLayout(grid);
		frm.add(btn1);	frm.add(btn2);	frm.add(btn3);
		frm.add(btn4);	frm.add(btn5);	frm.add(btn6);
		frm.setVisible(true);
	}

	public void addEvent() {
		frm.addWindowListener(winEventProc);
	} // addEvent

	public static void main(String[] args) {
		L1Frame5 test = new L1Frame5();
		test.makeGui();
		test.addEvent();
	} // main

} // class
