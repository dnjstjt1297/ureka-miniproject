package menubook.order;

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

public class OrdControl extends MouseAdapter implements ActionListener {

	private OrdInsFrm ordInsFrm;
	private OrdUpFrm ordUpFrm;
	private JTable table;
	private JDialog dialog;
	private JLabel dialogLabel;
	private OrdDAO dao;
	private Vector<Vector<String>> readAllData;
	private Vector<Vector<String>> readAllCustData;
	private Vector<Vector<String>> readAllBookData;
	private Vector<String> colNames;
	private Vector<String> colNamesCust;
	private Vector<String> colNamesBook;
	private String selectedCustID;
	private String selectedBookID;
	private String selectedOrdID;
	private int afterList;

	public OrdControl(OrdListPan ordListPan, OrdInsFrm ordInsFrm, OrdUpFrm ordUpFrm
			, JDialog dialog, JLabel dialogLabel) {
		this.table = ordListPan.table;
		this.ordInsFrm = ordInsFrm;
		this.ordUpFrm = ordUpFrm;
		this.dialog = dialog;
		this.dialogLabel = dialogLabel;
		try {
			dao = new OrdDAO();
		} catch( SQLException e ) {
//			e.printStackTrace();
			dialogOpen("주문 관리를 위한 커넥션 연결을 실패 하였습니다.");
		}
		colNames = new Vector<String>();
		colNames.add("OrderID");
		colNames.add("CustID");		colNames.add("CustName");
		colNames.add("BookID");		colNames.add("BookName");
		colNames.add("SalePrice");	colNames.add("OrderDate");
		colNamesBook = new Vector<String>();
		colNamesBook.add("BookID");		colNamesBook.add("BookName");
		colNamesBook.add("Publisher");	colNamesBook.add("Price");
		colNamesCust = new Vector<String>();
		colNamesCust.add("CustID");		colNamesCust.add("CustName");
		colNamesCust.add("Address");	colNamesCust.add("Phone");
	} // constructor

	private void dialogOpen( String message ) {
		this.dialogLabel.setText(message);
		this.dialog.setVisible(true);
	} // dialogOpen

	private void jTableInit() {
		DefaultTableModel modelCust = new DefaultTableModel(new Vector<Vector<String>>(), colNamesCust);
		DefaultTableModel modelBook = new DefaultTableModel(new Vector<Vector<String>>(), colNamesBook);
		if(afterList == 1) {
			ordUpFrm.custTable.setModel(modelCust);
			ordUpFrm.bookTable.setModel(modelBook);
		} else {
			ordInsFrm.tfName.setText("");
			ordInsFrm.tfBookName.setText("");
			ordInsFrm.tfSalePrice.setText("");
			ordInsFrm.custTable.setModel(modelCust);
			ordInsFrm.bookTable.setModel(modelBook);
		}
	} // tableInit

	private void readAll() {
		try {
			readAllData = dao.readAll();
		} catch (SQLException e) {
//			e.printStackTrace();
			readAllData = new Vector<Vector<String>>();
			dialogOpen("주문 목록 조회에 실패 하였습니다.");
		}
		// OrdListPan의 JTABLE에 Data 입력.
		DefaultTableModel model = new DefaultTableModel(readAllData, colNames);
		table.setModel(model);
	} // readAll

	private void readAllCust() {
		try {
			readAllCustData = dao.readAllCust();
		} catch (SQLException e) {
			e.printStackTrace();
			readAllCustData = new Vector<Vector<String>>();
			dialogOpen("고객 목록 조회에 실패 하였습니다.");
		}
		// JTABLE에 Data 입력.
		DefaultTableModel model = new DefaultTableModel(readAllCustData, colNamesCust);
		if(afterList == 1) {
			ordUpFrm.custTable.setModel(model);
		} else {
			ordInsFrm.custTable.setModel(model);
		} // if ~ else
	} // readAllCust

	private void readAllBook() {
		try {
			readAllBookData = dao.readAllBook();
		} catch (SQLException e) {
			e.printStackTrace();
			readAllBookData = new Vector<Vector<String>>();
			dialogOpen("도서 목록 조회에 실패 하였습니다.");
		}
		// JTABLE에 Data 입력.
		DefaultTableModel model = new DefaultTableModel(readAllBookData, colNamesBook);
		if(afterList == 1) {
			ordUpFrm.bookTable.setModel(model);
		} else {
			ordInsFrm.bookTable.setModel(model);
		} // if ~ else
	} // readAllBook

	private void insertOne() {
		int successCnt = 0;
		try {
			successCnt = dao.insertOne(selectedCustID, selectedBookID, ordInsFrm.tfSalePrice.getText());
		} catch (SQLException e) {
//			e.printStackTrace();
		}
		if(successCnt < 1) { // insert fail
			dialogOpen("주문 정보 입력에 실패 하였습니다.");
		} else { // insert success - 입력 창 초기화 & 주문 목록 새로 고침.
			ordInsFrm.tfName.setText("");
			ordInsFrm.tfBookName.setText("");
			ordInsFrm.tfSalePrice.setText("");
			this.readAll();
		}
	} // insertOne

	private void updateOne() {
		int successCnt = 0;
		try {
			successCnt = dao.updateOne(selectedOrdID, selectedCustID, selectedBookID, ordUpFrm.tfSalePrice.getText());
		} catch (SQLException e) {
//			e.printStackTrace();
		}
		if(successCnt < 1) { // update fail
			dialogOpen("주문 정보 수정에 실패 하였습니다.");
		} else { // update success - 수정 창 닫기 & 주문 목록 새로 고침.
			ordUpFrm.setVisible(false);
			this.readAll();
		}
	} // updateOne

	private void deleteOne() {
		int successCnt = 0;
		try {
			successCnt = dao.deleteOne(selectedOrdID);
		} catch (SQLException e) {
//			e.printStackTrace();
		}
		if(successCnt < 1) { // delete fail
			dialogOpen("주문 정보 삭제에 실패 하였습니다.");
		} else { // delete success - 삭제 창 닫기 & 주문 목록 새로 고침.
			ordUpFrm.setVisible(false);
			this.readAll();
		}
	} // deleteOne

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if( command.equals("목록 조회") ) {
			this.readAll();
		} else if( command.equals("입력 취소") ) {
			ordInsFrm.setVisible(false);
		} else if( command.equals("주문 추가") ) {
			afterList = 0;
			this.jTableInit();
			ordInsFrm.setVisible(true);
		} else if( command.equals("고객 검색") ) {
			this.readAllCust();
		} else if( command.equals("도서 검색") ) {
			this.readAllBook();
		} else if( command.equals("주문 저장") ) {
			this.insertOne();
		} else if( command.equals("주문 수정") ) {
			this.updateOne();
		} else if( command.equals("주문 삭제") ) {
			this.deleteOne();
		} else if( command.equals("수정 취소") ) {
			ordUpFrm.setVisible(false);
		}
	} // actionPerformed

	@Override
	public void mouseClicked(MouseEvent e) {
		String jTableName = ((JTable) e.getSource()).getName();
		int rowIdx = 0;
		Vector<String> readOne = null;

		if(jTableName.equals("CustTable")) {
			if(afterList == 1) {
				rowIdx = ordUpFrm.custTable.getSelectedRow();
				readOne = readAllCustData.get(rowIdx);
				ordUpFrm.tfName.setText( readOne.get(1) );
			} else {
				rowIdx = ordInsFrm.custTable.getSelectedRow();
				readOne = readAllCustData.get(rowIdx);
				ordInsFrm.tfName.setText( readOne.get(1) );
			} // if ~ else
			selectedCustID = readOne.get(0);
		} else if(jTableName.equals("BookTable")) {
			if(afterList == 1) {
				rowIdx = ordUpFrm.bookTable.getSelectedRow();
				readOne = readAllBookData.get(rowIdx);
				ordUpFrm.tfBookName.setText( readOne.get(1) );
			} else {
				rowIdx = ordInsFrm.bookTable.getSelectedRow();
				readOne = readAllBookData.get(rowIdx);
				ordInsFrm.tfBookName.setText( readOne.get(1) );
			} // if ~ else
			selectedBookID = readOne.get(0);
		} else if(jTableName.equals("ListTable")) {
			afterList = 1;
			this.jTableInit();

			rowIdx = table.getSelectedRow();
			readOne = readAllData.get(rowIdx);
			selectedOrdID = readOne.get(0);

			ordUpFrm.tfName.setText( readOne.get(2) );
			ordUpFrm.tfBookName.setText( readOne.get(4) );
			ordUpFrm.tfSalePrice.setText( readOne.get(5) );
			ordUpFrm.setVisible(true);
		} // if ~ else
	} // mouseClicked

} // class
