package menubook.book;

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

public class BookControl extends MouseAdapter implements ActionListener {

	private BookInsFrm bookInsFrm;
	private BookUpFrm bookUpFrm;
	private JTable table;
	private JDialog dialog;
	private JLabel dialogLabel;
	private BookDAO dao;
	private Vector<Vector<String>> readAllData = null;
	private Vector<String> colNames;
	private String selectedBookID;

	public BookControl(BookListPan bookListPan, BookInsFrm bookInsFrm, BookUpFrm bookUpFrm
			, JDialog dialog, JLabel dialogLabel) {
		this.table = bookListPan.table;
		this.bookInsFrm = bookInsFrm;
		this.bookUpFrm = bookUpFrm;
		this.dialog = dialog;
		this.dialogLabel = dialogLabel;
		try {
			dao = new BookDAO();
		} catch( SQLException e ) {
//			e.printStackTrace();
			dialogOpen("도서 관리를 위한 커넥션 연결을 실패 하였습니다.");
		}
		colNames = new Vector<String>();
		colNames.add("BookID");		colNames.add("BookName");
		colNames.add("Publisher");	colNames.add("Price");
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
			dialogOpen("도서 목록 조회에 실패 하였습니다.");
		}
		// BookListPan의 JTABLE에 Data 입력.
		DefaultTableModel model = new DefaultTableModel(readAllData, colNames);
		table.setModel(model);
	} // readAll

	private void insertOne() {
		int successCnt = 0;
		try {
			successCnt = dao.insertOne(bookInsFrm.tfBookName.getText()
					, bookInsFrm.tfPublisher.getText(), bookInsFrm.tfPrice.getText());
		} catch (SQLException e) {
//			e.printStackTrace();
		}
		if(successCnt < 1) { // insert fail
			dialogOpen("도서 정보 입력에 실패 하였습니다.");
		} else { // insert success - 입력 창 초기화 & 도서 목록 새로 고침.
			bookInsFrm.tfBookName.setText("");
			bookInsFrm.tfPublisher.setText("");
			bookInsFrm.tfPrice.setText("");
			this.readAll();
		}
	} // insertOne

	private void updateOne() {
		int successCnt = 0;
		try {
			successCnt = dao.updateOne(selectedBookID, bookUpFrm.tfBookName.getText()
					, bookUpFrm.tfPublisher.getText(), bookUpFrm.tfPrice.getText());
		} catch (SQLException e) {
//			e.printStackTrace();
		}
		if(successCnt < 1) { // update fail
			dialogOpen("도서 정보 수정에 실패 하였습니다.");
		} else { // update success - 수정 창 닫기 & 도서 목록 새로 고침.
			bookUpFrm.setVisible(false);
			this.readAll();
		}
	} // updateOne

	private void deleteOne() {
		int successCnt = 0;
		try {
			successCnt = dao.deleteOne(selectedBookID);
		} catch (SQLException e) {
//			e.printStackTrace();
		}
		if(successCnt < 1) { // delete fail
			dialogOpen("도서 정보 삭제에 실패 하였습니다.");
		} else { // delete success - 삭제 창 닫기 & 도서 목록 새로 고침.
			bookUpFrm.setVisible(false);
			this.readAll();
		}
	} // deleteOne

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if( command.equals("목록 조회") ) {
			this.readAll();
		} else if( command.equals("도서 추가") ) {
			bookInsFrm.setVisible(true);
		} else if( command.equals("입력 취소") ) {
			bookInsFrm.setVisible(false);
		} else if( command.equals("도서 저장") ) {
			this.insertOne();
		} else if( command.equals("도서 수정") ) {
			this.updateOne();
		} else if( command.equals("도서 삭제") ) {
			this.deleteOne();
		} else if( command.equals("수정 취소") ) {
			bookUpFrm.setVisible(false);
		}
	} // actionPerformed

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowIdx = table.getSelectedRow();
		Vector<String> readOne = readAllData.get(rowIdx);
		selectedBookID = readOne.get(0);

		bookUpFrm.tfBookName.setText( readOne.get(1) );
		bookUpFrm.tfPublisher.setText( readOne.get(2) );
		bookUpFrm.tfPrice.setText( readOne.get(3) );
		bookUpFrm.setVisible(true);
	} // mouseClicked

} // class







