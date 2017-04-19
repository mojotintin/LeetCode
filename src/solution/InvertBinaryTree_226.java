package solution;

import entities.TreeNode;

/**
 * Created by calabash on 2017/3/28.
 * LeetCode 226th Invert Binary Tree
 * √
 */
public class InvertBinaryTree_226 {

    public TreeNode invertTree(TreeNode root) {

        if (root != null && (root.left != null || root.right != null)) {
            TreeNode nodeLeft = invertTree(root.left);
            TreeNode  nodeRight = invertTree(root.right);
            root.left = nodeRight;
            root.right = nodeLeft;
        }
        return root;
    }
}
