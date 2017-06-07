package solutions.twopointers;

/**
 * Created by Calabash on 2017/6/7.
 * Problem Number : 11
 * Problem Name : Container With Most Water
 * Description : https://leetcode.com/problems/container-with-most-water/#/description
 * Difficulty : Medium
 * Tags : Array, Two Pointers
 */
public class ContainerWithMostWater {

  /**
   * Submission : 1
   * Status : Time Limit Exceeded
   * Runtime : N/A
   * Time Complexity : o(n^2)
   */
  public int maxArea_1(int[] height) {
    int water = 0;
    for (int i = 0; i < height.length - 1; i++) {
      for (int j = i + 1; j < height.length; j++) {
        water = Math.max(water, (j - i) * Math.min(height[i], height[j]));
      }
    }
    return water;
  }

  /**
   * Submission : 2
   * Status : Accepted
   * Runtime : 11ms
   * Time Complexity : o(n)
   * Note : Two Pointers
   */
  public int maxArea_2(int[] height) {
    int water = 0;
    int start = 0;
    int end   = height.length - 1;
    while (start < end) {
      water = Math.max(water, (end - start) * Math.min(height[start], height[end]));
      if (height[start] > height[end]) {
        end--;
      } else if (height[start] < height[end]) {
        start++;
      } else {
        end--;
        start++;
      }
    }
    return water;
  }
}
