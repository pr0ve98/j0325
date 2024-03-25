package t4_Panel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T2_GridPanel1 extends Frame implements WindowListener, ActionListener{
	Panel pn1, pn2, pn3, pn4;
	Label lbl1, lbl2, lbl3;
	Button btnExit;
	
	public T2_GridPanel1() {
		super("그리드 패널 연습");
		setLayout(new GridLayout(1,3));
		setBounds(400, 350, 400, 350);
		
		// 첫번째 패널
		pn1 = new Panel();
		pn1.setBackground(Color.MAGENTA); // 배경
		pn1.setForeground(Color.white); // 글자
		lbl1 = new Label("첫번째 패널입니당. (^-^)/");
		pn1.add(lbl1);
		add(pn1);
		
		// 두번째 패널
		pn2 = new Panel();
		pn2.setBackground(Color.black); // 배경
		pn2.setForeground(Color.white); // 글자
		lbl2 = new Label("두번째 패널입니당. \\(^0^)");
		pn2.add(lbl2);
		add(pn2);

		// 세번째 패널
		pn3 = new Panel();
		pn3.setBackground(Color.orange); // 배경
		pn3.setLayout(new GridLayout(2,1));
		lbl3 = new Label("세번째 패널입니당. <(>-0)>");
		btnExit = new Button("바이바이 (T^T)/");
		pn3.add(lbl3);
		pn3.add(btnExit);
		add(pn3);
		
		
		
		
		setVisible(true);
		
		addWindowListener(this);
		btnExit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new T2_GridPanel1();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
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
