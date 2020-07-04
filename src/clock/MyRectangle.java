package clock;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class MyRectangle extends Shape {
	public Point A;
	public Point B;
	public Point C;
	public Point D;
	public double Width;
	public double Height;
	private ArrayList<Line> lines;

	public MyRectangle(Rectangle rect, Color color) {
		super(rect, color);
		lines = new ArrayList<Line>();
		OnChangedRegionValue();
		Width = Math.abs(B.x - A.x);
		Height = Math.abs(D.y - A.y);
	}

	/// <summary>
	/// Update lại giá trị đỉnh ABCD Width Height sau khi Region bị thay đổi
	/// </summary>
	private void OnChangedRegionValue() {
		// code chỗ này hơi ngu => sửa sau
		A = new Point(region.x, region.y);
		B = new Point(region.x + region.width, region.y);
		C = new Point(region.x + region.width, region.y + region.height);
		D = new Point(region.x, region.y + region.height);
		// Khi new 1 line thì Begin và End truyền vô sẽ được chuyển sang tọa độ máy
		// mà ABCD đã là tọa độ máy => cần chuyển về tọa độ ng dùng
		Point worldA = CommonExtensions.ToWorldCoordinates(A);
		Point worldB = CommonExtensions.ToWorldCoordinates(B);
		Point worldC = CommonExtensions.ToWorldCoordinates(C);
		Point worldD = CommonExtensions.ToWorldCoordinates(D);
		lines.clear();
		lines.add(new Line(worldA, worldB, color));
		lines.add(new Line(worldA, worldD, color));
		lines.add(new Line(worldD, worldC, color));
		lines.add(new Line(worldB, worldC, color));
	}

	@Override
	public void Draw(Graphics2D graphics, Dashes dashes) {
		for (Line line : lines) {
			line.Draw(graphics, dashes);
		}
	}

	public String ToString() {
		double worldWidth = Width / 5;
		double worldHeight = Height / 5;
		Point worldKernel = CommonExtensions.ToWorldCoordinates(kernel);
		Point worldA = CommonExtensions.ToWorldCoordinates(A);
		Point worldB = CommonExtensions.ToWorldCoordinates(B);
		Point worldC = CommonExtensions.ToWorldCoordinates(C);
		Point worldD = CommonExtensions.ToWorldCoordinates(D);

		return null;
	}

	@Override
	public void TranslatingTransform(int trX, int trY) {
		region.setLocation(AnimationsExtension.Translating(region.getLocation(), trX, trY));
		kernel = AnimationsExtension.Translating(kernel, trX, trY);

		A = AnimationsExtension.Translating(A, trX, trY);
		B = AnimationsExtension.Translating(B, trX, trY);
		C = AnimationsExtension.Translating(C, trX, trY);
		D = AnimationsExtension.Translating(D, trX, trY);
		Point worldA = CommonExtensions.ToWorldCoordinates(A);
		Point worldB = CommonExtensions.ToWorldCoordinates(B);
		Point worldC = CommonExtensions.ToWorldCoordinates(C);
		Point worldD = CommonExtensions.ToWorldCoordinates(D);
		lines.clear();
		lines.add(new Line(worldA, worldB, color));
		lines.add(new Line(worldA, worldD, color));
		lines.add(new Line(worldD, worldC, color));
		lines.add(new Line(worldB, worldC, color));
	}

	@Override
	public void ScaleTransform(Point origin, double scalex, double scaley) {
		Width *= scalex;
		Height *= scaley;
		A = AnimationsExtension.Scale(A, origin, scalex, scaley);
		kernel = AnimationsExtension.Scale(kernel, origin, scalex, scaley);
		region = new Rectangle(A.x, A.y, (int) Width, (int) Height);////////////////////////////////////////// ????????????????????????
		OnChangedRegionValue();
	}

	@Override
	public void RotateTransform(Point origin, Double angle) {
		region.setLocation(AnimationsExtension.Rotate(region.getLocation(), origin, angle));
		kernel = AnimationsExtension.Rotate(kernel, origin, angle);

		A = AnimationsExtension.Rotate(A, origin, angle);
		B = AnimationsExtension.Rotate(B, origin, angle);
		C = AnimationsExtension.Rotate(C, origin, angle);
		D = AnimationsExtension.Rotate(D, origin, angle);
		Point worldA = CommonExtensions.ToWorldCoordinates(A);
		Point worldB = CommonExtensions.ToWorldCoordinates(B);
		Point worldC = CommonExtensions.ToWorldCoordinates(C);
		Point worldD = CommonExtensions.ToWorldCoordinates(D);

		lines.clear();
		lines.add(new Line(worldA, worldB, color));
		lines.add(new Line(worldA, worldD, color));
		lines.add(new Line(worldD, worldC, color));
		lines.add(new Line(worldB, worldC, color));
	}

	@Override
	public void OppositeTransform(Point origin, OppositeType oppositeType) {
		kernel = AnimationsExtension.Opposite(kernel, origin, oppositeType);
		region.setLocation((kernel.x - CommonExtensions.Round5(region.width / 2)),
				kernel.y - CommonExtensions.Round5((region.height / 2)));
		OnChangedRegionValue();
	}
}
