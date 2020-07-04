package clock;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Line extends Shape {
	public int Length;
	
	public Point A;
	public Point B;
	

	public int getLength() {
		return Length;
	}

	public void setLength(int length) {
		Length = length;
	}

	public Point getA() {
		return A;
	}

	public void setA(Point a) {
		A = a;
	}

	public Point getB() {
		return B;
	}

	public void setB(Point b) {
		B = b;
	}

	public Line(Point begin, Point end, Color color) {
		super(begin, end, color);
		
		this.A = begin;
		this.B = end;
		
		OnChangedLength();
	}

	private void Put8PixelsLine(Color color, Point start, int run, int follow, int dx, int dy) {
		if (dx >= dy && dx > 0 && dy >= 0)
			PutPixel(color, start.x + run, start.y + follow);
		else if (dx < dy && dx >= 0 && dy > 0)
			PutPixel(color, start.x + follow, start.y + run);
		else if (Math.abs(dx) < dy && dx <= 0 && dy > 0)
			PutPixel(color, start.x - follow, start.y + run);
		else if (Math.abs(dx) >= dy && dx < 0 && dy >= 0)
			PutPixel(color, start.x - run, start.y + follow);
		else if (Math.abs(dx) >= Math.abs(dy) && dx < 0 && dy <= 0)
			PutPixel(color, start.x - run, start.y - follow);
		else if (Math.abs(dx) < Math.abs(dy) && dx <= 0 && dy < 0)
			PutPixel(color, start.x - follow, start.y - run);
		else if (dx < Math.abs(dy) && dx >= 0 && dy < 0)
			PutPixel(color, start.x + follow, start.y - run);
		else if (dx >= Math.abs(dy) && dx > 0 && dy <= 0)
			PutPixel(color, start.x + run, start.y - follow);
	}

	private void OnChangedLength() {
		int x = Math.abs(begin.x - end.x);
		int y = Math.abs(begin.y - end.y);
		Length = (int) Math.sqrt(x * x + y * y);
		
		this.A = begin;
		this.B = end;
		
	}

	@Override
	public void Draw(Graphics2D graphics, Dashes dashes) {

		super.graphics = graphics;

		int dashLength = 2;
		int count = 0;

		int dx = end.x - begin.x;
		int dy = end.y - begin.y;
		
		this.A = begin;
		this.B = end;
		
		// int dRun = Math.Abs(dx) >= Math.Abs(dy) ? Math.Abs(dx) : Math.Abs(dy);
		int dRun = Math.max(Math.abs(dx), Math.abs(dy));
		// int dFollow = Math.Abs(dx) < Math.Abs(dy) ? Math.Abs(dx) : Math.Abs(dy);
		int dFollow = Math.min(Math.abs(dx), Math.abs(dy));
		int follow = 0;
		int p = 2 * dFollow - dRun;
		for (int run = 0; run <= dRun; run += 5) {
			if (dashes == Dashes.Dash) {
				if (count % (2 * dashLength) == 0)
					count = 0;
				if (count == 0 || count == 1) {
					Put8PixelsLine(color, begin, run, follow, dx, dy);
				}
				count++;
			} else {
				Put8PixelsLine(color, begin, run, follow, dx, dy);
			}

			if (p < 0)
				p += 2 * dFollow;
			else {
				follow += 5;
				p += 2 * (dFollow - dRun);
			}
		}
	}

	public String ToString() {
		Point worldBegin = CommonExtensions.ToWorldCoordinates(begin);
		Point worldEnd = CommonExtensions.ToWorldCoordinates(end);
		return null;
	}

	// Khi chạy hiệu ứng cần update lại Begin, End, [Length]
	@Override
	public void TranslatingTransform(int trX, int trY) {
		begin = AnimationsExtension.Translating(begin, trX, trY);
		end = AnimationsExtension.Translating(end, trX, trY);
	}

	@Override
	public void ScaleTransform(Point origin, double scaleX, double scaleY) {
		begin = AnimationsExtension.Scale(begin, origin, scaleX, scaleY);
		end = AnimationsExtension.Scale(end, origin, scaleX, scaleY);
		OnChangedLength();
	}

	@Override
	public void RotateTransform(Point origin, Double angle) {
		begin = AnimationsExtension.Rotate(begin, origin, angle);
		end = AnimationsExtension.Rotate(end, origin, angle);
	}

	@Override
	public void OppositeTransform(Point origin, OppositeType oppositeType) {
		begin = AnimationsExtension.Opposite(begin, origin, oppositeType);
		end = AnimationsExtension.Opposite(end, origin, oppositeType);
	}
}
