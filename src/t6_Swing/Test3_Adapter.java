package t6_Swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

// 어댑터를 이용한 스윙의 종료
@SuppressWarnings("serial")
public class Test3_Adapter extends JFrame {
	
	
	public Test3_Adapter() {
		super("스윙스 연습");
		
		setBounds(300, 250, 300, 250);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test3_Adapter();
	}
}
