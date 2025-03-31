package menubook.customer;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustUpFrm extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panInsert, panButton;
	private JLabel labelCustName, labelAddress, labelPhone;
	protected JTextField tfCustName, tfAddress, tfPhone;
	private JButton btnUpdate, btnDelete, btnCancel;

	public CustUpFrm() {
		panInsert = new JPanel();
		panButton = new JPanel();
		labelCustName = new JLabel("CustName");
		labelAddress = new JLabel("Address");
		labelPhone = new JLabel("Phone");
		tfCustName = new JTextField();
		tfAddress = new JTextField();
		tfPhone = new JTextField();
		btnUpdate = new JButton("고객 수정");
		btnDelete = new JButton("고객 삭제");
		btnCancel = new JButton("수정 취소");
		makeGui();
	}

	public void makeGui() {
		setTitle("고객 정보 입력");
		setSize(500, 500);
		//==================================
		add(panInsert, BorderLayout.CENTER);
		panInsert.setLayout(null);
		panInsert.add(labelCustName);	labelCustName.setBounds(10, 10, 100, 35);
		panInsert.add(labelAddress);	labelAddress.setBounds(10, 50, 100, 35);
		panInsert.add(labelPhone);		labelPhone.setBounds(10, 90, 100, 35);
		panInsert.add(tfCustName);		tfCustName.setBounds(120, 10, 300, 35);
		panInsert.add(tfAddress);		tfAddress.setBounds(120, 50, 300, 35);
		panInsert.add(tfPhone);			tfPhone.setBounds(120, 90, 300, 35);
		//==================================
		add(panButton, BorderLayout.SOUTH);
		panButton.add(btnUpdate);
		panButton.add(btnDelete);
		panButton.add(btnCancel);
	}

	public void addEvent(CustControl custControl) {
		btnUpdate.addActionListener(custControl);
		btnDelete.addActionListener(custControl);
		btnCancel.addActionListener(custControl);
	}

} // class
