package clock;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class Clock extends Shape {

    public MyRectangle rectangleClock;
    public Circle clokCircle;
    public Circle clockBoderCircle;
    public Line seconsLine;
    public Line minutesLine;
    public Line hoursLine;
    
    
    public MyRectangle getRectangleClock() {
		return rectangleClock;
	}

	public void setRectangleClock(MyRectangle rectangleClock) {
		this.rectangleClock = rectangleClock;
	}

	public Circle getClokCircle() {
		return clokCircle;
	}

	public void setClokCircle(Circle clokCircle) {
		this.clokCircle = clokCircle;
	}

	public Circle getClockBoderCircle() {
		return clockBoderCircle;
	}

	public void setClockBoderCircle(Circle clockBoderCircle) {
		this.clockBoderCircle = clockBoderCircle;
	}

	public Line getSeconsLine() {
		return seconsLine;
	}

	public void setSeconsLine(Line seconsLine) {
		this.seconsLine = seconsLine;
	}

	public Line getMinutesLine() {
		return minutesLine;
	}

	public void setMinutesLine(Line minutesLine) {
		this.minutesLine = minutesLine;
	}

	public Line getHoursLine() {
		return hoursLine;
	}

	public void setHoursLine(Line hoursLine) {
		this.hoursLine = hoursLine;
	}

	public Clock(Rectangle rect, Color color) {
        super(rect, color);
        Rectangle abc = CommonExtensions.ToWorldRectangle((Rectangle)rect.clone());
        clokCircle = new Circle(new Rectangle(abc.x, abc.y, abc.width, abc.height), color);
        seconsLine = new Line(new Point(0, 0), new Point(0, 28), color);
        minutesLine = new Line(new Point(0, 0), new Point(0, 25), color);
        hoursLine = new Line(new Point(0, 0), new Point(0, 20), color);
    }

    public void RotateTransformSecons(Double angle){
        Point origin = seconsLine.begin;
		seconsLine.end = AnimationsExtension.Rotate(seconsLine.end, origin, angle);
    }

    public void RotateTransformMinutes(Double angle){
        Point origin = minutesLine.begin;
		minutesLine.end = AnimationsExtension.Rotate(minutesLine.end, origin, angle);
    }

    public void RotateTransformHours(Double angle){
        Point origin = seconsLine.begin;
		hoursLine.end = AnimationsExtension.Rotate(hoursLine.end, origin, angle);
    }

    @Override
    public void Draw(Graphics2D graphics, Dashes dashes) {
        
        Rectangle temp = CommonExtensions.ToComputerRectangle(new Rectangle(-40, 40, 80, 120));
        graphics.setColor(Color.CYAN);
       // graphics.fillRect(temp.x, temp.y, temp.width, temp.height);
        graphics.setColor(Color.WHITE);
      //  graphics.fillOval(region.x, region.y, region.width, region.height);
        clokCircle.Draw(graphics, dashes);
        
        /// OUT LOG
        
        hoursLine.Draw(graphics, dashes);
        minutesLine.Draw(graphics, dashes);
        seconsLine.Draw(graphics, dashes);
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
