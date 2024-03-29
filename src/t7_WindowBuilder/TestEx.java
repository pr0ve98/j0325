package t7_WindowBuilder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TestEx extends JFrame {
	int day = 1, love = 0, dirty = 100;
	JLabel lblLove, lblDirty, lblDate;
	
	public TestEx() {
		super("춘배 키우기");
		getContentPane().setLayout(null);
		setSize(710, 586);
		setLocationRelativeTo(null);
		setResizable(false);
		
		// 제목 패널
		JPanel pn1 = new JPanel();
		pn1.setBounds(37, 31, 590, 91);
		getContentPane().add(pn1);
		
		JLabel lblTitle = new JLabel("춘배 키우기");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("나눔손글씨 곰신체", Font.BOLD, 66));
		pn1.add(lblTitle);
		
		// 춘배와 춘배 스탯 패널
		JPanel pn2 = new JPanel();
		pn2.setBounds(37, 148, 590, 214);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lblLove = new JLabel("춘배 호감도  "+love);
		lblLove.setFont(new Font("나눔손글씨 곰신체", Font.BOLD, 23));
		lblLove.setBounds(424, 44, 154, 28);
		pn2.add(lblLove);
		
		lblDirty = new JLabel("춘배 청결도  "+dirty);
		lblDirty.setFont(new Font("나눔손글씨 곰신체", Font.BOLD, 23));
		lblDirty.setBounds(424, 82, 154, 28);
		pn2.add(lblDirty);
		
		lblDate = new JLabel("날짜  "+day+"일째");
		lblDate.setForeground(new Color(0, 0, 0));
		lblDate.setBackground(new Color(255, 255, 255));
		lblDate.setFont(new Font("나눔손글씨 곰신체", Font.BOLD, 23));
		lblDate.setBounds(424, 10, 154, 28);
		pn2.add(lblDate);
		
		JLabel lblImg = new JLabel(" ", JLabel.CENTER);
		ImageIcon icon = new ImageIcon("imgs/chunbae.png");
		lblImg.setIcon(icon);
		lblImg.setBounds(41, 10, 348, 183);
		pn2.add(lblImg);
		
		// 버튼 패널
		JPanel pn3 = new JPanel();
		pn3.setBounds(37, 384, 590, 91);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnEat = new JButton("춘배 밥 주기");
		btnEat.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 16));
		btnEat.setBounds(46, 16, 135, 53);
		pn3.add(btnEat);
		
		JButton btnPlay = new JButton("춘배랑 놀기");
		btnPlay.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 16));
		btnPlay.setBounds(227, 16, 135, 53);
		pn3.add(btnPlay);
		
		JButton btnWash = new JButton("춘배 씻기기");
		btnWash.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 16));
		btnWash.setBounds(408, 16, 135, 53);
		pn3.add(btnWash);
		
		setVisible(true);
		
		// 게임 방법 안내 메시지
		JOptionPane.showMessageDialog(null, "춘배의 호감도를 30일 안에 100으로 만들면 엔딩!\n청결도가 50아래로 떨어지면 게임 오버~","게임 방법",JOptionPane.INFORMATION_MESSAGE);
		
		// 윈도우 종료
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// 밥 주기
		btnEat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				day++;
				love += 5;
				dirty -= 5;
				JOptionPane.showMessageDialog(null, "춘배의 호감도가 올라갔어요! (=^-ω-^=)", "밥 주기", JOptionPane.INFORMATION_MESSAGE);
				setNum();
				gameOver();
				ending();
			}
		});
		
		// 놀아주기
		btnPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				day++;
				love += 10;
				dirty -= 8;
				JOptionPane.showMessageDialog(null, "춘배의 호감도가 올라갔어요! /ᐠ •ヮ• マ Ⳋ", "놀아 주기", JOptionPane.INFORMATION_MESSAGE);
				setNum();
				gameOver();
				ending();
			}
		});
		
		// 씻겨주기
		btnWash.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				day++;
				love -= 10;
				dirty += 15;
				JOptionPane.showMessageDialog(null, "춘배의 청결도가 올라가고 호감도가 떨어졌어요!\n ( =①ω①=)", "씻겨 주기", JOptionPane.INFORMATION_MESSAGE);
				setNum();
				gameOver();
				ending();
			}
		});
	}
	
	// 호감도, 청결도, 날짜 재설정
	void setNum() {
		lblDirty.setText("춘배 청결도  "+dirty);
		lblDate.setText("날짜  "+day+"일째");
		lblLove.setText("춘배 호감도  "+love);
	}
	
	// 게임 엔딩
	void ending() {
		if(love >= 100) {
			JOptionPane.showMessageDialog(null, "당신이 너무 마음에 든 춘배가\n당신과 결혼하겠다고 합니다!\n행복하세요! o(=´∇｀=)o","결혼 엔딩", JOptionPane.DEFAULT_OPTION);
			System.exit(0);
		}
		
	}
	
	// 게임 실패
	void gameOver() {
		if(day > 30 && love < 100) {
			JOptionPane.showMessageDialog(null, "30일 동안 춘배의 마음을 사로잡지 못했어요...(=🝦 ༝ 🝦=)","게임 오버", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		else if(dirty < 50 && love < 100) {
			JOptionPane.showMessageDialog(null, "춘배가 너무 더러워 동물보호단체에서\n춘배를 데려갔어요!✧/ᐠ-ꞈ-ᐟ\\","게임 오버", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
	
	// 메인 메소드
	public static void main(String[] args) {
		new TestEx();
	}
}
