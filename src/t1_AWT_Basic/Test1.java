package t1_AWT_Basic;

import java.awt.Frame;

// 직접 Frame(Windows 창) 객체를 생성해서 작업처리
public class Test1 {
	public static void main(String[] args) {
		Frame fream = new Frame();
		
		fream.setTitle("AWT 프레임");
		fream.setSize(300, 250); // 프레임의 크기(가로(폭), 높이(세로)) 픽셀 단위
		
		fream.setVisible(true);
	}
}
