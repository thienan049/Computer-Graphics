package clock;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class Circle extends Shape {
	
	public double Radius;

	public Circle(Rectangle rect, Color color) {
		super(rect, color);
		Radius = (CommonExtensions.Round5((int)(region.getWidth() / 2)));
	}

	private void Put8PixelCircle(Color color, Point kernel, int x, int y) {
		PutPixel(color, kernel.x + x, kernel.y + y);
		PutPixel(color, kernel.x + y, kernel.y + x);
		PutPixel(color, kernel.x + y, kernel.y - x);
		PutPixel(color, kernel.x + x, kernel.y - y);
		PutPixel(color, kernel.x - x, kernel.y - y);
		PutPixel(color, kernel.x - y, kernel.y - x);
		PutPixel(color, kernel.x - y, kernel.y + x);
		PutPixel(color, kernel.x - x, kernel.y + y);
	}

	private void Put8PixelCircleHalf(Color color, Point kernel, int x, int y) {
		PutPixel(color, kernel.x + y, kernel.y - x);
		PutPixel(color, kernel.x + x, kernel.y - y);
		PutPixel(color, kernel.x - x, kernel.y - y);
		PutPixel(color, kernel.x - y, kernel.y - x);
	}

	public void DrawHalf(Graphics2D graphics, Dashes dashes) {
		super.graphics = graphics;

		int x, y;
		int R = region.width / 2;
		Point kernel = new Point(region.x + R, region.y + R);
		kernel.x = CommonExtensions.Round5(kernel.x);
		kernel.y = CommonExtensions.Round5(kernel.y);

		x = 0;
		y = R;
		Put8PixelCircleHalf(color, kernel, x, CommonExtensions.Round5(y));
		long p = 1 - R; // 5/4-R
		while (x < y) {
			if (p < 0)
				p += 2 * x + 3;
			else {
				p += 2 * (x - y) + 5;
				y--;
			}
			x++;
			// Round y láº¡i Ä‘á»ƒ trÃ¡nh y % 5 != 0
			if (x % 5 == 0)
				Put8PixelCircleHalf(color, kernel, x, CommonExtensions.Round5(y));
		}
	}


	@Override
	public void Draw(Graphics2D graphics, Dashes dashes) {
		super.graphics = graphics;

		int x, y;
		int R = region.width / 2;
		Point kernel = new Point(region.x + R, region.y + R);
		kernel.x = CommonExtensions.Round5(kernel.x);
		kernel.y = CommonExtensions.Round5(kernel.y);

		x = 0;
		y = R;
		Put8PixelCircle(color, kernel, x, CommonExtensions.Round5(y));
		long p = 1 - R; // 5/4-R
		while (x < y) {
			if (p < 0)
				p += 2 * x + 3;
			else {
				p += 2 * (x - y) + 5;
				y--;
			}
			x++;
			// Round y láº¡i Ä‘á»ƒ trÃ¡nh y % 5 != 0
			if (x % 5 == 0)
				Put8PixelCircle(color, kernel, x, CommonExtensions.Round5(y));
		}
	}

	public String ToString() {
		Point worldKernel = CommonExtensions.ToWorldCoordinates(kernel);
		return null;
	}

	@Override
	public void TranslatingTransform(int trX, int trY) {
		region.setLocation(AnimationsExtension.Translating(region.getLocation(), trX, trY));
		kernel = AnimationsExtension.Translating(kernel, trX, trY);
	}

	@Override
	public void ScaleTransform(Point origin, double scaleX, double scaleY) {
		Radius *= scaleX;
		kernel = AnimationsExtension.Scale(kernel, origin, scaleX, scaleY);
		Point A = new Point(kernel.x - (int) Radius, kernel.y - (int) Radius);
		region = new Rectangle(A.x,A.y,(int) Radius * 2, (int) Radius * 2);/////////////////////////////////////// ?????????????
	}

	@Override
	public void RotateTransform(Point origin, Double angle) {
		// Quay tÃ¢m ellipse, ko pháº£i quay gÃ³c trÃ¡i
		// sai
		kernel = AnimationsExtension.Rotate(kernel, origin, angle);
		region.setLocation((kernel.x - CommonExtensions.Round5((region.width / 2))),
				(kernel.y) - CommonExtensions.Round5((region.height / 2)));

	}

	@Override
	public void OppositeTransform(Point origin, OppositeType oppositeType) {
		kernel = AnimationsExtension.Opposite(kernel, origin, oppositeType);
		region.setLocation((kernel.x - CommonExtensions.Round5((region.width / 2))),
				(kernel.y) - CommonExtensions.Round5((region.height / 2)));
	}
}