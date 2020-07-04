package clock;
import java.awt.Point;
import java.awt.Rectangle;

public class CommonExtensions {
	/// <summary>
	/// Làm tròn thành tọa độ 5px
	/// </summary>
	/// <param name="value"></param>
	/// <returns>Tọa độ đã đc làm tròn</returns>
	
	public static int Round5(int value) {
		int newValue;
		double sodu = value % 5;
		if (sodu != 0) {
			if (sodu >= 3)
				newValue = (int) (value + 5 - sodu);
			else
				newValue = (int) (value - sodu);
		} else
			newValue = value;
		return newValue;
	}

	public static double[][] Round5(double[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = Round5((int) (Math.round(matrix[i][j])));
			}
		}
		return matrix;
	}
	

	public static Point ToWorldCoordinates(Point computerCoordinates) {
		int width = Cons.WIDTH;
		int height = Cons.HEIGHT;
		return new Point((computerCoordinates.x - (width / 2)) / 5, ((height / 2) - computerCoordinates.y) / 5);
	}

	public static Point ToComputerCoordinates(Point worldCoordinates) {

		int width = Cons.WIDTH;
		int height = Cons.HEIGHT;
		return new Point(worldCoordinates.x * 5 + (width / 2), (height / 2) - worldCoordinates.y * 5);
	}

	public static Rectangle ToWorldRectangle(Rectangle computerRectangle) {
		int width = Cons.WIDTH;
		int height = Cons.HEIGHT;
		computerRectangle.width /= 5;
		computerRectangle.height /= 5;
		computerRectangle.setLocation(ToWorldCoordinates(computerRectangle.getLocation()));
		return computerRectangle;
	}

	public static Rectangle ToComputerRectangle(Rectangle computerRectangle) {
		int width = Cons.WIDTH;
		int height = Cons.HEIGHT;
		computerRectangle.width *= 5;
		computerRectangle.height *= 5;
		computerRectangle.setLocation(ToComputerCoordinates(computerRectangle.getLocation()));
		return computerRectangle;
	}


}
