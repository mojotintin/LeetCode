package solutions.tree;

import entities.TreeNode;

/**
 * Created by Calabash on 2017/5/20.
 * LeetCode : Convert Sorted Array to Binary Search Tree
 * Description : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/#/description
 * Difficulty : Easy
 * Tags : Tree, Depth-first Search
 */
public class ConvertSortedArraytoBinarySearchTree_108 {

    /**
     * Status : Accepted
     * Runtime : 1ms
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode root = new TreeNode(0);
        generateBST(nums, root, 0, nums.length - 1);

        return root;
    }
    public void generateBST(int[] nums, TreeNode root, int min, int max){
        if(max == min) {
            root.val = nums[max];
            return;
        }
        if(max - min == 1) {
            root.val = nums[min];
            root.right = new TreeNode(nums[max]);
            return;
        }

        int mid = (max + min) / 2;
        root.val = nums[mid];
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        generateBST(nums, root.left, min, mid -1);
        generateBST(nums, root.right, mid + 1, max);
    }
}
