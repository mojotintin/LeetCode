/*
 * Created by calabash on 2017/8/14.
 * Problem Number: 85.
 * Problem Name: Maximal Rectangle.
 * Difficulty: Hard.
 * Related Topics: Array, Hash Table, Stack, Dynamic Programming.
 * Source: https://leetcode.com/problems/maximal-rectangle/
 */

package algorithms.stack;

import java.util.Stack;

/**
 * #---------------------------------------------------------------------------
 * # Given a 2D binary matrix filled with 0's and 1's, find the largest
 * # rectangle containing only 1's and return its area.
 * #
 * # For example, given the following matrix:
 * # 1 0 1 0 0
 * # 1 0 1 1 1
 * # 1 1 1 1 1
 * # 1 0 0 1 0
 * # Return 6.
 * #---------------------------------------------------------------------------
 */
public class MaximalRectangle {

  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 32ms
   */
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int area = 0;
    int[] heights = new int[matrix[0].length + 1];
    for (char[] row : matrix) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (row[j] == '1') {
          heights[j] += 1;
        } else {
          heights[j] = 0;
        }
      }
      Stack<Integer> stack = new Stack<>();
      for (int j = 0; j <= matrix[0].length; j++) {
        while (!stack.empty() && heights[j] < heights[stack.peek()]) {
          int index = stack.pop();
          int left = (stack.empty()) ? -1 : stack.peek();
          area = Math.max(area, heights[index] * (j - left - 1));
        }
        stack.push(j);
      }
    }
    return area;
  }
}
