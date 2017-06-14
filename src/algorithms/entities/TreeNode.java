package algorithms.entities;

/**
 * Created by calabash on 2017/3/27.
 * LeetCode TreeNode Class
 */
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;
  public TreeNode(int x) { val = x; }

  @Override
  public String toString() {
    return "TreeNode{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        '}';
  }
}