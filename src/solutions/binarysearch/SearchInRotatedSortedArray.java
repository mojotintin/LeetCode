package solutions.binarysearch;

/**
 * Created by Calabash on 2017/5/24.
 * Problem Number : 33
 * problem Name : Search in Rotated Sorted Array
 * Description : https://leetcode.com/problems/search-in-rotated-sorted-array/#/description
 * Difficulty : Medium
 * Tags : Binary Search, Array
 */
public class SearchInRotatedSortedArray {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 15ms
   */
  public int search(int[] nums, int target) {
    if(nums.length == 0) {
      return -1;
    }
    int min = 0;
    int max = nums.length - 1;
    return isSearched(nums, min, max, target);
  }

  private int isSearched(int[] nums, int min, int max, int target) {
    while (max - min > 1) {
      int mid = (min + max) / 2;
      if (nums[mid] > nums[min]) {
        if (target >= nums[min] && target <= nums[mid]) {
          return binarySearch(nums, min, mid, target);
        }
        else {
          min = mid + 1;
        }
      } else {
        if (target >= nums[mid] && target <= nums[max]) {
          return binarySearch(nums, mid, max, target);
        }
        else {
          max = mid - 1;
        }
      }
    }
    if (nums[min] == target) {
      return min;
    }
    else if (nums[max] == target) return max;
    else {
      return -1;
    }
  }

  private int binarySearch(int[] nums, int min, int max, int target) {
    while (max - min > 1) {
      int mid = (min + max) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    if (nums[min] == target) {
      return min;
    }
    else if (nums[max] == target) {
      return max;
    }
    else {
      return -1;
    }
  }
}
