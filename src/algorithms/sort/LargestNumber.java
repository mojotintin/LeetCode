/*
 * Created by calabash on 2017/9/15.
 * Problem Number: 179.
 * Problem Name: Largest Number.
 * Difficulty: Medium.
 * Related Topics: Sort.
 * Source: https://leetcode.com/problems/largest-number/.
 */

package algorithms.sort;

import java.util.Arrays;

/**
 * # --------------------------------------------------------------------------
 * # Given a list of non negative integers, arrange them such that they form
 * # the largest number.
 * # For example, given [3, 30, 34, 5, 9], the largest formed number is
 * # 9534330.
 * # Note: The result may be very large, so you need to return a string instead
 * # of an integer.
 * # --------------------------------------------------------------------------
 */
public class LargestNumber {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 119ms
   */
  public String largestNumber(int[] nums) {
    String[] strs = new String[nums.length];
    // transfer the int array to string array
    for (int i = 0; i < nums.length; i++) {
      strs[i] = String.valueOf(nums[i]);
    }
    // resort thr string array
    Arrays.sort(strs, (str1, str2) -> {
      String s1 = str1 + str2;
      String s2 = str2 + str1;
      for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) > s2.charAt(i)) {
          return -1;
        } else if (s1.charAt(i) < s2.charAt(i)) {
          return 1;
        }
      }
      return 1;
    });
    StringBuilder s = new StringBuilder();
    boolean isZero =true;
    for (String str : strs) {
      s.append(str);
      if (!str.equals("0")) {
        isZero = false;
      }
    }
    if (isZero) {
      return "0";
    }
    return s.toString();
  }
}
