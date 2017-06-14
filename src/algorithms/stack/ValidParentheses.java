package algorithms.stack;

import java.util.Stack;

/**
 * Created by Calabash on 2017/6/10.
 * Problem Number : 20
 * Problem Name : Valid Parentheses
 * Description : https://leetcode.com/problems/valid-parentheses/#/description
 * Difficulty : Easy
 * Tags : Stack, String
 */
public class ValidParentheses {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 11ms
   */
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
        stack.push(s.charAt(i));
      } else if (stack.empty()){
        return false;
      } else if (s.charAt(i) == ')') {
        if (stack.pop() != '(') {
          return false;
        }
      } else if (s.charAt(i) == ']') {
        if (stack.pop() != '[') {
          return false;
        }
      } else if (s.charAt(i) == '}') {
        if (stack.pop() != '{') {
          return false;
        }
      }
    }
    return stack.empty();
  }
}
