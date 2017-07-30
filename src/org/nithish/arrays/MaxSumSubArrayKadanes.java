package org.nithish.arrays;

public class MaxSumSubArrayKadanes {

	public static void MaxSumSubArray(int[] array) {
		int start = 0, end = 0;
		int s = 0;
		int max_ending_here = 0;
		int max_so_far = array[0];
		for (int i = 0; i < array.length; i++) {
			max_ending_here = max_ending_here + array[i];
			if (max_ending_here > max_so_far) {
				start = s;
				end = i;
				max_so_far = max_ending_here;
			}
			if (max_ending_here < 0) {
				s = i + 1;
				max_ending_here = 0;
			}
		}
		System.out.println("Max So far: " + max_so_far);
		System.out.println("Start: " + start + " Ending: " + end);

	}

	public static void main(String[] args) {
		int[] array = { 4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 1, 2 };
		MaxSumSubArray(array);

	}

}
