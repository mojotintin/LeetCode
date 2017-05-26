package solutions.stack;

import java.util.Stack;

/**
 * Created by calabash on 2017/3/31.
 * Problem Number : 456
 * Problem Name : 132 Pattern
 * Description : https://leetcode.com/problems/132-pattern/#/description
 * Difficulty : Medium
 * Tags : Stack
 */
public class Pattern132 {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 366ms
     * Time complexity : O(n ^ 2)
     */
    public boolean find132pattern_1(int[] nums) {

        if (nums.length < 3){
            return false;
        }

        int min = nums[0];
        for (int i = 1; i< nums.length - 1; i++){
            if (nums[i] > min) {
                for (int j = i + 1; j < nums.length; j++){
                    if (nums[i] > nums[j] && min < nums[j]) {
                        return true;
                    }
                }
            } else {
                min = nums[i];
            }
        }
        return false;
    }

    /**
     * Submission : 2
     * Status : Accepted
     * Runtime : 33ms
     * Time complexity : O(n)
     */
    public boolean find132pattern_2(int[] nums) {

        int len = nums.length;
        if (len < 3){
            return false;
        }

        Stack<Integer> right = new Stack<>();
        int s3 = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] < s3) {
                return true;
            }
            while (!right.empty() && nums[i] > right.peek()) {
                s3 = right.pop();
            }
            right.push(nums[i]);
        }
        return false;
    }
}
