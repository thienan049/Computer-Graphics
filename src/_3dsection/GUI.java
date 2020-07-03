package _3dsection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import javax.swing.Icon;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class GUI extends JFrame {

    /*---------------------------------------------------------*/
    /**
     * Declare Variable                   *
     */
    /*---------------------------------------------------------*/
    public static String selectButton = "";
    public static Color selectColor = Color.black;
    public static ArrayList<Paint> paint2D = new ArrayList<Paint>();
    public static ArrayList<Paint> paint3D = new ArrayList<Paint>();
    private final JPanel contentPane;
    public static boolean Draw3d = false;
    public static GUI frame;
    public static int X;
    public static int Y;
    public static int Z;
    public static Paint1 paint1;
    public static void main(String[] args) {
        try {
            frame = new GUI();
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    Paint1 paint2DAnimation = new Paint1();
    JFrame jFrame2D;

    public GUI() {
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setTitle("Kỹ Thuật Đồ Họa JAVA");
        this.setSize(1000, 600);
        this.setResizable(false);
        this.setIconImage(new ImageIcon("Image/draw.png").getImage());
//        
//        //Create Menu bar
//        JMenuBar menuBar = new JMenuBar();
//        this.setJMenuBar(menuBar);
//
//        JMenu mnMenu = new JMenu("Menu");
//        menuBar.add(mnMenu);
//
//        //Menu Create News paint
//        JMenuItem mntmNew = new JMenuItem("New");
//        mntmNew.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                selectButton = "";
//                OpenFile.image = null;
//                paint2D.clear();
//                repaint();
//            }
//        });
//        mnMenu.add(mntmNew);
//
//        //Menu open this paint 
//        JMenuItem mntmOpen = new JMenuItem("Open");
//        mntmOpen.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                selectButton = "Open";
//                try {
//                    GUI.paint2D.clear();
//                    new OpenFile();
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        mnMenu.add(mntmOpen);
//
//        //Menu Save this paint 
//        JMenuItem mntmNew_1 = new JMenuItem("Save");
//        mntmNew_1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                selectButton = "Save";
//                new SaveFile();
//            }
//        });
//        mnMenu.add(mntmNew_1);
//
//        //Menu exit this application
//        JMenuItem mntmNew_2 = new JMenuItem("Exit");
//        mntmNew_2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                selectButton = "Exit";
//                System.exit(0);
//            }
//        });
//        mnMenu.add(mntmNew_2);
//
//        //Menu Help
//        JMenu mnHelp = new JMenu("Help");
//        mnHelp.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent arg0) {
//                new Information("Help", " Sorry!  that's just troll :-)", 80, 50);
//            }
//        });
//        menuBar.add(mnHelp);


        /*---------------------------------------------------------*/
        /**
         * Panel Main (Painting On This Panel)          *
         */
        /*---------------------------------------------------------*/
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.setBackground(Color.white);
        this.setContentPane(contentPane);

        JPanel pnlShape = new JPanel();
        GridLayout shapeLayout = new GridLayout(1, 12);
        pnlShape.setLayout(shapeLayout);
        shapeLayout.setHgap(5);
        pnlShape.setBackground(Color.WHITE);
        contentPane.add(pnlShape, BorderLayout.NORTH);

        JPanel pnlTool = new JPanel();
        GridLayout toolLayout = new GridLayout(8, 1);
        pnlTool.setLayout(toolLayout);
        pnlTool.setBackground(Color.WHITE);
        toolLayout.setVgap(5);
        contentPane.add(pnlTool, BorderLayout.WEST);

        /*---------------------------------------------------------*/
        /**
         * Button selected draw Line               *
         */
        /*---------------------------------------------------------*/
//        JButton btnLine = new JButton(new ImageIcon("Image/line.png"));
//        btnLine.setToolTipText("Vẽ đường thẳng ! ");
//        btnLine.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                selectButton = "Line";
//            }
//        });

//        JButton btnRect = new JButton(new ImageIcon("Image/rect.png"));
//        btnRect.setToolTipText("Vẽ hình chữ nhật ! ");
//        btnRect.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                selectButton = "Rectangle";
//            }
//        });

//        JButton btnTriangle = new JButton(new ImageIcon("Image/triangle.png"));
//        btnTriangle.setToolTipText("Vẽ hình tam giác ! ");
//        btnTriangle.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                selectButton = "Triangle";
//            }
//        });



//        JButton btnEllip = new JButton(new ImageIcon("Image/ellipse.png"));
//        btnEllip.setToolTipText("Vẽ hình ellip ! ");
//        btnEllip.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                selectButton = "Ellip";
//            }
//        });


//        JButton btnRhumbus = new JButton(new ImageIcon("Image/rhombus.png"));
//        btnRhumbus.setToolTipText("Vẽ hình thoi ! ");
//        btnRhumbus.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                selectButton = "Rhombus";
//            }
//        });
        JButton btnCube = new JButton(new ImageIcon("Image/cube.png"));
        btnCube.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                NhapToaDo3D hcn = new NhapToaDo3D("Cube");
            }
        });

        JButton btnPyramid = new JButton(new ImageIcon("Image/pyramid.png"));
        btnPyramid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                NhapToaDo3D ht = new NhapToaDo3D("Pyramid");
            }
        });

        /*---------------------------------------------------------*/
        /**
         * Button Tool                    *
         */
        /*---------------------------------------------------------*/
//        JButton btnChooseColor = new JButton(new ImageIcon("Image/color.png"));
//        btnChooseColor.setToolTipText("Chọn màu nét vẽ ! ");
//        btnChooseColor.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                selectButton = "ChooseColor";
//                new ColorChoose();
//            }
//        });
    

      

  

        /*---------------------------------------------------------*/
        /**
         * Add Button To Panel                 *
         */
        /*---------------------------------------------------------*/
    

        pnlShape.add(btnCube).setEnabled(true);
        pnlShape.add(btnPyramid).setEnabled(true);

     
        /*---------------------------------------------------------*/
        /**
         * Panel Draw                     *
         */
        /*---------------------------------------------------------*/
        JPanel pnlOxy = new JPanel();
        pnlOxy.setBackground(Color.WHITE);
        pnlOxy.setBorder(new EmptyBorder(7, 8, 0, 0));
        pnlOxy.setLayout(new BorderLayout());

        JPanel pnlOxyz = new JPanel();
        pnlOxyz.setBackground(Color.WHITE);
        pnlOxyz.setBorder(new EmptyBorder(10, 10, 0, 0));
        pnlOxyz.setLayout(new BorderLayout());

        pnlOxy.add(new Paint_2D(), BorderLayout.CENTER);
        //pnlOxyz.add(new Paint_3D(), BorderLayout.CENTER);
        contentPane.add(pnlOxy, BorderLayout.CENTER);

  
    }

}
