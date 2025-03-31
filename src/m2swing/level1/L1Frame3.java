package m2swing.level1;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Layout : 컴포넌트 배치를 위한 디자인 가이드.
 * BorderLayout의 예.
 * BorderLayout : 동, 서, 남, 북, 중앙으로 컴포넌트 배치. Frame 객체의 기본 Layout.
 */
public class L1Frame3 {

	private JFrame frm;
	private JButton btn;
	private JPanel pan1, pan2, pan3, pan4, pan5;
	private WindowEventProcessor winEventProc;

	public L1Frame3() {
		frm = new JFrame("제목은 여기에 쓰시면 됩니다.");
		btn = new JButton("버튼 제목은 여기 입니다.");
		pan1 = new JPanel(); pan1.setBackground( Color.BLUE );
		pan2 = new JPanel(); pan2.setBackground( Color.GRAY );
		pan3 = new JPanel(); pan3.setBackground( Color.PINK );
		pan4 = new JPanel(); pan4.setBackground( Color.GREEN );
		pan5 = new JPanel(); pan5.setBackground( Color.ORANGE );
		winEventProc = new WindowEventProcessor();
	}

	public void makeGui() {
		frm.setSize(500, 500);
		pan1.add(btn);
		frm.add(pan1, BorderLayout.SOUTH);
		frm.add(pan2, BorderLayout.CENTER);
		frm.add(pan3, BorderLayout.EAST);
		frm.add(pan4, BorderLayout.NORTH);
		frm.add(pan5, BorderLayout.WEST);
		frm.setVisible(true);
	}

	public void addEvent() {
		frm.addWindowListener(winEventProc);
	} // addEvent

	public static void main(String[] args) {
		L1Frame3 test = new L1Frame3();
		test.makeGui();
		test.addEvent();
	} // main

} // class
