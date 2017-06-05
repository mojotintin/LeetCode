package solutions.binarysearch;

/**
 * Created by Calabash on 2017/5/26.
 * Problem Number : 34
 * Problem Name : Search for a Range
 * Description : https://leetcode.com/problems/search-for-a-range/#/description
 * Difficulty : Medium
 * Tags : Binary Search, Array
 */
public class SearchForARange {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 7ms
   * Note : Binary Search
   */
  public int[] searchRange(int[] nums, int target) {
    int min = 0;
    int max = nums.length - 1;
    int pos = -1;
    int[] range = new int[]{-1, -1};
    if(nums.length == 0) {
      return range;
    }
    while (max - min > 1) {
      int mid = (max + min) / 2;
      if (nums[mid] == target) {
        pos = mid;
        break;
      } else if (nums[mid]  > target) {
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    if (pos == -1) {
      if (nums[min] == target) {
        pos = min;
      } else if (nums[max] == target) {
        pos = max;
      }
    }
    if (pos == -1) {
      return range;
    }
    int start = pos;
    int end = pos;
    while(start >= 0 && nums[start] == target) {
      start --;
    }
    while(end <= nums.length - 1 && nums[end] == target) {
      end ++;
    }
    range[0] = start + 1;
    range[1] = end - 1;
    return range;
  }
}
