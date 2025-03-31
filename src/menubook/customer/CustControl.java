package menubook.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CustControl extends MouseAdapter implements ActionListener {

	private CustInsFrm custInsFrm;
	private CustUpFrm custUpFrm;
	private JTable table;
	private JDialog dialog;
	private JLabel dialogLabel;
	private CustDAO dao;
	private Vector<Vector<String>> readAllData = null;
	private Vector<String> colNames;
	private String selectedCustID;

	public CustControl(CustListPan custListPan, CustInsFrm custInsFrm, CustUpFrm custUpFrm
			, JDialog dialog, JLabel dialogLabel) {
		this.table = custListPan.table;
		this.custInsFrm = custInsFrm;
		this.custUpFrm = custUpFrm;
		this.dialog = dialog;
		this.dialogLabel = dialogLabel;
		try {
			dao = new CustDAO();
		} catch( SQLException e ) {
//			e.printStackTrace();
			dialogOpen("고객 관리를 위한 커넥션 연결을 실패 하였습니다.");
		}
		colNames = new Vector<String>();
		colNames.add("CustID");		colNames.add("CustName");
		colNames.add("Address");	colNames.add("Phone");
	} // constructor

	private void dialogOpen( String message ) {
		this.dialogLabel.setText(message);
		this.dialog.setVisible(true);
	} // dialogOpen

	private void readAll() {
		try {
			readAllData = dao.readAll();
		} catch (SQLException e) {
//			e.printStackTrace();
			readAllData = new Vector<Vector<String>>();
			dialogOpen("고객 목록 조회에 실패 하였습니다.");
		}
		// CustListPan의 JTABLE에 Data 입력.
		DefaultTableModel model = new DefaultTableModel(readAllData, colNames);
		table.setModel(model);
	} // readAll

	private void insertOne() {
		int successCnt = 0;
		try {
			successCnt = dao.insertOne(custInsFrm.tfCustName.getText()
					, custInsFrm.tfAddress.getText(), custInsFrm.tfPhone.getText());
		} catch (SQLException e) {
//			e.printStackTrace();
		}
		if(successCnt < 1) { // insert fail
			dialogOpen("고객 정보 입력에 실패 하였습니다.");
		} else { // insert success - 입력 창 초기화 & 고객 목록 새로 고침.
			custInsFrm.tfCustName.setText("");
			custInsFrm.tfAddress.setText("");
			custInsFrm.tfPhone.setText("");
			this.readAll();
		}
	} // insertOne

	private void updateOne() {
		int successCnt = 0;
		try {
			successCnt = dao.updateOne(selectedCustID, custUpFrm.tfCustName.getText()
					, custUpFrm.tfAddress.getText(), custUpFrm.tfPhone.getText());
		} catch (SQLException e) {
//			e.printStackTrace();
		}
		if(successCnt < 1) { // update fail
			dialogOpen("고객 정보 수정에 실패 하였습니다.");
		} else { // update success - 수정 창 닫기 & 고객 목록 새로 고침.
			custUpFrm.setVisible(false);
			this.readAll();
		}
	} // updateOne

	private void deleteOne() {
		int successCnt = 0;
		try {
			successCnt = dao.deleteOne(selectedCustID);
		} catch (SQLException e) {
//			e.printStackTrace();
		}
		if(successCnt < 1) { // delete fail
			dialogOpen("고객 정보 삭제에 실패 하였습니다.");
		} else { // delete success - 삭제 창 닫기 & 고객 목록 새로 고침.
			custUpFrm.setVisible(false);
			this.readAll();
		}
	} // deleteOne

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if( command.equals("목록 조회") ) {
			this.readAll();
		} else if( command.equals("고객 추가") ) {
			custInsFrm.setVisible(true);
		} else if( command.equals("입력 취소") ) {
			custInsFrm.setVisible(false);
		} else if( command.equals("고객 저장") ) {
			this.insertOne();
		} else if( command.equals("고객 수정") ) {
			this.updateOne();
		} else if( command.equals("고객 삭제") ) {
			this.deleteOne();
		} else if( command.equals("수정 취소") ) {
			custUpFrm.setVisible(false);
		}
	} // actionPerformed

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowIdx = table.getSelectedRow();
		Vector<String> readOne = readAllData.get(rowIdx);
		selectedCustID = readOne.get(0);

		custUpFrm.tfCustName.setText( readOne.get(1) );
		custUpFrm.tfAddress.setText( readOne.get(2) );
		custUpFrm.tfPhone.setText( readOne.get(3) );
		custUpFrm.setVisible(true);
	} // mouseClicked

} // class







