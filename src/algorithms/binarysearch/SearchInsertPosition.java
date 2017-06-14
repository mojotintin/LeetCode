package algorithms.binarysearch;

/**
 * Created by Calabash on 2017/5/4.
 * Problem Number : 35
 * Problem Name : Search Insert Position
 * Description : https://leetcode.com/problems/search-insert-position/#/description
 * Difficulty : Easy
 * Tags : Array, Binary Search
 */
public class SearchInsertPosition {

  /**
   * Status : Accepted
   * Runtime : 5ms
   * Note : Binary Search
   */
  public int searchInsert(int[] nums, int target) {
    if (nums.length == 0) {
      return 0;
    }
    int min = 0;
    int max = nums.length - 1;
    int mid = (min + max) / 2;
    while (max - min > 1) {
      if (nums[mid] > target) {
        max = mid;
        mid = (min + max) / 2;
      }
      else if (nums[mid] < target){
        min = mid;
        mid = (min + max) / 2;
      } else {
        return mid;
      }
    }
    if (nums[max] < target) {
      return max + 1;
    }
    else if (nums[min] >= target) {
      return min;
    }
    else {
      return min + 1;
    }
  }
}
