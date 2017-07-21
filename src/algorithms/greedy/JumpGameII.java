package algorithms.greedy;

/**
 * Created by Calabash on 2017/7/21.
 * Problem Number : 45
 * Problem Name : Jump Game II
 * Difficulty : Hard
 * Tags : Greedy
 * #---------------------------------------------------------------------------
 * # Description : https://leetcode.com/problems/jump-game-ii/#/description
 * #
 * # Given an array of non-negative integers, you are initially positioned at
 * # the first index of the array.
 * # Each element in the array represents your maximum jump length at that
 * # position.
 * # Your goal is to reach the last index in the minimum number of jumps.
 * #
 * # For example:
 * # Given array A = [2,3,1,1,4]
 * # The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * # index 0 to 1, then 3 steps to the last index.）
 * #
 * # Note:
 * # You can assume that you can always reach the last index.
 * #---------------------------------------------------------------------------
 */
public class JumpGameII {

  /**
   * Submission : 1
   * Runtime : 10ms
   * Status : Accepted
   */
  public int jump(int[] nums) {
    int number = 0;
    int position = 0;
    while(position < nums.length - 1) {
      int max = 0;
      int next = position;
      for (int j = 0; j < nums[position]; j++) {
        if (j + position + 1 >= nums.length - 1) {
          return number + 1;
        }
        if (nums[j + position + 1] + j > max) {
          max = nums[j + position + 1] + j;
          next = j + position + 1;
        }
      }
      position = next;
      number += 1;
    }
    return number;
  }
}
