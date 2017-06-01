package solutions.array;

/**
 * Created by Calabash on 2017/5/15.
 * Problem Number : 209
 * Problem Name : Minimum Size Subarray Sum
 * Description : https://leetcode.com/problems/binary-tree-paths/#/description
 * Difficulty : Medium
 * Tags : Array, Two Pointers, Binary Search
 */
public class MinimumSizeSubarraySum {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 2ms
     */
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int minLen = nums.length + 1;
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= s) return 1;
            sum += nums[i];
            if (sum >= s) {
                while (sum >= s) {
                    sum -= nums[start++];
                }
                minLen = Math.min(minLen, i - start + 2);
            }
        }

        if (minLen == nums.length + 1) return 0;
        else return minLen;
    }
}
