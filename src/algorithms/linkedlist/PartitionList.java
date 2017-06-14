package algorithms.linkedlist;

import algorithms.entities.ListNode;

/**
 * Created by Calabash on 2017/5/11.
 * Problem Number : 86
 * Problem Name : Partition List
 * Description : https://leetcode.com/problems/partition-list/#/description
 * Difficulty : Medium
 * Tags : Linked List, Two Points
 */
public class PartitionList {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 1ms
   */
  public ListNode partition(ListNode head, int x) {
    ListNode walkNode = new ListNode(0);
    ListNode newHead;
    ListNode lessNode = new ListNode(0);
    ListNode moreHead = walkNode;
    walkNode.next = head;
    newHead = lessNode;
    while (walkNode.next != null) {
      if (walkNode.next.val < x) {
        ListNode temp = walkNode.next;
        walkNode.next = walkNode.next.next;
        lessNode.next = temp;
        lessNode = lessNode.next;
      } else {
        walkNode= walkNode.next;
      }
    }
    lessNode.next = moreHead.next;
    return newHead.next;
  }
}
