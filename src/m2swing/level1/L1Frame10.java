package m2swing.level1;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * CardLayout + MenuBar, Menu, MenuItem
 */
public class L1Frame10 {

	private JFrame frm;
	private JPanel pan1, pan2, pan3, pan4, pan5;
	private CardLayout card;
	private MenuBar menuBar;
	private Menu menu1;
	private MenuItem menuItem1, menuItem2, menuItem3, menuItem4, menuItem5;
	private WindowEventProcessor winEventProc;
	private MenuEventProcessor menuEventProc;

	public L1Frame10() {
		frm = new JFrame("제목은 여기에 쓰시면 됩니다.");
		pan1 = new JPanel(); pan1.setBackground( Color.BLUE );
		pan2 = new JPanel(); pan2.setBackground( Color.GRAY );
		pan3 = new JPanel(); pan3.setBackground( Color.PINK );
		pan4 = new JPanel(); pan4.setBackground( Color.GREEN );
		pan5 = new JPanel(); pan5.setBackground( Color.ORANGE );
		card = new CardLayout();
		menuBar = new MenuBar();
		menu1 = new Menu("MenuName");
		menuItem1 = new MenuItem("BLUE");
		menuItem2 = new MenuItem("GRAY");
		menuItem3 = new MenuItem("PINK");
		menuItem4 = new MenuItem("GREEN");
		menuItem5 = new MenuItem("ORANGE");
		winEventProc = new WindowEventProcessor();
		menuEventProc = new MenuEventProcessor(frm, card);
	}

	public void makeGui() {
		frm.setSize(500, 500);
		//===============================
		frm.setMenuBar(menuBar);
		menuBar.add(menu1);
		menu1.add(menuItem1);		menu1.addSeparator();
		menu1.add(menuItem2);		menu1.addSeparator();
		menu1.add(menuItem3);		menu1.addSeparator();
		menu1.add(menuItem4);		menu1.addSeparator();
		menu1.add(menuItem5);
		//===============================
		frm.setLayout(card);
		frm.add(pan1, "BLUE");
		frm.add(pan2, "GRAY");
		frm.add(pan3, "PINK");
		frm.add(pan4, "GREEN");
		frm.add(pan5, "ORANGE");
		frm.setVisible(true);
	}

	public void addEvent() {
		frm.addWindowListener(winEventProc);
		menuItem1.addActionListener(menuEventProc);
		menuItem2.addActionListener(menuEventProc);
		menuItem3.addActionListener(menuEventProc);
		menuItem4.addActionListener(menuEventProc);
		menuItem5.addActionListener(menuEventProc);
	} // addEvent

	public static void main(String[] args) {
		L1Frame10 test = new L1Frame10();
		test.makeGui();
		test.addEvent();
	} // main

} // class
