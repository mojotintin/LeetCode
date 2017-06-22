package algorithms.linkedlist;

import algorithms.entities.ListNode;

/**
 * Created by calabash on 2017/6/22.
 * Problem Number : 445
 * Problem Name : Add Two Numbers II
 * Description : https://leetcode.com/problems/add-two-numbers-ii/#/description
 * Difficulty : Medium
 * Tags : Linked List
 */
public class AddTwoNumbersII {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 67ms
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int len1 = 0;
    int len2 = 0;
    ListNode node1 = l1;
    ListNode node2 = l2;
    while (node1 != null) {
      len1 += 1;
      node1 = node1.next;
    }
    while (node2 != null) {
      len2 += 1;
      node2 = node2.next;
    }
    ListNode head = new ListNode(0);
    ListNode node = head;
    if (len1 > len2) {
      node1 = l2;
      node2 = l1;
    } else {
      node1 = l1;
      node2 = l2;
    }
    while (len1 != len2) {
      node.next = new ListNode(node2.val);
      node  = node.next;
      node2 = node2.next;
      if (len1 > len2) {
        len1 -= 1;
      } else if (len1 < len2){
        len2 -= 1;
      }
    }
    while (node1 != null) {
      node.next = new ListNode(node1.val + node2.val);
      node  = node.next;
      node1 = node1.next;
      node2 = node2.next;
    }
    carry(head);
    if (head.val == 0) {
      return head.next;
    } else {
      return head;
    }
  }

  private int carry(ListNode head) {
    if (head == null) {
      return 0;
    }
    head.val += carry(head.next);
    if (head.val >= 10) {
      head.val -= 10;
      return 1;
    } else {
      return 0;
    }
  }
}
