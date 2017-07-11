package algorithms.dp;

/**
 * Created by calabash on 2017/7/11.
 * Problem Number : 152
 * Problem Name : Maximum Product Subarray
 * Difficulty : Medium
 * Description : https://leetcode.com/problems/maximum-product-subarray/#/description
 * #---------------------------------------------------------------------------
 * # Find the contiguous subarray within an array (containing at least one
 * # number) which has the largest product.
 *
 * # For example, given the array [2,3,-2,4],
 * # the contiguous subarray [2,3] has the largest product = 6.
 * #---------------------------------------------------------------------------
 */
public class MaximumProductSubarray {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 2ms
   */
  public int maxProduct(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int n1 = 1;
    int n2 = 1;
    boolean negative = false;
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      if (num == 0) {
        n1 = 1;
        n2 = 1;
        negative = false;
        max = Math.max(0, max);
        continue;
      }
      n1 *= num;
      if (negative) {
        n2 *= num;
        max = Math.max(max, Math.max(n1, n2));
      } else {
        if (num < 0) {
          negative = true;
        }
        max = Math.max(max, n1);
      }
    }
    return max;
  }
}
