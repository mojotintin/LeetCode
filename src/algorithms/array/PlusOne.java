package algorithms.array;

/**
 * Created by Calabash on 2017/6/7.
 * Problem Number : 66
 * Problem Name : Plus One
 * Description : https://leetcode.com/problems/plus-one/#/description
 * Difficulty : Easy
 * Tags : Array, Math
 */
public class PlusOne {
  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 0ms
   */
  public int[] plusOne(int[] digits) {
    int over = 1;
    for (int i = digits.length - over; i >= 0; i--) {
      if (digits[i] + over >= 10) {
        digits[i] = digits[i] + over - 10;
      } else {
        digits[i] = digits[i] + over;
        over = 0;
        break;
      }
    }
    if (over == 0) {
      return digits;
    } else {
      int[] newDigits = new int[digits.length + 1];
      newDigits[0] = 1;
      System.arraycopy(digits, 0, newDigits, 1, digits.length);
      return newDigits;
    }
  }
}
