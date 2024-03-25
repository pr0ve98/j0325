package t6_Swing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Test8_DialogBox extends JFrame {
	JPanel pn1, pn2;
	JButton btn1, btn2, btn3, btn4, btn5;
	JLabel lblMsg;
	
	public Test8_DialogBox() {
		super("DialogBox 연습");
		setLayout(new GridLayout(2,1));
		setSize(400, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		
		pn1 = new JPanel();
		btn1 = new JButton("경고");
		btn2 = new JButton("입력");
		btn3 = new JButton("종료");
		btn4 = new JButton("종료(예/아니오)");
		btn5 = new JButton("예/아니오/취소");
		pn1.add(btn1);
		pn1.add(btn2);
		pn1.add(btn3);
		pn1.add(btn4);
		pn1.add(btn5);
		
		pn2 = new JPanel();
		lblMsg = new JLabel("메시지가 출력됩니다.", JLabel.CENTER);
		pn2.add(lblMsg);
		
		add(pn1);
		add(pn2);
		
		// ---------------- 위쪽은 디자인 ---------------
		setVisible(true);
		// ---------------- 아래쪽은 메소드 --------------
		
		// 경고메시지 출력 메소드
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMsg.setText("!!경고!!경고!!경고!!경고!!");
//				JOptionPane.showMessageDialog(null, "니 경고. t(`-'t)");
				JOptionPane.showMessageDialog(null, "니 경고. t(`-'t)", "경고 메시지", JOptionPane.WARNING_MESSAGE);
			}
		});
		
		// 입력 메소드
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMsg.setText("!!입력!!입력!!입력!!입력!!");
				String mid = JOptionPane.showInputDialog(null, "아이디를 입력해주쎄용! (^-^)/", "입력창", JOptionPane.INFORMATION_MESSAGE);
				if(mid != null) lblMsg.setText("당신의 아이디는 "+mid+" 입니당! \\(^-^)");
			}
		});
		
		// 그냥 종료
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// 종료시 예/아니오
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMsg.setText("종료합니까...? (T-T)");
				// 0(예) or 1(아니오)
				int ans = JOptionPane.showConfirmDialog(null, "진짜 가실 건가요...? ㅡ('ㅅ`ㅡ)...", "종료창", JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					JOptionPane.showMessageDialog(null, "바이바이~ (/^\\.)..");
					System.exit(0);
				}
				else {
					JOptionPane.showMessageDialog(null, "돌아와서 기뻐! \\(^ 0 ^)/");
				}
			}
		});
		
		// '예/아니오/취소' 메소드
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 0:예, 1:아니오, 2:취소
				int ans = JOptionPane.showConfirmDialog(null, "진짜 가실 건가요...? ㅡ('ㅅ`ㅡ)...", "종료창", JOptionPane.YES_NO_CANCEL_OPTION);
				if(ans == 0) {
					JOptionPane.showMessageDialog(null, "바이바이~ (/^\\.)..");
					System.exit(0);
				}
				else if(ans == 1){
					JOptionPane.showMessageDialog(null, "돌아와서 기뻐! \\(^ 0 ^)/");
				}
				else {
					JOptionPane.showMessageDialog(null, "취소해서 기뻐! \\(^ 0 ^)/");
				}
			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Test8_DialogBox();
	}
}
