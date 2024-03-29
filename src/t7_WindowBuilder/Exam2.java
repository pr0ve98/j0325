package t7_WindowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Exam2 extends JFrame {
	JButton[] strBtn = new JButton[100];
	
	ExamDAO dao = new ExamDAO();
	ArrayList<ImageInforVO> vos = dao.getImageInforList();
	int btnCount = vos.size();
	
	
	public Exam2() {
		super("다중버튼...");
		setSize(1080, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 584, 54);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 55, 584, 386);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
//		int x=248, y=445, cnt=0;
		int x=20, y=40, cnt=0;
		System.out.println("vos : " + vos);
		for(int i=0; i<btnCount; i++) {
			strBtn[i] = new JButton("버튼"+(i+1));
			strBtn[i].setBounds(x, y, 100, 40);
			strBtn[i].setIcon(new ImageIcon("images/" + vos.get(i).getImg()));
			pn2.add(strBtn[i]);
//			y += 50;
			x += 110;
			cnt++;
			
			if(cnt % 3 == 0){
				x = 20;
				y += 50;
			}
		}
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Exam2();
	}
}
