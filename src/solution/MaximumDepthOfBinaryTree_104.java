package solution;

import entities.TreeNode;

/**
 * Created by calabash on 2017/4/7.
 *
 */
public class MaximumDepthOfBinaryTree_104 {

    public int maxDepth(TreeNode root) {

        if (root == null) return 0;
        else return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
