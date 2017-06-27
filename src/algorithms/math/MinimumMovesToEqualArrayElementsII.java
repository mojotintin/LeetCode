package algorithms.math;

import java.util.Arrays;

/**
 * Created by Calabash on 2017/6/27.
 * Problem Number : 462
 * Problem Name : Minimum Moves to Equal Array Elements II
 * Description : https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/#/description
 * Difficulty : Medium
 * Tags : Math
 */
public class MinimumMovesToEqualArrayElementsII {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 9ms
   */
  public int minMoves2(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    Arrays.sort(nums);
    int median = nums[nums.length / 2];
    int moves = 0;
    for (int num : nums) {
      moves += Math.abs(num - median);
    }
    return moves;
  }
}
