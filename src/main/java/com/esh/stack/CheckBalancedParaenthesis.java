package com.esh.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. Push opening brackets to stack 2. If next bracket is closing bracket, pop
 * element from stack and check if braces are matching. 3. If stack is not empty
 * it is not balanced paranethesis.
 *
 */
public class CheckBalancedParaenthesis {
	ArrayStack<String> stack;
	List<String> openingBrackets = new ArrayList<>(Arrays.asList("{", "[", "("));
	List<String> closingBrackets = new ArrayList<>(Arrays.asList("}", "]", ")"));
	Map<String, String> bracketPair = new HashMap<>();

	CheckBalancedParaenthesis() {
		bracketPair.put("{", "}");
		bracketPair.put("(", ")");
		bracketPair.put("[", "]");
	}

	public boolean isValidExpr(String expr) throws Exception {
		stack = new ArrayStack<>();
		boolean isValidExpr = true;
		char[] brackets = expr.toCharArray();
		for (char ch : brackets) {
			String chStr = ch + "";
			if (openingBrackets.contains(chStr)) {
				stack.push(chStr);
			} else {
				String openingBracket = stack.pop();
				if (!chStr.equals(bracketPair.get(openingBracket))) {
					isValidExpr = false;
					break;
				}
			}
		}
		return isValidExpr && stack.isEmpty();
	}

	public static void main(String[] args) throws Exception {
		CheckBalancedParaenthesis cp = new CheckBalancedParaenthesis();
		String[] expression = { "{[", "{[}]","{(){}[{}]}" };
		for (String expr : expression) {
			System.out.println("Expr: " + expr + " " + cp.isValidExpr(expr));
		}
	}

}
