/*
 * Created by calabash on 2017/8/3.
 * Problem Number: 397
 * Problem Name: Integer Replacement
 * Difficulty: Medium
 * Related Topics: Math, Bit Manipulation
 * Source: https://leetcode.com/problems/integer-replacement/
 */
package algorithms.bitmanipulation;

/**
 * Description:
 * #---------------------------------------------------------------------------
 * # Given a positive integer n and you can do operations as follow:
 * #   1. If n is even, replace n with n/2.
 * #   2. If n is odd, you can replace n with either n + 1 or n - 1.
 * # What is the minimum number of replacements needed for n to become 1?
 * #
 * # Example 1:
 * # Input:
 * # 8
 * # Output:
 * # 3
 * # Explanation:
 * # 8 -> 4 -> 2 -> 1
 * #
 * # Example 2:
 * # Input:
 * # 7
 * # Output:
 * # 4
 * # Explanation:
 * # 7 -> 8 -> 4 -> 2 -> 1
 * # or
 * # 7 -> 6 -> 3 -> 2 -> 1
 * #---------------------------------------------------------------------------
 */
public class IntegerReplacement {

  /**
   * Submission: 1
   * Status: Runtime Error
   * Runtime: N/A
   * Runtime Error Message: java.lang.StackOverflowError
   * Last executed input: 2147483647
   */
  public int integerReplacement_1(int n) {
    if (n == 1 || n ==2) {
      return n - 1;
    }
    if (n % 2 == 0) {
      return integerReplacement_1(n / 2) + 1;
    } else {
      return Math.min(integerReplacement_1(n + 1),
          integerReplacement_1(n -1)) + 1;
    }
  }

  /**
   * Submission: 2
   * Status: Accepted
   * Runtime: 4ms
   */
  public int integerReplacement_2(int n) {
    int count = 0;
    while (n != 1) {
      if ((n & 1) == 0) {
        n >>>= 1;
      } else if (n == 3 || ((n >>> 1) & 1) == 0) {
        n -= 1;
      } else {
        n += 1;
      }
      count += 1;
    }
    return count;
  }
}
