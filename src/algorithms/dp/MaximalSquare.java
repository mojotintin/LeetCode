/*
 * Created by calabash on 2017/8/14.
 * Problem Number: 221.
 * Problem Name: Maximal Square.
 * Difficulty: Medium.
 * Related Topics: Dynamic Programming.
 * Source: https://leetcode.com/problems/maximal-square/
 */

package algorithms.dp;

import java.util.Arrays;

/**
 * #---------------------------------------------------------------------------
 * # Given a 2D binary matrix filled with 0's and 1's, find the largest
 * # square containing only 1's and return its area.
 * #
 * # For example, given the following matrix:
 * # 1 0 1 0 0
 * # 1 0 1 1 1
 * # 1 1 1 1 1
 * # 1 0 0 1 0
 * # Return 4.
 * #---------------------------------------------------------------------------
 */
public class MaximalSquare {

  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 11ms
   */
  public int maximalSquare(char[][] matrix) {
    int maxSide = 0;
    if (matrix.length == 0 || matrix[0].length == 0) {
      return maxSide * maxSide;
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
      // calculate the left of current element
      int curLeft = 0;
      for (int j = 0; j < rowLen; j++) {
        if (row[j] == '1') {
          left[j] = Math.max(curLeft, left[j]);
        } else {
          left[j] = 0;
          curLeft = j + 1;
        }
      }
      // calculate the right of current element
      int curRight = rowLen - 1;
      for (int j = rowLen - 1; j >= 0; j--) {
        if (row[j] == '1') {
          right[j] = Math.min(curRight, right[j]);
        } else {
          right[j] = rowLen - 1;
          curRight = j - 1;
        }
      }
      // calculate the max side of the row
      for (int j = 0; j < rowLen; j++) {
        maxSide = Math.max(maxSide, Math.min(height[j], right[j] - left[j] + 1));
      }
    }
    return maxSide * maxSide;
  }
}
