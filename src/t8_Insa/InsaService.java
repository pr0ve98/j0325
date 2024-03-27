package t8_Insa;

import java.util.Calendar;

public class InsaService {
	InsaVO vo = null;

	// 오늘의 날짜를 구하는 메소드
	public InsaVO getDefaultDate() {
		vo = new InsaVO();
		
		Calendar cal = Calendar.getInstance();
		vo.setCbYY(cal.get(Calendar.YEAR)+"");
		vo.setCbMM((cal.get(Calendar.MONTH)+1)+"");
		vo.setCbDD(cal.get(Calendar.DATE)+"");
		
		return vo;
	}
	
}
