package t8_Insa;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.JobAttributes;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class InsaSearch extends JFrame {
	private JTextField txtName;
	private JTextField txtAge;
	private final ButtonGroup btnGroupGender = new ButtonGroup();
	@SuppressWarnings("rawtypes")
	JComboBox cbYY, cbMM, cbDD;
	
	InsaDAO dao = new InsaDAO();
	InsaVO vo = null;
	int res = 0;
	
	public InsaSearch(InsaVO vo) {
		super("회원등록창");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 75);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("회원  개별  조회 | 수정 | 삭제");
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
		txtName.setEditable(false);
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
		
		JRadioButton rdGenderMale = new JRadioButton("  남자");
		btnGroupGender.add(rdGenderMale);
		rdGenderMale.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		rdGenderMale.setBounds(381, 196, 121, 46);
		pn2.add(rdGenderMale);
		
		JRadioButton rdGenderFemale = new JRadioButton("  여자");
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
		
		JButton btnUpdate = new JButton("수정하기");
		btnUpdate.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setBounds(109, 17, 115, 40);
		pn3.add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제하기");
		btnDelete.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setBounds(333, 17, 115, 40);
		pn3.add(btnDelete);
		
		JButton btnClose = new JButton("창 닫기");
		btnClose.setFont(new Font("경기천년제목 Light", Font.BOLD, 14));
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setBackground(new Color(255, 0, 0));
		btnClose.setBounds(557, 17, 115, 40);
		pn3.add(btnClose);
		
		// vo에 담겨서 넣어온 회원의 정보를 검색창에 뿌려주도록 한다.
		txtName.setText(vo.getName());
		txtAge.setText(vo.getAge()+"");
		
		if(vo.getGender().equals("남자")) rdGenderMale.setSelected(true);
		else rdGenderFemale.setSelected(true);
		
		// DB의 날짜 형식을 ComboBox의 날짜형식과 일치시켜서 비교하기 위한 작업
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d"); // 2024-03-25 를 2024-3-25로 변경하기 위한 준비
		LocalDate date = LocalDate.parse(vo.getIpsail().substring(0, 10),dtf);
		String strDate = date.format(dtf);
		String[] ymds = strDate.split("-");
		cbYY.setSelectedItem(ymds[0]);
		cbMM.setSelectedItem(ymds[1]);
		cbDD.setSelectedItem(ymds[2]);

		
		// ----------------------------------- 위쪽은 UI ----------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		// ----------------------------------- 아래쪽은 메소드 ----------------------------------------
		
		// 수정하기 버튼
		// 마우스
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText().trim();
				String age = txtAge.getText().trim();
				String gender = "";
				String ipsail = cbYY.getSelectedItem()+"-"+cbMM.getSelectedItem()+"-"+cbDD.getSelectedItem();
				
				// 유효성 검사
				if(!Pattern.matches("^[0-9]+$", age)) {
					JOptionPane.showMessageDialog(null, "나이는 숫자로만 입력하세요.","나이 오류",JOptionPane.ERROR_MESSAGE);
					txtAge.requestFocus();
				}
				else {
					if(rdGenderMale.isSelected()) gender = "남자";
					else gender = "여자";
				}
				
				//모든 체크가 끝나면 DB에 새로운 회원을 가입처리한다.
				vo.setName(txtName.getText());
				vo.setAge(Integer.parseInt(age));
				vo.setGender(gender);
				vo.setIpsail(ipsail);
					
				res = dao.setInsaUpdate(vo);
					
				if(res != 0) {
					JOptionPane.showMessageDialog(null, "정보가 수정되었습니다! (^-^)/", "수정 성공",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "정보 수정 실패...","수정 실패",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//키보드
		btnUpdate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String name = txtName.getText().trim();
				String age = txtAge.getText().trim();
				String gender = "";
				String ipsail = cbYY.getSelectedItem()+"-"+cbMM.getSelectedItem()+"-"+cbDD.getSelectedItem();
				
				// 유효성 검사
				if(!Pattern.matches("^[0-9]+$", age)) {
					JOptionPane.showMessageDialog(null, "나이는 숫자로만 입력하세요.","나이 오류",JOptionPane.ERROR_MESSAGE);
					txtAge.requestFocus();
				}
				else {
					if(rdGenderMale.isSelected()) gender = "남자";
					else gender = "여자";
				}
				
				//모든 체크가 끝나면 DB에 새로운 회원을 수정처리한다.
				vo.setName(txtName.getText());
				vo.setAge(Integer.parseInt(age));
				vo.setGender(gender);
				vo.setIpsail(ipsail);
					
				res = dao.setInsaUpdate(vo);
					
				if(res != 0) {
					JOptionPane.showMessageDialog(null, "정보가 수정되었습니다! (^-^)/", "수정 성공",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "정보 수정 실패...","수정 실패",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// 삭제버튼
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				
				int ans = JOptionPane.showConfirmDialog(null, name+" 회원을 삭제하시겠습니까?","회원 삭제창",JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					res = dao.setInsaDelete(name);
					if(res != 0) {
						JOptionPane.showMessageDialog(null, name+" 회원 자료가 삭제되었습니다");
						dispose();
						new InsaMain();
					}
					else JOptionPane.showMessageDialog(null, name+" 회원 자료 삭제 실패!");
				}
				else JOptionPane.showMessageDialog(null, name+" 회원 자료 삭제 취소!");
			}
		});
		
		// 창 닫기 버튼
		// 마우스
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InsaMain();
			}
		});
		
		// 키보드
		btnClose.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new InsaMain();
			}
		});
	}
	
//	public static void main(String[] args) {
//		
//	}
}
