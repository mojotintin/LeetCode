package algorithms.design;

import java.util.Stack;

/**
 * Created by calabash on 2017/4/7.
 * Problem Number : 155
 * Problem Name : Min Stack
 * Description : https://leetcode.com/problems/min-stack/#/description
 * Difficulty : Easy
 * Tags : Stack, Design
 */
public class MinStack {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 135ms
   */
  private Stack<Integer> min;
  private Stack<Integer> stack;
  /** initialize your data structure here. */
  public MinStack() {
    min = new Stack<>();
    stack = new Stack<>();
    min.push(Integer.MAX_VALUE);
  }

  public void push(int x) {
    min.push(Math.min(x, min.peek()));
    stack.push(x);
  }

  public void pop() {
    min.pop();
    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min.peek();
  }
}
