/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computergraphics;

/**
 *
 * @author Administrator
 */
public class _2dShapesSize {
    int A;
    int B;
    int C;
    int D;
    int R;
    int R2;
    int xO;
    int yO;
    
    public _2dShapesSize(){}
    
    public _2dShapesSize(int a, int b, int c, int d){
        this.A = a;
        this.B = b;
        this.C = c;
        this.D = d;
    }

    public _2dShapesSize(int xo, int yo, int r) {
        this.R = r;
        this.xO = xo;
        this.yO = yo;
    }
   
    public int getA() {
        return A;
    }

    public void setA(int A) {
        this.A = A;
    }

    public int getB() {
        return B;
    }

    public void setB(int B) {
        this.B = B;
    }

    public int getC() {
        return C;
    }

    public void setC(int C) {
        this.C = C;
    }

    public int getD() {
        return D;
    }

    public void setD(int D) {
        this.D = D;
    }

    public int getR() {
        return R;
    }

    public void setR(int R) {
        this.R = R;
    }

    public int getxO() {
        return xO;
    }

    public void setxO(int xO) {
        this.xO = xO;
    }

    public int getyO() {
        return yO;
    }

    public void setyO(int yO) {
        this.yO = yO;
    }

    public int getR2() {
        return R2;
    }

    public void setR2(int R2) {
        this.R2 = R2;
    }

    
}
