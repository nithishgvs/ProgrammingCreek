package org.nithish.strings;

import java.util.ArrayList;

public class Palindrome_Programs {

	public static boolean isPalindrome(String str) {
		System.out.println(str);
		if (str == null || str.length() < 2) {
			return false;
		}
		int l = 0;
		int h = str.length() - 1;
		while (l < h) {
			if (str.charAt(l) == str.charAt(h)) {
				h--;
				l++;
			} else {
				return false;
			}
			if (l == h) {
				System.out.println("Odd Length Palindrome");
				return true;
			}
		}
		if (l > h) {
			System.out.println("Even Length Palindrome");
			return true;
		}

		return false;
	}

	public static boolean validPalindrome(String str) {
		str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.println(str);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void CheckAllPalindromes(String str) {
		if (str == null || str.length() < 2) {
			return;
		}
		ArrayList<String> stringList = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			int h = str.length() - 1;
			while (i < h) {
				if (str.charAt(i) == str.charAt(h)) {
					if (isPalindrome(str.substring(i, h + 1))) {
						stringList.add(str.substring(i, h + 1));
					}
					break;
				} else {
					h--;
				}
			}
		}
		for (String s : stringList) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		String s = "MADAM";
		System.out.println(validPalindrome(s));
		CheckAllPalindromes("ABAYYCDDC");

	}

}
