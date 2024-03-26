package t7_WindowBulider;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class T2_TextField extends JFrame {
	private JTextField txtMid, txtName, txtAge;
	private JButton btnSubmit, btnReset, btnExit;
	private JPasswordField txtPwd;
	
	private String rexAge = "^[0-9]+$";

	public T2_TextField() {
		super("회원가입");
		setSize(600, 480);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(255, 128, 64));
		pn1.setBounds(12, 10, 560, 62);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회 원 가 입");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 536, 42);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(139, 209, 252));
		pn2.setBounds(12, 88, 560, 279);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblMid = new JLabel("아 이 디");
		lblMid.setHorizontalAlignment(SwingConstants.CENTER);
		lblMid.setFont(new Font("굴림", Font.PLAIN, 18));
		lblMid.setBounds(35, 28, 124, 34);
		pn2.add(lblMid);
		
		JLabel lblPwd = new JLabel("비 밀 번 호");
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setFont(new Font("굴림", Font.PLAIN, 18));
		lblPwd.setBounds(35, 90, 124, 34);
		pn2.add(lblPwd);
		
		JLabel lblName = new JLabel("성 명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("굴림", Font.PLAIN, 18));
		lblName.setBounds(35, 152, 124, 34);
		pn2.add(lblName);
		
		txtMid = new JTextField();
		txtMid.setFont(new Font("굴림", Font.PLAIN, 18));
		txtMid.setBounds(209, 23, 276, 41);
		pn2.add(txtMid);
		txtMid.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.PLAIN, 18));
		txtName.setColumns(10);
		txtName.setBounds(209, 151, 276, 41);
		pn2.add(txtName);
		
		JLabel lblAge = new JLabel("나 이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("굴림", Font.PLAIN, 18));
		lblAge.setBounds(35, 214, 124, 34);
		pn2.add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("굴림", Font.PLAIN, 18));
		txtAge.setColumns(10);
		txtAge.setBounds(209, 215, 276, 41);
		pn2.add(txtAge);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(209, 87, 276, 41);
		pn2.add(txtPwd);
		
		JLabel lblImg = new JLabel("");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setIcon(new ImageIcon(T2_TextField.class.getResource("/t7_WindowBulider/imgs/17.jpg")));
		lblImg.setBounds(0, 0, 560, 279);
		pn2.add(lblImg);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(new Color(255, 128, 192));
		pn3.setBounds(12, 381, 560, 50);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnSubmit = new JButton("회원가입");
		btnSubmit.setFont(new Font("굴림", Font.PLAIN, 18));
		btnSubmit.setBounds(51, 10, 118, 30);
		pn3.add(btnSubmit);
		
		btnReset = new JButton("다시입력");
		btnReset.setFont(new Font("굴림", Font.PLAIN, 18));
		btnReset.setBounds(220, 10, 118, 30);
		pn3.add(btnReset);
		
		btnExit = new JButton("종료");
//		btnExit.setIcon(new ImageIcon("D:\\javaclass\\java\\works\\j0325_AWT_Swing_WindowBulider\\src\\myImges\\3.png"));
//		btnExit.setIcon(new ImageIcon("./myImges/3.png"));
		btnExit.setIcon(new ImageIcon(T2_TextField.class.getResource("/myImges/3.png")));
		btnExit.setFont(new Font("굴림", Font.PLAIN, 18));
		btnExit.setBounds(389, 10, 118, 30);
		pn3.add(btnExit);
		
		// ----------------------------------- 위쪽은 UI ----------------------------------------
		setLocationRelativeTo(null); // 윈도우창 가운데 정렬
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우 종료
		setResizable(false); // 윈도우창 사이즈 변경 불가
		setVisible(true);
		// ----------------------------------- 아래쪽은 메소드 ----------------------------------------
		
		
		// 회원가입 버튼
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMid.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
					txtMid.requestFocus();
				}
				else if(txtPwd.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.");
					txtPwd.requestFocus();
				}
				else if(txtName.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
					txtName.requestFocus();
				}
//				else if(txtAge.getText().trim().equals("")) {
//					JOptionPane.showMessageDialog(null, "나이를 입력하세요.");
//					txtAge.requestFocus();
//				}
				else if(!Pattern.matches(rexAge, txtAge.getText().trim())) {
					JOptionPane.showMessageDialog(null, "나이는 숫자만 입력하세요.");
					txtAge.requestFocus();
				}
				else {
					JOptionPane.showMessageDialog(null, "회원 가입 완료! (>▽<)//");
				}
				
			}
		});
		
		// 다시입력 버튼
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMid.setText("");
				txtPwd.setText("");
				txtName.setText("");
				txtAge.setText("");
				txtMid.requestFocus();
			}
		});
		
		// 종료 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new T2_TextField();
	}
}
