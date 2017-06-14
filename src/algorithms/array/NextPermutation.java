package algorithms.array;

/**
 * Created by Calabash on 2017/6/3.
 * Problem Number : 31
 * Problem Name : Next Permutation
 * Description : https://leetcode.com/problems/next-permutation/#/description
 * Difficulty : Medium
 * Tags : Array
 */
public class NextPermutation {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 18ms
   */
  public void nextPermutation(int[] nums) {
    for (int i = nums.length - 1; i > 0; i--) {
      if (nums[i - 1] < nums[i]) {
        for (int j = nums.length - 1; j > i - 1; j--) {
          if (nums[j] > nums[i - 1]) {
            swap(nums, i-1, j);
            break;
          }
        }
        reverse(nums, i, nums.length - 1);
        break;
      }
      if (i == 1) {
        reverse(nums, 0, nums.length - 1);
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void reverse(int[] nums, int i, int j) {
    int count = (j - i + 1) / 2;
    for (int k = 0; k < count; k++) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }
}
