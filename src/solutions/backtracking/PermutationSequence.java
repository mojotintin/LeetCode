package solutions.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/6/5.
 * Problem Number : 60
 * Problem Name : Permutation Sequence
 * Description : https://leetcode.com/problems/permutation-sequence/#/description
 * Difficulty : Medium
 * Tags : Backtracking, Math
 */
public class PermutationSequence {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 16ms
   */
  public String getPermutation(int n, int k) {
    int num = 1;
    for (int i = 1; i < n; i++) {
      num *= i;
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      list.add(i);
    }
    StringBuilder s = new StringBuilder();
    for (int i = n - 1; i >= 1; i--) {
      int count = (k - 1) / num;
      s.append(list.remove(count));
      k  -= num * count;
      num /= i;
    }
    s.append(list.remove(0));
    return s.toString();
  }
}
