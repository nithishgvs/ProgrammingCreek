package org.nithish.arrays;

public class QuickSort {

	public static void QuickSortCode(int[] array, int low, int high) {
		if (low >= high) {
			return;
		}
		int l = low;
		int h = high;
		int mid = low + (high - low) / 2;
		int pivot = array[mid];
		while (l <= h) {
			while (array[l] < pivot) {
				l++;
			}
			while (array[h] > pivot) {
				h--;
			}
			if (l <= h) {
				int temp = array[h];
				array[h] = array[l];
				array[l] = temp;
				l++;
				h--;
			}
		}
		if (low < h) {
			QuickSortCode(array, low, h);
		}
		if (high > l) {
			QuickSortCode(array, l, high);
		}

	}

	public static void print(int[] listToSort) {
		for (int el : listToSort) {
			System.out.print(el + ",");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] array = { 5, 4, 8, 3, 2 };
		QuickSortCode(array, 0, array.length - 1);
		print(array);

	}

}
