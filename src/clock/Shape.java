package clock;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class Shape {
	public Point begin;
	public Point end;
	public Point kernel;
	public Rectangle region;
	public Color color;
	public Graphics2D graphics;

	public Shape(Rectangle rect, Color color) {
		this.color = color;
		rect.width *= 5;
		rect.height *= 5;
		rect.setLocation(CommonExtensions.ToComputerCoordinates(rect.getLocation()));
		region = rect;
		kernel = new Point(rect.x + (rect.width / 2), rect.y + (rect.height / 2));
	}

// Constructor cho line
	public Shape(Point start, Point endp, Color color) {
		this.color = color;
		begin = CommonExtensions.ToComputerCoordinates(start);
		end = CommonExtensions.ToComputerCoordinates(endp);
		//begin = start;
		//end = endp;
	}

	public void PutPixel(Color color, int x, int y) {
		graphics.setColor(Color.BLACK);
		graphics.fillRect(x - 2, y - 2, 5, 5);

	}

	public void Dispose() {
		graphics.dispose();
	}

	public abstract void Draw(Graphics2D graphics, Dashes dashes);

	public abstract void TranslatingTransform(int trX, int trY);

	public abstract void ScaleTransform(Point origin, double scaleX, double scaleY);

	public abstract void RotateTransform(Point origin, Double angle);

	public abstract void OppositeTransform(Point origin, OppositeType oppositeType);
}
