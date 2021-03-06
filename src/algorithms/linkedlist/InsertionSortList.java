package algorithms.linkedlist;

import algorithms.entities.ListNode;

/**
 * Created by Calabash on 2017/5/19.
 * Problem Number : 147
 * Problem Name : Insertion Sort List
 * Description : https://leetcode.com/problems/insertion-sort-list/#/description
 * Difficulty : Medium
 * Tags : Linked List, Sort
 */
public class InsertionSortList {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 37ms
   */
  public ListNode insertionSortList(ListNode head) {
    ListNode newHead = new ListNode(Integer.MIN_VALUE);
    ListNode reHead = newHead;
    while (head != null) {
      ListNode temp = head.next;
      while (newHead.next != null) {
        if (head.val < newHead.next.val) {
          head.next = newHead.next;
          newHead.next = head;
          break;
        }
        newHead = newHead.next;
      }
      if (newHead.next == null) {
        head.next = null;
        newHead.next = head;
      }
      newHead = reHead;
      head = temp;
    }
    return reHead.next;
  }
}
