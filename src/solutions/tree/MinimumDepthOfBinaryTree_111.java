package solutions.tree;

import entities.TreeNode;

/**
 * Created by calabash on 2017/4/6.
 * The LeetCode 111th
 * Tags : Tree, Depth-first Search, Breadth-first Search
 */
public class MinimumDepthOfBinaryTree_111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 1;
        else if (root.left != null && root.right != null) return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        else return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
