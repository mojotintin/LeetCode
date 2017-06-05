package solutions.array;

/**
 * Created by Calabash on 2017/5/3.
 * Problem Number : 566
 * Problem Name : Reshape the Matrix
 * Description : https://leetcode.com/problems/reshape-the-matrix/#/description
 * Difficulty : Easy
 * Tags : Array
 */
public class ReshapeTheMatrix {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 8ms
   */
  public int[][] matrixReshape(int[][] nums, int r, int c) {
    if (nums.length == 0) {
      return nums;
    }
    if (nums.length * nums[0].length != r * c) {
      return nums;
    }
    int m = 0, n = 0;
    int[][] reshapedNums = new int[r][c];
    for (int[] num : nums) {
      for (int j = 0; j < nums[0].length; j++) {
        reshapedNums[m][n] = num[j];
        if (n + 1 == c) {
          n = 0;
          m++;
        } else {
          n++;
        }
      }
    }
    return reshapedNums;
  }
}
