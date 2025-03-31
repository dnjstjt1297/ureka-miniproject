package m2swing.level1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/*
 * Layout : 컴포넌트 배치를 위한 디자인 가이드.
 * NullLayout의 예.
 * NullLayout : 좌표 값을 활용하여 컴포넌트 배치.
 * 
 * Event : Window Event & Action Event 처리
 */
public class L1Frame6 {

	private JFrame frm;
	private JTextField tf1, tf2;
	private JButton btn1, btn2;	
	private WindowEventProcessor winEventProc;
	private ActionEventProcessor actionEventProc;

	public L1Frame6() {
		frm = new JFrame("제목은 여기에 쓰시면 됩니다.");
		tf1 = new JTextField();
		tf2 = new JTextField();
		btn1 = new JButton("ToDown");
		btn2 = new JButton("ToUp");
		winEventProc = new WindowEventProcessor();
		actionEventProc = new ActionEventProcessor(tf1, tf2);
	}

	public void makeGui() {
		frm.setSize(500, 500);
		frm.setLayout(null);
		tf1.setBounds(10, 20, 200, 30);		frm.add(tf1);
		tf2.setBounds(10, 70, 200, 30);		frm.add(tf2);
		btn1.setBounds(240, 20, 100, 30);	frm.add(btn1);
		btn2.setBounds(240, 70, 100, 30);	frm.add(btn2);
		frm.setVisible(true);
	}

	public void addEvent() {
		frm.addWindowListener(winEventProc);
		btn1.addActionListener(actionEventProc);
		btn2.addActionListener(actionEventProc);
	} // addEvent

	public static void main(String[] args) {
		L1Frame6 test = new L1Frame6();
		test.makeGui();
		test.addEvent();
	} // main

} // class
