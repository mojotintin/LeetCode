/*
 * Created by calabash on 2017/8/17.
 * Problem Number: 329.
 * Problem Name: Longest Increasing Path in a Matrix.
 * Difficulty: Hard.
 * Related Topics: Depth-first Search, Topological Sort, Memoization.
 * Source: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/.
 */

package algorithms.dfs;

/**
 * #---------------------------------------------------------------------------
 * # Given an integer matrix, find the length of the longest increasing path.
 * # From each cell, you can either move to four directions: left, right, up or
 * # down. You may NOT move diagonally or move outside of the boundary (i.e.
 * # wrap-around is not allowed).
 * #
 * # Example 1:
 * # nums = [
 * # [9,9,4],
 * # [6,6,8],
 * # [2,1,1]
 * # ]
 * # Return 4
 * # The longest increasing path is [1, 2, 6, 9].
 * #
 * # Example 2:
 * # nums = [
 * # [3,4,5],
 * # [3,2,6],
 * # [2,2,1]
 * # ]
 * # Return 4
 * # The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not
 * # allowed.
 * #---------------------------------------------------------------------------
 */
public class LongestIncreasingPathInAMatrix {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 16ms
   */
  public int longestIncreasingPath(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int longestLen = 0;
    int[][] memo = new int[matrix.length][matrix[0].length];
    // search the longest increasing path for all element
    // pick the maximal one
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        longestLen = Math.max(longestLen, helper(matrix, memo, Integer.MIN_VALUE, 0, i, j));
      }
    }
    return longestLen;
  }

  private int helper(int[][] matrix, int[][] memo, int last, int len, int i ,int j) {
    // if the coordinate beyond the limit or the path is not increasing, find the longest length.
    if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= last) {
      return len;
    }
    // if the path of element matrix[i][j] had founded, find the longest length.
    if (memo[i][j] > 0) {
      return len + memo[i][j];
    }
    // find the longest length for current element and store it in memo, return the length.
    memo[i][j] = Math.max(
        Math.max(helper(matrix, memo, matrix[i][j], len + 1, i + 1, j),
            helper(matrix, memo, matrix[i][j], len + 1, i - 1, j)),
        Math.max(helper(matrix, memo, matrix[i][j], len + 1, i, j + 1),
            helper(matrix, memo, matrix[i][j], len + 1, i, j - 1))) - len;
    return memo[i][j] + len;
  }
}
