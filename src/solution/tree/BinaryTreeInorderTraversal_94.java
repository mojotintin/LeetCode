package solution.tree;

import entities.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Calabash on 2017/5/11.'
 * The LeetCode 94th
 * Tags : Tree, Hash Table, Stack
 */
public class BinaryTreeInorderTraversal_94 {

    // dfs
    List<Integer> traversal = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return traversal;
        if(root.left != null) inorderTraversal(root.left);
        traversal.add(root.val);
        if(root.right != null) inorderTraversal(root.right);
        return traversal;
    }
}
