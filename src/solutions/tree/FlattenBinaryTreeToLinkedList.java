package solutions.tree;

import entities.TreeNode;

/**
 * Created by Calabash on 2017/5/25.
 * Problem Number : 114
 * problem Name : Flatten Binary Tree to Linked List
 * Description : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/#/description
 * Difficulty : Medium
 * Tags : Tree, Depth-first Search
 */
public class FlattenBinaryTreeToLinkedList {

     /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 1ms
     */
     public void flatten(TreeNode root) {

        if (root== null) return;

        constructTree(root);
    }

    private TreeNode constructTree(TreeNode root) {

    	if (root.left == null  && root.right == null) return root;
        else if (root.left == null) return constructTree(root.right);
        else if (root.right == null) {
        	root.right = root.left;
        	root.left = null;
        	return constructTree(root.right);
        } else {
        	TreeNode temp = root.right;
        	root.right = root.left;
        	root.left = null;
        	TreeNode node = constructTree(root.right);
        	node.right = temp;
        	return constructTree(temp);
        }
    }
}
