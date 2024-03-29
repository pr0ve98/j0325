package t7_WindowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class T3_Image extends JFrame{
	private JButton btn1, btn2, btn3, btn4, btnExit, btnClose, btnTotal, btnRandom;
	private JLabel lblImg1, lblImg2, lblImg3, lblImg4, lblCount; 
	int img1Cnt = 0, img2Cnt = 0, img3Cnt = 0, img4Cnt = 0;
	
	public T3_Image() {
		super("카드 횟수 맞히기");
		setSize(800, 480);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 43);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		btnTotal = new JButton("모두보기");
		btnTotal.setFont(new Font("굴림", Font.BOLD, 14));
		btnTotal.setBounds(0, 0, 100, 43);
		pn1.add(btnTotal);
		
		btn1 = new JButton("1번보기");
		btn1.setFont(new Font("굴림", Font.BOLD, 14));
		btn1.setBounds(100, 0, 100, 43);
		pn1.add(btn1);
		
		btn2 = new JButton("2번보기");
		btn2.setFont(new Font("굴림", Font.BOLD, 14));
		btn2.setBounds(200, 0, 100, 43);
		pn1.add(btn2);
		
		btn3 = new JButton("3번보기");
		btn3.setFont(new Font("굴림", Font.BOLD, 14));
		btn3.setBounds(300, 0, 100, 43);
		pn1.add(btn3);
		
		btn4 = new JButton("4번보기");
		btn4.setFont(new Font("굴림", Font.BOLD, 14));
		btn4.setBounds(400, 0, 100, 43);
		pn1.add(btn4);
		
		btnRandom = new JButton("랜덤보기");
		btnRandom.setFont(new Font("굴림", Font.BOLD, 14));
		btnRandom.setBounds(500, 0, 100, 43);
		pn1.add(btnRandom);
		
		btnClose = new JButton("모두닫기");
		btnClose.setFont(new Font("굴림", Font.BOLD, 14));
		btnClose.setBounds(600, 0, 100, 43);
		pn1.add(btnClose);
		
		btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 14));
		btnExit.setBounds(700, 0, 82, 43);
		pn1.add(btnExit);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 43, 784, 355);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lblImg1 = new JLabel("");
		lblImg1.setIcon(new ImageIcon(T3_Image.class.getResource("/t7_WindowBulider/imgs/11.jpg")));
		lblImg1.setBounds(12, 10, 181, 335);
		pn2.add(lblImg1);
		lblImg1.setVisible(false);
		
		lblImg2 = new JLabel("");
		lblImg2.setIcon(new ImageIcon(T3_Image.class.getResource("/t7_WindowBulider/imgs/13.jpg")));
		lblImg2.setBounds(205, 10, 181, 335);
		pn2.add(lblImg2);
		lblImg2.setVisible(false);
		
		lblImg3 = new JLabel("");
		lblImg3.setIcon(new ImageIcon(T3_Image.class.getResource("/t7_WindowBulider/imgs/14.jpg")));
		lblImg3.setBounds(398, 10, 181, 335);
		pn2.add(lblImg3);
		lblImg3.setVisible(false);
		
		lblImg4 = new JLabel("");
		lblImg4.setIcon(new ImageIcon(T3_Image.class.getResource("/t7_WindowBulider/imgs/12.jpg")));
		lblImg4.setBounds(591, 10, 181, 335);
		pn2.add(lblImg4);
		lblImg4.setVisible(false);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 398, 784, 43);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		lblCount = new JLabel("1번: 0, 2번: 0, 3번: 0, 4번: 0");
		lblCount.setForeground(new Color(255, 0, 0));
		lblCount.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 16));
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCount.setBounds(12, 10, 760, 23);
		pn3.add(lblCount);
		
		// ----------------------------------- 위쪽은 UI ----------------------------------------
		setLocationRelativeTo(null); // 윈도우창 가운데 정렬
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우 종료
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		// ----------------------------------- 아래쪽은 메소드 ----------------------------------------
		
		// 모두보기 버튼
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allDisplay();
				img1Cnt++; img2Cnt++; img3Cnt++; img4Cnt++;
				dispCount();
			}
		});
		
		// 1번보기 버튼
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblImg1.setVisible(true);
				lblImg2.setVisible(false);
				lblImg3.setVisible(false);
				lblImg4.setVisible(false);
				img1Cnt++;
				dispCount();
			}
		});
		
		// 2번보기 버튼
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblImg1.setVisible(false);
				lblImg2.setVisible(true);
				lblImg3.setVisible(false);
				lblImg4.setVisible(false);
				img2Cnt++;
				dispCount();
			}
		});
		
		// 3번보기 버튼
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblImg1.setVisible(false);
				lblImg2.setVisible(false);
				lblImg3.setVisible(true);
				lblImg4.setVisible(false);
				img3Cnt++;
				dispCount();
			}
		});
		
		// 4번보기 버튼
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblImg1.setVisible(false);
				lblImg2.setVisible(false);
				lblImg3.setVisible(false);
				lblImg4.setVisible(true);
				img4Cnt++;
				dispCount();
			}
		});
		
		// 랜덤보기 버튼
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = (int)((Math.random()*4)+1);
				switch(num) {
					case 1: 
						lblImg1.setVisible(true);
						lblImg2.setVisible(false);
						lblImg3.setVisible(false);
						lblImg4.setVisible(false);
						img1Cnt++;
						dispCount();
						break;
					case 2:
						lblImg1.setVisible(false);
						lblImg2.setVisible(true);
						lblImg3.setVisible(false);
						lblImg4.setVisible(false);
						img2Cnt++;
						dispCount();
						break;
					case 3:
						lblImg1.setVisible(false);
						lblImg2.setVisible(false);
						lblImg3.setVisible(true);
						lblImg4.setVisible(false);
						img3Cnt++;
						dispCount();
						break;
					case 4:
						lblImg1.setVisible(false);
						lblImg2.setVisible(false);
						lblImg3.setVisible(false);
						lblImg4.setVisible(true);
						img4Cnt++;
						dispCount();
						break;
				}
			}
		});
		
		// 모두닫기 버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allClose();
				dispCount();
			}
		});
		
		// 종료 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	// 카운트 레이블에 표시하기
	protected void dispCount() {
		lblCount.setText("1번: "+img1Cnt+", 2번: "+img2Cnt+", 3번: "+img3Cnt+", 4번: "+img4Cnt);
	}

	// 모두 닫기
	protected void allClose() {
		lblImg1.setVisible(false);
		lblImg2.setVisible(false);
		lblImg3.setVisible(false);
		lblImg4.setVisible(false);
	}

	// 모두 보기
	protected void allDisplay() {
		lblImg1.setVisible(true);
		lblImg2.setVisible(true);
		lblImg3.setVisible(true);
		lblImg4.setVisible(true);
	}

	public static void main(String[] args) {
		new T3_Image();
	}
}
