package clock;
public class MatrixTransform {
	public double[][] TranslatingMatrix = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
	public double[][] RotateMatrix = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
	public double[][] ScaleMatrix = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
	public double[][] HorizontalOppositeMatrix = { { 1, 0, 0 }, { 0, -1, 0 }, { 0, 0, 1 } };
	public double[][] VerticalOppositeMatrix = { { -1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
	public double[][] OriginCoordinatesOppositeMatrix = { { -1, 0, 0 }, { 0, -1, 0 }, { 0, 0, 1 } };

	public void GenerateTranslatingMatrix(int trX, int trY) {
		TranslatingMatrix[2][0] = trX;
		TranslatingMatrix[2][1] = trY;
	}

	/// Khoi tao ma tran Rotate

	public void GenerateRotateMatrix(double angle) {
		double temp = Math.PI * angle / 180;
		RotateMatrix[0][0] = Math.cos(temp);
		RotateMatrix[0][1] = Math.sin(temp);
		RotateMatrix[1][0] = -RotateMatrix[0][1];
		RotateMatrix[1][1] = RotateMatrix[0][0];
	}

	/// Khoi tao ma tran Scale

	public void GenerateScaleMatrix(double scaleX, double scaleY) {
		ScaleMatrix[0][0] = scaleX;
		ScaleMatrix[1][1] = scaleY;
	}
}
