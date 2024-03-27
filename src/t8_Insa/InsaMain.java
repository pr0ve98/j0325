package t8_Insa;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InsaMain extends JFrame{
	JButton btnInput, btnSearch, btnList, btnExit;
	
	public InsaMain() {
		super("인사관리 메뉴");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(255, 255, 255));
		pn1.setBounds(0, 0, 784, 67);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("인사관리 프로그램(v1.0)");
		lblNewLabel.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 784, 67);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 67, 784, 428);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblMainImges = new JLabel("");
		lblMainImges.setIcon(new ImageIcon(InsaMain.class.getResource("/t8_Insa/images/1.jpg")));
		lblMainImges.setBounds(0, 0, 784, 428);
		pn2.add(lblMainImges);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(new Color(255, 255, 255));
		pn3.setBounds(0, 494, 784, 67);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("사원 등록");
		btnInput.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		btnInput.setBackground(new Color(255, 255, 255));
		btnInput.setBounds(57, 10, 124, 47);
		pn3.add(btnInput);
		
		btnSearch = new JButton("개별 조회");
		btnSearch.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(238, 10, 124, 47);
		pn3.add(btnSearch);
		
		btnList = new JButton("전체 조회");
		btnList.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		btnList.setBackground(Color.WHITE);
		btnList.setBounds(419, 10, 124, 47);
		pn3.add(btnList);
		
		btnExit = new JButton("종료");
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setFont(new Font("경기천년제목 Light", Font.BOLD, 16));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setBounds(600, 10, 124, 47);
		pn3.add(btnExit);
		
		// ----------------------------------- 위쪽은 UI ----------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		// ----------------------------------- 아래쪽은 메소드 ----------------------------------------
		
		// 회원 등록 버튼을 키보드 엔터키로 등록시 수행
		btnInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new InsaInput();
			}
		});

		// 회원 등록 버튼을 마우스로 클릭시 수행
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0); // 사용 X
				dispose(); // 창만 닫는 것
				new InsaInput();
			}
		});
		
		// 개별 조회 버튼
		// 마우스
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("검색할 성명을 입력하세용. ('-')/");
				InsaDAO dao = new InsaDAO();
				InsaVO vo = dao.getNameSearch(name);
				
				if(vo.getName() == null) JOptionPane.showMessageDialog(null, "찾으신 회원이 없습니다... \\(ㅇ-ㅇ)>","성명 오류",JOptionPane.ERROR_MESSAGE);
				else {
					dispose();
					new InsaSearch(vo);
				}
			}
		});
		
		// 키보드
		btnSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String name = JOptionPane.showInputDialog("검색할 성명을 입력하세용. ('-')/");
				InsaDAO dao = new InsaDAO();
				InsaVO vo = dao.getNameSearch(name);
				
				if(vo.getName() == null) JOptionPane.showMessageDialog(null, "찾으신 회원이 없습니다... \\(ㅇ-ㅇ)>","성명 오류",JOptionPane.ERROR_MESSAGE);
				else {
					dispose();
					new InsaSearch(vo);
				}
			}
		});
		
		// 전체 조회 버튼
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InsaList();
			}
		});
		
		// 종료 버튼
		// 마우스
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// 키보드
		btnExit.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	public static void main(String[] args) {
		new InsaMain();
	}
}
