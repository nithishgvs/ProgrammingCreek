package org.nithish.strings;

import java.util.Stack;

import javax.swing.plaf.multi.MultiButtonUI;

public class ReversePolishNotation {

	/*
	 * Evaluate the value of an arithmetic expression in Reverse Polish
	 * Notation. Valid operators are +, -, *, /. Each operand may be an integer
	 * or another expression. For example:
	 * 
	 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", "5", "/",
	 * "+"] -> (4 + (13 / 5)) -> 6
	 * 
	 */
	public static void ReversePolishNotationProgram(String[] array) {

		if (array.length == 0) {
			return;
		}
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < array.length; i++) {
			String operators = "+-/*";
			if (operators.contains(array[i])) {
				int intg1 = Integer.parseInt(stack.pop());
				int intg2 = Integer.parseInt(stack.pop());
				int result = 0;
				if (array[i].equals("+")) {
					result = intg2 + intg1;
				} else if (array[i].equals("-")) {
					result = intg2 - intg1;
				} else if (array[i].equals("*")) {
					result = intg2 * intg1;
				} else if (array[i].equals("/")) {
					result = intg2 / intg1;
				}
				stack.push(String.valueOf(result));
			} else {
				stack.push(array[i]);
			}

		}
		if (!stack.isEmpty()) {
			System.out.println("Outcome of Reverse Polish Notation: " + stack.pop());
		}

	}

	public static void main(String[] args) {
		String[] array = new String[] { "4", "13", "5", "/", "+" };
		ReversePolishNotationProgram(array);
		int[][] multD = new int[5][10];
        System.out.println(multD.length);
        System.out.println(multD[0].length);
        
	   
	}

}
