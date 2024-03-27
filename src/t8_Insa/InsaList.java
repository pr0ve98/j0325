package t8_Insa;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

@SuppressWarnings({"serial","rawtypes","unchecked"})
public class InsaList extends JFrame {
	private JTextField txtCondition;
	private final ButtonGroup btnGroupGender = new ButtonGroup();
	private JTable table;
	private Vector title, vData;
	private DefaultTableModel dtm;
	private JComboBox cbCondition;
	private JButton btnCondition, btnList, btnExit, btnIpsailAsc, btnIpsailDesc;
	private JRadioButton rdFemale, rdMale;
	
	private InsaDAO dao = new InsaDAO();
	private JScrollPane scrollPane;

	public InsaList() {
		super("전체 조회");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 67);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		cbCondition = new JComboBox();
		cbCondition.setBackground(new Color(255, 255, 255));
		cbCondition.setModel(new DefaultComboBoxModel(new String[] {"성명", "나이", "성별", "입사일"}));
		cbCondition.setBounds(12, 16, 138, 36);
		pn1.add(cbCondition);
		
		txtCondition = new JTextField();
		txtCondition.setBounds(162, 17, 138, 36);
		pn1.add(txtCondition);
		txtCondition.setColumns(10);
		
		btnCondition = new JButton("조건 검색");
		btnCondition.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		btnCondition.setBounds(312, 10, 97, 47);
		pn1.add(btnCondition);
		
		btnList = new JButton("전체 검색");
		btnList.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		btnList.setBounds(566, 10, 97, 47);
		pn1.add(btnList);
		
		btnExit = new JButton("종료");
		btnExit.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		btnExit.setBounds(675, 10, 97, 47);
		pn1.add(btnExit);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 65, 784, 418);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		//JScrollPane scrollPane = new JScrollPane();
		//pn2.add(scrollPane);
		
		//table = new JTable();
		//scrollPane.setViewportView(table);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 483, 784, 78);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		rdFemale = new JRadioButton("여자");
		btnGroupGender.add(rdFemale);
		rdFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rdFemale.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		rdFemale.setBounds(8, 26, 121, 34);
		pn3.add(rdFemale);
		
		rdMale = new JRadioButton("남자");
		btnGroupGender.add(rdMale);
		rdMale.setHorizontalAlignment(SwingConstants.CENTER);
		rdMale.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		rdMale.setBounds(143, 26, 121, 34);
		pn3.add(rdMale);
		
		btnIpsailAsc = new JButton("입사일 오름차순");
		btnIpsailAsc.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		btnIpsailAsc.setBounds(502, 20, 127, 46);
		pn3.add(btnIpsailAsc);
		
		btnIpsailDesc = new JButton("입사일 내림차순");
		btnIpsailDesc.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		btnIpsailDesc.setBounds(645, 20, 127, 46);
		pn3.add(btnIpsailDesc);
		
		// JTable 설계
		title = new Vector<>();
		title.add("번호");
		title.add("성명");
		title.add("나이");
		title.add("성별");
		title.add("입사일");
		
		vData = dao.getInsaList("","");
		dtm = new DefaultTableModel(vData, title);
		
		table = new JTable(dtm);
		table.setRowSorter(new TableRowSorter<>(dtm));
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 760, 398);
		pn2.add(scrollPane);
		
		// -----------------------------------------------
		
		// 조건검색처리 클릭
		btnCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conditionSearch();
			}
		});
		
		// 조건검색처리 키보드
		btnCondition.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				conditionSearch();
			}
		});
		
		// 전체검색 마우스
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalSearch();
			}
		});
		
		// 전체검색 키보드
		btnList.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				totalSearch();
			}
		});
		
		// 입사일 오름차순
		btnIpsailAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getInsaList("ipsail", "a");
				dtm.setDataVector(vData, title);
			}
		});
		
		// 입사일 내림차순
		btnIpsailDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getInsaList("ipsail", "d");
				dtm.setDataVector(vData, title);
			}
		});
		
		// 종료버튼 클릭
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InsaMain();
			}
		});
		
		
		// -----------------------------------------------
		setVisible(true);
		// -----------------------------------------------
	}
	
	// 전체 검색시 처리할 메소드
	protected void totalSearch() {
		vData = dao.getInsaList("", "");
		dtm.setDataVector(vData, title);
	}

	// 조건 검색시 처리할 메소드
	void conditionSearch() {
		String cbCondi = cbCondition.getSelectedItem().toString();
		String txtCondi = txtCondition.getText();
		
		if(txtCondi.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요.","검색 오류",JOptionPane.ERROR_MESSAGE);
			txtCondition.requestFocus();
			return;
		}
		
		if(cbCondi.equals("성명")) vData = dao.getConditionSearch("name", txtCondi);
		else if(cbCondi.equals("나이")) {
			if(!Pattern.matches("^[0-9]+$", txtCondi)) {
				JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요.");
				txtCondition.requestFocus();
			}
			else vData = dao.getConditionSearch("age", txtCondi);
		}
		else if(cbCondi.equals("성별")) vData = dao.getConditionSearch("gender", txtCondi);
		else if(cbCondi.equals("입사일")) vData = dao.getConditionSearch("ipsail", txtCondi);
		dtm.setDataVector(vData, title);
	}
	
//	public static void main(String[] args) {
//		new InsaList();
//	}
}
