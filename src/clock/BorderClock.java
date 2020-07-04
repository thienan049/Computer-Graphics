package clock;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class BorderClock extends Shape {

    public MyRectangle rectangleClock;
    public Line headSpaceLine;


    public BorderClock(Rectangle rect, Color color) {
        super(rect, color);
        Rectangle contain = CommonExtensions.ToWorldRectangle((Rectangle) rect.clone());
		int x = contain.x;
		int y = contain.y;
		int width = contain.width;
        int height = contain.height;

        rectangleClock = new MyRectangle(contain, Color.black);

        Point beginHeadAlien = new Point(x + width/2,y - height +22);
        Point endHeadAlien = new Point(x + width/4, y - height+ 22);
        headSpaceLine = new Line(beginHeadAlien, endHeadAlien , color);
    }

    @Override
    public void Draw(Graphics2D graphics, Dashes dashes) {
        // for(int i = 0; i < 30; i++){
        //     headSpaceLine.RotateTransform(headSpaceLine.begin, -2.0);
        //     headSpaceLine.Draw(graphics, dashes);;
        // }
        for(int i = 0; i < 360; i++){
            headSpaceLine.RotateTransform(headSpaceLine.begin, -2.0);
            headSpaceLine.Draw(graphics, dashes);
        }
        rectangleClock.Draw(graphics, dashes);
       
    }

    @Override
    public void TranslatingTransform(int trX, int trY) {

    }

    @Override
    public void ScaleTransform(Point origin, double scaleX, double scaleY) {

    }

    @Override
    public void RotateTransform(Point origin, Double angle) {

    }

    @Override
    public void OppositeTransform(Point origin, OppositeType oppositeType) {

    }

}