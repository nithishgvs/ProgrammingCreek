package org.nithish.arrays;

import java.util.Arrays;

public class RotateArray {

	/*
	 * Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7 Output:arr[] = [3, 4, 5,
	 * 6, 7, 1, 2]
	 */
	public static void RotatingArrayRightTwoLoops(int[] array, int K) {

		for (int i = 0; i < K; i++) {
			rotateByOne(array);
		}
		PrintArray(array);

	}

	private static void rotateByOne(int[] array) {
		int temp = array[0];
		int i;
		for (i = 0; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		array[i] = temp;
	}

	public static <T> void RotatingArrayRightByChopping(int[] array, int K) {

		int[] subArray1 = Arrays.copyOfRange(array, K, array.length);
		int[] subArray2 = Arrays.copyOfRange(array, 0, K);
		int[] result = Arrays.copyOf(subArray1, subArray1.length + subArray2.length);
		System.arraycopy(subArray2, 0, result, subArray1.length, subArray2.length);
		PrintArray(result);

	}

	private static void PrintArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "->");
		}
		System.out.println();

	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		RotatingArrayRightTwoLoops(array, 2);
		RotatingArrayRightByChopping(array, 2);

	}

}
