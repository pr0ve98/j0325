package t2_Layout;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T2_FlowLayout extends Frame implements WindowListener, ActionListener {
	Button btn1, btn2, btn3, btn4, btn5;
	Label lbl1, lbl2, lbl3, lbl4, lbl5;

	// 생성자: UI 설계
	public T2_FlowLayout() {
		super("FlowLayout 연습~~!");
		setLayout(new FlowLayout());
		setBounds(300, 250, 300, 300);
		
		// 버튼 설계
		btn1 = new Button("버튼1");
		btn2 = new Button();
		btn2.setLabel("버튼2");
		btn3 = new Button("종료");
		btn4 = new Button("버튼4");
		btn5 = new Button("버튼5");
		
		this.add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		
		// 레이블 설계
		lbl1 = new Label("제목1");
		lbl2 = new Label("제목2");
		lbl3 = new Label("제목3");
		lbl4 = new Label("제목4");
		lbl5 = new Label("제목5");
		
		add(lbl1);
		add(lbl2);
		add(lbl3);
		add(lbl4);
		add(lbl5);
		
		setVisible(true);
		
		addWindowListener(this);
		btn3.addActionListener(this);
	}
	
	public static void main(String[] args) { // 메인메소드
		new T2_FlowLayout();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) { System.exit(0); }

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
