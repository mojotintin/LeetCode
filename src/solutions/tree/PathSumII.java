package solutions.tree;

import entities.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by calabash on 2017/5/29.
 * Problem Number : 113
 * Problem Name : Path Sum II
 * Description : https://leetcode.com/problems/path-sum-ii/#/description
 * Difficulty : Medium
 * Tags : Tree, Depth-first Search
 */
public class PathSumII {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 6ms
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null) return new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        return getPath(root, sum, path);
    }

    private List<List<Integer>> getPath(TreeNode root, int sum, List<Integer> path) {

        path.add(root.val);
        if (root.left == null && root.right == null) {
            List<List<Integer>> pathList = new ArrayList<>();
            if (sum == root.val) {
                pathList.add(path);
                return pathList;
            }
            else return pathList;
        } else if (root.left == null) {
            List<Integer> newPath = new ArrayList<>(path);
            return getPath(root.right, sum - root.val, newPath);
        } else if (root.right == null) {
            List<Integer> newPath = new ArrayList<>(path);
            return getPath(root.left, sum - root.val, newPath);
        } else {
            List<Integer> newLeftPath = new ArrayList<>(path);
            List<Integer> newRightPath = new ArrayList<>(path);
            List<List<Integer>> pathList = getPath(root.left, sum - root.val, newLeftPath);
            pathList.addAll(getPath(root.right, sum - root.val, newRightPath));
            return pathList;
        }
    }
}
