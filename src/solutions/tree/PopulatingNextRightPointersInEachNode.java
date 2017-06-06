package solutions.tree;

import entities.TreeLinkNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/6/6.
 * Problem NUmber : 116
 * Problem Name : Populating Next Right Pointers in Each Node
 * Description : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/#/description
 * Difficulty : Medium
 * Tags : Tree, Depth-first Search
 */
public class PopulatingNextRightPointersInEachNode {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 4ms
   */
  public void connect(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    List<TreeLinkNode> list = new ArrayList<>();
    list.add(root);
    while (list.size() != 0) {
      List<TreeLinkNode> floor = new ArrayList<>();
      for (int i = 0;i < list.size() - 1; i++) {
        TreeLinkNode node = list.get(i);
        node.next = list.get(i + 1);
        if (node.left != null) {
          floor.add(node.left);
        }
        if (node.right != null) {
          floor.add(node.right);
        }
      }
      TreeLinkNode node = list.get(list.size() - 1);
      node.next = null;
      if (node.left != null) {
        floor.add(node.left);
      }
      if (node.right != null) {
        floor.add(node.right);
      }
      list = floor;
    }
  }
}
