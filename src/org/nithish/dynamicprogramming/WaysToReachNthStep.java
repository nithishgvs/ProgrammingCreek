package org.nithish.dynamicprogramming;

public class WaysToReachNthStep {
	public int findWays(int stair) {
		if (stair < 0) {
			return 0;
		}
		if (stair == 0) {
			return 1;
		}
		if (stair == 1) {
			return 1;
		} else {
			return findWays(stair - 1) + findWays(stair - 2);
		}
	}

	public static void main(String args[]) {
		WaysToReachNthStep noOfWays = new WaysToReachNthStep();
		System.out.println("No of ways");
		System.out.println(noOfWays.findWays(4));

	}
}
