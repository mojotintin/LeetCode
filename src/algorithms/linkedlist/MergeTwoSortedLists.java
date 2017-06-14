package algorithms.linkedlist;

import algorithms.entities.ListNode;

/**
 * Created by Calabash on 2017/5/24.
 * Problem Number : 21
 * problem Name : Merge Two Sorted Lists
 * Description : https://leetcode.com/problems/merge-two-sorted-lists/#/description
 * Difficulty : Easy
 * Tags : Linked List
 */
public class MergeTwoSortedLists {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 17ms
   */
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode newHead = head;
    while(l1 != null || l2 != null) {
      if (l2 == null) {
        head.next = l1;
        l1 = l1.next;
      } else if (l1 == null) {
        head.next = l2;
        l2 = l2.next;
      } else {
        if (l1.val <= l2.val) {
          head.next = l1;
          l1 = l1.next;
        } else {
          head.next = l2;
          l2 = l2.next;
        }
      }
      head = head.next;
    }
    return newHead.next;
  }
}
