package t7_WindowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

@SuppressWarnings("serial")
public class T4_Radio_CheckBox extends JFrame {
	JRadioButton rdMale, rdFemale;
	JCheckBox ckHobby1, ckHobby2, ckHobby3, ckHobby4;
	JButton btnGender, btnHobby, btnExit;
	JLabel lblMassage;
	private final ButtonGroup btnGroupGender = new ButtonGroup();
	
	public T4_Radio_CheckBox() {
		super("라디오/체크박스 연습");
		setSize(600, 400);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(255, 255, 255));
		pn1.setBounds(0, 0, 584, 46);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("라디오 버튼 /  체크박스 연습");
		lblNewLabel.setFont(new Font("경기천년제목V Bold", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 584, 46);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 255, 255));
		pn2.setBounds(0, 47, 584, 268);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("성별");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("KBIZ한마음고딕 R", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(48, 35, 101, 44);
		pn2.add(lblNewLabel_1);
		
		rdMale = new JRadioButton("남자");
		btnGroupGender.add(rdMale);
		rdMale.setBackground(new Color(255, 255, 255));
		rdMale.setHorizontalAlignment(SwingConstants.CENTER);
		rdMale.setFont(new Font("KBIZ한마음고딕 R", Font.PLAIN, 15));
		rdMale.setBounds(197, 35, 144, 44);
		pn2.add(rdMale);
		
		rdFemale = new JRadioButton("여자");
		btnGroupGender.add(rdFemale);
		rdFemale.setBackground(new Color(255, 255, 255));
		rdFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rdFemale.setFont(new Font("KBIZ한마음고딕 R", Font.PLAIN, 15));
		rdFemale.setBounds(389, 35, 144, 44);
		pn2.add(rdFemale);
		
		JLabel lblNewLabel_1_1 = new JLabel("취미");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("KBIZ한마음고딕 R", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(48, 105, 101, 44);
		pn2.add(lblNewLabel_1_1);
		
		ckHobby1 = new JCheckBox("등산");
		ckHobby1.setBackground(new Color(255, 255, 255));
		ckHobby1.setFont(new Font("KBIZ한마음고딕 R", Font.PLAIN, 15));
		ckHobby1.setHorizontalAlignment(SwingConstants.CENTER);
		ckHobby1.setBounds(157, 112, 95, 31);
		pn2.add(ckHobby1);
		
		ckHobby2 = new JCheckBox("낚시");
		ckHobby2.setHorizontalAlignment(SwingConstants.CENTER);
		ckHobby2.setFont(new Font("KBIZ한마음고딕 R", Font.PLAIN, 15));
		ckHobby2.setBackground(new Color(240, 240, 240));
		ckHobby2.setBounds(256, 112, 95, 31);
		pn2.add(ckHobby2);
		
		ckHobby3 = new JCheckBox("수영");
		ckHobby3.setHorizontalAlignment(SwingConstants.CENTER);
		ckHobby3.setFont(new Font("KBIZ한마음고딕 R", Font.PLAIN, 15));
		ckHobby3.setBackground(UIManager.getColor("Button.background"));
		ckHobby3.setBounds(355, 112, 95, 31);
		pn2.add(ckHobby3);
		
		ckHobby4 = new JCheckBox("바둑");
		ckHobby4.setHorizontalAlignment(SwingConstants.CENTER);
		ckHobby4.setFont(new Font("KBIZ한마음고딕 R", Font.PLAIN, 15));
		ckHobby4.setBackground(UIManager.getColor("Button.background"));
		ckHobby4.setBounds(454, 112, 95, 31);
		pn2.add(ckHobby4);
		
		lblMassage = new JLabel("메시지 출력");
		lblMassage.setFont(new Font("KBIZ한마음고딕 R", Font.PLAIN, 20));
		lblMassage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMassage.setBounds(48, 178, 485, 63);
		pn2.add(lblMassage);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(new Color(255, 255, 255));
		pn3.setBounds(0, 315, 584, 46);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnGender = new JButton("성별출력");
		btnGender.setFont(new Font("KBIZ한마음고딕 R", Font.PLAIN, 12));
		btnGender.setBounds(56, 10, 120, 26);
		pn3.add(btnGender);
		
		btnExit = new JButton("종료");
		btnExit.setFont(new Font("KBIZ한마음고딕 R", Font.PLAIN, 12));
		btnExit.setBounds(408, 12, 120, 26);
		pn3.add(btnExit);
		
		btnHobby = new JButton("취미출력");
		btnHobby.setFont(new Font("KBIZ한마음고딕 R", Font.PLAIN, 12));
		btnHobby.setBounds(232, 12, 120, 26);
		pn3.add(btnHobby);
		
		// ----------------------------------- 위쪽은 UI ----------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		// ----------------------------------- 아래쪽은 메소드 ----------------------------------------
		
		// 성별출력 버튼
		btnGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender = "";
				if(rdMale.isSelected()) gender += rdMale.getText();
				else if(rdFemale.isSelected()) gender += rdFemale.getText();
				lblMassage.setText("선택하신 성별은: "+gender);
			}
		});
		
		// 취미출력 버튼
		btnHobby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hobby = "";
				if(ckHobby1.isSelected()) hobby += ckHobby1.getText() + " / ";
				if(ckHobby2.isSelected()) hobby += ckHobby2.getText() + " / ";
				if(ckHobby3.isSelected()) hobby += ckHobby3.getText() + " / ";
				if(ckHobby4.isSelected()) hobby += ckHobby4.getText() + " / ";
				
				hobby = hobby.substring(0, hobby.length()-1);
				
				lblMassage.setText("선택하신 취미는? "+hobby);
				JOptionPane.showMessageDialog(null, "선택된 취미는 "+hobby);
			}
		});
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
	}
	
	public static void main(String[] args) {
		new T4_Radio_CheckBox();
	}
}
