package t7_WindowBulider;

import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class T8_File extends JFrame {
	private JFileChooser chooser;
	private JButton btnUpload, btnDelete, btnExit;
	private JLabel lblImage;
	private JTable table;
	private Vector title, vData;
	private DefaultTableModel dtm;
	private JScrollPane scrollPane;
	
	public T8_File() {
		super("파일처리 연습");
		setSize(600, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 584, 66);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		btnUpload = new JButton("그림 업로드");
		btnUpload.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		btnUpload.setBounds(12, 10, 131, 46);
		pn1.add(btnUpload);
		
		btnDelete = new JButton("그림 삭제");
		btnDelete.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		btnDelete.setBounds(155, 10, 131, 46);
		pn1.add(btnDelete);
		
		btnExit = new JButton("종료");
		btnExit.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		btnExit.setBounds(441, 10, 131, 46);
		pn1.add(btnExit);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 65, 584, 312);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lblImage = new JLabel("사진이 출력됩니다.");
		lblImage.setFont(new Font("경기천년제목 Light", Font.PLAIN, 18));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(312, 10, 260, 292);
		pn2.add(lblImage);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(23, 10, 260, 292);
//		pn2.add(scrollPane);
//		
//		table = new JTable();
//		scrollPane.setViewportView(table);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 375, 584, 66);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		// JTable 설계
		title = new Vector<>();
		title.add("경로/파일명");
		
		// 폴더 안에 정보를 가져오기
//		getFolderInfor();
		
		dtm = new DefaultTableModel(vData, title);
		table = new JTable(dtm);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(23, 10, 260, 292);
		pn2.add(scrollPane);
		
		// --------------------------------------------------------------
		setVisible(true);
		// --------------------------------------------------------------
		
		// 그림 업로드 처리
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 파일 다이얼로그 생성
				chooser = new JFileChooser();
				
				// 파일 확장자로 선별 출력 처리
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"JPG & GIF Images", "jpg","gif");
				chooser.setFileFilter(filter);
				
				// 파일 다이얼로그 박스 출력처리
				int res = chooser.showOpenDialog(null);
				
				if(res != chooser.APPROVE_OPTION) { // 사용자가 파일을 선택하지 않고 창을 닫거나 취소한 경우
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다","경고",JOptionPane.WARNING_MESSAGE);
				}
				else {
					// 사용자가 파일을 선택하고 '열기' 버튼을 누른 경우 또는 선택한 파일명을 더블클릭한 경우
					String filePath = chooser.getSelectedFile().getPath(); // 파일 경로명을 알아온다.
					lblImage.setIcon(new ImageIcon(filePath));
					
					// 파일 업로드하기
					try {
						File imageFile = new File(filePath); // 업로드 되는 파일의 위치정보+파일명
						String fileName = filePath.substring(filePath.lastIndexOf("\\")+1); //파일명과 확장자를 가져옴
						String extension = filePath.substring(filePath.lastIndexOf(".")+1); //확장자를 가져옴
						
						BufferedImage image = ImageIO.read(imageFile);
						File file = new File("myImages/"+fileName); // 서버에 저장되는 폴더+파일명
						if(!file.exists()) file.mkdir(); // 폴더가 존재하지 않으면 폴더를 생성
						
						ImageIO.write(image, extension, file); // images를 file로 업로드시켜준다.
						System.out.println("파일명: "+fileName);
						JOptionPane.showMessageDialog(null, "이미지 업로드 완료!");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		
		// 종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	// 폴더 안의 파일 목록을 가져오는 메소드
	private void getFolderInfor() {
		File folder = new File("myImages");
		File files[] = folder.listFiles();
//		for(File f:files) {
//			System.out.println(f.getName());
//		}
		vData = new Vector<>();
		if(files.length != 0) {
			for(int i=0; i<files.length; i++) {
				System.out.println("파일("+i+1+"): "+files[i]);
				Vector vo = new Vector<>();
				vo.add(files[i]);
				vData.add(vo);
			}
			dtm.setDataVector(vData, title);
		}
	}

	public static void main(String[] args) {
		new T8_File();
	}
}
