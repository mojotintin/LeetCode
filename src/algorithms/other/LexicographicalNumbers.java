/*
 * Created by calabash on 2017/8/17.
 * Problem Number: 386.
 * Problem Name: Lexicographical Numbers.
 * Difficulty: Medium.
 * Related Topics: Other.
 * Source: https://leetcode.com/problems/lexicographical-numbers/.
 */

package algorithms.other;

import java.util.ArrayList;
import java.util.List;

/**
 * # --------------------------------------------------------------------------
 * # Given an integer n, return 1 - n in lexicographical order.
 * # For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * # Please optimize your algorithm to use less time and space. The input size
 * # may be as large as 5,000,000.
 * #---------------------------------------------------------------------------
 */
public class LexicographicalNumbers {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 166ms
   */
  public List<Integer> lexicalOrder(int n) {
    // the n numbers from 0 to n can construct a tree,
    // the preorder of the is the answer.
    List<Integer> orders = new ArrayList<>();
    for (int i = 1; i <= 9; i++) {
      if (i > n) {
        break;
      }
      orders.add(i);
      preorder(n, i, orders);
    }
    return orders;
  }

  // preorder traversal for the tree
  private void preorder(int n, int num, List<Integer> orders) {
    for (int i = 0; i <= 9; i++) {
      if (num * 10 + i > n) {
        break;
      }
      orders.add(num * 10 + i);
      preorder(n, num * 10 + i, orders);
    }
  }
}
