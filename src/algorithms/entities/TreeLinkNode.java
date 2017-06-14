package algorithms.entities;

/**
 * Created by Calabash on 2017/6/6.
 * Definition for binary tree with next pointer.
 */
public class TreeLinkNode {
  public int val;
  public TreeLinkNode left, right, next;
  public TreeLinkNode(int x) { val = x; }

  @Override
  public String toString() {
    return "TreeLinkNode{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        ", next=" + next +
        '}';
  }
}
