package m2swing.level1;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * CardLayout
 */
public class L1Frame9 {

	private JFrame frm;
	private JPanel pan1, pan2, pan3, pan4, pan5;
	private CardLayout card;
	private WindowEventProcessor winEventProc;
	private CardEventProcessor cardEventProc;

	public L1Frame9() {
		frm = new JFrame("제목은 여기에 쓰시면 됩니다.");
		pan1 = new JPanel(); pan1.setBackground( Color.BLUE );
		pan2 = new JPanel(); pan2.setBackground( Color.GRAY );
		pan3 = new JPanel(); pan3.setBackground( Color.PINK );
		pan4 = new JPanel(); pan4.setBackground( Color.GREEN );
		pan5 = new JPanel(); pan5.setBackground( Color.ORANGE );
		card = new CardLayout();
		winEventProc = new WindowEventProcessor();
		cardEventProc = new CardEventProcessor(frm, card);
	}

	public void makeGui() {
		frm.setSize(500, 500);
		frm.setLayout(card);
		frm.add(pan1);
		frm.add(pan2);
		frm.add(pan3);
		frm.add(pan4);
		frm.add(pan5);
		frm.setVisible(true);
	}

	public void addEvent() {
		frm.addWindowListener(winEventProc);
		pan1.addMouseListener(cardEventProc);
		pan2.addMouseListener(cardEventProc);
		pan3.addMouseListener(cardEventProc);
		pan4.addMouseListener(cardEventProc);
		pan5.addMouseListener(cardEventProc);
	} // addEvent

	public static void main(String[] args) {
		L1Frame9 test = new L1Frame9();
		test.makeGui();
		test.addEvent();
	} // main

} // class
