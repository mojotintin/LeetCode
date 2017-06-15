package algorithms.tree;

import algorithms.entities.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Calabash on 2017/6/15.
 * Problem Number : 508
 * Problem Name : Most Frequent Subtree Sum
 * Description : https://leetcode.com/problems/most-frequent-subtree-sum/#/description
 * Difficulty : Medium
 * Tags : Tree, Hash Table
 */
public class MostFrequentSubtreeSum {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 18ms
   */
  public int[] findFrequentTreeSum(TreeNode root) {
    HashMap<Integer, Integer> map = new HashMap<>();
    update(root, map);
    List<Integer> list = new ArrayList<>();
    int count = -1;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (count < entry.getValue()) {
        count = entry.getValue();
        list = new ArrayList<>();
        list.add(entry.getKey());
      } else if (count == entry.getValue()) {
        list.add(entry.getKey());
      }
    }
    count = 0;
    int[] fre = new int[list.size()];
    for (int i : list) {
      fre[count++] = i;
    }
    return fre;
  }

  private int update(TreeNode root, HashMap<Integer, Integer> map) {
    if (root == null) {
      return 0;
    } else {
      root.val += update(root.left, map) + update(root.right, map);
      if (map.containsKey(root.val)) {
        map.replace(root.val, map.get(root.val) + 1);
      } else {
        map.put(root.val, 0);
      }
      return root.val;
    }
  }
}
