package t6_Swing;

import javax.swing.JFrame;

// 스윙에서 윈도우 종료(완전히 종료 X)
@SuppressWarnings("serial")
public class Test1_Basic extends JFrame {
	
	
	public Test1_Basic() {
		super("스윙스 연습");
		
		setBounds(300, 250, 300, 250);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test1_Basic();
	}
}
