package org.nithish.strings;

import java.util.HashMap;

public class IsomorphicStrings {

	public static boolean IsomorphicStringsHelper(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		}
		HashMap<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			if (map.containsKey(s1.charAt(i))) {
				if (map.get(s1.charAt(i)) != s2.charAt(i)) {
					return false;
				}
			} else {
				map.put(s1.charAt(i), s2.charAt(i));
			}
		}

		return true;

	}

	public static void main(String[] args) {
		IsomorphicStringsHelper("aac", "xyz");

	}

}
