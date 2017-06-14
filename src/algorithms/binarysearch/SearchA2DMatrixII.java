package algorithms.binarysearch;

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
   * Time complexity : o(m * logn)
   */
  public boolean searchMatrix_1(int[][] matrix, int target) {
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

  /**
   * Submission : 2
   * Status : Accepted
   * Runtime : 15ms
   * Time complexity : o(m + n)
   */
  public boolean searchMatrix_2(int[][] matrix, int target) {
    if (matrix == null ||matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    int height = 0;
    int width  = matrix[0].length - 1;
    while (height != matrix.length - 1 || width != 0) {
      if (target == matrix[height][width]) {
        return true;
      }
      if (height == matrix.length - 1) {
        width -= 1;
        continue;
      } else if (width == 0) {
        height += 1;
        continue;
      }
      if (target > matrix[height][width]) {
        height += 1;
      } else if (target < matrix[height][width]) {
        width -= 1;
      }
    }
    return matrix[height][width] == target;
  }
}
