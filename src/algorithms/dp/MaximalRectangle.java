package algorithms.dp;

/*
 * Created by calabash on 2017/8/14.
 * Problem Number: 85.
 * Problem Name: Maximal Rectangle.
 * Difficulty: Hard.
 * Related Topics: Array, Hash Table, Stack, Dynamic Programming.
 * Source: https://leetcode.com/problems/maximal-rectangle/
 */

import java.util.Arrays;

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
    int maxArea = 0;
    if (matrix.length == 0 || matrix[0].length == 0) {
      return maxArea;
    }
    int rowLen = matrix[0].length;
    int[] height = new int[rowLen];
    int[] left = new int[rowLen];
    int[] right = new int[rowLen];
    Arrays.fill(right, rowLen - 1);
    // traversal every row of the matrix
    for (char[] row : matrix) {
      // calculate the height of current element
      for (int j = 0; j < rowLen; j++) {
        if (row[j] == '1') {
          height[j] += 1;
        } else {
          height[j] = 0;
        }
      }
      // calculate the left '1' of current element
      int curLeft = 0;
      for (int j = 0; j < rowLen; j++) {
        if (row[j] == '1') {
          left[j] = Math.max(curLeft, left[j]);
        } else {
          left[j] = 0;
          curLeft = j + 1;
        }
      }
      // calculate the right '1' of current element
      int curRight = rowLen - 1;
      for (int j = rowLen - 1; j >= 0; j--) {
        if (row[j] == '1') {
          right[j] = Math.min(curRight, right[j]);
        } else {
          right[j] = rowLen - 1;
          curRight = j - 1;
        }
      }
      // calculate the max area of the row
      for (int j = 0; j < rowLen; j++) {
        maxArea = Math.max(maxArea, height[j] * (right[j] - left[j] + 1));
      }
    }
    return maxArea;
  }
}
