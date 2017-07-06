package algorithms.other;

/**
 * Created by Calabash on 2017/7/6.
 * Problem Number : 334
 * Problem Name : Increasing Triplet Subsequence
 * Description : https://leetcode.com/problems/increasing-triplet-subsequence/#/description
 * Difficulty : Medium
 * Tags : Other
 */
public class IncreasingTripletSubsequence {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 6ms
   */
  public boolean increasingTriplet(int[] nums) {
    int min = Integer.MAX_VALUE;
    int mid = Integer.MAX_VALUE;
    for (int num : nums) {
      if (num > mid) {
        return true;
      } else if (num <= min) {
        min = num;
      } else {
        mid = num;
      }
    }
    return false;
  }
}
