package algorithms.design;

import java.util.Stack;

/**
 * Created by Calabash on 2017/7/3.
 * Problem Number : 232
 * Problem Name : Implement Queue using Stacks
 * Description : https://leetcode.com/problems/implement-queue-using-stacks/#/description
 * Difficulty : Easy
 * Tags : Stack, Design
 */
public class ImplementQueueUsingStacks {

  private Stack<Integer> pushStack;
  private Stack<Integer> popStack;

  /** Initialize your data structure here. */
  public ImplementQueueUsingStacks() {
    pushStack = new Stack<>();
    popStack = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    pushStack.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    if (!popStack.isEmpty()) {
      return popStack.pop();
    } else if (!pushStack.isEmpty()) {
      while (!pushStack.isEmpty()) {
        popStack.push(pushStack.pop());
      }
      return pop();
    } else {
      return -1;
    }
  }

  /** Get the front element. */
  public int peek() {
    if (!popStack.isEmpty()) {
      return popStack.peek();
    } else if (!pushStack.isEmpty()) {
      while (!pushStack.isEmpty()) {
        popStack.push(pushStack.pop());
      }
      return peek();
    } else {
      return -1;
    }
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return pushStack.isEmpty() && popStack.isEmpty();
  }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */