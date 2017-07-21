package algorithms.bitmanipulation;

/**
 * Created by Calabash on 2017/7/21.
 * Problem Number : 231
 * Problem Name : Power of Two
 * Difficulty : Easy
 * Tags : Math, Bit Manipulation
 * #---------------------------------------------------------------------------
 * # Description : https://leetcode.com/problems/power-of-two/#/description
 * #
 * # Given an integer, write a function to determine if it is a power of two.
 * #---------------------------------------------------------------------------
 */
public class PowerOfTwo {

  /**
   * Submission : 1
   * Runtime : 2ms
   * Status : Accepted
   */
  public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }
}
