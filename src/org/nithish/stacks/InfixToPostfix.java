package org.nithish.stacks;

import java.util.Stack;

/**
 * 
 * @author nithishgvs
 *
 */
public class InfixToPostfix {

	/**
	 * 
	 * @param infix
	 * @return
	 */
	public static String convertInfixToPostfix(String infix) {
		StringBuffer postfixString = new StringBuffer();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < infix.length(); i++) {
			char fromInfix = infix.charAt(i);
			if (!isOperator(fromInfix)) {
				postfixString.append(fromInfix);
			} else {
				if (!stack.isEmpty()) {
					Character top = stack.peek();
					if (findPrecedence(top, fromInfix)) {
						while (!stack.isEmpty()) {
							postfixString.append(stack.pop());
						}
						stack.push(fromInfix);
					} else {
						stack.push(fromInfix);
					}
				} else {
					stack.push(fromInfix);
				}
			}

		}
		while (!stack.isEmpty()) {
			postfixString.append(stack.pop());
		}
		return postfixString.toString();
	}

	public static boolean findPrecedence(char c1, char c2) {

		if ((c1 == '*' && c2 == '+')) {
			return true;
		} else if ((c1 == '*' && c2 == '-')) {
			return true;
		} else if ((c1 == '/' && c2 == '+')) {
			return true;
		} else if ((c1 == '/' && c2 == '-')) {
			return true;
		}

		return false;
	}

	public static boolean isOperator(char c1) {

		switch (c1) {
		case '*':
			return true;
		case '/':
			return true;
		case '+':
			return true;
		case '-':
			return true;
		default:
			return false;

		}

	}

	public static void main(String[] args) {
		System.out.println(findPrecedence('+', '/'));
		System.out.println(isOperator('+'));
		System.out.println(convertInfixToPostfix("2*3-4/5"));
		// a+b*c-d
		System.out.println(convertInfixToPostfix("a+b*c-d"));

	}

}
