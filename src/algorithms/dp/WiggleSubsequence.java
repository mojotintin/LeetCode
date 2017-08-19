/*
 * Created by calabash on 2017/8/19.
 * Problem Number: 376.
 * Problem Name: Wiggle Subsequence.
 * Difficulty: Medium.
 * Related Topics: Dynamic Programming, Greedy.
 * Source: https://leetcode.com/problems/wiggle-subsequence/.
 */

package algorithms.dp;

/**
 * # --------------------------------------------------------------------------
 * # A sequence of numbers is called a wiggle sequence if the differences
 * # between successive numbers strictly alternate between positive and
 * # negative. The first difference (if one exists) may be either positive or
 * # negative. A sequence with fewer than two elements is trivially a wiggle
 * # sequence.
 * #
 * # For example, [1,7,4,9,2,5] is a wiggle sequence because the differences
 * # (6,-3,5,-7,3) are alternately positive and negative. In contrast,
 * # [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because
 * # its first two differences are positive and the second because its last
 * # difference is zero.
 * #
 * # Given a sequence of integers, return the length of the longest subsequence
 * # that is a wiggle sequence. A subsequence is obtained by deleting some
 * # number of elements (eventually, also zero) from the original sequence,
 * # leaving the remaining elements in their original order.
 * # Examples:
 * # Input: [1,7,4,9,2,5]
 * # Output: 6
 * # The entire sequence is a wiggle sequence.
 * #
 * # Input: [1,17,5,10,13,15,10,5,16,8]
 * # Output: 7
 * # There are several subsequences that achieve this length. One is
 * # [1,17,10,13,10,16,8].
 * #
 * # Input: [1,2,3,4,5,6,7,8,9]
 * # Output: 2
 * #
 * # Follow up:
 * # Can you do it in O(n) time?
 * # --------------------------------------------------------------------------
 */
public class WiggleSubsequence {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 14ms
   * Time Complexity: o(n * n)
   * Space Complexity: o(n)
   * Method: DP
   */
  public int wiggleMaxLength_1(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int[] high = new int[nums.length];
    int[] low = new int[nums.length];
    high[0] = 1;
    low[0] = 1;
    int maxLen = 1;
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          high[i] = Math.max(high[i], low[j] + 1);
        } else if (nums[i] < nums[j]) {
          low[i] = Math.max(low[i], high[j] + 1);
        }
      }
      maxLen = Math.max(maxLen, Math.max(high[i], low[i]));
    }
    return maxLen;
  }

  /**
   * Submission: 2
   * Status: Accepted
   * Runtime: 0ms
   * Time Complexity: o(n)
   * Space Complexity: o(1)
   * Method: DP & Greedy
   */
  public int wiggleMaxLength_2(int[] nums) {
    if (nums.length == 0 || nums.length == 1) {
      return nums.length;
    }
    int maxLen1 = getMaxLength(nums, Integer.MIN_VALUE, true);
    int maxLen2 = getMaxLength(nums, Integer.MAX_VALUE, false);
    return Math.max(maxLen1, maxLen2);
  }

  private int getMaxLength(int[] nums, int last, boolean flag) {
    int maxLen = 0;
    for (int num : nums) {
      if (flag && num > last) {
        // if we need a bigger number and we get a bigger number
        // then we need a smaller number
        flag = false;
        maxLen += 1;
      } else if ( !flag && num < last) {
        // if we need a smaller number and get a smaller number
        // then we need a bigger number
        flag = true;
        maxLen += 1;
      }
      // replace the last number with the current number
      last = num;
    }
    return maxLen;
  }
}
