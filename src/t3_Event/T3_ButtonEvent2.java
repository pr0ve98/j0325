package t3_Event;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T3_ButtonEvent2 extends Frame implements WindowListener, ActionListener {
	Button btnPlay, btnStop, btnExit, btnMessage;
	Label lblMessage;
	
	public T3_ButtonEvent2() {
		super("버튼 이벤트 연습");
		setLayout(new FlowLayout());
		setBounds(350, 300, 300, 250);
		
		// 버튼 객체 생성 및 배치
		btnPlay = new Button("Start");
		btnStop = new Button("Stop");
		btnExit = new Button("Exit");
		btnMessage = new Button("Message");
		add(btnPlay);
		add(btnStop);
		add(btnExit);
		add(btnMessage);
		
		// 레이블 생성 및 배치
		lblMessage = new Label();
		lblMessage.setSize(150, 20);
		lblMessage.setBackground(Color.PINK);
		add(lblMessage);
		
		setVisible(true);
		
		addWindowListener(this);
		btnExit.addActionListener(this);
		btnPlay.addActionListener(this);
		btnStop.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new T3_ButtonEvent2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Button btnText = (Button) e.getSource();
		
		if(btnText.getLabel().equals("Start")) {
			//System.out.println("시작합니당 (^-^)/");
			lblMessage.setText("시작합니당 (^-^)/"); //레이블에 띄우려면 setText
//			btnMessage.setLabel("시작합니당 (^-^)/"); // 버튼에 띄우려면 setLabel
		}
		else if(btnText.getLabel().equals("Stop")) {
			//System.out.println("끝났습니당 <(+ㅅ+)>");
			lblMessage.setText("끝났습니당 <(+ㅅ+)>");
//			btnMessage.setLabel("끝났습니당 <(+ㅅ+)>");
		}
		else {
			System.exit(0);
		}
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
