package t1_AWT_Basic;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 종료 버튼 처리(인터페이스를 이용)
@SuppressWarnings("serial")
public class Test4 extends Frame implements WindowListener {
	
	// 객체를 생성시에 UI설계 처리를 한다.
	public Test4() {
		super("AWT 프레임");
		//setTitle("AWT 프레임");
		setBounds(300, 200, 350, 250); // 프레임의 위치크기(x축, y축, 폭, 높이) 픽셀 단위
		
		setVisible(true);
		
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new Test4();
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0); // JVM 완전히 실행종료(윈도우창 닫기)
	}

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
