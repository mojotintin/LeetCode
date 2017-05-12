package solutions.tree;

import entities.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/5/12.
 * The LeetCode 145th
 * Tags : Tree, Stack
 */
public class BinaryTreePostorderTraversal_145 {

    // Recursive
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal_1(TreeNode root) {

        if (root == null) {
            return list;
        }
        if (root.left != null) {
            postorderTraversal_1(root.left);
        }
        if (root.right != null) {
            postorderTraversal_1(root.right);
        }
        list.add(root.val);
        return list;
    }

    // using stack
    public List<Integer> postorderTraversal_2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }


        return list;
    }
}
