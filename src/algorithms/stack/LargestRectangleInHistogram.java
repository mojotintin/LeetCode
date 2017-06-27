package algorithms.stack;

import java.util.Stack;

/**
 * Created by Calabash on 2017/6/27.
 * Problem Number : 84
 * Problem Name : Largest Rectangle in Histogram
 * Description : https://leetcode.com/problems/largest-rectangle-in-histogram/#/description
 * Difficulty : Medium
 * Tags : Array, Stack
 */
public class LargestRectangleInHistogram {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 28ms
   */
  public int largestRectangleArea(int[] heights) {
    int maxArea = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i <= heights.length; i++) {
      int height = (i == heights.length) ? 0 : heights[i];
      if (stack.isEmpty() || height >= heights[stack.peek()]) {
        stack.push(i);
      } else {
        int index = stack.pop();
        int left = (stack.isEmpty()) ? -1 : stack.peek();
        maxArea = Math.max(maxArea, (i - left - 1) * heights[index]);
        i--;
      }
    }
    return maxArea;
  }
}
