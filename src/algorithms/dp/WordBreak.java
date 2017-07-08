package algorithms.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Calabash on 2017/7/8.
 * Problem Number : 139
 * Problem Name : Word Break
 * Difficulty : Medium
 * Tags : Dynamic Programming
 * Description : https://leetcode.com/problems/word-break/#/description
 * #---------------------------------------------------------------------------
 * # Given a non-empty string s and a dictionary wordDict containing a list of
 * # non-empty words, determine if s can be segmented into a space-separated
 * # sequence of one or more dictionary words. You may assume the dictionary
 * # does not contain duplicate words.
 * #
 * # For example, given
 * # s = "leetcode",
 * # dict = ["leet", "code"].
 * # Return true because "leetcode" can be segmented as "leet code".
 * #
 * # UPDATE (2017/1/4):
 * # The wordDict parameter had been changed to a list of strings (instead of a
 * # set of strings). Please reload the code definition to get the latest
 * # changes.
 * #---------------------------------------------------------------------------
 */
public class WordBreak {

  /**
   * Submission : 1
   * Status : Time Limit Exceeded
   * Runtime : N/A
   */
  public boolean wordBreak_1(String s, List<String> wordDict) {
    if (s.equals("")) {
      return true;
    }
    boolean canBreak = false;
    for (String word : wordDict) {
      if (word.length() <= s.length() && s.substring(0, word.length()).equals(word)) {
        canBreak |= wordBreak_1(s.substring(word.length(), s.length()), wordDict);
      }
    }
    return canBreak;
  }

  /**
   * Submission : 2
   * Status : Accepted
   * Runtime : 19ms
   */
  public boolean wordBreak_2(String s, List<String> wordDict) {
    Set<String> words = new HashSet<>(wordDict);
    boolean[] canBreak = new boolean[s.length() + 1];
    Arrays.fill(canBreak, false);
    canBreak[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (canBreak[j] && words.contains(s.substring(j, i))) {
          canBreak[i] = true;
          break;
        }
      }
    }
    return canBreak[s.length()];
  }
}
