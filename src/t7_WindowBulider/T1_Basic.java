package t7_WindowBulider;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class T1_Basic extends JFrame {
	private JTextField textName, textKor, textEng, textMat;
	private JButton btnInput, btnReset, btnExit; 

	public T1_Basic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("그린중학교 성적표");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblTitle.setBounds(80, 35, 627, 37);
		getContentPane().add(lblTitle);
		
		JLabel lblName = new JLabel("성 명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(90, 119, 107, 37);
		getContentPane().add(lblName);
		
		JLabel lblKor = new JLabel("국어점수");
		lblKor.setHorizontalAlignment(SwingConstants.CENTER);
		lblKor.setBounds(90, 201, 107, 37);
		getContentPane().add(lblKor);
		
		JLabel lblEng = new JLabel("영어점수");
		lblEng.setHorizontalAlignment(SwingConstants.CENTER);
		lblEng.setBounds(90, 280, 107, 37);
		getContentPane().add(lblEng);
		
		JLabel lblMat = new JLabel("수학점수");
		lblMat.setHorizontalAlignment(SwingConstants.CENTER);
		lblMat.setBounds(90, 364, 107, 37);
		getContentPane().add(lblMat);
		
		textName = new JTextField();
		textName.setBounds(234, 119, 348, 37);
		getContentPane().add(textName);
		textName.setColumns(10);
		
		textKor = new JTextField();
		textKor.setColumns(10);
		textKor.setBounds(234, 201, 348, 37);
		getContentPane().add(textKor);
		
		textEng = new JTextField();
		textEng.setColumns(10);
		textEng.setBounds(234, 280, 348, 37);
		getContentPane().add(textEng);
		
		textMat = new JTextField();
		textMat.setColumns(10);
		textMat.setBounds(234, 364, 348, 37);
		getContentPane().add(textMat);
		
		btnInput = new JButton("입력");
		
		btnInput.setBounds(90, 466, 141, 37);
		getContentPane().add(btnInput);
		
		btnReset = new JButton("다시입력");
		btnReset.setBounds(321, 466, 141, 37);
		getContentPane().add(btnReset);
		
		btnExit = new JButton("종료");
		btnExit.setBounds(552, 466, 141, 37);
		getContentPane().add(btnExit);
		
		setVisible(true);
		
		// 입력 버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		// 다시 입력 버튼
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textName.setText("");
				textKor.setText("");
				textEng.setText("");
				textMat.setText("");
				textName.requestFocus();
			}
		});
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "작업을 종료하시겠습니까?","",JOptionPane.YES_NO_OPTION);
				if(ans == 0) System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		T1_Basic frame = new T1_Basic();
	}
}
