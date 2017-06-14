package algorithms.backtracking;

/**
 * Created by Calabash on 2017/6/14.
 * Problem Number : 526
 * Problem Name : Beautiful Arrangement
 * Description : https://leetcode.com/problems/beautiful-arrangement/#/description
 * Difficulty : Medium
 * Tags : Backtracking
 */
public class BeautifulArrangement {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 90ms
   */
  private int count = 0;

  public int countArrangement(int N) {
    helper(N, 1, new boolean[N + 1]);
    return count;
  }

  private void helper(int N, int pos, boolean[] walked) {
    if (pos > N) {
      count += 1;
      return;
    }
    for (int i = 1; i <= N; i++) {
      if (walked[i] || (pos % i != 0 && i % pos != 0)) {
        continue;
      }
      walked[i] = true;
      helper(N, pos + 1, walked);
      walked[i] = false;
    }
  }
}
