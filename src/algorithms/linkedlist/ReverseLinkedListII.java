package algorithms.linkedlist;

import algorithms.entities.ListNode;

/**
 * Created by calabash on 2017/5/30.
 * Problem Number : 92
 * Problem Name : Reverse Linked List II
 * Description : https://leetcode.com/problems/reverse-linked-list-ii/#/description
 * Difficulty : Medium
 * Tags : Linked List
 */
public class ReverseLinkedListII {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 0ms
   */
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode newHead = new ListNode(0);
    ListNode reHead = newHead;
    newHead.next = head;
    int count = 0;
    while (count < m - 1) {
      newHead = newHead.next;
      count++;
    }
    ListNode prev = new ListNode(0);
    ListNode tail = newHead.next;
    while (count < n) {
      ListNode temp = newHead.next;
      newHead.next = newHead.next.next;
      temp.next = prev.next;
      prev.next = temp;
      count++;
    }
    tail.next = newHead.next;
    newHead.next = prev.next;
    return reHead.next;
  }
}
