package org.nithish.dynamicprogramming;

public class LongestCommonSubsequence {

	public static void longestCommonSubsequence(String string1, String string2) {
		
		int[][] matrix = new int[string1.length() + 1][string2.length() + 1];
		
		for (int i = 1; i <= string1.length(); i++) {
			for (int j = 1; j <= string2.length(); j++) {
				if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				} else {
					matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
				}
			}
		}
		
		System.out.print("The Length of Longest Common Subsequence: ");
		System.out.println(matrix[string1.length()][string2.length()]);
	}

	public static void main(String[] args) {
		longestCommonSubsequence("abcvdefgh", "bqdrcvefgh");

	}

}
