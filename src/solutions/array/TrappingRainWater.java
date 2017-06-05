package solutions.array;

/**
 * Created by Calabash on 2017/4/24.
 * Problem Number : 42
 * Problem Name : Trapping Rain Water
 * Description : https://leetcode.com/problems/trapping-rain-water/#/description
 * Difficulty : Hard
 * Tags : Array, Stack, Two Points
 */
public class TrappingRainWater {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 21ms
   */
  public int trap(int[] height) {
    int water = 0;
    int[] waterHeight = new int[height.length];
    int curMax = 0;
    for (int i = 0; i < height.length; i ++) {
      if (height[i] >= curMax) {
        curMax = height[i];
        waterHeight[i] = curMax;
      } else {
        waterHeight[i] = curMax;
      }
    }
    curMax = 0;
    for (int i = height.length - 1; i >= 0; i --) {
      if (height[i] >= curMax) {
        curMax = height[i];
        waterHeight[i] = curMax;
      } else {
        waterHeight[i] = Math.min(curMax, waterHeight[i]);
      }
    }
    for (int i = 0; i < height.length; i ++) {
      water += waterHeight[i] - height[i];
    }
    return water;
  }
}
