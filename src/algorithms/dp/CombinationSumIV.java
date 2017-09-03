/*
 * Created by calabash on 2017/9/3.
 * Problem Number: 377.
 * Problem Name: Combination Sum IV.
 * Difficulty: Medium.
 * Related Topics: Dynamic Programming.
 * Source: https://leetcode.com/problems/combination-sum-iv/.
 */

package algorithms.dp;

/**
 * # --------------------------------------------------------------------------
 * # Given an integer array with all positive numbers and no duplicates, find
 * # the number of possible combinations that add up to a positive integer
 * # target.
 * #
 * # Example:
 * # nums = [1, 2, 3]
 * # target = 4
 * # The possible combination ways are:
 * # (1, 1, 1, 1)
 * # (1, 1, 2)
 * # (1, 2, 1)
 * # (1, 3)
 * # (2, 1, 1)
 * # (2, 2)
 * # (3, 1)
 * # Note that different sequences are counted as different combinations.
 * # Therefore the output is 7.
 * #
 * # Follow up:
 * # What if negative numbers are allowed in the given array?
 * # How does it change the problem?
 * # What limitation we need to add to the question to allow negative numbers?
 * # --------------------------------------------------------------------------
 */
public class CombinationSumIV {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 5ms
   */
  public int combinationSum4(int[] nums, int target) {
    int[] combinations = new int[target + 1];
    combinations[0] = 1;
    for (int i = 1; i <= target; i++) {
      for (int num : nums) {
        if (i >= num) {
          combinations[i] += combinations[i - num];
        }
      }
    }
    return combinations[target];
  }
}
