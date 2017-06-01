package solutions.tree;

import entities.TreeNode;

/**
 * Created by Calabash on 2017/5/7.
 * Problem Number : 572
 * Problem Name : Subtree of Another Tree
 * Description : https://leetcode.com/problems/subtree-of-another-tree/#/description
 * Difficulty : Easy
 * Tags : Tree
 */
public class SubtreeOfAnotherTree {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 29ms
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (s ==null || t == null) {
            return false;
        } else if (isSameTree(s, t)) {
            return true;
        } else return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {

        if (s == null && t == null) return true;
        else if (s != null && t != null && s.val == t.val) return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        else return false;
    }
}
