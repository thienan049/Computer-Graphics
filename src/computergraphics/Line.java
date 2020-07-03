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

/**
 *
 * @author AnThien049
 */
public class Line
{
    private Point beginPoint;
    private Point endPoint;

    public Line() {}
    
    public Line(Point beginPoint, Point endPoint)
    {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }
    
    public void setBeginPoint(Point beginPoint)
    {
        this.beginPoint = beginPoint;
    }
    
    public void setEndPoint(Point endPoint)
    {
        this.endPoint = endPoint;
    }
    
    public Point getBeginPoint()
    {
        return this.beginPoint;
    }
    
    public Point getEndPoint()
    {
        return this.endPoint;
    }
    
    public void drawLine(Graphics2D grp) // Vẽ đường thẳng
    {
        //grp.setColor(Color.RED);
        //grp.setStroke(new BasicStroke(2));
        //y = mx + b -> y = y + m
        int beginPointX = (int) beginPoint.getX();
        int beginPointY = (int) beginPoint.getY();;
        int endPointX = (int) endPoint.getX();
        int endPointY = (int) endPoint.getY();

        int Dx = endPointX - beginPointX;
        int Dy = endPointY - beginPointY;
        int step;
        if (Math.abs(Dx) > Math.abs(Dy)) {
            step = Dx > 0 ? Dx : (-Dx);
        } else {
            step = Dy > 0 ? Dy : (-Dy);
        }

        float xStep = (float) Dx / step;
        float yStep = (float) Dy / step;
        float yNext = beginPointY;
        float xNext = beginPointX;
        int count = 0;

        while (count <= step) {
            grp.drawLine(round(xNext), round(yNext), round(xNext), round(yNext));
            yNext += yStep;
            xNext += xStep;
            count++;
        }
    }
    
    public void drawDashedLinebyDDA(Graphics2D grp, int drawRange, int skipRange) // Vẽ đường nét đứt
    {
        //grp.setColor(Color.RED);
        // grp.setStroke(new BasicStroke(2));
        //y = mx + b -> y = y + m

        int beginPointX = (int) beginPoint.getX();
        int beginPointY = (int) beginPoint.getY();
        int endPointX = (int) endPoint.getX();
        int endPointY = (int) endPoint.getY();

        int Dx = endPointX - beginPointX;
        int Dy = endPointY - beginPointY;
        int step;
        if (Math.abs(Dx) > Math.abs(Dy)) {
            step = Dx > 0 ? Dx : (-Dx);
        } else {
            step = Dy > 0 ? Dy : (-Dy);
        }
        float xStep = (float) Dx / step;
        float yStep = (float) Dy / step;
        float yNext = beginPointY;
        float xNext = beginPointX;

        //drawRange = 30, skipRange = 20;

        int countPartLength = 0;
        int countFullLength = 0;
        
        while (countFullLength <= Math.abs(step)) {
            if (countPartLength == drawRange) {
                countPartLength = 0;
                countFullLength += skipRange;
                if (Math.abs(Dx) > Math.abs(Dy)) {
                    xNext += Dx < 0 ? -skipRange : skipRange;
                } else {
                    yNext += Dy < 0 ? -skipRange : skipRange;
                }
            }
            grp.drawLine(round(xNext), round(yNext), round(xNext), round(yNext));
            countFullLength++;
            countPartLength++;
            xNext += xStep;
            yNext += yStep;
        }
    }
    
    public int round(float num) {
        return (int) (num + 0.5);
    }
}
