package t4_Panel;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T1_GridPanel1 extends Frame implements WindowListener, ActionListener{
	//Button btnExit;
	Panel pn1, pn2, pn3;
	Label lbl1, lbl2, lbl3;
	
	public T1_GridPanel1() {
		super("그리드 패널 연습");
		setLayout(new GridLayout(3,1));
		setBounds(400, 350, 400, 350);
		
		// 첫번째 패널
		pn1 = new Panel();
		lbl1 = new Label("첫번째 패널입니당. (^-^)/");
		pn1.add(lbl1); // 레이블을 패널에 올림
		add(pn1); // 패널을 프레임에 올림
		
		// 두번째 패널
		pn2 = new Panel();
		lbl2 = new Label("두번째 패널입니당. \\(^0^)");
		pn2.add(lbl2);
		add(pn2);
		
		// 세번째 패널
		pn3 = new Panel();
		lbl3 = new Label("세번째 패널입니당. <(>-0)>");
		pn3.add(lbl3);
		add(pn3);
		
		
		setVisible(true);
		
		addWindowListener(this);
//		btnExit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new T1_GridPanel1();
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
