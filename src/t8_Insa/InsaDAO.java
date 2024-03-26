package t8_Insa;

import java.sql.SQLException;

public class InsaDAO extends DBConn {
	InsaVO vo = null;

	// 회원 개별 조회(성명 중복체크)
	public InsaVO getNameSearch(String name) {
		InsaVO vo = new InsaVO();
		try {
			sql = "SELECT * FROM insa2 WHERE name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setIpsail(rs.getString("ipsail"));
			}
		} catch (SQLException e) {
			System.out.println("sql 오류: "+e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	public int setInsaInput(InsaVO vo) {
		int res = 0;
		try {
			sql = "INSERT INTO insa2 VALUES (DEFAULT,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getIpsail());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql 오류: "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
}
