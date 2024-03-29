package t7_WindowBuilder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import t8_Insa.InsaDAO;
import t8_Insa.InsaVO;

@SuppressWarnings({"serial","rawtypes","unchecked"})
public class T7_JTable extends JFrame {
	private JTable table;
	private Vector title, vData;
	private DefaultTableModel dtm;
	private JScrollPane scrollPane;
	
	InsaDAO dao = new InsaDAO();
	
	public T7_JTable() {
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
		
		// 테이블의 내용을 행(타이틀)이름으로 정렬(오름차순/내림차순)하고자 한다면?
		table.setRowSorter(new TableRowSorter<>(dtm));
		
		// 5. 자료가 담긴 JTable을 JScrollPane 객체 생성시에 함께 담아서 생성해준다.
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 460, 169);
		pn2.add(scrollPane);
		
		// 6. 출력결과를 확인한다.
		
		// JTable 속성 제어하기
		// table의 컬럼 크기 / 크기고정 설정
		table.getColumnModel().getColumn(0).setMaxWidth(50); // 컬럼의 최대크기 지정
		table.getColumnModel().getColumn(2).setMaxWidth(50);
		table.getColumnModel().getColumn(0).setResizable(false); // 컬럼 크기 조정불가
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getTableHeader().setReorderingAllowed(false); // 컬럼 위치 고정
		
		// 테이블 셀 안의 내용 수평정렬하기
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
//		tcm.getColumn(3).setCellRenderer(dtcr);
		
		
		// 전체 셀 고정
		for(int i=0; i<tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
		//------------------------
		setVisible(true);
		//------------------------
		
		// 종료버튼 마우스
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// 종료버튼 키보드
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.exit(0);
			}
		});
		
		// 테이블에서 선택된 셀의 레코드(행)의 정보를 출력하기
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
//				if(row < 0) {
//					JOptionPane.showMessageDialog(null, "행을 선택 후 버튼을 눌러주세요.");
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "선택된 인덱스 행 번호"+row+", 열 번호: "+column);
//				}
				if(row != -1) {
//					System.out.println("선택된 내용:"+table.getValueAt(row, column));
//					lblMessage.setText("선택된 내용: "+table.getValueAt(row, column));
					// 선택된 행의 모든 정보를 메시지창에 띄우시오.
					InsaVO vo = dao.getNameSearch(table.getValueAt(row, 1)+"");
					String temp = "성명: "+vo.getName()+", 나이: "+vo.getAge()+", 성별: "+vo.getGender()+", 입사일: "+vo.getIpsail().substring(0, 10);
					lblMessage.setText(temp);
				}
			}	
		});
	}
	
	public static void main(String[] args) {
		new T7_JTable();
	}
}
