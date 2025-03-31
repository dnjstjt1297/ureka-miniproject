package m1jdbc.general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * ResutSet
 * - select 수행의 결과 집합(테이블/표 형태).
 * - 결과 집합에 지시자가 포함되어 있다.
 *  
 * 지시자 관련 method
 * - afterLast : 맨 끝 data의 뒤로 이동.
 * - beforeFirst : 맨 첫 data의 앞으로 이동.
 * - first : 맨 첫 data로 이동.
 * - last : 맨 끝 data로 이동.
 * - next : 다음 아래 data로 이동.
 * - previous : 다음 위 data로 이동.
 * - absolute : 지정된 순서의 data로 이동.
 * - relative : 현재 data에서 지정된 거리의 data로 이동.
 * - isAfterLast : 지시자의 위치가 AfterLast인가?
 * - isBeforeFirst : 지시자의 위치가 BeforeFirst인가?
 * - isFirst : 지시자의 위치가 First인가?
 * - isLast : 지시자의 위치가 Last인가?
 */
public class JDBC5ResultSet {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Step1.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step2.
		String url = "jdbc:mysql://127.0.0.1:3306/ureca";
		String user = "ureca";
		String password = "ureca";
		Connection con = DriverManager.getConnection(url, user, password);

		// Step3.
		Statement stmt = con.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		// Step4.
		String query = "SELECT e.*, d.*"
				+ "  FROM emp e, dept d"
				+ "  WHERE e.deptno = d.deptno"
				+ "  ORDER BY e.ename";
		ResultSet rs = stmt.executeQuery(query);

		// ResultSet traverse
		System.out.println("rs.isBeforeFirst : " + rs.isBeforeFirst());
		System.out.println("rs.isAfterLast : " + rs.isAfterLast());
		rs.afterLast();
		System.out.println("===> rs.afterLast 수행");
		System.out.println("rs.isBeforeFirst : " + rs.isBeforeFirst());
		System.out.println("rs.isAfterLast : " + rs.isAfterLast());
		System.out.println("==============================");
		rs.beforeFirst();
		System.out.println("===> rs.beforeFirst 수행");
		rs.next();
		System.out.println("===> rs.next 수행");
		System.out.println(rs.getString("ename"));
		rs.next();
		System.out.println("===> rs.next 수행");
		System.out.println(rs.getString("ename"));
		rs.previous();
		System.out.println("===> rs.previous 수행");
		System.out.println(rs.getString("ename"));
		System.out.println("==============================");
		rs.last();
		System.out.println("===> rs.last 수행");
		System.out.println(rs.getString("ename"));
		rs.previous();
		System.out.println("===> rs.previous 수행");
		System.out.println(rs.getString("ename"));
		System.out.println("==============================");
		rs.absolute(3);
		System.out.println("===> rs.absolute(3) 수행");
		System.out.println(rs.getString("ename"));
		rs.relative(2);
		System.out.println("===> rs.relative(2) 수행");
		System.out.println(rs.getString("ename"));
		rs.relative(-2);
		System.out.println("===> rs.relative(-2) 수행");
		System.out.println(rs.getString("ename"));

		// Step5.
		rs.close();
		stmt.close();
		con.close();
	} // main

} // class
