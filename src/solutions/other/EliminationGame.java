package solutions.other;

/**
 * Created by calabash on 2017/6/13.
 * Problem Number : 390
 * Problem Name : Elimination Game
 * Description : https://leetcode.com/problems/elimination-game/#/description
 * Difficulty : Medium
 * Tags : Other
 */
public class EliminationGame {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 77ms
   */
  public int lastRemaining(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    if (n % 2 != 0) {
      return lastRemaining(n - 1);
    } else {
      return (n / 2 + 1 - lastRemaining(n / 2)) * 2;
    }
  }
}
