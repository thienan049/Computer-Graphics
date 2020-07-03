package _3dsection;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalTime;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paint1 extends JPanel {

    private static final long serialVersionUID = 1L;
    public static JFrame window = new JFrame();
   
    private int counter = 0;
    private boolean isDraw = false;
 
    public Paint1() {
        this.setPreferredSize(new Dimension(window.getWidth(), window.getHeight()));
     
        Timer timer = new Timer(400, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.repaint();
                isDraw = true;
                counter++;

            }
        });
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        
    }

    public void HumanRun(Graphics2D g2d) {
      
    }

    public JFrame doWork() {

        window.setResizable(true);
        window.setUndecorated(false);
        window.setSize(1921, 1081);
        window.setContentPane(new Paint1());
        window.pack();
        window.setVisible(true);
        window.setLocation(55, 80);
        return window;
    }

//    public static void main(String[] args) {
//        window.setResizable(true);
//        window.setUndecorated(true);
//        window.setSize(1921, 1081); //1915 1036
//        // window.setSize(1920, 1080);
//        // Cons.WIDTH = 1937;
//        // Cons.HEIGHT = 1096;
//        window.setContentPane(new Paint1());
//        window.pack();
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.setLocationRelativeTo(null);
//        window.setVisible(true);
//        // JOptionPane.showConfirmDialog(null, window.size().toString());
//    }
}
