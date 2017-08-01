package algorithms.dc;

/**
 * Created by Calabash on 2017/8/1.
 * Problem Number: 312
 * Problem Name: Burst Balloons
 * Difficulty: Hard
 * Related Topics: Dynamic Programming, Divide and Conquer
 * Description: https://leetcode.com/problems/burst-balloons/description/
 * #---------------------------------------------------------------------------
 * # Given n balloons, indexed from 0 to n-1. Each balloon is painted with a
 * # number on it represented by array nums. You are asked to burst all the
 * # balloons. If the you burst balloon i you will get nums[left] * nums[i] *
 * # nums[right] coins. Here left and right are adjacent indices of i. After
 * # the burst, the left and right then becomes adjacent.
 * #
 * # Find the maximum coins you can collect by bursting the balloons wisely.
 * #
 * # Note:
 * # (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you
 * #     can not burst them.
 * # (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * #
 * # Example:
 * # Given [3, 1, 5, 8]
 * # Return 167
 * # nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * # coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * #---------------------------------------------------------------------------
 */
public class BurstBalloons {

  /**
   * Submission: 1
   * Status: Time Limit Exceeded
   * Runtime: N/A
   * Method: D&C
   */
  public int maxCoins_1(int[] nums) {
    int start = 0;
    int end = nums.length - 1;
    int left = 1;
    int right = 1;
    return helper_1(nums, start, end, left, right);
  }

  private int helper_1(int[] nums, int start, int end, int left, int right) {
    if (start > end) {
      return 0;
    }
    int coins = 0;
    for (int i = start; i <= end; i++) {
      coins = Math.max(coins, helper_1(nums, start, i - 1, left, nums[i]) +
          left * nums[i] * right +
          helper_1(nums, i + 1, end, nums[i], right));
    }
    return coins;
  }

  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 13ms
   * Method: D&C with Memoization
   */
  public int maxCoins_2(int[] nums) {
    int start = 0;
    int end = nums.length - 1;
    int left = 1;
    int right = 1;
    int[][] memo = new int[nums.length][nums.length];
    return helper_2(nums, memo, start, end, left, right);
  }

  private int helper_2(int[] nums, int[][] memo, int start, int end, int left, int right) {
    if (start > end) {
      return 0;
    }
    if (memo[start][end] != 0) {
      return memo[start][end];
    }
    int coins = 0;
    for (int i = start; i <= end; i++) {
      coins = Math.max(coins, helper_2(nums, memo,  start, i - 1, left, nums[i]) +
          left * nums[i] * right +
          helper_2(nums, memo, i + 1, end, nums[i], right));
    }
    memo[start][end] = coins;
    return coins;
  }
}
