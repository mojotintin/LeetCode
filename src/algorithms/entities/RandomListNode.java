package algorithms.entities;

/**
 * Created by Calabash on 2017/6/21.
 * Definition for singly-linked list with a random pointer.
 */
public class RandomListNode {
  public int label;
  public RandomListNode next, random;
  public RandomListNode(int x) { this.label = x; }

  @Override
  public String toString() {
    return "RandomListNode{" +
        "label=" + label +
        ", next=" + next +
        ", random=" + random +
        '}';
  }
}
