package algorithms.dp;

import java.util.Arrays;

/**
 * Created by Calabash on 2017/6/29.
 * Problem Number : 300
 * Problem Name : Longest Increasing Subsequence
 * Description :
 * Difficulty : Medium
 * Tags : Dynamic Programming, Binary Search
 */
public class LongestIncreasingSubsequence {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 37ms
   */
  public int lengthOfLIS_1(int[] nums) {
    int[] lengths = new int[nums.length];
    Arrays.fill(lengths, 1);
    int longest = 0;
    int max;
    for (int i = 0; i < nums.length; i++) {
      max = 0;
      for(int j = 0; j < i; j++) {
        if (nums[j] < nums[i] && lengths[j] > max) {
          max = lengths[j];
        }
      }
      lengths[i] = Math.max(1, max + 1);
      longest = Math.max(longest, lengths[i]);
    }
    return longest;
  }
}
