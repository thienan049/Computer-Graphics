package clock;
import java.awt.Point;

public class AnimationsExtension {
	public static Point Translating(Point point, int trX, int trY)
	{
		trY = -trY;
		MatrixTransform trans = new MatrixTransform();
		
		// Truyền vào trX và trY để get ma trận Move
		trans.GenerateTranslatingMatrix(trX * 5, trY * 5);
		double[][] matrixOfPoint = ToMatrix(point);
		// Thực hiện nhân với ma trận move
//		double[][] resultMatrix = matrixOfPoint.MultiplicationWithMatrix(trans.TranslatingMatrix);
		double[][] resultMatrix = MatrixExtension.MultiplicationWithMatrix(matrixOfPoint,trans.TranslatingMatrix);
		// Trả về tọa độ điểm mới
		return ToPoint(resultMatrix);
	}
	/// <summary>
	/// Biến đổi Rotate trường hợp tổng quát (quay quanh 1 điểm bất kỳ)
	/// </summary>
	/// <param name="point">Điểm cần quay</param>
	/// <param name="origin">Gốc tọa độ (0, 0) hoặc điểm bất kỳ</param>
	/// <param name="alpha">Góc quay</param>
	/// <returns>Tọa độ điểm sau khi Rotate quanh 1 điểm bất kỳ</returns>
	public static Point Rotate(Point point, Point origin, Double angle)
	{
		MatrixTransform trans = new MatrixTransform();
		// Tạo ma trận move về gốc tọa độ
		trans.GenerateTranslatingMatrix(-origin.x, -origin.y);
		// Tạo ma trận rotate
		trans.GenerateRotateMatrix(angle);
		double[][] matrixOfPoint = ToMatrix(point);
		// Tịnh tiến về Origin(0, 0) và thực hiện Rotate
		double[][] resultMatrix = MatrixExtension.MultiplicationWithMatrix(matrixOfPoint,trans.TranslatingMatrix);
		resultMatrix = MatrixExtension.MultiplicationWithMatrix(resultMatrix,trans.RotateMatrix);
		// Tạo ma trận move về tọa độ ban đầu
		trans.GenerateTranslatingMatrix(origin.x, origin.y);
		// Thực hiện biến đổi
		resultMatrix = MatrixExtension.MultiplicationWithMatrix(resultMatrix,trans.TranslatingMatrix);
		// Trả về tọa độ điểm mới
		return ToPoint(CommonExtensions.Round5(resultMatrix));
	}
	/// <summary>
	/// Thực hiện đối xứng qua 1 điểm bất kỳ
	/// </summary>
	/// <param name="point">Điểm cần đối xứng</param>
	/// <param name="origin">Điểm chọn làm tâm đối xứng</param>
	/// <param name="oppositeType">Kiểu đối xứng</param>
	/// <returns>Tọa độ điểm sau khi đối xứng</returns>
	public static Point Opposite(Point point, Point origin, OppositeType oppositeType)
	{
		MatrixTransform trans = new MatrixTransform();
		// Tạo ma trận move về gốc tọa độ
		trans.GenerateTranslatingMatrix(-origin.x, -origin.y);
		double[][] matrixOfPoint = ToMatrix(point);
		double[][] oppositeMatrix = new double[3][3];
		// Get opposite matrix
//		
		switch(oppositeType)
		{
			case HorizontalAxis:
				oppositeMatrix = trans.HorizontalOppositeMatrix;
				break;
			case VerticalAxis:
				oppositeMatrix = trans.VerticalOppositeMatrix;
				break;
			default:
				oppositeMatrix = trans.OriginCoordinatesOppositeMatrix;
				break;
		}
		double[][] resultMatrix = MatrixExtension.MultiplicationWithMatrix(MatrixExtension.MultiplicationWithMatrix(matrixOfPoint,trans.TranslatingMatrix),oppositeMatrix);
		// Tạo ma trận move về tọa độ ban đầu
		trans.GenerateTranslatingMatrix(origin.x, origin.y);
		// Thực hiện biến đổi
		resultMatrix = MatrixExtension.MultiplicationWithMatrix(resultMatrix,trans.TranslatingMatrix);
		// Trả về tọa độ điểm mới
		return ToPoint(resultMatrix);
	}
	/// <summary>
	/// Thực hiện scale 1 điểm theo tâm scale
	/// </summary>
	/// <param name="point">Điểm cần scale</param>
	/// <param name="origin">Tâm scale</param>
	/// <param name="scaleX">Tỷ lệ theo trục hoành</param>
	/// <param name="scaleY">Tỷ lệ theo trục tung</param>
	/// <returns>Tọa độ điểm sau khi scale</returns>
	public static Point Scale(Point point, Point origin, double scaleX, double scaleY)
	{
		MatrixTransform trans = new MatrixTransform();
		// Tạo ma trận move về gốc tọa độ
		trans.GenerateTranslatingMatrix(-origin.x, -origin.y);
		// Tạo ma trận scale
		trans.GenerateScaleMatrix(scaleX, scaleY);
		double[][] matrixOfPoint = ToMatrix(point);
		double[][] resultMatrix = MatrixExtension.MultiplicationWithMatrix(MatrixExtension.MultiplicationWithMatrix(matrixOfPoint,trans.TranslatingMatrix),trans.ScaleMatrix);
		// Tạo ma trận move về tọa độ ban đầu
		trans.GenerateTranslatingMatrix(origin.x, origin.y);
		// Thực hiện biến đổi
		resultMatrix = MatrixExtension.MultiplicationWithMatrix(resultMatrix,trans.TranslatingMatrix);
		// Trả về tọa độ điểm mới
		return ToPoint(resultMatrix);
	}

	/// <summary>
	/// Chuyển tọa độ điểm thành ma trận 1x3
	/// </summary>
	/// <param name="point"></param>
	/// <returns></returns>
	private static double[][] ToMatrix(Point point)
	{
		return new double[][] { { point.x, point.y, 1 } };
	}
	/// <summary>
	/// Chuyển ma trận 1x3 thành điểm
	/// </summary>
	/// <param name="matrix"></param>
	/// <returns></returns>
	private static Point ToPoint(double[][] matrix)
	{
		return new Point((int)matrix[0][0],(int)matrix[0][1]);
	}
}
