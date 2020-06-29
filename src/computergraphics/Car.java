/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computergraphics;

import java.awt.Point;

/**
 *
 * @author AnThien049
 */
public class Car {
    private Point firstPoint;
    private Point secondPoint;
  
    public Car(){}
    
    public Car(Point _1sPoint)
    {
        this.firstPoint = _1sPoint;
        this.secondPoint = new Point((int)this.firstPoint.getX() + 400, (int)this.firstPoint.getY());
    }
       
    public void set1stPoint(Point _1stPoint)
    {
        this.firstPoint = _1stPoint;
    }
       
    public Point get1stPoint()
    {
        return this.firstPoint;
    }
    
    public Point get2ndPoint()
    {
        return this.secondPoint;
    }
    
}
