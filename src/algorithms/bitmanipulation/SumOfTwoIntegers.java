package algorithms.bitmanipulation;

/**
 * Created by calabash on 2017/6/22.
 * Problem Number : 371
 * Problem Name : Sum of Two Integers
 * Description : https://leetcode.com/problems/sum-of-two-integers/#/description
 * Difficulty : Easy
 * Tags : Bit Manipulation
 */
public class SumOfTwoIntegers {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 0ms
   */
  public int getSum(int a, int b) {
    int sum   = a ^ b;
    int carry = (a & b) << 1;
    while (carry != 0) {
      a = sum;
      b = carry;
      sum   = a ^ b;
      carry = (a & b) << 1;
    }
    return sum;
  }
}

