package org.nithish.arrays;

public class NoOfIslands {

	public static boolean isSafe(int[][] matrix, int row, int col, boolean[][] visited) {

		if ((row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[0].length)
				&& (matrix[row][col] == 1 && !visited[row][col])) {
			return true;
		}

		return false;
	}

	// A utility function to do DFS for a 2D boolean matrix.
	// It only considers the 8 neighbors as adjacent vertices
	public static void DFS(int[][] matrix, boolean[][] visited, int i, int j) {

		// These arrays are used to get row and column numbers
		// of 8 neighbors of a given cell
		int rowNbr[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

		// Mark this cell as visited
		visited[i][j] = true;

		// Recursion for all connected neighbours
		for (int k = 0; k < rowNbr.length; k++) {
			if (isSafe(matrix, i + rowNbr[k], j + colNbr[k], visited)) {
				DFS(matrix, visited, i + rowNbr[k], j + colNbr[k]);
			}

		}
	}

	public static void countIslands(int[][] matrix, boolean[][] visited) {
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == 1 && !visited[i][j]) {
					DFS(matrix, visited, i, j);
					count++;
				}
			}
		}
		System.out.println("Count of Islands: " + count);

	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];

		countIslands(matrix, visited);

	}

}
