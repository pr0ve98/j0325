package t6_Swing;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

// 인터페이스를 이용한 스윙의 종료
@SuppressWarnings("serial")
public class Test2_Interface extends JFrame implements WindowListener {
	
	
	public Test2_Interface() {
		super("스윙스 연습");
		
		setBounds(300, 250, 300, 250);
		
		addWindowListener(this);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test2_Interface();
	}

	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {System.exit(0);}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
}
