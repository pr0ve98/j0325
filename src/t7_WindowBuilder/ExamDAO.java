package t7_WindowBuilder;

import java.sql.SQLException;
import java.util.ArrayList;

import t8_Insa.DBConn;

public class ExamDAO extends DBConn {

	public ArrayList<ImageInforVO> getImageInforList() {
		ArrayList<ImageInforVO> vos = new ArrayList<ImageInforVO>();
		try {
			sql = "select * from mvwmovie";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ImageInforVO vo = new ImageInforVO();
				vo.setImg(rs.getString("img"));
				
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}
  
}
