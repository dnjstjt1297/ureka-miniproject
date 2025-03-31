package m2swing.level3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * DAO : Data(Base) Access Object
 */
public class EmpDAO {

	private Connection con;
	private String url = "jdbc:mysql://127.0.0.1:3306/ureca";
	private String user = "ureca";
	private String password = "ureca";
	private String sqlSelectAll = "select * from emp";

	public EmpDAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);
	}

	public void close() throws SQLException {
		con.close();
	} // close

	/* ResultSet 객체는 커넥션을 통해, DBMS의 외부 스키마에 생성된 조회 결과를 반영한다.
	 * 따라서, 커넥션이 종료되면, 더 이상 참조 불가능하다.
	 * 그러므로, ResultSet을 다른 객체와 공유하는 것은 바람직하지 않다.
	 * 그러한 이유로, DTO(Data Transfer Object)를 사용한다.
	 */
//	public ResultSet selectAll() throws SQLException {
//		Statement stmt = con.createStatement();
//		ResultSet rs = stmt.executeQuery(sqlSelectAll);
//		return rs;
//	} // selectAll

	public List<EmpDTO> selectAll() throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlSelectAll);

		List<EmpDTO> list = new ArrayList<>();

		while(rs.next()) {
			EmpDTO dto = new EmpDTO();
			dto.setEmpno( rs.getString("empno") );
			dto.setEname( rs.getString("ename") );
			dto.setJob( rs.getString("job") );
			dto.setMgr( rs.getString("mgr") );
			dto.setHiredate( rs.getString("hiredate") );
			dto.setSal( rs.getString("sal") );
			dto.setComm( rs.getString("comm") );
			dto.setDeptno( rs.getString("deptno") );
			list.add(dto);
		} // while

		return list;
	} // selectAll

} // class







