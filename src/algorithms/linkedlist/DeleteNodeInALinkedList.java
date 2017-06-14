package algorithms.linkedlist;

import algorithms.entities.ListNode;

/**
 * Created by Calabash on 2017/6/10.
 * Problem Number : 237
 * Problem Name : Delete Node in a Linked List
 * Description : https://leetcode.com/problems/delete-node-in-a-linked-list/#/description
 * Difficulty : Easy
 * Tags : Linked List
 */
public class DeleteNodeInALinkedList {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 1ms
   */
  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
