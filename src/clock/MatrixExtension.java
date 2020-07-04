package clock;

public class MatrixExtension {

	/// <summary>
	/// Nhân 2 ma trận matrix1 và matrix2
	/// </summary>
	/// <param name="matrix1"></param>
	/// <param name="matrix2"></param>
	/// <returns>Ma trận sau khi nhân</returns>
	public static double[][] MultiplicationWithMatrix(double[][] matrix1, double[][] matrix2) {
		int rowOfMatrix1 = matrix1.length;
		int colOfMatrix1 = matrix1[0].length;
		int rowOfMatrix2 = matrix2.length;
		int colOfMatrix2 = matrix2[0].length;

		int rowResultMatrix = rowOfMatrix1;
		int colResultMatrix = colOfMatrix2;
		double[][] resultMatrix = new double[rowResultMatrix][colResultMatrix];

		double sum;
		for (int row = 0; row < rowResultMatrix; row++) {
			for (int col = 0; col < colResultMatrix; col++) {
				sum = 0;
				for (int k = 0; k < colOfMatrix1; k++) {
					sum += matrix1[row][k] * matrix2[k][col];
				}
				resultMatrix[row][col] = sum;
			}
		}

		return resultMatrix;
	}
	
}
