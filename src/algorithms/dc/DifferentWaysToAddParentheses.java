/*
 * Created by calabash on 2017/9/10.
 * Problem Number: 241.
 * Problem Name: Different Ways to Add Parentheses.
 * Difficulty: Medium.
 * Related Topics: Divide and Conquer.
 * Source: https://leetcode.com/problems/different-ways-to-add-parentheses/.
 */

package algorithms.dc;

import java.util.ArrayList;
import java.util.List;

/**
 * # --------------------------------------------------------------------------
 * # Given a string of numbers and operators, return all possible results from
 * # computing all the different possible ways to group numbers and operators.
 * # The valid operators are +, - and *.
 * #
 * # Example 1
 * # Input: "2-1-1".
 * # ((2-1)-1) = 0
 * # (2-(1-1)) = 2
 * # Output: [0, 2]
 * #
 * # Example 2
 * # Input: "2*3-4*5"
 * # (2*(3-(4*5))) = -34
 * # ((2*3)-(4*5)) = -14
 * # ((2*(3-4))*5) = -10
 * # (2*((3-4)*5)) = -10
 * # (((2*3)-4)*5) = 10
 * # Output: [-34, -14, -10, -10, 10]
 * # --------------------------------------------------------------------------
 */
public class DifferentWaysToAddParentheses {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 8ms
   */
  public List<Integer> diffWaysToCompute(String input) {
    int count = 0;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
        count += 1;
      }
    }
    int[] paras = new int[count + 1];
    char[] operators = new char[count];
    int lastOperator = -1;
    count  = 0;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
        operators[count] = input.charAt(i);
        paras[count] = Integer.valueOf(input.substring(lastOperator + 1, i));
        lastOperator = i;
        count += 1;
      }
    }
    paras[count] = Integer.valueOf(input.substring(lastOperator + 1, input.length()));
    return helper(paras, operators, 0, count);
  }

  private List<Integer> helper(int[] paras, char[] operators, int start, int end) {
    List<Integer> results = new ArrayList<>();
    if (start == end) {
      results.add(paras[start]);
      return results;
    }
    for (int i = start; i < end; i++) {
      List<Integer> r1 = helper(paras, operators, start, i);
      List<Integer> r2 = helper(paras, operators, i + 1, end);
      for (int m : r1) {
        for (int n : r2) {
          if (operators[i] == '+') {
            results.add(m + n);
          } else if (operators[i] == '-') {
            results.add(m - n);
          } else if (operators[i] == '*') {
            results.add(m * n);
          }
        }
      }
    }
    return results;
  }
}
