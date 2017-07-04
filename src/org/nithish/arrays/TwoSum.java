package org.nithish.arrays;

import java.util.HashMap;

public class TwoSum {
	/**
	 * Two Sum for Sorted Array
	 * 
	 * @param array
	 * @param sum
	 * @return
	 */
	private static int[] twoSumSortedArray(int[] array, int sum) {
		if (array.length < 2) {
			return null;
		}
		int l = 0;
		int h = array.length - 1;
		int[] intArray = new int[2];
		while (l < h) {
			int target = array[l] + array[h];
			if (target > sum) {
				h--;
			} else if (target < sum) {
				l++;
			} else {
				intArray[0] = l;
				intArray[1] = h;
				return intArray;
			}
		}
		return intArray;
	}

	/**
	 * Two Sum Unsorted Array
	 * 
	 * @param array
	 * @param sum
	 * @return
	 */
	private static int[] twoSumUnSortedArray(int[] array, int sum) {
		if (array.length < 2) {
			return null;
		}
		int[] intArray = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (!map.containsKey(sum - array[i])) {
				map.put(array[i], i);
			} else if (map.containsKey(sum - array[i])) {
				intArray[0] = map.get(sum - array[i]);
				intArray[1] = i;
				return intArray;
			}

		}
		return intArray;
	}

	public static void main(String[] args) {
		int[] array = { 2, 7, 11, 15 };
		int[] result = twoSumUnSortedArray(array, 18);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}

}
