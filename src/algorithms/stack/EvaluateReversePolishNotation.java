package algorithms.stack;

import java.util.Stack;

/**
 * Created by Calabash on 2017/6/27.
 * Problem Number ： 150
 * Problem Name : Evaluate Reverse Polish Notation
 * Description : https://leetcode.com/problems/evaluate-reverse-polish-notation/#/description
 * Difficulty : Medium
 * Tags : Stack
 */
public class EvaluateReversePolishNotation {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 14ms
   */
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    int para1;
    int para2;
    int result;
    for (String token : tokens) {
      if (token.equals("+") || token.equals("-")  || token.equals("*") || token.equals("/") ) {
        para2 = stack.pop();
        para1 = stack.pop();
        result = calculate(para1, para2, token);
        stack.push(result);
      } else {
        stack.push(Integer.parseInt(token));
      }
    }
    return stack.pop();
  }

  private int calculate(int para1, int para2, String operator) {
    switch (operator) {
      case "+":
        return para1 + para2;
      case "-":
        return para1 - para2;
      case "*":
        return para1 * para2;
      default:
        return para1 / para2;
    }
  }
}
