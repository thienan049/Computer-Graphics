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
public class Rectangle 
{
    private Point _1stDiagPoint;
    private Point _2ndDiagPoint;
    
    public Rectangle(){}
    
    public Rectangle(Point _1sPoint, Point _2ndPoint)
    {
        this._1stDiagPoint = _1sPoint;
        this._2ndDiagPoint = _2ndPoint;
       // this._3rdPoint = _3rdPoint;
    }
    
    public void set1stPoint(Point _1stPoint)
    {
        this._1stDiagPoint = _1stPoint;
    }
    
    public void set2ndPoint(Point _2ndPoint)
    {
        this._2ndDiagPoint = _2ndPoint;
    }
    
    public Point get1stPoint()
    {
        return this._1stDiagPoint;
    }
    
    public Point get2ndPoint()
    {
        return this._2ndDiagPoint;
    }
    
    public void drawRectangleByDiagonalLine(Graphics2D grp) {
        
        //grp.setColor(Color.RED);
        //grp.setStroke(new BasicStroke(2));
        //y = mx + b -> y = y + m
        int _1stPointX = (int) _1stDiagPoint.getX();
        int _1stPointY = (int) _1stDiagPoint.getY();
        int _2ndPointX = (int) _2ndDiagPoint.getX();
        int _2ndPointY = (int) _2ndDiagPoint.getY();

        Point _3rdPoint = new Point(_2ndPointX, _1stPointY);
        Point _4thPoint = new Point(_1stPointX, _2ndPointY);

//        drawLine(pointByScale(_1stDiagPoint), pointByScale(_3rdPoint));
//        drawLine(pointByScale(_1stDiagPoint), pointByScale(_4thPoint));
//        drawLine(pointByScale(_2ndDiagPoint), pointByScale(_3rdPoint));
//        drawLine(pointByScale(_2ndDiagPoint), pointByScale(_4thPoint));

        new Line(_1stDiagPoint, _3rdPoint).drawLine(grp);
        new Line(_1stDiagPoint, _4thPoint).drawLine(grp);
        new Line(_2ndDiagPoint, _3rdPoint).drawLine(grp);
        new Line(_2ndDiagPoint, _4thPoint).drawLine(grp);
    }
}
