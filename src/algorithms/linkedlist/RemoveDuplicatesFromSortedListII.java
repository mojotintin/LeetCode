package algorithms.linkedlist;

import algorithms.entities.ListNode;

/**
 * Created by Calabash on 2017/5/13.
 * Problem Number : 82
 * Problem Name : Remove Duplicates from Sorted List II
 * Description : https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/#/description
 * Difficulty : Medium
 * Tags : Linked List
 */
public class RemoveDuplicatesFromSortedListII {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 1ms
   */
  public ListNode deleteDuplicates(ListNode head) {
    ListNode link = new ListNode(0);
    ListNode newHead = link;
    link.next = head;
    while (link.next != null && link.next.next != null) {
      ListNode node = link.next;
      if (node.val != node.next.val) {
        link = node;
      } else {
        while (node.next != null && node.val == node.next.val) {
          node = node.next;
        }
        link.next = node.next;
      }
    }
    return newHead.next;
  }
}
