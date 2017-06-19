package org.nithish.strings;

public class MinimumEditDistanceDP {

	public static int MinEditDistanceTwoStrings(char[] str1, char[] str2) {
		if (str1.length != str2.length) {
			System.out.println("There is no Min Distance b/w" + str1 + "," + str2);
			return 0;
		}
		int[][] matrix = new int[str1.length + 1][str2.length + 1];

		for (int i = 0; i < matrix[0].length; i++) {
			matrix[0][i] = i;
		}

		for (int i = 0; i < matrix.length; i++) {
			matrix[i][0] = i;
		}

		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					matrix[i][j] = matrix[i - 1][j - 1];
				} else {
					matrix[i][j] = 1 + Math.min(matrix[i - 1][j - 1], Math.min(matrix[i][j - 1], matrix[i - 1][j]));
				}
			}
		}

		return matrix[str1.length][str2.length];
	}

	public static void main(String[] args) {
		String str1 = "hit";
		String str2 = "cog";
		System.out.println(MinEditDistanceTwoStrings(str1.toCharArray(), str2.toCharArray()));

	}

}
