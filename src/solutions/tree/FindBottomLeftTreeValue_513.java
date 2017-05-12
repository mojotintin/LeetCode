package solutions.tree;

import entities.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by calabash on 2017/4/6.
 * The LeetCode 523th
 * Tags : Tree, Depth-first Search, Breadth-first Search
 */
public class FindBottomLeftTreeValue_513 {

    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            if (node.right != null) queue.add(node.right);
            if (node.left != null) queue.add(node.left);
        }
        return node.val;
    }
}
