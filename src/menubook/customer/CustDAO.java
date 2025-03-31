package menubook.customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

import menubook.DBUtils;

public class CustDAO {

	private Properties sqlProperties;

	public CustDAO() throws SQLException {
		sqlProperties = DBUtils.getSqlProperties();
	}

	public Vector<Vector<String>> readAll() throws SQLException {

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
	} // readAll

	public int insertOne(String name, String address, String phone) throws SQLException {
		int successCnt = 0;

		PreparedStatement psmt = DBUtils.getConnection().prepareStatement( sqlProperties.getProperty("custInsertOne") );
		psmt.setString(1, name);
		psmt.setString(2, address);
		psmt.setString(3, phone);
		successCnt = psmt.executeUpdate();
		psmt.close();

		return successCnt;
	} // insertOne

	public int updateOne(String selectedBookID, String name, String address, String phone) throws SQLException {
		int successCnt = 0;

		PreparedStatement psmt = DBUtils.getConnection().prepareStatement( sqlProperties.getProperty("custUpdateOne") );
		psmt.setString(1, name);
		psmt.setString(2, address);
		psmt.setString(3, phone);
		psmt.setString(4, selectedBookID);
		successCnt = psmt.executeUpdate();
		psmt.close();

		return successCnt;
	} // updateOne

	public int deleteOne(String selectedBookID) throws SQLException {
		int successCnt = 0;

		PreparedStatement psmt = DBUtils.getConnection().prepareStatement( sqlProperties.getProperty("custDeleteOne") );
		psmt.setString(1, selectedBookID);
		successCnt = psmt.executeUpdate();
		psmt.close();

		return successCnt;
	} // deleteOne

} // class
