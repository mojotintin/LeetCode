package algorithms.stack;

import java.util.Stack;

/**
 * Created by calabash on 2017/6/19.
 * Problem Number : 331
 * Problem name : Verify Preorder Serialization of a Binary Tree
 * Description : https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/#/description
 * Difficulty : Medium
 * Tags : Stack
 */
public class VerifyPreorderSerializationOfABinaryTree {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 21ms
   * Note : Stack
   */
  public boolean isValidSerialization(String preorder) {
    Stack<String> stack = new Stack<>();
    String[] nodes = preorder.split(",");
    for (String node : nodes) {
      if (!node.equals("#")) {
        stack.push(node);
      } else {
        while (true) {
          if (stack.empty() || !stack.peek().equals("#")) {
            stack.push("#");
            break;
          } else {
            stack.pop();
            if (stack.empty() || stack.peek().equals("#")) {
              return false;
            }
            stack.pop();
          }
        }
      }
    }
    return stack.pop().equals("#") && stack.empty();
  }
}
