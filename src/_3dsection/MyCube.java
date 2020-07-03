package _3dsection;

import java.awt.Point;
import java.io.BufferedWriter;


public class MyCube implements Hinh3D{
    private MyLine dt1;
    private MyLine dt2;
    private MyLine dt3;
    private MyLine dt4;
    private MyLine dt5;
    private MyLine dt6;
    private MyLine dt7;
    private MyLine dt8;
    private MyLine dt9;
    private MyLine dt10;
    private MyLine dt11;
    private MyLine dt12;
    
    public MyCube() {
        
    }

    public MyCube(MyLine dt1, MyLine dt2, MyLine dt3, MyLine dt4, MyLine dt5, MyLine dt6, MyLine dt7, MyLine dt8, MyLine dt9, MyLine dt10, MyLine dt11, MyLine dt12) {
        this.dt1 = dt1;
        this.dt2 = dt2;
        this.dt3 = dt3;
        this.dt4 = dt4;
        this.dt5 = dt5;
        this.dt6 = dt6;
        this.dt7 = dt7;
        this.dt8 = dt8;
        this.dt9 = dt9;
        this.dt10 = dt10;
        this.dt11 = dt11;
        this.dt12 = dt12;
    }

    @Override
    public void makeObject(Point startDrag, Point endDrag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void makeCube(int x,int y,int z) {
        y = y/2;
        setDt1(new MyLine(new Point(400,250),new Point(400,250-z))); //oz
        setDt2(new MyLine(new Point(400,250-z),new Point(400+x,250-z)));
        setDt3(new MyLine(new Point(400+x,250-z),new Point(400+x,250)));
        setDt4(new MyLine(new Point(400,250),new Point(400+x,250))); // ox
        setDt5(new MyLine(new Point(400-y,250+y),new Point(400,250))); // oy
        setDt6(new MyLine(new Point(400-y,250+y),new Point(400-y+x,250+y)));
        setDt7(new MyLine(new Point(400-y+x,250+y),new Point(400+x,250)));
        setDt8(new MyLine(new Point(400-y,250+y-z),new Point(400-y,250+y)));
        setDt9(new MyLine(new Point(400-y,250+y-z),new Point(400-y+x,250+y-z)));
        setDt10(new MyLine(new Point(400-y+x,250+y),new Point(400-y+x,250+y-z)));
        setDt11(new MyLine(new Point(400-y,250+y-z),new Point(400,250-z)));
        setDt12(new MyLine(new Point(400-y+x,250+y-z),new Point(400+x,250-z)));
    }
    

    @Override
    public void draw(GraphicAdapter g) {
        this.dt1.Net_Dut(g.getGraphicAdapter(), this.getDt1().getA().x, this.getDt1().getA().y, this.getDt1().getB().x, this.getDt1().getB().y);
        this.dt2.draw(g);
        this.dt3.draw(g);
        if(GUI.Z != 0)
            this.dt4.Net_Dut(g.getGraphicAdapter(), this.getDt4().getA().x, this.getDt4().getA().y, this.getDt4().getB().x, this.getDt4().getB().y);
        else
            this.dt4.draw(g);
        this.dt5.Net_Dut(g.getGraphicAdapter(), this.getDt5().getA().x, this.getDt5().getA().y, this.getDt5().getB().x, this.getDt5().getB().y);   
        this.dt6.draw(g);
        this.dt7.draw(g);
        this.dt8.draw(g);
        this.dt9.draw(g);
        this.dt10.draw(g);
        this.dt11.draw(g);
        this.dt12.draw(g);
        
    }
    @Override
    public boolean contains(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move(Point startDrag, Point endDrag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writetoFile(BufferedWriter b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public MyLine getDt1() {
        return dt1;
    }

    public void setDt1(MyLine dt1) {
        this.dt1 = dt1;
    }

    public MyLine getDt2() {
        return dt2;
    }

    public void setDt2(MyLine dt2) {
        this.dt2 = dt2;
    }

    public MyLine getDt3() {
        return dt3;
    }

    public void setDt3(MyLine dt3) {
        this.dt3 = dt3;
    }

    public MyLine getDt4() {
        return dt4;
    }

    public void setDt4(MyLine dt4) {
        this.dt4 = dt4;
    }

    public MyLine getDt5() {
        return dt5;
    }

    public void setDt5(MyLine dt5) {
        this.dt5 = dt5;
    }

    public MyLine getDt6() {
        return dt6;
    }

    public void setDt6(MyLine dt6) {
        this.dt6 = dt6;
    }

    public MyLine getDt7() {
        return dt7;
    }

    public void setDt7(MyLine dt7) {
        this.dt7 = dt7;
    }

    public MyLine getDt8() {
        return dt8;
    }

    public void setDt8(MyLine dt8) {
        this.dt8 = dt8;
    }

    public MyLine getDt9() {
        return dt9;
    }

    public void setDt9(MyLine dt9) {
        this.dt9 = dt9;
    }

    public MyLine getDt10() {
        return dt10;
    }

    public void setDt10(MyLine dt10) {
        this.dt10 = dt10;
    }

    public MyLine getDt11() {
        return dt11;
    }

    public void setDt11(MyLine dt11) {
        this.dt11 = dt11;
    }

    public MyLine getDt12() {
        return dt12;
    }

    public void setDt12(MyLine dt12) {
        this.dt12 = dt12;
    }
 

    @Override
    public void rotate(Point startDrag, Point endDrag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void scale(Point startDrag, Point endDrag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
