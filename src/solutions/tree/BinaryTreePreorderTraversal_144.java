package solutions.tree;

import entities.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Calabash on 2017/5/12.
 * The LeetCode 144th
 * Tags : Tree, Stack
 */
public class BinaryTreePreorderTraversal_144 {

    // recursion
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal_1(TreeNode root) {
        if(root == null) return list;
        list.add(root.val);
        if(root.left != null) {
            preorderTraversal_1(root.left);
        }
        if(root.right != null) {
            preorderTraversal_1(root.right);
        }
        return list;
    }

    // using stack
    public List<Integer> preorderTraversal_2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
        	return list;
        }
        stack.push(root);

        while (!stack.empty()) {
        	TreeNode node = stack.pop();
        	list.add(node.val);
        	if (node.right != null) {
        		stack.push(node.right);
        	}
        	if (node.left != null) {
        		stack.push(node.left);
        	}
        }

        return list;
    }
}
