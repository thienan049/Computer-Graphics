/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computergraphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author AnThien049
 */
public class Circle
{
    private Point centerPoint;
    private int radius;

    public Circle() {}
    
    public Circle(Point centerPoint, int radius)
    {
        this.centerPoint = centerPoint;
        this.radius = radius;
    }
    
    public void setCenterPoint(Point centerPoint)
    {
        this.centerPoint = centerPoint;
    }
    
    public void setRadius(int radius)
    {
        this.radius = radius;
    }
    
    public Point getCenterPoint()
    {
        return this.centerPoint;
    }
    
    public int getRadius()
    {
        return this.radius;
    }
    
    public void ve8Diem(Graphics2D grp, int xDraw, int yDraw, int centerX, int centerY) {
//        try {
//            TimeUnit.MILLISECONDS.sleep(300);
//        } catch (Exception e) {
//        }

        grp.drawLine(xDraw + centerX, centerY + yDraw, xDraw + centerX, centerY + yDraw);//(x,-y)
        grp.drawLine(xDraw + centerX, centerY - yDraw, xDraw + centerX, centerY - yDraw);//(x,y)
        grp.drawLine(-xDraw + centerX, centerY + yDraw, -xDraw  + centerX, centerY + yDraw);//(-x,-y)
        grp.drawLine(-xDraw + centerX, centerY - yDraw, -xDraw  + centerX, centerY - yDraw);//(-x,y)
        
        grp.drawLine(centerX + yDraw, xDraw + centerY, centerX + yDraw, xDraw + centerY);//(y,-x)
        grp.drawLine(centerX + yDraw, -xDraw + centerY, centerX + yDraw, -xDraw + centerY);//(y,x)
        grp.drawLine(centerX - yDraw, xDraw + centerY, centerX - yDraw, xDraw + centerY);//(-y,-x)
        grp.drawLine(centerX - yDraw, -xDraw + centerY, centerX - yDraw, -xDraw + centerY);//(-y,x)
    }

    public void drawCircle(Graphics2D grp) {
        
        //grp.setColor(Color.RED);
        grp.setStroke(new BasicStroke(2));

        int xDraw = 0;
        int centerX = (int)this.centerPoint.getX();
        int centerY = (int)this.centerPoint.getY();
        //int yDraw = reverseScale(radius);
        int yDraw = this.radius;
        
        float p = 3 - 2 * (this.radius);

        while (xDraw <= this.radius * Math.sqrt(2) / 2) {
            ve8Diem(grp, xDraw, yDraw, centerX, centerY);

            xDraw++;
            if (p < 0) {
                p = p + 4 * xDraw + 6;
            } else {
                yDraw--;
                p = p + 4 * (xDraw - yDraw) + 10;
            }
        }
    }
}
