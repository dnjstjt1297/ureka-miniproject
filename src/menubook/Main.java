package menubook;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import menubook.book.BookControl;
import menubook.book.BookInsFrm;
import menubook.book.BookListPan;
import menubook.book.BookUpFrm;
import menubook.customer.CustControl;
import menubook.customer.CustInsFrm;
import menubook.customer.CustListPan;
import menubook.customer.CustUpFrm;
import menubook.order.OrdControl;
import menubook.order.OrdInsFrm;
import menubook.order.OrdListPan;
import menubook.order.OrdUpFrm;

public class Main {

	private JFrame frm;
	private CardLayout card;
	//=======================================================
	private JDialog dialog;
	private JLabel dialogLabel;
	private JButton dialogBtnClose;
	//=======================================================
	private MenuBar menuBar;
	private Menu menu1;
	private MenuItem menuItemBook, menuItemCust, menuItemOrd;
	private MenuControl menuControl;
	//=======================================================
	private BookListPan bookListPan;
	private BookInsFrm bookInsFrm;
	private BookUpFrm bookUpFrm;
	private BookControl bookControl;
	//=======================================================
	private CustListPan custListPan;
	private CustInsFrm custInsFrm;
	private CustUpFrm custUpFrm;
	private CustControl custControl;
	//=======================================================
	private OrdListPan ordListPan;
	private OrdInsFrm ordInsFrm;
	private OrdUpFrm ordUpFrm;
	private OrdControl ordControl;

	private Main() {
		frm = new JFrame("도서 판매 시스템");
		card = new CardLayout();
		//=======================================================
		// modal - true(알림 닫기 전 프레임 접근 금지)
		// modal - false(알림 닫기 전에도 프레임 접근 가능)
		dialog = new JDialog(frm, "알림", true);
		dialogLabel = new JLabel("");
		dialogBtnClose = new JButton("알림 닫기");
		//=======================================================
		menuBar = new MenuBar();
		menu1 = new Menu("선 택");
		menuItemBook = new MenuItem("도서 관리");
		menuItemCust = new MenuItem("고객 관리");
		menuItemOrd = new MenuItem("주문 관리");
		menuControl = new MenuControl(frm, card, dialog);
		//=======================================================
		bookListPan = new BookListPan();
		bookInsFrm = new BookInsFrm();
		bookUpFrm = new BookUpFrm();
		//=======================================================
		custListPan = new CustListPan();
		custInsFrm = new CustInsFrm();
		custUpFrm = new CustUpFrm();
		//=======================================================
		ordListPan = new OrdListPan();
		ordInsFrm = new OrdInsFrm();
		ordUpFrm = new OrdUpFrm();
	} // contructor

	private void makeGui() {
		frm.setSize(500, 500);
		//=======================================================
		frm.setMenuBar(menuBar);
		menuBar.add(menu1);
		menu1.add(menuItemBook);	menu1.addSeparator();
		menu1.add(menuItemCust);	menu1.addSeparator();
		menu1.add(menuItemOrd);
		//=======================================================
		frm.setLayout(card);
		frm.add(bookListPan, "BookList");
		frm.add(custListPan, "CustList");
		frm.add(ordListPan, "OrdList");
		//=======================================================
		dialog.setSize(300, 100);
		dialog.setLayout( new GridLayout(2,1) );
		dialog.add(dialogLabel);
		dialog.add(dialogBtnClose);
		//=======================================================
		frm.setVisible(true);
	}

	private void addEvent() {
		dialogBtnClose.addActionListener(menuControl);
		menuItemBook.addActionListener(menuControl);
		menuItemCust.addActionListener(menuControl);
		menuItemOrd.addActionListener(menuControl);
		//=======================================================
		// Anonymous Inner Class
		frm.addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						try {
							DBUtils.closeSingleConnection();
						} catch (SQLException e1) {
//							e1.printStackTrace();
							dialogLabel.setText("커넥션 종료를 실패 하였습니다.");
							dialog.setVisible(true);
						}
						System.exit(0);
					} // windowClosing
				} // new WindowAdapter
		); // addWindowListener
		//=======================================================
		bookControl = new BookControl(bookListPan, bookInsFrm, bookUpFrm, dialog, dialogLabel);
		bookListPan.addEvent(bookControl);
		bookInsFrm.addEvent(bookControl);
		bookUpFrm.addEvent(bookControl);
		//=======================================================
		custControl = new CustControl(custListPan, custInsFrm, custUpFrm, dialog, dialogLabel);
		custListPan.addEvent(custControl);
		custInsFrm.addEvent(custControl);
		custUpFrm.addEvent(custControl);
		//=======================================================
		ordControl = new OrdControl(ordListPan, ordInsFrm, ordUpFrm, dialog, dialogLabel);
		ordListPan.addEvent(ordControl);
		ordInsFrm.addEvent(ordControl);
		ordUpFrm.addEvent(ordControl);
	} // addEvent

	public static void main(String[] args) {
		Main m = new Main();
		m.makeGui();
		m.addEvent();
	} // main

} // class
