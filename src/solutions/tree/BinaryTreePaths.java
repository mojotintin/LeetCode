package solutions.tree;

import entities.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/5/15.
 * Problem : 257
 * Problem Name : Binary Tree Paths
 * Description : https://leetcode.com/problems/binary-tree-paths/#/description
 * Difficulty : Easy
 * Tags : Tree, Depth-first Search
 */
public class BinaryTreePaths {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 19ms
     * Note : Recursive
     */
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        if (root.left == null && root.right == null) {
            paths.add(String.valueOf(root.val));
            return paths;
        } else if (root.left == null) {
            paths = binaryTreePaths(root.right);
            for (int i = 0; i < paths.size(); i++) {
                paths.set(i, root.val + "->" +paths.get(i));
            }
            return paths;
        } else if (root.right == null) {
            paths = binaryTreePaths(root.left);
            for (int i = 0; i < paths.size(); i++) {
                paths.set(i, root.val + "->" +paths.get(i));
            }
            return paths;
        } else {
            paths = binaryTreePaths(root.left);
            paths.addAll(binaryTreePaths(root.right));
            for (int i = 0; i < paths.size(); i++) {
                paths.set(i, root.val + "->" +paths.get(i));
            }
            return paths;
        }
    }
}
