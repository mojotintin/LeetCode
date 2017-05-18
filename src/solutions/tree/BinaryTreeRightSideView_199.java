package solutions.tree;

import entities.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/5/18.
 * LeetCode 199th
 * Description : https://leetcode.com/problems/binary-tree-right-side-view/#/description
 * Difficulty : Medium
 * Tags : Tree, Depth-first Search, Breadth-first Search
 */
public class BinaryTreeRightSideView_199 {

    /**
     * Status : Accepted
     * Runtime : 4ms
     * Note : BFS
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<Integer>();
        if (root == null) return view;
        List<TreeNode> floor = new ArrayList<>();
        floor.add(root);
        while (!floor.isEmpty()) {
            view.add(floor.get(floor.size() - 1).val);
            List<TreeNode> list = new ArrayList<>();
            for (TreeNode node : floor) {
                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
            }
            floor = list;
        }
        return view;
    }
}
