/*
 * Created by calabash on 2017/9/5.
 * Problem Number: 594.
 * Problem Name: Longest Harmonious Subsequence.
 * Difficulty: Easy.
 * Related Topics: Hash Table.
 * Source: https://leetcode.com/problems/longest-harmonious-subsequence/.
 */

package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * # --------------------------------------------------------------------------
 * # We define a harmonious array is an array where the difference between its
 * # maximum value and its minimum value is exactly 1.
 * # Now, given an integer array, you need to find the length of its longest
 * # harmonious subsequence among all its possible subsequences.
 * #
 * # Example 1:
 * # Input: [1,3,2,2,5,2,3,7]
 * # Output: 5
 * # Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * #
 * # Note: The length of the input array will not exceed 20,000.
 * # --------------------------------------------------------------------------
 */
public class LongestHarmoniousSubsequence {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 107ms
   */
  public int findLHS(int[] nums) {
    int maxLen = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
      int len = 0;
      if (map.containsKey(num - 1)) {
        len = map.get(num - 1);
      }
      if (map.containsKey(num + 1)) {
        len = Math.max(len, map.get(num + 1));
      }
      if (len != 0) {
        maxLen = Math.max(maxLen, len + map.get(num));
      }
    }
    return maxLen;
  }
}
