package solutions.linkedlist;

import entities.ListNode;

/**
 * Created by Calabash on 2017/6/5.
 * Problem Number : 142
 * Problem Name : Linked List Cycle II
 * Description : https://leetcode.com/problems/linked-list-cycle-ii/#/description
 * Difficulty : Medium
 * Tags : Linked List , Two Pointers
 */
public class LinkedListCycleII {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 1ms
   */
  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return null;
    }
    ListNode h1 = head.next;
    ListNode h2 = head.next.next;
    while (h1 != h2) {
      if(h2.next == null || h2.next.next == null) {
        return null;
      }
      h1 = h1.next;
      h2 = h2.next.next;
    }
    int cycleSize = 1;
    h2 = h2.next;
    while (h1 != h2) {
      h2 = h2.next;
      cycleSize++;
    }
    ListNode head1 = head;
    ListNode head2 = head.next;
    int count = 1;
    while (head1 != head2){
      if (count < cycleSize) {
        count++;
        head2 = head2.next;
      } else {
        head1 = head1.next;
        head2 = head2.next;
      }
    }
    return head1;
  }
}
