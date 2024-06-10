package co.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	// 세션(Connection), 쿼리실행객체(PreparedStatement), 결과객체(ResultSet).
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	// 세션 얻는 메소드(Connection 객체)
	public void getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // jdbc:oracle:thin:@데이터베이스주소:포트번호:xe
		String user_id = "jsp";
		String user_pw = "jsp";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user_id, user_pw); // url, user_id, user_pw
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disconn() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
