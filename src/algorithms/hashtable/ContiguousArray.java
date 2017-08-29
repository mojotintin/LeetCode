/*
 * Created by calabash on 2017/8/29.
 * Problem Number: 525.
 * Problem Name: Contiguous Array.
 * Difficulty: Medium.
 * Related Topics: Hash Table.
 * Source: https://leetcode.com/problems/contiguous-array/.
 */

package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * # --------------------------------------------------------------------------
 * # Given a binary array, find the maximum length of a contiguous subarray
 * # with equal number of 0 and 1.
 * #
 * # Example 1:
 * # Input: [0,1]
 * # Output: 2
 * # Explanation: [0, 1] is the longest contiguous subarray with equal number
 * #              of 0 and 1.
 * # Example 2:
 * # Input: [0,1,0]
 * # Output: 2
 * # Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with
 * #              equal number of 0 and 1.
 * # --------------------------------------------------------------------------
 */
public class ContiguousArray {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 90ms
   */
  public int findMaxLength(int[] nums) {
    int maxLen = 0;
    int diff = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        diff += 1;
      } else {
        diff -= 1;
      }
      if (map.containsKey(diff)) {
        maxLen = Math.max(maxLen, i - map.get(diff));
      } else {
        map.put(diff, i);
      }
    }
    return maxLen;
  }
}
