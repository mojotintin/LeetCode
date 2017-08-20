/*
 * Created by calabash on 2017/8/17.
 * Problem Number: 416.
 * Problem Name: Partition Equal Subset Sum.
 * Difficulty: Medium.
 * Related Topics: Dynamic Programming.
 * Source: https://leetcode.com/problems/partition-equal-subset-sum/.
 */

package algorithms.dp;

/**
 * # --------------------------------------------------------------------------
 * # Given a non-empty array containing only positive integers, find if the
 * # array can be partitioned into two subsets such that the sum of elements
 * # in both subsets is equal.
 * #
 * # Note:
 * #   > Each of the array element will not exceed 100.
 * #   > The array size will not exceed 200.
 * #
 * # Example 1:
 * # Input: [1, 5, 11, 5]
 * # Output: true
 * # Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * #
 * # Input: [1, 2, 3, 5]
 * # Output: false
 * # Explanation: The array cannot be partitioned into equal sum subsets.
 * # --------------------------------------------------------------------------
 */
public class PartitionEqualSubsetSum {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 26ms
   * Time Complexity: o(n * m) (n is the length of nums, m is the sum of nums)
   * Space Complexity: o(m) (m is the sum of nums)
   */
  public boolean canPartition(int[] nums) {
    // get the sum of nums
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    // if the sum is odd, the array can not be partition
    // if the sum is even, get half of the sum
    if (sum % 2 != 0) {
      return false;
    } else {
      sum /= 2;
    }
    // find if the half of sum can get from a subset.
    boolean[] isFind = new boolean[sum + 1];
    isFind[0] = true;
    for (int num : nums) {
      for (int i = sum; i > 0; i--) {
        if (num <= i) {
          isFind[i] = isFind[i] || isFind[i - num];
        }
      }
    }
    return isFind[sum];
  }
}
