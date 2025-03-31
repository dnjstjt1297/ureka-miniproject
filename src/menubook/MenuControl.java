package menubook;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class MenuControl implements ActionListener {

	private JFrame frm;
	private CardLayout card;
	private JDialog dialog;

	public MenuControl() {}
	public MenuControl(JFrame frm, CardLayout card, JDialog dialog) {
		this.frm = frm;
		this.card = card;
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if( command.equals("도서 관리") ) {
			card.show(frm.getContentPane(), "BookList");
		} else if( command.equals("고객 관리") ) {
			card.show(frm.getContentPane(), "CustList");
		} else if( command.equals("주문 관리") ) {
			card.show(frm.getContentPane(), "OrdList");
		} else if( command.equals("알림 닫기") ) {
			dialog.setVisible(false);
		}
	} // actionPerformed

} // class
