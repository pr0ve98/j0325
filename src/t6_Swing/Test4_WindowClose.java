package t6_Swing;

import javax.swing.JFrame;

// JFrame 명령어를 이용한 스윙의 종료
@SuppressWarnings("serial")
public class Test4_WindowClose extends JFrame {
	
	
	public Test4_WindowClose() {
		super("스윙스 연습");
		
		setBounds(300, 250, 300, 250);
		
		setVisible(true);

		// 윈도우 창 닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Test4_WindowClose();
	}
}
