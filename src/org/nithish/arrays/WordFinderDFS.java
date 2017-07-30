package org.nithish.arrays;

public class WordFinderDFS {

	public static void main(String[] args) {
		char[][] matrix = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		boolean[][] box = new boolean[matrix.length][matrix[0].length];
		findWordInMatrix(matrix, word, box);

	}

	private static boolean findWordInMatrix(char[][] matrix, String word, boolean[][] box) {
		int x = matrix.length;
		int y = matrix[0].length;

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (DFS(matrix, i, j, 0, box, word)) {
					System.out.println("Found");
					return true;
				}
			}
		}
		return false;
	}

	private static boolean DFS(char[][] matrix, int i, int j, int k, boolean[][] box, String word) {
		int x = matrix.length;
		int y = matrix[0].length;

		if (i < 0 || j < 0 || i >= x || j >= y) {
			return false;
		}
		if (matrix[i][j] == word.charAt(k) && !box[i][j]) {
			box[i][j] = true;
			if (k == word.length() - 1) {
				return true;
			} else if (DFS(matrix, i, j + 1, k + 1, box, word) || DFS(matrix, i, j - 1, k + 1, box, word)
					|| DFS(matrix, i - 1, j, k + 1, box, word) || DFS(matrix, i + 1, j, k + 1, box, word)) {
				return true;
			}
		}
		return false;
	}

}
