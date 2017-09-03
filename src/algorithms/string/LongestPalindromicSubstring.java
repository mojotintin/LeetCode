/*
 * Created by calabash on 2017/9/3.
 * Problem Number: 5.
 * Problem Name: Longest Palindromic Substring.
 * Difficulty: Medium.
 * Related Topics: String.
 * Source: https://leetcode.com/problems/longest-palindromic-substring/.
 */

package algorithms.string;

/**
 * # --------------------------------------------------------------------------
 * # Given a string s, find the longest palindromic substring in s. You may
 * # assume that the maximum length of s is 1000.
 * #
 * # Example:
 * # Input: "babad"
 * # Output: "bab"
 * # Note: "aba" is also a valid answer.
 * #
 * # Example:
 * # Input: "cbbd"
 * # Output: "bb"
 * # --------------------------------------------------------------------------
 */
public class LongestPalindromicSubstring {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 92ms
   */
  public String longestPalindrome(String s) {
    if (s.equals("")) {
      return s;
    }
    boolean[][] isPali = new boolean[s.length()][s.length()];
    int start = 0;
    int end = 0;
    // s[i - i] is a palindrome
    for (int i = 0; i < s.length(); i++) {
      isPali[i][i] = true;
      start = i;
      end = i;
    }
    // if s[i] == s[i - 1], s[i - (i + 1)] is a palindrome
    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        isPali[i][i + 1] = true;
        start = i;
        end = i + 1;
      }
    }
    for (int j = 2; j < s.length(); j++) {
      for (int i = 0; i < s.length() - j; i++) {
        if (isPali[i + 1][i + j - 1] && s.charAt(i) == s.charAt(i + j)) {
          isPali[i][i + j] = true;
          start = i;
          end = i + j;
        }
      }
    }
    return s.substring(start, end + 1);
  }
}
