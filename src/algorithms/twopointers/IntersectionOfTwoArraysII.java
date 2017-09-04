/*
 * Created by calabash on 2017/9/4.
 * Problem Number: 350.
 * Problem Name: Intersection of Two Arrays II.
 * Difficulty: Easy.
 * Related Topics: Binary Search, .
 * Source: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/.
 */

package algorithms.twopointers;

import java.util.Arrays;

/**
 * # --------------------------------------------------------------------------
 * # Given two arrays, write a function to compute their intersection.
 *
 * # Example:
 * # Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * #
 * # Note:
 * #   > Each element in the result should appear as many times as it shows in
 * #     both arrays.
 * #   > The result can be in any order.
 * #
 * # Follow up:
 * #   > What if the given array is already sorted? How would you optimize your
 * #     algorithm?
 * #   > What if nums1's size is small compared to nums2's size? Which
 * #     algorithm is better?
 * #   > What if elements of nums2 are stored on disk, and the memory is
 * #     limited such that you cannot load all elements into the memory at
 * #     once?
 * # --------------------------------------------------------------------------
 */
public class IntersectionOfTwoArraysII {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 3ms
   */
  public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int[] intersection = new int[Math.max(nums1.length, nums2.length)];
    int i = 0;
    int j = 0;
    int count = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] == nums2[j]) {
        intersection[count] = nums1[i];
        count += 1;
        i += 1;
        j += 1;
      } else if (nums1[i] < nums2[j]) {
        i += 1;
      } else {
        j += 1;
      }
    }
    return Arrays.copyOf(intersection, count);
  }
}
