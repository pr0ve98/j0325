package t6_Swing;

import javax.swing.JFrame;

// 화면 중앙에 윈도우 정렬, 윈도우 크기 고정
@SuppressWarnings("serial")
public class Test5_WindowAlign extends JFrame {
	
	
	public Test5_WindowAlign() {
		super("스윙스 연습");
		
//		setBounds(300, 250, 300, 250);
		setSize(300, 250); // 폭, 높이
		setLocationRelativeTo(null); // 윈도우를 화면 중앙에 배치
		setResizable(false); // 윈도우 크기 고정
		
		setVisible(true);

		// 윈도우 창 닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Test5_WindowAlign();
	}
}
