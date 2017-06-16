package algorithms.tree;

import algorithms.entities.TreeNode;

/**
 * Created by Calabash on 2017/6/16.
 * Problem Number : 450
 * Problem Name : Delete Node in a BST
 * Description : https://leetcode.com/problems/delete-node-in-a-bst/#/description
 * Difficulty : Medium
 * Tags : Tree
 */
public class DeleteNodeInABST {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 8ms
   */
  public TreeNode deleteNode(TreeNode root, int key) {
    TreeNode father = new TreeNode(0);
    TreeNode node = father;
    father.left = root;
    father = find(root, father, key);
    if (father != null){
      if(father.left != null && father.left.val == key){
        TreeNode temp = father.left;
        if (temp.left == null) {
          father.left = temp.right;
        } else if (temp.right == null) {
          father.left = temp.left;
        } else {
          father.left = temp.right;
          father= father.left;
          while (father.left != null) {
            father = father.left;
          }
          father.left = temp.left;
        }

      } else{
        TreeNode temp = father.right;
        if (temp.left == null) {
          father.right = temp.right;
        } else if (temp.right == null) {
          father.right = temp.left;
        } else {
          father.right = temp.right;
          father = father.right;
          while (father.left != null) {
            father = father.left;
          }
          father.left = temp.left;
        }
      }
    }
    return node.left;
  }

  private TreeNode find(TreeNode root, TreeNode father, int key) {
    if (root == null) {
      return null;
    }
    if (root.val == key){
      return father;
    }else if(root.val > key){
      return find(root.left,  root, key);
    }else {
      return find(root.right, root, key);
    }
  }
}
