package m2swing.level1;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * Layout : 컴포넌트 배치를 위한 디자인 가이드.
 * FlowLayout의 예.
 * FlowLayout : 흐르는대로(좌->우, 위->아래) 컴포넌트 배치.
 */
public class L1Frame4 {

	private JFrame frm;
	private FlowLayout flow;
	private JButton btn1, btn2;
	private WindowEventProcessor winEventProc;

	public L1Frame4() {
		frm = new JFrame("제목은 여기에 쓰시면 됩니다.");
		flow = new FlowLayout();
		btn1 = new JButton("김수한무거북이와두루미");
		btn2 = new JButton("삼천갑자동방삭");
		winEventProc = new WindowEventProcessor();
	}

	public void makeGui() {
		frm.setSize(500, 500);
		frm.setLayout(flow);
		frm.add(btn1);
		frm.add(btn2);
		frm.setVisible(true);
	}

	public void addEvent() {
		frm.addWindowListener(winEventProc);
	} // addEvent

	public static void main(String[] args) {
		L1Frame4 test = new L1Frame4();
		test.makeGui();
		test.addEvent();
	} // main

} // class
