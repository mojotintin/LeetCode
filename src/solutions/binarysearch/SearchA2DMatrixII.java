package solutions.binarysearch;

/**
 * Created by Calabash on 2017/6/13.
 * Problem Number : 240
 * Problem Name : Search a 2D Matrix II
 * Description : https://leetcode.com/problems/search-a-2d-matrix-ii/#/description
 * Difficulty : Medium
 * Tags : Binary Search, Divide and Conquer
 */
public class SearchA2DMatrixII {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 16ms
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0) {
      return false;
    }
    if (matrix[0].length == 0) {
      return false;
    }
    for (int[] aMatrix : matrix) {
      if (searchArray(aMatrix, target)) {
        return true;
      }
    }
    return false;
  }

  private boolean searchArray(int[] nums, int target) {
    int min = 0;
    int max = nums.length - 1;
    int mid;
    while (max - min > 1) {
      mid = (min + max) / 2;
      if (nums[mid] < target) {
        min = mid + 1;
      } else if (nums[mid] > target) {
        max = mid - 1;
      } else {
        return true;
      }
    }
    return nums[min] == target || nums[max] == target;
  }
}
