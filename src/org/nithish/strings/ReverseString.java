package org.nithish.strings;

public class ReverseString {

	public static String StringReverse(String str) {
		if (str.length() == 0 || str == null) {
			return new String("");
		} else {
			String sub = str.substring(str.length() - 1);
			return sub + StringReverse(str.substring(0, str.length() - 1));
		}

	}

	public static void main(String[] args) {
		String str = new String("I am a boy");
		System.out.println(StringReverse(str));

	}

}
