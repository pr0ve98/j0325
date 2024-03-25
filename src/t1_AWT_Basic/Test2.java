package t1_AWT_Basic;

import java.awt.Frame;

// Frame 객체를 상속받아서 작업처리
@SuppressWarnings("serial")
public class Test2 extends Frame {
	
	// 객체를 생성시에 UI설계 처리를 한다.
	public Test2() {
		super("AWT 프레임");
		//setTitle("AWT 프레임");
		setSize(300, 250); // 프레임의 크기(가로(폭), 높이(세로)) 픽셀 단위
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test2();
	}
}
