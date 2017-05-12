package solutions.tree;

import entities.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/5/11.'
 * The LeetCode 94th
 * Tags : Tree, Hash Table, Stack
 */
public class BinaryTreeInorderTraversal_94 {

    // Traversal
    List<Integer> traversal = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return traversal;
        }
        if(root.left != null) {
            inorderTraversal(root.left);
        }
        traversal.add(root.val);
        if(root.right != null) {
            inorderTraversal(root.right);
        }
        return traversal;
    }
}
