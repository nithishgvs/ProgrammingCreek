package org.nithish.dynamicprogramming;

import java.util.*;

public class Coin_Change {

	public static void CoinChangeProblem(ArrayList<Integer> coins, int sum) {
		int[][] matrix = new int[coins.size() + 1][sum + 1];

		System.out.println("X coordinate: " + matrix.length);
		System.out.println("Y coordinate: " + matrix[0].length);
		// Hypothetical -Vivek Says
		matrix[0][0] = 1;

		for (int i = 1; i < coins.size() + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (coins.get(i - 1) > j) {
					matrix[i][j] = matrix[i - 1][j];
				} else {
					matrix[i][j] = matrix[i - 1][j] + matrix[i][j - coins.get(i - 1)];
				}
			}
		}
		System.out.println(matrix[coins.size()][sum]);

	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(5);
		CoinChangeProblem(list, 7);

	}

}
