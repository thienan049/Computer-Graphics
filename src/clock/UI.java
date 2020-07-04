package clock;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JTextArea;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextArea textAreaLogInfo;
	

	Paint2D paint2D = new Paint2D(textAreaLogInfo);
	JFrame Frame2D;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public UI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 1250, 700);
		setLocation(30, 30);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelController = new JPanel();
		panelController.setBackground(Color.LIGHT_GRAY);
		panelController.setBounds(1000, 0, 245, 970);
		contentPane.add(panelController);
		panelController.setLayout(null);
		
		JButton btnAnimation2D = new JButton("Animation 2D");
		btnAnimation2D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					display2DAnimation(textAreaLogInfo);
				} catch (IllegalArgumentException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnAnimation2D.setBackground(new Color(255, 99, 71));
		btnAnimation2D.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAnimation2D.setBounds(12, 13, 209, 113);
		panelController.add(btnAnimation2D);

		
		textAreaLogInfo = new JTextArea();
		textAreaLogInfo.setText("[ LOG INFO ]");
		textAreaLogInfo.setBounds(12, 139, 209, 818);
		panelController.add(textAreaLogInfo);
	}
	
	
	public void display2DAnimation(JTextArea textAreaLogInfo) {   
		
		Frame2D = new JFrame("Frame Clock Animation");
		Frame2D.getContentPane().add(paint2D.doWork(textAreaLogInfo));
		Frame2D.pack();
		Frame2D.setLocationRelativeTo(null);
		Frame2D.setVisible(true);
		
	}

}
