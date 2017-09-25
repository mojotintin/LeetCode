/*
 * Created by calabash on 2017/9/25.
 * Problem Number: 415.
 * Problem Name: Add Strings.
 * Difficulty: Easy.
 * Related Topics: Math.
 * Source: https://leetcode.com/problems/add-strings/.
 */

package algorithms.math;

/**
 * # --------------------------------------------------------------------------
 * # Given two non-negative integers num1 and num2 represented as string,
 * # return the sum of num1 and num2.
 * #
 * # Note:
 * # 1. The length of both num1 and num2 is < 5100.
 * # 2. Both num1 and num2 contains only digits 0-9.
 * # 3. Both num1 and num2 does not contain any leading zero.
 * # 4. You must not use any built-in BigInteger library or convert the inputs
 * #    to integer directly.
 * # --------------------------------------------------------------------------
 */
public class AddStrings {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 31ms
   */
  public String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder();
    if (num1.length() < num2.length()) {
      String tempStr = num1;
      num1 = num2;
      num2 = tempStr;
    }
    StringBuilder num2b = new StringBuilder(num2);
    for (int i = 0; i < num1.length() - num2.length(); i++) {
      num2b.insert(0, "0");
    }
    num2 = num2b.toString();
    int carry = 0;
    for (int i = num1.length() - 1; i >= 0; i--) {
      int n = num1.charAt(i) - '0' + num2.charAt(i) - '0' + carry;
      carry = n >= 10 ? 1 : 0;
      sb.insert(0, n - 10 * carry);
    }
    if (carry == 1) {
      sb.insert(0, 1);
    }
    return sb.toString();
  }
}
