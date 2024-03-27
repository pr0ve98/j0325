package t8_Insa;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class InsaInput extends JFrame {
	private JTextField txtName;
	private JTextField txtAge;
	private final ButtonGroup btnGroupGender = new ButtonGroup();
	@SuppressWarnings("rawtypes")
	JComboBox cbYY, cbMM, cbDD;
	JRadioButton rdGenderMale, rdGenderFemale;
	
	InsaDAO dao = new InsaDAO();
	InsaVO vo = null;
	int res = 0;
	
	public InsaInput() {
		super("회원등록창");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 75);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("회 원  가 입  폼");
		lblTitle.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 784, 75);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 74, 784, 382);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblName = new JLabel("성 명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("경기천년제목 Light", Font.PLAIN, 20));
		lblName.setBounds(153, 44, 130, 48);
		pn2.add(lblName);
		
		JLabel lblAge = new JLabel("나 이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("경기천년제목 Light", Font.PLAIN, 20));
		lblAge.setBounds(153, 119, 130, 48);
		pn2.add(lblAge);
		
		JLabel lblGender = new JLabel("성 별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("경기천년제목 Light", Font.PLAIN, 20));
		lblGender.setBounds(153, 194, 130, 48);
		pn2.add(lblGender);
		
		JLabel lblIpsail = new JLabel("입사일");
		lblIpsail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpsail.setFont(new Font("경기천년제목 Light", Font.PLAIN, 20));
		lblIpsail.setBounds(153, 265, 130, 48);
		pn2.add(lblIpsail);
		
		txtName = new JTextField();
		txtName.setFont(new Font("경기천년제목 Light", Font.PLAIN, 20));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setBounds(381, 44, 230, 48);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setHorizontalAlignment(SwingConstants.CENTER);
		txtAge.setFont(new Font("경기천년제목 Light", Font.PLAIN, 20));
		txtAge.setColumns(10);
		txtAge.setBounds(381, 119, 230, 48);
		pn2.add(txtAge);
		
		rdGenderMale = new JRadioButton("  남자");
		btnGroupGender.add(rdGenderMale);
		rdGenderMale.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		rdGenderMale.setBounds(381, 196, 121, 46);
		pn2.add(rdGenderMale);
		
		rdGenderFemale = new JRadioButton("  여자");
		btnGroupGender.add(rdGenderFemale);
		rdGenderFemale.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		rdGenderFemale.setSelected(true);
		rdGenderFemale.setBounds(508, 196, 121, 46);
		pn2.add(rdGenderFemale);
		
		// 년도, 월, 일 초기값 생성하기
		String[] yy = new String[25];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		int imsi = 0;
		for(int i=0; i<yy.length; i++) {
			imsi = 2024 - i;
			yy[i] = imsi + "";
		}
		for(int i=0; i<mm.length; i++) {
			mm[i] = (i+1) + "";
		}
		for(int i=0; i<dd.length; i++) {
			dd[i] = (i+1) + "";
		}
		
		cbYY = new JComboBox(yy);
		cbYY.setBackground(new Color(255, 255, 255));
		cbYY.setBounds(347, 280, 69, 23);
		pn2.add(cbYY);
		
		cbMM = new JComboBox(mm);
		cbMM.setBackground(new Color(255, 255, 255));
		cbMM.setBounds(467, 280, 69, 23);
		pn2.add(cbMM);
		
		cbDD = new JComboBox(dd);
		cbDD.setBackground(new Color(255, 255, 255));
		cbDD.setBounds(581, 280, 69, 23);
		pn2.add(cbDD);
		
		JLabel lblNewLabel = new JLabel("년");
		lblNewLabel.setFont(new Font("경기천년제목 Light", Font.PLAIN, 20));
		lblNewLabel.setBounds(428, 275, 27, 32);
		pn2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("월");
		lblNewLabel_1.setFont(new Font("경기천년제목 Light", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(548, 275, 27, 32);
		pn2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("일");
		lblNewLabel_2.setFont(new Font("경기천년제목 Light", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(662, 275, 27, 32);
		pn2.add(lblNewLabel_2);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 454, 784, 107);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnInput = new JButton("가입하기");
		btnInput.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		btnInput.setBackground(new Color(255, 255, 255));
		btnInput.setBounds(109, 17, 115, 40);
		pn3.add(btnInput);
		
		JButton btnReset = new JButton("다시입력");
		btnReset.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		btnReset.setBackground(new Color(255, 255, 255));
		btnReset.setBounds(333, 17, 115, 40);
		pn3.add(btnReset);
		
		JButton btnClose = new JButton("창 닫기");
		btnClose.setFont(new Font("경기천년제목 Light", Font.BOLD, 14));
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setBackground(new Color(255, 0, 0));
		btnClose.setBounds(557, 17, 115, 40);
		pn3.add(btnClose);
		
		// 오늘날짜 가져와서 가입화면에 추가하기
		InsaService service = new InsaService();
		vo = service.getDefaultDate();
		cbYY.setSelectedItem(vo.getCbYY());
		cbMM.setSelectedItem(vo.getCbMM());
		cbDD.setSelectedItem(vo.getCbDD());
		
		// ----------------------------------- 위쪽은 UI ----------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		// ----------------------------------- 아래쪽은 메소드 ----------------------------------------
		
		// 회원가입 버튼을 키보드로 엔터키를 눌렀을 때 수행처리
		btnInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				setInsaInput();
			}
		});
		
		// 회원가입 버튼을 마우스로 클릭했을 때 수행처리
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setInsaInput();
			}
		});
		
		// 다시 입력
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
				txtName.requestFocus();
			}
		});
		
		// 창 닫기 버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InsaMain();
			}
		});
	}
	
	// 회원 가입 처리를 위한 메소드
	protected void setInsaInput() {
		String name = txtName.getText().trim();
		String age = txtAge.getText().trim();
		String gender = "";
		String ipsail = cbYY.getSelectedItem()+"-"+cbMM.getSelectedItem()+"-"+cbDD.getSelectedItem();
		
		// 유효성 검사
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null, "성명을 입력하세요.","성명 오류",JOptionPane.ERROR_MESSAGE);
			txtName.requestFocus();
		}
		else if(!Pattern.matches("^[0-9]+$", age)) {
			JOptionPane.showMessageDialog(null, "나이는 숫자로만 입력하세요.","나이 오류",JOptionPane.ERROR_MESSAGE);
			txtAge.requestFocus();
		}
		else {
			if(rdGenderMale.isSelected()) gender = "남자";
			else gender = "여자";
		}
		
		// 모든 체크가 끝나면 DB에 새로운 회원을 가입처리한다.
		// 회원명 중복처리
		vo = dao.getNameSearch(name);
		if(vo.getName() != null) {
			JOptionPane.showMessageDialog(null, "이미 가입된 회원입니다. 다른 성명을 입력하세요.","성명 오류",JOptionPane.ERROR_MESSAGE);
			txtName.requestFocus();
		}
		else {
			// 정상적으로 자료가 입력되었다면 vo에 담아서 있는 값을 DB에 저장
			vo.setName(name);
			vo.setAge(Integer.parseInt(age));
			vo.setGender(gender);
			vo.setIpsail(ipsail);
			
			res = dao.setInsaInput(vo);
			
			if(res != 0) {
				JOptionPane.showMessageDialog(null, "가입되셨습니다! (^-^)/", "가입 성공",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				new InsaMain();
			}
			else {
				JOptionPane.showMessageDialog(null, "회원가입 실패...","가입 실패",JOptionPane.ERROR_MESSAGE);
				txtName.requestFocus();
			}
			
		}
	}

	public static void main(String[] args) {
		new InsaInput();
	}
}
