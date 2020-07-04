/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computergraphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Administrator
 */
public class Ellipse {

    private int R1;
    private int R2;
    private Point centerPoint; 

    public Ellipse() {
    }

    public Ellipse(Point centerPoint,int R1, int R2) {
        this.R1 = R1;
        this.R2 = R2;
        this.centerPoint = centerPoint;
    }

    public int getR1() {
        return R1;
    }

    public void setR1(int r1) {
        R1 = r1;
    }

    public int getR2() {
        return R2;
    }

    public void setR2(int r2) {
        R2 = r2;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }
    
    public void ve4diem(Graphics2D grp, int xDraw, int yDraw, int centerX, int centerY) {
        grp.fillRect(xDraw + centerX, centerY + yDraw, 5, 5);//(x,-y)
        grp.fillRect(xDraw + centerX, centerY - yDraw, 5, 5);//(x,y)
        grp.fillRect(-xDraw + centerX, centerY + yDraw, 5, 5);//(-x,-y)
        grp.fillRect(-xDraw + centerX, centerY - yDraw, 5, 5);//(-x,y)
    }

    public void drawEllipse(Graphics2D grp) {
        //grp.setColor(Color.BLUE);
        //grp.setStroke(new BasicStroke(2));
        
//        int R1 = this.R1 * 5;
//        int R2 = this.R2 * 5;
        int centerX = (int)this.centerPoint.getX();
        int centerY = (int)this.centerPoint.getY();
        
        float rxSq = R1 * R1;
        float rySq = R2 * R2;
        int xDraw = 0;
        int yDraw = R2;
        int fx = 0, fy = 2 * (int)rxSq * yDraw;
        
        // Region 1
        float p = rySq - rxSq * R2 + (float)(rxSq / 4);

        while (fx < fy) {               
            ve4diem(grp, xDraw, yDraw, centerX, centerY);
            if (p < 0) {
                p = p + rySq*(2 * xDraw + 3);
            } else {
                yDraw--;
                p = p + rySq*(2 * xDraw + 3) + rxSq*(-2 * yDraw + 2);
                fy -= 2 * rxSq;
            }
            xDraw++;
            fx += 2 * rySq;
        }
        
        // Region 2 
        float a = (xDraw + 1/2) * (xDraw + 1/2);
        float b = (yDraw - 1) * (yDraw - 1);
        float q  = rySq * a + rxSq * b - rxSq*rySq;

        while (yDraw >= 0) { 
            ve4diem(grp, xDraw, yDraw, centerX, centerY);
            if (q >= 0) {
                q = q + rxSq*(3 - 2*yDraw);
            } else {
                xDraw++;
                fx += 2 * rySq;
                q = q + rySq*(2*xDraw + 2) + rxSq*(-2*yDraw + 3);
            }
            yDraw--;
            fy -= 2 * rxSq;
        }
    }
}
		
