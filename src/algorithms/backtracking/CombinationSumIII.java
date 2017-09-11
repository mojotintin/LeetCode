/*
 * Created by calabash on 2017/9/11.
 * Problem Number: 216.
 * Problem Name: Combination Sum III.
 * Difficulty: Medium.
 * Related Topics: Array, Backtracking.
 * Source: https://leetcode.com/problems/combination-sum-iii/.
 */

package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * # --------------------------------------------------------------------------
 * # Find all possible combinations of k numbers that add up to a number n,
 * # given that only numbers from 1 to 9 can be used and each combination
 * # should be a unique set of numbers.
 * #
 * # Example 1:
 * # Input: k = 3, n = 7
 * # Output:
 * # [[1,2,4]]
 * #
 * # Example 2:
 * # Input: k = 3, n = 9
 * # Output:
 * # [[1,2,6], [1,3,5], [2,3,4]]
 * # --------------------------------------------------------------------------
 */
public class CombinationSumIII {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 2ms
   */
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> combinations = new ArrayList<>();
    helper(k, n, 0, 0, combinations, new ArrayList<Integer>());
    return combinations;
  }

  private void helper(int k, int n, int last, int sum, List<List<Integer>> combinations, List<Integer> combination) {
    if (sum > n) {
      return;
    }
    if (combination.size() == k) {
      if (sum == n) {
        combinations.add(combination);
      }
      return;
    }
    for (int i = last + 1; i <= 9; i++) {
      List<Integer> temp = new ArrayList<>(combination);
      temp.add(i);
      helper(k, n, i, sum + i, combinations, temp);
    }
  }
}
