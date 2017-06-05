package solutions.array;

/**
 * Created by calabash on 2017/5/26.
 * Problem Number : 41
 * Problem Name : First Missing Positive
 * Description : https://leetcode.com/problems/first-missing-positive/#/description
 * Difficulty : Hard
 * Tags : Array
 */
public class FirstMissingPositive {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 13ms
   * Time Complexity : o(n)
   */
  public int firstMissingPositive(int[] nums) {

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= 0) {
        nums[i] = Integer.MAX_VALUE;
      }
    }
    for (int num : nums) {
      int n = Math.abs(num);
      if (n <= nums.length && nums[n - 1] > 0) {
        nums[n - 1] = -nums[n - 1];
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        return i + 1;
      }
    }
    return nums.length + 1;
  }
}
