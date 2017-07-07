package org.nithish.arrays;

public class SmallestElementKth {

	public static int getKth(int k, int[] nums, int start, int end) {

		int pivot = nums[end];

		int left = start;
		int right = end;

		while (true) {

			while (nums[left] < pivot && left < right) {
				left++;
			}

			while (nums[right] >= pivot && right > left) {
				right--;
			}

			if (left == right) {
				break;
			}

			swap(nums, left, right);
		}

		swap(nums, left, end);

		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}

	/**
	 * Hoares Algorithm for Quick Select
	 * 
	 * @param array
	 * @param k
	 */
	@SuppressWarnings("null")
	public static void QuickSelectAlgorithm(int k, int[] array, int low, int high) {
		int l = low;
		int h = high;
		int pivot = array[high];
		System.out.println("Pivot: " + pivot);
		while (true) {
			while (array[l] < pivot) {
				l++;
				System.out.println("l" + l);
			}
			while (array[h] > pivot) {
				h--;
				System.out.println("h" + h);
			}
			if (l == h) {
				break;
			}
			if (l < h) {
				int temp = array[l];
				array[l] = array[h];
				array[h] = temp;
			}
		}
		if (l + 1 == k) {
			System.out.println(k + "th Smallest Element: " + pivot);
			return;
		} else if (k < l + 1) {
			QuickSelectAlgorithm(k, array, low, l);
		} else {
			QuickSelectAlgorithm(k, array, l + 1, high);
		}
	}

	/**
	 * 
	 * @param array
	 * @param low
	 * @param high
	 */
	public static void QuickSort(int[] array, int low, int high) {
		if (low >= high) {
			return;
		}
		int l = low;
		int h = high;
		int mid = low + (high - low) / 2;
		int pivot = array[mid];
		System.out.println("Pivot: " + pivot);
		while (l <= h) {
			while (array[l] < pivot) {
				l++;
				System.out.println("l" + l);
			}
			while (array[h] > pivot) {
				h--;
				System.out.println("h" + h);
			}
			if (l <= h) {
				int temp = array[l];
				array[l] = array[h];
				array[h] = temp;
				l++;
				h--;
			}
		}
		if (low < h)
			QuickSort(array, low, h);
		if (high > l)
			QuickSort(array, l, high);

	}

	public static void print(int[] listToSort) {
		for (int el : listToSort) {
			System.out.print(el + ",");
		}
		System.out.println();
	}


	public static void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}

	public static void main(String[] args) {
		int[] array = { 7, -2, 8, 5, 1, 6 };
		int[] array2 = { 6, 5, 4, 3, 2, 1 };
		int[] int_array = { 8, 7, 6, -100, 3, 4, 12, 15, -10, 666 };
		// QuickSort(int_array, 0, int_array.length - 1);
		System.out.println();
		QuickSelectAlgorithm(2, array2, 0, array2.length - 1);
		// /print(int_array);
		// /QuickSelectAlgorithm(2,array2, 0,array2.length-1);
	}

}
