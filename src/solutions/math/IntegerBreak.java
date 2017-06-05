package solutions.math;

/**
 * Created by Calabash on 2017/5/14.
 * Problem Number : 343
 * Problem Name : Integer Break
 * Description : https://leetcode.com/problems/integer-break/#/description
 * Difficulty : Medium
 * Tags : Dynamic Programming, Math
 */
public class IntegerBreak {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 0ms
   * Note : Math
   */
  public int integerBreak(int n) {
    if(n == 2) {
      return 1;
    }else if(n == 3) {
      return 2;
    }
    int x = n / 3;
    int y = n % 3;
    if (y == 0) {
      return (int)Math.pow(3, x);
    } else if (y == 1) {
      return (int)Math.pow(3, x - 1) * 4;
    } else{
      return (int)Math.pow(3, x) * 2;
    }
  }
}
