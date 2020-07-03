package _3dsection;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedWriter;
import java.io.IOException;
//import javafx.scene.shape.Line;

public class MyLine implements Hinh2D {

    private Point A , B;
    private Color LineColor = null;
    private float angle = 0;
    
    // add here
    private Point markPoint = new Point();
    

    public MyLine() {

    }

    public MyLine(Point A, Point B) {
        this.A = A;
        this.B = B;
    }

    @Override
    public void makeObject(Point startDrag, Point endDrag) {
        
        setLineColor(GUI.selectColor);
        this.setA(new Point(startDrag.x, startDrag.y));
        this.setB(new Point(endDrag.x, endDrag.y));
    }

    
    public void makeLine(int x1, int y1, int x2, int y2) {
        setLineColor(GUI.selectColor);
        this.setA(new Point(x1, y1));
        this.setB(new Point(x2, y2));
        
        //add here
        markPoint = this.getB();
    }

    @Override
    public boolean contains(Point p) {
//        Line l1 = new Line(this.getA().x, this.getA().y, this.getB().x, this.getB().y);
//        Line l2 = new Line(this.getA().x -1, this.getA().y -1, this.getB().x+1, this.getB().y+1);
//        Line l3 = new Line(this.getA().x -2, this.getA().y -2, this.getB().x+2, this.getB().y+2);
//        Line l4 = new Line(this.getA().x -3, this.getA().y -3, this.getB().x+3, this.getB().y+3);
//        
        return true;//(l1.contains(p.x, p.y)||l2.contains(p.x, p.y)||l3.contains(p.x, p.y)||l4.contains(p.x, p.y));
    }

    @Override
    public void move(Point startDrag, Point endDrag) {
        this.setA(new Point(this.getA().x + (endDrag.x - startDrag.x), this.getA().y + (endDrag.y - startDrag.y)));
        this.setB(new Point(this.getB().x + (endDrag.x - startDrag.x), this.getB().y + (endDrag.y - startDrag.y)));
    }

    @Override
    public void scale(Point startDrag, Point endDrag) {
        this.setA(new Point(this.getA().x, this.getA().y));
        this.setB(new Point(endDrag.x, endDrag.y));
    }

    @Override
    public void draw(GraphicAdapter g) {
        
        // add here
        markPoint.x = this.getB().x;
        markPoint.y = this.getB().y;
        
        g.getGraphicAdapter().setColor(getLineColor());
        int Dx, Dy, count;
        float delta_X, delta_Y, i, m, n;
        Dx = this.getB().x - this.getA().x;
        Dy = this.getB().y - this.getA().y;
        
        
        //Lay so buoc ve
        if (Math.abs(Dy) > Math.abs(Dx)) {
            count = Math.abs(Dy);
        } else {
            count = Math.abs(Dx);
        }
        // add 
//        count /= 7;
        if (count > 0) {
        	
            delta_X = (int) Dx;
            delta_X /= count;
            
            delta_Y = (int) Dy;
            delta_Y /= count;
            
            m = this.getA().x;
            n = this.getA().y;

            

            do {

                g.getGraphicAdapter().fillRect((int) m, (int) n , 5, 5);
                
                markPoint.x = (int) m;
                markPoint.y = (int) n;
                
                m += (delta_X); // is new value
                
                n += (delta_Y); // is new value
                
//                // 1
//                if ((int)m - markPoint.x >= 1) {
//                	m += 2;
//                }
//                // add
//                else {
//                }
//                // 2
//                if (markPoint.x - (int)m >= 1) {
//                	m -= 2;
//                }
//                // 3
//                if ((int)n - markPoint.y >= 1) {
//                	n+=2;
//                }
//                // 4
//                if (markPoint.y - (int)n >= 1) {
//                	n-= 2;
//                }
//                // 5
//                if ((int)m - markPoint.x >= 1 && (int)n - markPoint.y >= 1) {
//                	m += 2;
//                	n -= 2;
//                }
//                // 6
//                if ((int)m - markPoint.x >= 1 && markPoint.y - (int)n >= 1) {
//                	m += 2;
//                	n += 2;
//                }
//                // 7
//                if (markPoint.x - (int)m >= 1 && markPoint.y - (int)n >= 1) {
//                	n += 2;
//                }
//                // 8
//                if (markPoint.x - (int)m >= 1 && (int)n - markPoint.y >= 1) {
//                	m -= 2;
//                	n -= 2;
//                }
                

                
                -- count;
                
            } while (count != -1);
            
        }

    }
//    public static int Round5(int)
 //   @Override
//    public void rotate(Point startDrag, Point endDrag) {
//        float a = GUI.angleBetween2Lines(startDrag, endDrag);
//        Point startPoint = new Point(this.getA().x, this.getA().y);
//        Point endPoint = new Point(this.getB().x, this.getB().y);
//
//        startPoint = GUI.rotateAround(startPoint, a);
//        endPoint = GUI.rotateAround(endPoint, a);
//
//        this.setA(startPoint);
//        this.setB(endPoint);
//
//        this.setAngle(this.getAngle() + a);
//    }

 //   @Override
//    public void writetoFile(BufferedWriter b) {
//        Point p1 = new Point(GUI.convertMtoND(getA().x, getA().y));
//        Point p2 = new Point(GUI.convertMtoND(getB().x, getB().y));
//        try {
//            b.write(getClass().getSimpleName() + ";");
//            b.write(p1.x + ";" + p1.y + ";" + p2.x + ";" + p2.y + ";");
//            b.write(getLineColor().getRed() + ";" + getLineColor().getGreen() + ";" + getLineColor().getBlue());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public Color getLineColor() {
        return LineColor;
    }

    public void setLineColor(Color color) {
        this.LineColor = color;
    }

    public Point getA() {
        return A;
    }

    public void setA(Point A) {
        this.A = A;
    }

    public Point getB() {
        return B;
    }

    public void setB(Point B) {
        this.B = B;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        if (angle > 360) {
            angle -= 360;
        }
        this.angle = angle;
    }

    public void Net_Dut(Graphics g, int x1, int y1, int x2, int y2) {
 
        int Dx, Dy, count;
        float delta_X, delta_Y, m, n;
        Dx = x2 - x1;
        Dy = y2 - y1;
        
        //add here
        Math.round(y2/5);
        Math.round(x2/5);
        
        
        int dem = 0;
        //Lay so buoc ve
        if (Math.abs(Dy) > Math.abs(Dx)) {
            count = Math.abs(Dy);
        } else {
            count = Math.abs(Dx);
        }

        if (count > 0) {
            delta_X = (int) Dx;
            delta_X /= count;
            delta_Y = (int) Dy;
            delta_Y /= count;

            m = x1;
            n = y1;

            do {
                if (dem < 7) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                if (dem % 10 == 0) {
                    dem = 0;
                }

                g.fillRect((int) m, (int) n, 5, 5);
                m += delta_X;
                n += delta_Y;
                dem++;
                --count;
                g.setColor(Color.BLACK);
            } while (count != -1);

        }
    }

    public Point GiaoDiem(MyLine dt) {
        Point point = null;

        int denominator = (this.getA().x - this.getB().x) * (dt.getA().y - dt.getB().y)
                - (this.getA().y - this.getB().y) * (dt.getA().x - dt.getB().x);

        int px = 0;
        int py = 0;

        if (denominator == 0) {
            return null;
        }

        px = ((this.getA().x * this.getB().y - this.getA().y * this.getB().x) * (dt.getA().x - dt.getB().x) - (this.getA().x - this.getB().x)
                * (dt.getA().x * dt.getB().y - dt.getA().y * dt.getB().x))
                / denominator;
        py = ((this.getA().x * this.getB().y - this.getA().y * this.getB().x) * (dt.getA().y - dt.getB().y) - (this.getA().y - this.getB().y)
                * (dt.getA().x * dt.getB().y - dt.getA().y * dt.getB().x))
                / denominator;

        point = new Point(px, py);
        return point;

    }

    @Override
    public void rotate(Point startDrag, Point endDrag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writetoFile(BufferedWriter b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
