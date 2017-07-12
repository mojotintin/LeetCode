package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/7/12.
 * Problem Number : 77
 * Problem Name : Combinations
 * Difficulty : Medium
 * Tags : Backtracking
 * Description : https://leetcode.com/problems/combinations/#/description
 * #---------------------------------------------------------------------------
 * # Given two integers n and k, return all possible combinations of k numbers
 * # out of 1 ... n.
 * #
 * # For example,
 * # If n = 4 and k = 2, a solution is:
 * # [
 * # [2,4],
 * # [3,4],
 * # [2,3],
 * # [1,2],
 * # [1,3],
 * # [1,4],
 * # ]
 * #---------------------------------------------------------------------------
 */
public class Combinations {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 27ms
   */
  public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        if (k == 0) {
            combinations.add(new ArrayList<>());
            return combinations;
        }
        for (int i = 1; i <= n - k + 1; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            combinations.add(list);
        }
        for (int i = 1; i < k; i++) {
            int len = combinations.size();
            while (len > 0) {
                List<Integer> combination = combinations.remove(0);
                for (int j = combination.get(combination.size() - 1) + 1; j <= n - k + 1 + i; j++) {
                    List<Integer> list = new ArrayList<>(combination);
                    list.add(j);
                    combinations.add(list);
                }
                len -= 1;
            }
        }
        return combinations;
    }
}
