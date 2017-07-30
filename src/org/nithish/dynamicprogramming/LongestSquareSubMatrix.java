package org.nithish.dynamicprogramming;

public class LongestSquareSubMatrix {

	public static void LongestSquareMatrix(int[][] matrix) {
		int[][] tempMatrix = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix[0].length; i++) {
			tempMatrix[0][i] = matrix[0][i];
		}
		for (int i = 0; i < matrix.length; i++) {
			tempMatrix[i][0] = matrix[i][0];
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					tempMatrix[i][j] = Math.min(Math.min(tempMatrix[i][j - 1], tempMatrix[i - 1][j - 1]),
							tempMatrix[i - 1][j]) + 1;
				} else {
					tempMatrix[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };
		int[][] sub = { { 1, 1, 0, 1, 1 }, { 0, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 0 } };
		LongestSquareMatrix(sub);

	}

}
