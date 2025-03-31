package m2swing.level1;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MenuEventProcessor implements ActionListener {

	private JFrame frm;
	private CardLayout card;

	public MenuEventProcessor() {}
	public MenuEventProcessor(JFrame frm, CardLayout card) {
		this.frm = frm;
		this.card = card;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("BLUE")) {
			card.show( frm.getContentPane(), command );
		} else if(command.equals("GRAY")) {
			card.show( frm.getContentPane(), command );
		} else if(command.equals("PINK")) {
			card.show( frm.getContentPane(), command );
		} else if(command.equals("GREEN")) {
			card.show( frm.getContentPane(), command );
		} else if(command.equals("ORANGE")) {
			card.show( frm.getContentPane(), command );
		}
	} // actionPerformed

} // class
