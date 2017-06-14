package algorithms.math;

/**
 * Created by Calabash on 2017/4/13.
 * Problem Number : 400
 * Problem Name : Nth Digit
 * Description : https://leetcode.com/problems/nth-digit/#/description
 * Difficulty : Easy
 * Tags : Math
 */
public class NthDigit {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 6ms
   */
  public int findNthDigit(int n) {
    int c = 1;
    long m = 9;
    while (n > c * m) {
      n -= c * m;
      c += 1;
      m *= 10;
    }
    return Character.getNumericValue((String.valueOf
        ((long) (Math.pow(10, c - 1)) + (n - 1) / c).charAt((n - 1) % c)));
  }
}