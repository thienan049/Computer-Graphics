package _3dsection;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NhapToaDo3D extends JFrame{
    private JPanel contentPane;
    private JTextField txtX,txtY,txtZ;
    private JButton btnDraw;
	public NhapToaDo3D(String hinh) {	
		this.setBounds(600, 200, 300, 180);
		this.setVisible(true);
                this.setResizable(false);		
		this.setFocusable(true);
                this.setAlwaysOnTop(true);
   
                contentPane = new JPanel();
                this.setContentPane(contentPane);
                btnDraw = new JButton("Vẽ hình!");
                
                if("Cube".equals(hinh)){
                    this.setTitle("Hình hộp chữ nhật");
                    this.setIconImage(new ImageIcon("Image/cube2.png").getImage());
                }
                else if("Pyramid".equals(hinh)){
                    this.setTitle("Hình chóp");
                    this.setIconImage(new ImageIcon("Image/pyramid.png").getImage());
                }
                    JLabel lblX = new JLabel("Chiều dài  X   : ");
                    txtX = new JTextField();
                    txtX.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if (!Character.isDigit(e.getKeyChar()) || txtX.getText().length() >= 3)
                            e.consume();      
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {
                            if (e.getKeyCode()==KeyEvent.VK_ENTER){
                                if(txtX.getText().length() == 0){
                                    txtX.requestFocus();
                                }
                                else if(txtY.getText().length() == 0){
                                    txtY.requestFocus();
                                }
                                else if(txtZ.getText().length() == 0){
                                    txtZ.requestFocus();
                                }
                                else{
                                    GUI.X = Integer.parseInt(txtX.getText());
                                    GUI.Y = Integer.parseInt(txtY.getText());
                                    GUI.Z = Integer.parseInt(txtZ.getText());
                                    GUI.selectButton = hinh;                                 
                                    dispose();                                 
                                }                
                            }                     
                        }
                    });   
                
                    JLabel lblY = new JLabel("Chiều rộng Y : ");
                    txtY = new JTextField();
                    txtY.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyTyped(KeyEvent e) {
                            if (!Character.isDigit(e.getKeyChar()) || txtY.getText().length() >= 3)
                            e.consume();
                        }
                        @Override
                         public void keyPressed(KeyEvent e) {
                            if (e.getKeyCode()==KeyEvent.VK_ENTER){
                                if(txtX.getText().length() == 0){
                                    txtX.requestFocus();
                                }
                                else if(txtY.getText().length() == 0){
                                    txtY.requestFocus();
                                }
                                else if(txtZ.getText().length() == 0){
                                    txtZ.requestFocus();
                                }
                                else{
                                    GUI.X = Integer.parseInt(txtX.getText());
                                    GUI.Y = Integer.parseInt(txtY.getText());
                                    GUI.Z = Integer.parseInt(txtZ.getText());
                                    GUI.selectButton = hinh;                                 
                                    dispose();                                 
                                }                
                            }                     
                        }
                    });
                
                    JLabel lblZ = new JLabel("Chiều cao  Z  : ");
                    txtZ = new JTextField();
                    txtZ.addKeyListener(new KeyAdapter() {
                    @Override
                        public void keyTyped(KeyEvent e) {
                            if (!Character.isDigit(e.getKeyChar()) || txtZ.getText().length() >= 3)
                            e.consume();
                        }
                    @Override
                        public void keyPressed(KeyEvent e) {
                            if (e.getKeyCode()==KeyEvent.VK_ENTER){
                                if(txtX.getText().length() == 0){
                                    txtX.requestFocus();
                                }
                                else if(txtY.getText().length() == 0){
                                    txtY.requestFocus();
                                }
                                else if(txtZ.getText().length() == 0){
                                    txtZ.requestFocus();
                                }
                                else{
                                    GUI.X = Integer.parseInt(txtX.getText());
                                    GUI.Y = Integer.parseInt(txtY.getText());
                                    GUI.Z = Integer.parseInt(txtZ.getText());
                                    GUI.selectButton = hinh;                                 
                                    dispose();                                 
                                }                
                            }                     
                        }                   
                    });
           
                contentPane.add(lblX).setPreferredSize(new Dimension(100, 30));
                contentPane.add(txtX).setPreferredSize(new Dimension(120, 30));              
                contentPane.add(lblY).setPreferredSize(new Dimension(100, 30));
                contentPane.add(txtY).setPreferredSize(new Dimension(120, 30));
                contentPane.add(lblZ).setPreferredSize(new Dimension(100, 30));
                contentPane.add(txtZ).setPreferredSize(new Dimension(120, 30));
          
                contentPane.add(btnDraw).setPreferredSize(new Dimension(100, 30));                         
                txtX.requestFocus();
                btnDraw.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
				if(txtX.getText().length() == 0){
                                    txtX.requestFocus();
                                }
                                else if(txtY.getText().length() == 0){
                                    txtY.requestFocus();
                                }
                                else if(txtZ.getText().length() == 0){
                                    txtZ.requestFocus();
                                }
                                else{
                                    GUI.X = Integer.parseInt(txtX.getText());
                                    GUI.Y = Integer.parseInt(txtY.getText());
                                    GUI.Z = Integer.parseInt(txtZ.getText());
                                    GUI.selectButton = hinh;                                 
                                    dispose();                                 
                                }
                        }                               
		});
                this.validate();
        }    
}
