/*
 * Created by calabash on 2017/9/7.
 * Problem Number: 76.
 * Problem Name: Minimum Window Substring.
 * Difficulty: Hard.
 * Related Topics: Hash Table, Two Pointers, String.
 * Source: https://leetcode.com/problems/minimum-window-substring/.
 */

package algorithms.string;

/**
 * # --------------------------------------------------------------------------
 * # Given a string S and a string T, find the minimum window in S which will
 * # contain all the characters in T in complexity O(n).
 * #
 * # For example,
 * # S = "ADOBECODEBANC"
 * # T = "ABC"
 * # Minimum window is "BANC".
 * #
 * # Note:
 * # If there is no such window in S that covers all characters in T, return
 * # the empty string "".
 * # If there are multiple such windows, you are guaranteed that there will
 * # always be only one unique minimum window in S.
 * # --------------------------------------------------------------------------
 */
public class MinimumWindowSubstring {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 14ms
   */
  public String minWindow(String s, String t) {
    int[] mapT = new int[128];
    for (int i = 0; i < t.length(); i++) {
      mapT[t.charAt(i)] += 1;
    }
    int count = 0;
    int low = 0;
    int start = 0;
    int len = Integer.MAX_VALUE;
    int[] mapS = new int[128];
    for (int i = 0; i < s.length(); i++) {
      if (mapT[s.charAt(i)] > 0) {
        mapS[s.charAt(i)] += 1;
        if (mapS[s.charAt(i)] <= mapT[s.charAt(i)]) {
          count += 1;
        }
      }
      while (count == t.length()) {
        if (i - low + 1 < len) {
          len = i - low + 1;
          start = low;
        }
        if (mapT[s.charAt(low)] > 0) {
          if (mapS[s.charAt(low)] <= mapT[s.charAt(low)]) {
            count -= 1;
          }
          mapS[s.charAt(low)] -= 1;
        }
        low += 1;
      }
    }
    return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
  }
}
