package t7_WindowBuilder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import t8_Insa.InsaDAO;

@SuppressWarnings({"serial","rawtypes","unchecked"})
public class T6_JTable extends JFrame {
	private JTable table;
	private Vector title, vData;
	private DefaultTableModel dtm;
	private JScrollPane scrollPane;
	
	InsaDAO dao = new InsaDAO();
	
	public T6_JTable() {
		super("JTable 연습");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 484, 42);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JButton btnPrint = new JButton("선택셀값출력");
		btnPrint.setBackground(new Color(255, 255, 255));
		btnPrint.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		btnPrint.setBounds(12, 11, 119, 23);
		pn1.add(btnPrint);
		
		JButton btnExit = new JButton("종료");
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setFont(new Font("경기천년제목 Light", Font.BOLD, 14));
		btnExit.setBounds(392, 10, 80, 23);
		pn1.add(btnExit);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 42, 484, 179);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		
//		table = new JTable();
//		scrollPane.setViewportView(table);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 219, 484, 42);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JLabel lblMessage = new JLabel("JTable에서 선택된 값을 출력합니다.");
		lblMessage.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(0, 0, 484, 42);
		pn3.add(lblMessage);
		
		// 아래로 JTable 설계하기
		// JTable 제작시는 '부제목' 과 '데이터'를 설계하여 Vector 타입으로 준비한다.
		
		// 1. '부제목'을 Vector에 저장
		title = new Vector<>();
		title.add("번호");
		title.add("성명");
		title.add("나이");
		title.add("성별");
		title.add("입사일");
		
		// 2. '데이터'를 Vector 타입으로 준비! 데이터는 DB에서 가져온다.
		vData = dao.getInsaList("","");

		// 3. DB에서 가져온 자료(vData)와 타이틀(title)을 DefaultTableModel 객체를 생성하면서 담아준다.
		dtm = new DefaultTableModel(vData, title);
		
		// 4. DefaultTableModel에 담긴 벡터타입의 '데이터'와'타이틀'을 JTable 객체 생성시에 담아준다.
		table = new JTable(dtm);
		
		// 5. 자료가 담긴 JTable을 JScrollPane 객체 생성시에 함께 담아서 생성해준다.
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 460, 169);
		pn2.add(scrollPane);
		
		// 6. 출력결과를 확인한다.
		
		
		//------------------------
		setVisible(true);
		//------------------------
		
		// 종료버튼 마우스
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new T6_JTable();
	}
}
