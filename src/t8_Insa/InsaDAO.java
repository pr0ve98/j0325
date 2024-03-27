package t8_Insa;

import java.sql.SQLException;
import java.util.Vector;

@SuppressWarnings({"rawtypes","unchecked"})
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

	// 가입
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

	// 회원 정보 수정처리
	public int setInsaUpdate(InsaVO vo) {
		int res = 0;
		try {
			sql = "UPDATE insa2 SET age=?, gender=?, ipsail=? WHERE name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getAge());
			pstmt.setString(2, vo.getGender());
			pstmt.setString(3, vo.getIpsail());
			pstmt.setString(4, vo.getName());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql 오류: "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	// 회원 삭제처리
	public int setInsaDelete(String name) {
		int res = 0;
		try {
			sql = "DELETE FROM insa2 WHERE name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql 오류: "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	public Vector getInsaList(String str, String order) {
		Vector vData = new Vector<>();
		try {
			if(str.equals("ipsail") && order.equals("a")) {
				sql = "SELECT * FROM insa2 ORDER BY ipsail";
			}
			else if(str.equals("ipsail") && order.equals("d")) {
				sql = "SELECT * FROM insa2 ORDER BY ipsail DESC";
			}
			else {
				sql = "SELECT * FROM insa2 ORDER BY idx DESC";
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail").substring(0,10));
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql 오류: "+e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

	// 조건을 이용한 다양한 검색처리
	public Vector getConditionSearch(String fieldName, String txtCondi) {
		Vector vData = new Vector<>();
		try {
			sql = "SELECT * FROM insa2 WHERE "+fieldName+" LIKE ? ORDER BY name";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+txtCondi+"%"); // 정확하게 치지 않고 중간 단어만 검색해도 나오게 처리
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail").substring(0,10));
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql 오류: "+e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	
}
