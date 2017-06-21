package algorithms.linkedlist;

import algorithms.entities.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Calabash on 2017/6/21.
 * Problem Number : 138
 * Problem Name : Copy List with Random Pointer
 * Description : https://leetcode.com/problems/copy-list-with-random-pointer/#/description
 * Difficulty : Medium
 * Tags : Linked List
 */
public class CopyListWithRandomPointer {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 166ms
   */
  public RandomListNode copyRandomList_1(RandomListNode head) {
    RandomListNode newHead = new RandomListNode(0);
    RandomListNode head1 = newHead;
    RandomListNode node1 = head;
    while (node1 != null) {
      head1.next = new RandomListNode(node1.label);
      head1 = head1.next;
      node1 = node1.next;
    }
    RandomListNode head2 = newHead.next;
    RandomListNode node2 = head;
    while (node2 != null) {
      if (node2.random == null) {
        head2.random = null;
      } else {
        RandomListNode n1 = newHead.next;
        RandomListNode n2 = head;
        while (n2 != node2.random) {
          n1 = n1.next;
          n2 = n2.next;
        }
        head2.random = n1;
      }
      head2 = head2.next;
      node2 = node2.next;
    }
    return newHead.next;
  }

  /**
   * Submission : 2
   * Status : Accepted
   * Runtime : 10ms
   */
  public RandomListNode copyRandomList_2(RandomListNode head) {
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode node = head;
    while (node !=  null) {
        map.put(node, new RandomListNode(node.label));
        node = node.next;
    }
    node = head;
    while (node != null) {
        map.get(node).next = map.get(node.next);
        map.get(node).random = map.get(node.random);
        node = node.next;
    }
    return map.get(head);
  }
}
