package t7_WindowBulider;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class T5_ComboBox_ListBox extends JFrame {
	JButton btnCombo, btnExit, btnList1, btnList2;
	@SuppressWarnings("rawtypes")
	JComboBox comboJob;
	JLabel lblMessage;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T5_ComboBox_ListBox() {
		super("콤보상자 연습");
		setSize(600, 500);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 292, 295);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("직업을 선택하세요");
		lblNewLabel.setFont(new Font("경기천년제목 Bold", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 268, 43);
		pn1.add(lblNewLabel);
		
		comboJob = new JComboBox();
		comboJob.setBackground(new Color(255, 255, 255));
		comboJob.setModel(new DefaultComboBoxModel(new String[] {"학   생", "회사원", "군   인", "변호사", "의   사", "공무원", "기   타"}));
		comboJob.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		comboJob.setBounds(12, 63, 268, 28);
		pn1.add(comboJob);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 132, 268, 141);
		pn1.add(scrollPane_1);
		
		JTextArea txtaMemo = new JTextArea();
		txtaMemo.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		scrollPane_1.setViewportView(txtaMemo);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(292, 0, 292, 295);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JList listJob = new JList();
		listJob.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		listJob.setModel(new AbstractListModel() {
			String[] values = new String[] {"학   생", "의   사", "변호사", "회계사", "판   사", "군   인", "공무원", "간호사", "역무원", "기   타"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listJob.setBounds(12, 27, 268, 119);
		pn2.add(listJob);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 156, 268, 129);
		pn2.add(scrollPane);
		
		JList listJob2 = new JList();
		listJob2.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		listJob2.setModel(new AbstractListModel() {
			String[] values = new String[] {"학   생", "의   사", "변호사", "회계사", "판   사", "군   인", "공무원", "간호사", "역무원", "기   타"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listJob2);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 294, 584, 83);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnCombo = new JButton("콤보 출력");
		btnCombo.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		btnCombo.setBounds(21, 10, 119, 52);
		pn3.add(btnCombo);
		
		btnExit = new JButton("종료");
		btnExit.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		btnExit.setBounds(441, 10, 119, 52);
		pn3.add(btnExit);
		
		btnList1 = new JButton("리스트 출력 1");
		btnList1.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		btnList1.setBounds(161, 10, 119, 52);
		pn3.add(btnList1);
		
		btnList2 = new JButton("리스트 출력 2");
		btnList2.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		btnList2.setBounds(301, 10, 119, 52);
		pn3.add(btnList2);
		
		JPanel pn4 = new JPanel();
		pn4.setBounds(0, 378, 584, 83);
		getContentPane().add(pn4);
		pn4.setLayout(null);
		
		lblMessage = new JLabel("출력 메시지");
		lblMessage.setFont(new Font("경기천년제목 Light", Font.PLAIN, 16));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(12, 20, 560, 40);
		pn4.add(lblMessage);
		
		// ----------------------------------- 위쪽은 UI ----------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		// ----------------------------------- 아래쪽은 메소드 ----------------------------------------
		
		// 콤보상자의 내용 출력하는 버튼
		btnCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = comboJob.getSelectedItem().toString()+"("+comboJob.getSelectedIndex()+")";
				lblMessage.setText(msg);
			}
		});
		
		//리스트 출력 1
		btnList1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "";
//				Object[] jobs = listJob.getSelectedValues();
				Object[] jobs = listJob.getSelectedValuesList().toArray();
				for(Object job:jobs) {
					msg += job+" / ";
				}
				msg = msg.substring(0, msg.length()-2);
				lblMessage.setText(msg);
			}
		});
		
		// 리스트 출력 2(리스트 상자2의 내용을 선택하면 왼쪽 메모창에 내용을 출력시켜준다.)
//		btnList2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String msg = "";
//				Object[] jobs = listJob2.getSelectedValuesList().toArray();
//				for(Object job:jobs) msg += job+"\n";
//				msg = msg.substring(0, msg.length()-2);
//				txtaMemo.setText(msg);
//			}
//		});
		btnList2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtaMemo.append(listJob2.getSelectedValue()+"\n");
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
		new T5_ComboBox_ListBox();
	}
}
