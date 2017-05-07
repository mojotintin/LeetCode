package solution;

import entities.TreeNode;

/**
 * Created by Calabash on 2017/5/7.
 *
 */
public class SubtreeOfAnotherTree_572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {

    	if (s ==null || t == null) {
        	return false;
        } else if (isSameTree(s, t)) {
        	return true;
        } else return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {

    	if (s == null && t == null) return true;
    	else if (s != null && t != null && s.val == t.val) return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    	else return false;
    }
}
