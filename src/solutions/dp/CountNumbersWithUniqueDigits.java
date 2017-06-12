package solutions.dp;

/**
 * Created by Calabash on 2017/6/12.
 * Problem Number : 357
 * Problem Name : Count Numbers with Unique Digits
 * Description : https://leetcode.com/problems/count-numbers-with-unique-digits/#/description
 * Difficulty : Medium
 * Tags : Dynamic Programming, Backtracking, Math
 */
public class CountNumbersWithUniqueDigits {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 0ms
   */
  public int countNumbersWithUniqueDigits(int n) {
    if (n == 0) {
      return 1;
    }
    int[] count = new int[10];
    count[0] = 10;
    for (int i = 1; i < 10; i++) {
      int k = 1;
      for (int j = 9; j >= 10 - i; j--) {
        k *= j;
      }
      count[i] += count[i - 1] + k * 9;
    }
    if (n <= 10) {
      return count[n - 1];
    } else {
      return count[9];
    }
  }
}
