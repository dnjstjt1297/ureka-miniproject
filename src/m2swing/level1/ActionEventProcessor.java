package m2swing.level1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ActionEventProcessor implements ActionListener {

	private JTextField tf1, tf2;

	public ActionEventProcessor() {}

	public ActionEventProcessor(JTextField tf1, JTextField tf2) {
		this.tf1 = tf1;
		this.tf2 = tf2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println("command : " + command);
		if(command.equals("ToDown")) {
			tf2.setText( tf1.getText() );
			tf1.setText("");
		} else if(command.equals("ToUp")) {
			tf1.setText( tf2.getText() );
			tf2.setText("");
		} // if
	} // actionPerformed

} // class
