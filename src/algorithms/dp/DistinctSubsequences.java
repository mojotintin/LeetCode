package algorithms.dp;

/**
 * Created by Calabash on 2017/7/5.
 * Problem Number : 115
 * Problem Name : Distinct Subsequences
 * Description : https://leetcode.com/problems/distinct-subsequences/#/description
 * Difficulty : Hard
 * Tags : Dynamic Programming, String
 */
public class DistinctSubsequences {

  /**
   * Submission : 1
   * Status : Time Limit Exceeded
   * Runtime : N/A
   */
  private int num = 0;
  public int numDistinct_1(String s, String t) {
    helper(s, s.length(), t, t.length());
    return num;
  }

  private void helper(String s, int slen, String t, int tlen) {
    if (slen == 0) {
      return;
    }
    if (tlen == 0) {
      num += 1;
      return;
    }
    if (slen == tlen) {
      if (s.substring(0, slen).equals(t.substring(0, tlen))) {
        num += 1;
      }
    } else if (slen > tlen){
      if (s.charAt(slen - 1) == t.charAt(tlen - 1)) {
        helper(s, slen - 1, t, tlen - 1);
      }
      helper(s, slen - 1, t, tlen);
    }
  }

  /**
   * Submission : 2
   * Status : Accepted
   * Runtime : 17ms
   */
  public int numDistinct_2(String s, String t) {
    int[][] nums = new int[t.length() + 1][s.length() + 1];
    for (int i = 0; i <= s.length(); i++) {
      nums[0][i] = 1;
    }
    for (int i = 1; i <= t.length(); i++) {
      for (int j = i; j <= s.length(); j++) {
        nums[i][j] = nums[i][j - 1];
        if (s.charAt(j - 1) == t.charAt(i - 1)) {
          nums[i][j] += nums[i - 1][j - 1];
        }
      }
    }
    return nums[t.length()][s.length()];
  }
}
