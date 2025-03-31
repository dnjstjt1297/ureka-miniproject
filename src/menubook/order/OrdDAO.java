package menubook.order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

import menubook.DBUtils;

public class OrdDAO {

	private Properties sqlProperties;

	public OrdDAO() throws SQLException {
		sqlProperties = DBUtils.getSqlProperties();
	}

	public Vector<Vector<String>> readAll() throws SQLException {

		Vector<Vector<String>> list = new Vector<Vector<String>>();

		Statement stmt = DBUtils.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery( sqlProperties.getProperty("ordrSelectAll") );
		while(rs.next()) {
			Vector<String> obj = new Vector<String>();
			obj.add( rs.getString("orderid") );
			obj.add( rs.getString("custid") );
			obj.add( rs.getString("name") );
			obj.add( rs.getString("bookid") );
			obj.add( rs.getString("bookname") );
			obj.add( rs.getString("saleprice") );
			obj.add( rs.getString("orderdate") );
			list.add(obj);
		} // while
		rs.close();
		stmt.close();

		return list;
	} // readAll

	public Vector<Vector<String>> readAllCust() throws SQLException {

		Vector<Vector<String>> list = new Vector<Vector<String>>();

		Statement stmt = DBUtils.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery( sqlProperties.getProperty("custSelectAll") );
		while(rs.next()) {
			Vector<String> obj = new Vector<String>();
			obj.add( rs.getString("custid") );
			obj.add( rs.getString("name") );
			obj.add( rs.getString("address") );
			obj.add( rs.getString("phone") );
			list.add(obj);
		} // while
		rs.close();
		stmt.close();

		return list;
	} // readAllCust

	public Vector<Vector<String>> readAllBook() throws SQLException {

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
	} // readAllBook

	public int insertOne(String selectedCustID, String selectedBookID, String salePrice) throws SQLException {
		int successCnt = 0;

		PreparedStatement psmt = DBUtils.getConnection().prepareStatement( sqlProperties.getProperty("ordrInsertOne") );
		psmt.setString(1, selectedCustID);
		psmt.setString(2, selectedBookID);
		psmt.setString(3, salePrice);
		successCnt = psmt.executeUpdate();
		psmt.close();

		return successCnt;
	} // insertOne

	public int updateOne(String selectedOrdID, String selectedCustID, String selectedBookID, String salePrice) throws SQLException {
		int successCnt = 0;

		PreparedStatement psmt = DBUtils.getConnection().prepareStatement( sqlProperties.getProperty("ordrUpdateOne") );
		psmt.setString(1, selectedCustID);
		psmt.setString(2, selectedBookID);
		psmt.setString(3, salePrice);
		psmt.setString(4, selectedOrdID);
		successCnt = psmt.executeUpdate();
		psmt.close();

		return successCnt;
	} // updateOne

	public int deleteOne(String selectedOrdID) throws SQLException {
		int successCnt = 0;

		PreparedStatement psmt = DBUtils.getConnection().prepareStatement( sqlProperties.getProperty("ordrDeleteOne") );
		psmt.setString(1, selectedOrdID);
		successCnt = psmt.executeUpdate();
		psmt.close();

		return successCnt;
	} // deleteOne

} // class
