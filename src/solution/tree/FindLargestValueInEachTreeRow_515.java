package solution.tree;

import entities.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Calabash on 2017/4/13.
 * The LeetCode 515th
 * Tags : Tree, Depth-first Search, Breadth-first Search
 */
public class FindLargestValueInEachTreeRow_515 {

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        list.add(root.val);
        queue.add(root);
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left != null) {
                q.add(node.left);
                max = Math.max(node.left.val, max);
            }
            if (node.right != null) {
                q.add(node.right);
                max = Math.max(node.right.val, max);
            }
            if (queue.isEmpty() && !q.isEmpty()) {
                queue = q;
                q = new LinkedList<>();
                list.add(max);
                max = Integer.MIN_VALUE;
            }
        }
        return list;
    }
}
