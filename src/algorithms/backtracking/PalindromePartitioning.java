package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/7/17.
 * Problem Number : 131
 * problem Name : Palindrome Partitioning
 * Difficulty : Medium
 * Tags : Backtracking
 * Description : https://leetcode.com/problems/palindrome-partitioning/#/description
 * #---------------------------------------------------------------------------
 * # Given a string s, partition s such that every substring of the partition
 * # is a palindrome.
 * # Return all possible palindrome partitioning of s.
 * #
 * # For example, given s = "aab",
 * # Return
 * # [
 * # ["aa","b"],
 * # ["a","a","b"]
 * # ]
 * #---------------------------------------------------------------------------
 */
public class PalindromePartitioning {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 9ms
   */
  public List<List<String>> partition(String s) {
    List<List<String>> results = new ArrayList<>();
    helper(s, 0, new ArrayList<>(), results);
    return results;
  }

  private void helper(String s, int start, List<String> result, List<List<String>> results) {
    // 如果整个字符串已经遍历完，存储到将要返回的二层List中
    if (start == s.length()) {
      List<String> list = new ArrayList<>(result);
      results.add(list);
      return;
    }
    // 从当前位置开始，如果之后出现子字符串是回文字符串，切分后进行剩下的部分
    for (int i = start + 1; i <= s.length(); i++) {
      if (isPalindrome(s, start, i)) {
        List<String> list = new ArrayList<>(result);
        list.add(s.substring(start, i));
        helper(s, i, list, results);
      }
    }
  }

  // 判断子字符串是否为回文字符串
  private boolean isPalindrome(String s, int start, int end) {
    for (int i = 0; i < (end - start) / 2; i++) {
      if (s.charAt(start + i) != s.charAt(end - i - 1)) {
        return false;
      }
    }
    return true;
  }
}
