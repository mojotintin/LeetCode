package algorithms.binarysearch;

/**
 * Created by Calabash on 2017/5/31.
 * Problem Number : 162
 * Problem Name : Find Peak Element
 * Description : https://leetcode.com/problems/find-peak-element/#/description
 * Difficulty : Medium
 * Tags : Binary Search, Array
 */
public class FindPeakElement {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 1ms
   * Time Complexity : o(n)
   */
  public int findPeakElement_1(int[] nums) {
    if (nums.length == 1) return 0;
    if (nums[0] > nums[1]) return 0;
    if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
    for (int i = 1; i < nums.length - 1; i++) {
      if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
    }
    return 0;
  }

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 0ms
   * Time Complexity : o(log(n))
   * Note : Binary Search
   */
  public int findPeakElement_2(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    int min = 0;
    int max = nums.length - 1;
    while (max - min > 1) {
      int mid = (min + max) / 2;
      if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
        return mid;
      } else if (nums[mid] >nums[mid - 1]) {
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }
    if (max == min) {
      return min;
    }
    if (nums[min] > nums[min + 1]) {
      return min;
    }
    if (nums[max] > nums[max - 1]) {
      return max;
    }
    return 0;
  }
}
