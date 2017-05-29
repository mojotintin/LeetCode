package solutions.tree;

import entities.TreeNode;

/**
 * Created by Calabash on 2017/5/21.
 * Problem Number : 129
 * Problem Name : Sum Root to Leaf Numbers
 * Description : https://leetcode.com/problems/sum-root-to-leaf-numbers/#/description
 * Difficulty : Medium
 * Tags : Tree, Depth-First Search
 */
public class SumRootToLeafNumbers {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 1ms
     */
    public int sumNumbers(TreeNode root) {
        return sumOfRootToLeaf(root, 0);
    }

    private int sumOfRootToLeaf(TreeNode root, int sum) {

        if(root ==null) return sum;
    	if (root.left == null && root.right == null) {
    	    return sum * 10 + root.val;
    	} else if (root.left == null) {
    		return sumOfRootToLeaf(root.right, sum * 10 + root.val);
    	} else if (root.right == null) {
    		return sumOfRootToLeaf(root.left, sum * 10 + root.val);
    	} else {
    		return sumOfRootToLeaf(root.left, sum * 10 + root.val) + sumOfRootToLeaf(root.right, sum * 10 + root.val);
    	}
    }
}
