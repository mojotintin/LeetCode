/*
 * Created by calabash on 2017/9/14.
 * Problem Number: 81.
 * Problem Name: Search in Rotated Sorted Array II.
 * Difficulty: Medium.
 * Related Topics: .
 * Source: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/.
 */

package algorithms.binarysearch;

/**
 * # --------------------------------------------------------------------------
 * # '''
 * # Follow up for "Search in Rotated Sorted Array":
 * # What if duplicates are allowed?
 * # Would this affect the run-time complexity? How and why?
 * # '''
 * #
 * # Suppose an array sorted in ascending order is rotated at some pivot
 * # unknown to you beforehand.
 * # (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * # Write a function to determine if a given target is in the array.
 * # The array may contain duplicates.
 * # --------------------------------------------------------------------------
 */
public class SearchInRotatedSortedArrayII {
  /**
   * Submission: 1
   * Stratus: Accepted
   * Runtime: 1ms
   */
  public boolean search(int[] nums, int target) {
    return searchForRange(nums, target, 0, nums.length - 1);
  }

  // search the target in the range of start to end
  private boolean searchForRange(int[] nums, int target, int start, int end) {
    if (start > end) {
      return false;
    }
    int mid = (start + end) / 2;
    if (nums[mid] == target) {
      return true;
    }
    if (nums[start] < nums[mid]) {
      if (nums[start] <= target && target < nums[mid]) {
        return searchForRange(nums, target, start, mid - 1);
      } else {
        return searchForRange(nums, target, mid + 1, end);
      }
    } else if (nums[mid] < nums[end]) {
      if (nums[mid] < target && target <= nums[end]) {
        return searchForRange(nums, target, mid + 1, end);
      } else {
        return searchForRange(nums, target, start, mid - 1);
      }
    } else {
      return searchForRange(nums, target, start, mid - 1) ||
          searchForRange(nums, target, mid + 1, end);
    }
  }
}
