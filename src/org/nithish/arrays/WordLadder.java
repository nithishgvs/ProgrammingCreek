package org.nithish.arrays;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static int WorldLadderCountSteps(String source, String target, Set<String> dictionary) {
		String s = source;
		String t = target;
		int noOfSteps = 0;
		Queue<String> queue = new LinkedList<String>();
		queue.add(s);
		Iterator<String> itr = dictionary.iterator();
		//String str = queue.poll();
		while (itr.hasNext()) {
			String str = queue.peek();
			String temp = itr.next();
			if(adjacentWordDistance(t, str)){
				return noOfSteps;
			}
			if (adjacentWordDistance(str, temp)) {
				itr.remove();
				queue.poll();
				queue.add(temp);
				System.out.println(str+temp);
				noOfSteps++;
			}

		}

		return noOfSteps;
	}

	public static boolean adjacentWordDistance(String str1, String str2) {
		int count = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (!(str1.charAt(i) == str2.charAt(i))) {
				count++;
			}
		}
		return count == 1 ? true : false;
	}

	public static void main(String[] args) {
		String[] strArray = { "hot", "dot", "dog", "lot", "log" };
		Set<String> hashSet = new HashSet<>();
		for (int i = 0; i < strArray.length; i++) {
			hashSet.add(strArray[i]);
		}
		WorldLadderCountSteps("hit","cog",hashSet);
	}

}
