package algorithms.linkedlist;

import algorithms.entities.ListNode;

/**
 * Created by Calabash on 2017/6/21.
 * Problem Number : 61
 * Problem Name : Rotate List
 * Description : https://leetcode.com/problems/rotate-list/#/description
 * Difficulty : Medium
 * Tags : Linked List, Two Pointer
 */
public class RotateList {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 16ms
   */
  public ListNode rotateRight(ListNode head, int k) {
    if (k == 0 || head == null) {
      return head;
    }
    int step = 0;
    ListNode node2 = head;
    while (step < k && node2 != null) {
      node2 = node2.next;
      step += 1;
    }
    if (node2 == null) {
      return rotateRight(head, k % step);
    }
    ListNode node1 = head;
    while (node2.next != null) {
      node1 = node1.next;
      node2 = node2.next;
    }
    ListNode newHead = node1.next;
    node1.next = null;
    node2.next = head;
    return newHead;
  }
}
