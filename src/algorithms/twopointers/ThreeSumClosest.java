/*
 * Created by calabash on 2017/8/4.
 * Problem Number: 16
 * Problem Name: 3Sum Closest
 * Difficulty: Medium
 * Related Topics: Array, Two Points
 * Source: https://leetcode.com/problems/3sum-closest/
 */
package algorithms.twopointers;

import java.util.Arrays;

/**
 * Description:
 * #---------------------------------------------------------------------------
 * # Given an array S of n integers, find three integers in S such that the sum
 * # is closest to a given number, target. Return the sum of the three integers.
 * # You may assume that each input would have exactly one solution.
 * #
 * # For example, given array S = {-1 2 1 -4}, and target = 1.
 * # The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * #---------------------------------------------------------------------------
 */
public class ThreeSumClosest {

  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 22ms
   */
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int closestSum = nums[0] + nums[1] + nums[2] - target;
    for (int i = 0; i < nums.length - 2; i++) {
      int low = i + 1;
      int high = nums.length - 1;
      while (low < high) {
        if (Math.abs(nums[i] + nums[low] + nums[high] - target) < Math.abs(closestSum)) {
          closestSum = nums[i] + nums[low] + nums[high] - target;
        }
        if (nums[low] + nums[high] > target - nums[i]) {
          high -= 1;
        } else if (nums[low] + nums[high] < target - nums[i]) {
          low += 1;
        } else {
          return target;
        }
      }
    }
    return closestSum + target;
  }
}
