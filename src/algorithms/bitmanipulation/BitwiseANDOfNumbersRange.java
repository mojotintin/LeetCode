package algorithms.bitmanipulation;

/**
 * Created by Calabash on 2017/6/26.
 * Problem Number : 201
 * Problem Name : Bitwise AND of Numbers Range
 * Description : https://leetcode.com/problems/bitwise-and-of-numbers-range/#/description
 * Difficulty : Medium
 * Tags : Bit Manipulation
 */
public class BitwiseANDOfNumbersRange {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 11ms
   */
  public int rangeBitwiseAnd(int m, int n) {
    int and = 0;
    while (m != 0 && log2(m) == log2(n)) {
      int i = (int) Math.pow(2, log2(n));
      and |= i;
      m ^= i;
      n ^= i;
    }
    return and;
  }
  
  private int log2(int x) {
    return (int) (Math.log(x) / Math.log(2));
  }
}
