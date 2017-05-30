package solutions.tree;

import entities.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by calabash on 2017/5/30.
 * Problem Number : 103
 * problem Name : Binary Tree Zigzag Level Order Traversal
 * Description : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/#/description
 * Difficulty : Medium
 * Tags : Tree, Breadth-first Search, Stack
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 2ms
     * Note : BFS
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> order = new ArrayList<>();
        if (root == null) return order;
        List<Integer> level = new ArrayList<>();
        List<TreeNode> levelNode = new ArrayList<>();
        level.add(root.val);
        levelNode.add(root);
        int ore = 0;

        while (!level.isEmpty()) {
            order.add(level);
            List<Integer> newLevel = new ArrayList<>();
            List<TreeNode> newLevelNode = new ArrayList<>();
            if (ore == 0) {
                for (int i = levelNode.size() - 1; i >= 0; i--) {
                    if (levelNode.get(i).right != null) {
                        newLevelNode.add(levelNode.get(i).right);
                        newLevel.add(levelNode.get(i).right.val);
                    }
                    if (levelNode.get(i).left != null) {
                        newLevelNode.add(levelNode.get(i).left);
                        newLevel.add(levelNode.get(i).left.val);
                    }
                }
                levelNode = newLevelNode;
                level = newLevel;
                ore = 1;
            } else {
                for (int i = levelNode.size() - 1; i >= 0; i--) {
                    if (levelNode.get(i).left != null) {
                        newLevelNode.add(levelNode.get(i).left);
                        newLevel.add(levelNode.get(i).left.val);
                    }
                    if (levelNode.get(i).right != null) {
                        newLevelNode.add(levelNode.get(i).right);
                        newLevel.add(levelNode.get(i).right.val);
                    }
                }
                levelNode = newLevelNode;
                level = newLevel;
                ore = 0;
            }
        }
        return order;
    }
}
