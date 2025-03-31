package m1jdbc.general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* JDBC : Java DataBase Connect
 * 
 * JDBC 5 Step
 * 1 - Driver loading (mysql-connector-j-8.4.0.jar)
 *     - Driver : DBMS 제조사가 제공하는 클라이언트 모듈.
 * 2 - 연결 확립 : Connection
 * 3 - 질의 생성 및 전송 : Statement & Query
 * 4 - 결과 확인 : CUD - CUD 건수 리턴, R - ResultSet 리턴.
 * 5 - 연결 해제 : Connection Close
 */
public class JDBC1Overview {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver"); // 1단계.

		String url = "jdbc:mysql://localhost:3306/ureca"; // 연결 명령, ip, port, dbname.
		String user = "ureca";
		String password = "ureca";
		Connection con = DriverManager.getConnection(url, user, password); // 2단계.

		String query = "SELECT e.empno, e.ename, e.job, e.mgr, e.hiredate"
				+ ", e.sal, e.comm, e.deptno, d.dname, d.loc"
				+ "  FROM emp e, dept d"
				+ "  WHERE e.deptno = d.deptno";
		Statement stmt = con.createStatement(); // 3단계.
		ResultSet rs = stmt.executeQuery(query);

//		while (rs.next()) { // 4단계.
//			System.out.print(rs.getInt(1) + "\t");
//			System.out.print(rs.getString(2) + "\t\t");
//			System.out.print(rs.getString(3) + "\t\t");
//			System.out.print(rs.getInt(4) + "\t");
//			System.out.print(rs.getString(5) + "\t");
//			System.out.print(rs.getInt(6) + "\t");
//			System.out.print(rs.getInt(7) + "\t");
//			System.out.print(rs.getInt(8) + "\t");
//			System.out.print(rs.getString(9) + "\t\t");
//			System.out.println(rs.getString(10));
//		} //while
		while (rs.next()) { // 4단계.
			System.out.print(rs.getString("sal") + "\t");
			System.out.print(rs.getInt("empno") + "\t");
			System.out.print(rs.getString("ename") + "\t\t");
			System.out.print(rs.getString("job") + "\t\t");
			System.out.print(rs.getInt("mgr") + "\t");
			System.out.print(rs.getString("hiredate") + "\t");
			System.out.print(rs.getInt("comm") + "\t");
			System.out.print(rs.getInt("deptno") + "\t");
			System.out.print(rs.getString("dname") + "\t\t");
			System.out.println(rs.getString("loc"));
		} //while

		// 5단계.
		rs.close();
		stmt.close();
		con.close();
	} // main

} // class





