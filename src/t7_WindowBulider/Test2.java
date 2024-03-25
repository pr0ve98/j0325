package t7_WindowBulider;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Test2 extends JFrame {
	private JTextField textField;
	private JTextField textField_1;

	public Test2() {
		super("회원가입");
		setSize(600, 400);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 548, 82);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("주 간 신 문");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(118, 10, 304, 49);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(22, 102, 259, 227);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("큰 제목");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 10, 235, 52);
		pn2.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(22, 72, 223, 78);
		pn2.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(68, 159, 120, 45);
		pn2.add(btnNewButton);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(303, 102, 259, 227);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("큰 제목");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(12, 10, 235, 52);
		pn3.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(22, 71, 223, 78);
		pn3.add(textField_1);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(71, 159, 120, 45);
		pn3.add(btnNewButton_1);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test2();
	}
}
