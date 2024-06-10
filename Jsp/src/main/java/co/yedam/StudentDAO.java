package co.yedam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DAO {
	// 등록, 삭제, 수정, 목록, 기능 구현.

	// 목록
	List<Student> studentList() {
		getConnection();
		String sql = "select * from tbl_student order by std_no";
		List<Student> students = new ArrayList<Student>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			// 조회된 결과 목록을 List<Student>에 담아서 반환.
			while (rs.next()) {
				Student student = new Student();
				student.setStdNo(rs.getString("std_no"));
				student.setStdName(rs.getString("std_name"));
				student.setPhone(rs.getString("phone"));
				student.setBldType(rs.getString("bld_type"));
				student.setCreateDate(rs.getDate("create_date"));

				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn(); // 자원 해제
		}

		return students;
	}

	// 추가
	boolean insertStudent(Student student) {
		getConnection();
		String sql = "insert into tbl_student(std_no, std_name, phone, bld_type) values(?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStdNo());
			psmt.setString(2, student.getStdName());
			psmt.setString(3, student.getPhone());
			psmt.setString(4, student.getBldType());
			if (psmt.executeUpdate() == 1) { // 처리된 건수 == 1
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn(); // 자원 해제
		}

		return false;
	}

	// 수정
	boolean updateStudent(Student student) {
		getConnection();
		String sql = "update tbl_student set phone = ? where std_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getPhone());
			psmt.setString(2, student.getStdNo());

			if (psmt.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn(); // 자원 해제
		}

		return false;
	}

	// 삭제
	boolean deleteStudent(String stdNo) {
		getConnection();
		String sql = "delete from tbl_student where std_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stdNo);
			if (psmt.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn(); // 자원 해제
		}

		return false;
	}
}
