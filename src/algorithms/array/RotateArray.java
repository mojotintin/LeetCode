package algorithms.array;

/**
 * Created by Calabash on 2017/6/29.
 * Problem Number : 189
 * Problem Name : Rotate Array
 * Description : https://leetcode.com/problems/rotate-array/#/description
 * Difficulty : Easy
 * Tags : Array
 */
public class RotateArray {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 1ms
   */
  public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        k %= nums.length;
        if (k == 0) {
            return;
        }
        for (int i = 0; i < (nums.length - k) / 2; i++) {
            swap(nums, i, nums.length - k - i - 1);
        }
        for (int i = 0; i < k / 2; i++) {
            swap(nums, nums.length - k + i, nums.length - 1 - i);
        }
        for (int i = 0; i < nums.length / 2; i++) {
            swap(nums, i, nums.length - 1 - i);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
