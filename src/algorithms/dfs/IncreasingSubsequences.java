/*
 * Created by calabash on 2017/8/17.
 * Problem Number: 491.
 * Problem Name: Increasing Subsequences.
 * Difficulty: Medium.
 * Related Topics: Depth-first Search.
 * Source: https://leetcode.com/problems/increasing-subsequences/.
 */

package algorithms.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * # --------------------------------------------------------------------------
 * # Given an integer array, your task is to find all the different possible
 * # increasing subsequences of the given array, and the length of an
 * # increasing subsequence should be at least 2 .
 * #
 * # Example:
 * # Input: [4, 6, 7, 7]
 * # Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7],
 * #         [4,7,7]]
 * #
 * # Note:
 * #   > The length of the given array will not exceed 15.
 * #   > The range of integer in the given array is [-100,100].
 * #   > The given array may contain duplicates, and two equal integers should
 * #     also be considered as a special case of increasing sequence.
 * # --------------------------------------------------------------------------
 */
public class IncreasingSubsequences {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 57ms
   */
  public List<List<Integer>> findSubsequences(int[] nums) {
    Set<List<Integer>> subsequences = new HashSet<>();
    List<Integer> subsequence = new ArrayList<>();
    helper(nums, subsequences, subsequence, Integer.MIN_VALUE, 0, -1);
    return new ArrayList<>(subsequences);
  }

  private void helper(int[] nums, Set<List<Integer>> subsequences,
                      List<Integer> subsequence, int last, int len, int pos) {
    if (len >= 2) {
      subsequences.add(subsequence);
    }
    for (int i = pos + 1; i < nums.length; i++) {
      if (nums[i] >= last) {
        List<Integer> newSubsequence = new ArrayList<>(subsequence);
        newSubsequence.add(nums[i]);
        helper(nums, subsequences, newSubsequence, nums[i], len + 1, i);
      }
    }
  }
}
