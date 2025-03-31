package menubook.book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

import menubook.DBUtils;

public class BookDAO {

	private Properties sqlProperties;

	public BookDAO() throws SQLException {
		sqlProperties = DBUtils.getSqlProperties();
	}

	public Vector<Vector<String>> readAll() throws SQLException {

		Vector<Vector<String>> list = new Vector<Vector<String>>();

		Statement stmt = DBUtils.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery( sqlProperties.getProperty("bookSelectAll") );
		while(rs.next()) {
			Vector<String> obj = new Vector<String>();
			obj.add( rs.getString("bookid") );
			obj.add( rs.getString("bookname") );
			obj.add( rs.getString("publisher") );
			obj.add( rs.getString("price") );
			list.add(obj);
		} // while
		rs.close();
		stmt.close();

		return list;
	} // readAll

	public int insertOne(String bookname, String publisher, String price) throws SQLException {
		int successCnt = 0;

		PreparedStatement psmt = DBUtils.getConnection().prepareStatement( sqlProperties.getProperty("bookInsertOne") );
		psmt.setString(1, bookname);
		psmt.setString(2, publisher);
		psmt.setString(3, price);
		successCnt = psmt.executeUpdate();
		psmt.close();

		return successCnt;
	} // insertOne

	public int updateOne(String selectedBookID, String bookname, String publisher, String price) throws SQLException {
		int successCnt = 0;

		PreparedStatement psmt = DBUtils.getConnection().prepareStatement( sqlProperties.getProperty("bookUpdateOne") );
		psmt.setString(1, bookname);
		psmt.setString(2, publisher);
		psmt.setString(3, price);
		psmt.setString(4, selectedBookID);
		successCnt = psmt.executeUpdate();
		psmt.close();

		return successCnt;
	} // updateOne

	public int deleteOne(String selectedBookID) throws SQLException {
		int successCnt = 0;

		PreparedStatement psmt = DBUtils.getConnection().prepareStatement( sqlProperties.getProperty("bookDeleteOne") );
		psmt.setString(1, selectedBookID);
		successCnt = psmt.executeUpdate();
		psmt.close();

		return successCnt;
	} // deleteOne

} // class
