package t2_Layout;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 사용자 지정 레이아웃
@SuppressWarnings("serial")
public class T5_AbsoluteLayout1 extends Frame implements WindowListener, ActionListener {
	Button btn1, btn2, btn3, btn4, btnExit;
	
	public T5_AbsoluteLayout1() {
		
		super("사용자지정 레이아웃!");
		setLayout(null); // 사용자 지정 레이아웃(수동레이아웃)
		setBounds(400, 300, 350, 400);
		
		btn1 = new Button("첫번째");
		btn2 = new Button("두번째");
		btn3 = new Button("세번째");
		btn4 = new Button("네번째");
		btnExit = new Button("종료");
		btn1.setBounds(50, 150, 50, 30);
		btn2.setBounds(50, 190, 50, 30);
		btn3.setBounds(50, 230, 50, 30);
		btn4.setBounds(50, 270, 50, 30);
		btnExit.setBounds(50, 310, 50, 30);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btnExit);
		
		setVisible(true);
		
		addWindowListener(this);
		btnExit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new T5_AbsoluteLayout1();
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
