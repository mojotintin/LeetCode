/*
 * Created by calabash on 2017/9/10.
 * Problem Number: 494.
 * Problem Name: Target Sum.
 * Difficulty: Medium.
 * Related Topics: Dynamic Programming, Depth-first Search.
 * Source: https://leetcode.com/problems/target-sum/.
 */

package algorithms.dp;

/**
 * # --------------------------------------------------------------------------
 * # You are given a list of non-negative integers, a1, a2, ..., an, and a
 * # target, S. Now you have 2 symbols + and -. For each integer, you should
 * # choose one from + and - as its new symbol.
 * # Find out how many ways to assign symbols to make sum of integers equal to
 * # target S.
 * #
 * # Example 1:
 * # Input: nums is [1, 1, 1, 1, 1], S is 3.
 * # Output: 5
 * # Explanation:
 * #
 * # -1+1+1+1+1 = 3
 * # +1-1+1+1+1 = 3
 * # +1+1-1+1+1 = 3
 * # +1+1+1-1+1 = 3
 * # +1+1+1+1-1 = 3
 * #
 * # There are 5 ways to assign symbols to make the sum of nums be target 3.
 * # --------------------------------------------------------------------------
 */
public class TargetSum {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 748ms
   */
  public int findTargetSumWays_1(int[] nums, int S) {
    if (nums.length == 0) {
      return 0;
    }
    return findWays(nums, S, 0);
  }

  private int findWays(int[] nums, int S, int position) {
    if (position == nums.length) {
      if (S == 0) {
        return 1;
      } else {
        return 0;
      }
    }
    return findWays(nums, S + nums[position], position + 1) +
        findWays(nums, S - nums[position], position + 1);
  }

  /**
   * Submission: 2
   * Status: Accepted
   * Runtime: 17ms
   */
  public int findTargetSumWays_2(int[] nums, int S) {
    if (nums.length == 0) {
      return 0;
    }
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum < Math.abs(S) || (sum + S) % 2 == 1) {
      return 0;
    }
    return helper(nums, (sum + S) / 2);
  }

  private int helper(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int num : nums) {
      for (int i = target; i >= 0; i--) {
        if (i < num) {
          break;
        }
        dp[i] += dp[i - num];
      }
    }
    return dp[target];
  }
}
