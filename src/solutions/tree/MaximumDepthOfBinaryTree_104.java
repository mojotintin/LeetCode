package solutions.tree;

import entities.TreeNode;

/**
 * Created by calabash on 2017/4/7.
 * The LeetCode 104th
 * Tags : Tree, Depth-first Search, Breadth-first Search
 */
public class MaximumDepthOfBinaryTree_104 {

    public int maxDepth(TreeNode root) {

        if (root == null) return 0;
        else return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
