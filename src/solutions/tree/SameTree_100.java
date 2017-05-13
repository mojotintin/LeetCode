package solutions.tree;

import entities.TreeNode;

/**
 * Created by calabash on 2017/3/27.
 * LeetCode 100th Same Tree.
 * Tags : Tree, Depth-first Search
 */
public class SameTree_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q ==null){
            return true;
        } else if (p == null && q != null){
            return false;
        } else if (p != null && q == null){
            return false;
        } else if (p.val != q.val) {
            return false;
        }  else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}