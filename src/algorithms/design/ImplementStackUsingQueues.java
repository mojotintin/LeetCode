package algorithms.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Calabash on 2017/7/23.
 * Problem Number : 225
 * Problem Name : Implement Stack using Queues
 * Difficulty : Easy
 * Tags : Stack, Design
 * #---------------------------------------------------------------------------
 * # Description : https://leetcode.com/problems/implement-stack-using-queues/#/description
 * # Implement the following operations of a stack using queues.
 * # . push(x) -- Push element x onto stack.
 * # . pop() -- Removes the element on top of the stack.
 * # . top() -- Get the top element.
 * # . empty() -- Return whether the stack is empty.
 * #
 * # Notes:
 * # .You must use only standard operations of a queue -- which means only push
 * #  to back, peek/pop from front, size, and is empty operations are valid.
 * # .Depending on your language, queue may not be supported natively. You may
 * #  simulate a queue by using a list or deque (double-ended queue), as long as
 * #  you use only standard operations of a queue.
 * # .You may assume that all operations are valid (for example, no pop or top
 * #  operations will be called on an empty stack).
 * #---------------------------------------------------------------------------
 */
public class ImplementStackUsingQueues {

  /**
   * Submission : 1
   * Runtime : 100ms
   * Status : Accepted
   */
  private Queue<Integer> queue1;
  private Queue<Integer> queue2;
  /** Initialize your data structure here. */
  public ImplementStackUsingQueues() {
    queue1 = new LinkedList<>();
    queue2 = new LinkedList<>();
  }

  /** Push element x onto stack. */
  public void push(int x) {
    if (queue1.isEmpty()) {
      queue2.add(x);
    } else {
      queue1.add(x);
    }
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    if (empty()) {
      return -1;
    } else {
      if (queue1.isEmpty()) {
        while (true) {
          int x = queue2.poll();
          if (queue2.isEmpty()) {
            return x;
          }
          queue1.offer(x);
        }
      } else {
        while (true) {
          int x = queue1.poll();
          if (queue1.isEmpty()) {
            return x;
          }
          queue2.offer(x);
        }
      }
    }
  }

  /** Get the top element. */
  public int top() {
    if (empty()) {
      return -1;
    } else {
      if (queue1.isEmpty()) {
        while (true) {
          int x = queue2.poll();
          queue1.offer(x);
          if (queue2.isEmpty()) {
            return x;
          }
        }
      } else {
        while (true) {
          int x = queue1.poll();
          queue2.offer(x);
          if (queue1.isEmpty()) {
            return x;
          }
        }
      }
    }
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return queue1.isEmpty() && queue2.isEmpty();
  }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */