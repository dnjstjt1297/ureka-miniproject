package menubook.customer;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CustListPan extends JPanel {
	private static final long serialVersionUID = 1L;

	private JPanel pan;
	private JButton btnAdd, btnReadAll;
	private BorderLayout border;
	protected JTable table;
	private JScrollPane scrollPan;

	public CustListPan() {
		pan = new JPanel();
		btnAdd = new JButton("고객 추가");
		btnReadAll = new JButton("목록 조회");
		border = new BorderLayout();
		table = new JTable();
		scrollPan = new JScrollPane(table);
		//==================================
		makeGui();
	}

	public void makeGui() {
		setLayout(border);
		setSize(500, 500);
		add(scrollPan, BorderLayout.CENTER);
		add(pan, BorderLayout.SOUTH);
		pan.add(btnAdd);
		pan.add(btnReadAll);
		setVisible(true);
	} // makeGui

	public void addEvent(CustControl custControl) {
		btnAdd.addActionListener(custControl);
		btnReadAll.addActionListener(custControl);
		table.addMouseListener(custControl);
	} // addEvent

} // class
