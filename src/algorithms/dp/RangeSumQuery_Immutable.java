package algorithms.dp;

/**
 * Created by Calabash on 2017/6/6.
 * Problem Number : 303
 * Problem Name : Range Sum Query - Immutable
 * Description : https://leetcode.com/problems/range-sum-query-immutable/#/description
 * Difficulty : Easy
 * Tags : Dynamic Programming
 */
public class RangeSumQuery_Immutable {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 250ms
   */
  private int[] numArray = new int[10000];

  public RangeSumQuery_Immutable(int[] nums) {
    if (nums.length != 0) {
      numArray[0] = nums[0];
    }
    for (int i = 1; i < nums.length; i++) {
      numArray[i] = numArray[i - 1] + nums[i];
    }
  }

  public int sumRange(int i, int j) {
    if (i == 0) {
      return numArray[j];
    }
    return numArray[j] - numArray[i - 1];
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
