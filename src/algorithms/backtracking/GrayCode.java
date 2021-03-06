package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/5/11.
 * Problem Number : 89
 * Problem Name : Gray Code
 * Description : https://leetcode.com/problems/gray-code/#/description
 * Difficulty : Medium
 * Tags : Backtracking
 */
public class GrayCode {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 3ms
   */
  public List<Integer> grayCode_1(int n) {
    List<Integer> codes = new ArrayList<>();
    codes.add(0);
    for (int i = 0; i < n; i ++) {
      for (int j = (int)Math.pow(2, i) - 1; j >= 0; j --) {
        codes.add((int)Math.pow(2, i) + codes.get(j));
      }
    }
    return codes;
  }

  /**
   * Submission : 2
   * Status : Accepted
   * Runtime : 2ms
   */
  public List<Integer> grayCode_2(int n) {
    List<Integer> codes = new ArrayList<>();
    codes.add(0);
    if (n == 0) {
      return codes;
    }
    codes.add(1);
    if (n == 1) {
      return codes;
    }
    for (int i = 1; i < n; i++) {
      for (int j = (2 << (i - 1)) - 1; j >= 0; j--) {
        codes.add((2 << (i - 1)) + codes.get(j));
      }
    }
    return codes;
  }

  /**
   * Submission : 3
   * Status : Accepted
   * Runtime : 1ms
   */
  public List<Integer> grayCode_3(int n) {
    List<Integer> codes = new ArrayList<>();
    codes.add(0);
    if (n == 0) {
      return codes;
    }
    codes.add(1);
    if (n == 1) {
      return codes;
    }
    int[] cs = new int[2 << (n - 1)];
    cs[0] = 0;
    cs[1] = 1;
    int count = 2;
    for (int i = 1; i < n; i++) {
      for (int j = (2 << (i - 1)) - 1; j >= 0; j--) {
        cs[count++] = (2 << (i - 1)) + cs[j];
      }
    }
    codes = new ArrayList<>();
    for (int i : cs) {
      codes.add(i);
    }
    return codes;
  }
}
