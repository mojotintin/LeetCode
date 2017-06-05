package solutions.binarysearch;

/**
 * Created by Calabash on 2017/6/3.
 * Problem Number : 153
 * Problem Name : Find Minimum in Rotated Sorted Array
 * Description : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/#/description
 * Difficulty : Medium
 * Tags : Array, Binary Search
 */
public class FindMinimumInRotatedSortedArray {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 1ms
   * Note : Binary Search
   */
  public int findMin(int[] nums) {
    return findMinOfArray(nums, 0, nums.length - 1);
  }

  private int findMinOfArray(int[] nums, int min, int max) {
    if (max == min) {
      return nums[min];
    }
    if (nums[max] > nums[min]) {
      return nums[min];
    }
    if (max - min == 1) {
      return nums[max];
    }
    int mid = (max + min) / 2;
    if (nums[mid] < nums[mid - 1]) {
      return nums[mid];
    } else if (nums[mid] > nums[min]) {
      return findMinOfArray(nums, mid + 1, max);
    } else {
      return findMinOfArray(nums, min, mid - 1);
    }
  }
}
