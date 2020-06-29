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
public class DrawCar {
    private Car car;
    private int bigRadius = 30;
    private int smallRadius = 10;
    
    public DrawCar(Car car)
    {
        this.car = car;
    }
    
    public void drawing(Graphics2D grp, Color color)
    {
        grp.setColor(color);
        grp.setStroke(new BasicStroke(2));
        //y = mx + b -> y = y + m
        int _1stPointX = (int) this.car.get1stPoint().getX();
        int _1stPointY = (int) this.car.get1stPoint().getY();
        int _2ndPointX = (int) this.car.get2ndPoint().getX();
        int _2ndPointY = (int) this.car.get2ndPoint().getY();

        Point _3rdPoint = new Point(_1stPointX, _1stPointY - 60);
        Point _4thPoint = new Point(_2ndPointX, _2ndPointY - 60);
        Point _5thPoint = new Point((int)_3rdPoint.getX() + 80, (int)_3rdPoint.getY() - 10);
        Point _6thPoint = new Point((int)_4thPoint.getX() - 80, (int)_4thPoint.getY() - 10);
        Point _7thPoint = new Point((int)_5thPoint.getX() + 30, (int)_5thPoint.getY() - 50);
        Point _8thPoint = new Point((int)_6thPoint.getX() - 30, (int)_6thPoint.getY() - 50);
        Point _17thPoint = new Point((int)_5thPoint.getX() - 3 - bigRadius, (int)_1stPointY);
        Point _18thPoint = new Point((int)_5thPoint.getX() - 3 + bigRadius, (int)_2ndPointY);
        Point _19thPoint = new Point((int)_6thPoint.getX() + 3 - bigRadius, (int)_1stPointY);
        Point _20thPoint = new Point((int)_6thPoint.getX() + 3 + bigRadius, (int)_2ndPointY);
        
        
        //Rectangles points
        Point _9thPoint = new Point((int)_7thPoint.getX() + 5, (int)_7thPoint.getY() + 10);
        Point _10thPoint = new Point((int)((_8thPoint.getX() - _7thPoint.getX())/2) + (int)_7thPoint.getX() - 5, (int)_5thPoint.getY());
        Point _11thPoint = new Point((int)((_8thPoint.getX() - _7thPoint.getX())/2) + (int)_7thPoint.getX() + 5, (int)_8thPoint.getY() + 10);
        Point _12thPoint = new Point((int)_8thPoint.getX() - 5, (int)_6thPoint.getY());
        Point _13thPoint = new Point((int)_5thPoint.getX() + 10, (int)_5thPoint.getY());
        Point _14thPoint = new Point((int)_6thPoint.getX() - 10, (int)_6thPoint.getY());
        
        //Circles points
        Point _15thPoint = new Point((int)_5thPoint.getX() - 3, (int)_1stPointY);
        Point _16thPoint = new Point((int)_6thPoint.getX() + 3, (int)_2ndPointY);

//        drawLine(pointByScale(this.car.get1stPoint()), pointByScale(_3rdPoint));
//        drawLine(pointByScale(this.car.get1stPoint()), pointByScale(_4thPoint));
//        drawLine(pointByScale(this.car.get2ndPoint()), pointByScale(_3rdPoint));
//        drawLine(pointByScale(this.car.get2ndPoint()), pointByScale(_4thPoint));
        
        Line horzLine1 = new Line(this.car.get1stPoint(), _17thPoint);
        horzLine1.drawLine(grp);
        Line horzLine2 = new Line(_18thPoint, _19thPoint);
        horzLine2.drawLine(grp);
        Line horzLine3 = new Line(_20thPoint, this.car.get2ndPoint());
        horzLine3.drawLine(grp);
        Line leftVertLine = new Line(this.car.get1stPoint(), _3rdPoint);
        leftVertLine.drawLine(grp);
        Line rightVertLine = new Line(this.car.get2ndPoint(), _4thPoint);
        rightVertLine.drawLine(grp);
        Line leftDownDiagLine = new Line(_3rdPoint, _5thPoint);
        leftDownDiagLine.drawLine(grp);
        Line rightDownDiagLine = new Line(_4thPoint, _6thPoint);
        rightDownDiagLine.drawLine(grp);
        Line leftUpDiagLine = new Line(_5thPoint, _7thPoint);
        leftUpDiagLine.drawLine(grp);
        Line rightUpDiagLine = new Line(_6thPoint, _8thPoint);
        rightUpDiagLine.drawLine(grp);
        Line upHorzLine = new Line(_7thPoint, _8thPoint);
        upHorzLine.drawLine(grp);
        
        Line leftTriaDiagLine = new Line(_9thPoint, _13thPoint);
        leftTriaDiagLine.drawLine(grp);
        Line leftTriaUnderLine = new Line(new Point((int)_9thPoint.getX(), (int)_10thPoint.getY()), _13thPoint);
        leftTriaUnderLine.drawLine(grp);
        Line rightTriaDiagLine = new Line(_12thPoint, _14thPoint);
        rightTriaDiagLine.drawLine(grp);
        Line rightTriaUnderLine = new Line(new Point((int)_12thPoint.getX(), (int)_11thPoint.getY()), _14thPoint);
        rightTriaUnderLine.drawLine(grp);
        
        
        Rectangle leftRect = new Rectangle(_9thPoint, _10thPoint);
        leftRect.drawRectangleByDiagonalLine(grp);
        Rectangle rightRect = new Rectangle(_11thPoint, _12thPoint);
        rightRect.drawRectangleByDiagonalLine(grp);
        
        Circle leftWheel = new Circle(_15thPoint, bigRadius);
        leftWheel.drawCircle(grp);
        Circle rightWheel = new Circle(_16thPoint, bigRadius);
        rightWheel.drawCircle(grp);
        Circle leftInWheel = new Circle(_15thPoint, smallRadius);
        leftInWheel.drawCircle(grp);
        Circle rightInWheel = new Circle(_16thPoint, smallRadius);
        rightInWheel.drawCircle(grp);
    }
}
