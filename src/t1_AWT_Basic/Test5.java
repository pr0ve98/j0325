package t1_AWT_Basic;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 종료 버튼 처리(인터페이스를 이용)
public class Test5 extends Frame implements WindowListener, ActionListener {
	
	// 객체를 생성시에 UI설계 처리를 한다.
	public Test5() {
		super("AWT 프레임");
		//setTitle("AWT 프레임");
		setBounds(300, 200, 350, 250); // 프레임의 위치크기(x축, y축, 폭, 높이) 픽셀 단위
		
		// 레이블 컴포넌트
		Label lbl1 = new Label("레이블 테스트입니다.");
		//this.add(lbl1);
		add(lbl1);
		
		// 컴포넌트를 생성하고 add로 꼭 올려야 함
		Button btnExit = new Button("종료");
		add(btnExit);
		
		setVisible(true);
		
		// 리스너 (윈도우 감지 부분 처리)
		addWindowListener(this);
		btnExit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new Test5();
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

	
	// 버튼 액션
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
