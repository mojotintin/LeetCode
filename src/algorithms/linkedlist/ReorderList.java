package algorithms.linkedlist;

import algorithms.entities.ListNode;

/**
 * Created by Calabash on 2017/6/21.
 * Problem Number : 143
 * Problem Name : Reorder List
 * Description :
 * Difficulty : Medium
 * Tags : Linked List
 */
public class ReorderList {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 3ms
   */
  public void reorderList(ListNode head) {
    if (head == null){
      return;
    }
    ListNode node1 = head;
    ListNode node2 = head;
    while (node2.next != null && node2.next.next != null) {
      node1 = node1.next;
      node2 = node2.next.next;
    }
    ListNode newHead = node1.next;
    node1.next = null;
    ListNode prev = new ListNode(0);
    ListNode temp;
    while (newHead != null) {
      temp = newHead.next;
      newHead.next = prev.next;
      prev.next = newHead;
      newHead = temp;
    }
    prev = prev.next;
    ListNode node = head;
    while (prev != null){
      temp = prev.next;
      prev.next = node.next;
      node.next = prev;
      node = prev.next;
      prev = temp;
    }
  }
}
