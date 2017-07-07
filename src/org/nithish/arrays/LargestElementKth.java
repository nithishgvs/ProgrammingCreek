package org.nithish.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestElementKth {

	/**
	 * Find Kth Largest Element in Unsorted array
	 * 
	 * @param array
	 * @param k
	 */
	public static void findKthLargestMinHeap(int[] array, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer int1, Integer int2) {
				return int2 - int1;
			}
		});
		for (Integer i : array) {
			maxHeap.add(i);
		}
		int i = 1;
		while (i < k) {
			maxHeap.poll();
			i++;
		}
		System.out.println(maxHeap.peek());
	}

	public static void main(String[] args) {
		int[] array = { 2, 0, 1, 3, 4, 6, 7, 99 };
		findKthLargestMinHeap(array, 3);

	}

}
