package algorithms.dp;

import java.util.Stack;

/**
 * Created by Calabash on 2017/6/30.
 * Problem Number : 32
 * Problem Name : Longest Valid Parentheses
 * Description : https://leetcode.com/problems/longest-valid-parentheses/#/description
 * Difficulty : Hard
 * Tags : Dynamic Programming, String
 */
public class LongestValidParentheses {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 29ms
   * Note : Stack
   */
  public int longestValidParentheses(String s) {
        Stack<Integer> stackOfIndex = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stackOfIndex.isEmpty() && s.charAt(i) == ')' &&
                s.charAt(stackOfIndex.peek()) == '(') {
                stackOfIndex.pop();
            } else {
                stackOfIndex.push(i);
            }
        }
        int length = 0;
        int end = s.length();
        while (!stackOfIndex.isEmpty()) {
            length = Math.max(length, end - stackOfIndex.peek() - 1);
            end = stackOfIndex.pop();
        }
        return Math.max(length, end);
    }
}
