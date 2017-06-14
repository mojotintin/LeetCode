package algorithms.linkedlist;

import algorithms.entities.ListNode;

/**
 * Created by Calabash on 2017/5/7.
 * Problem Number : 24
 * Problem Name : Swap Nodes in Pairs
 * Tags : Linked List
 */
public class SwapNodesInPairs {

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = head;
    head = head.next;
    while(head.next != null && head.next.next != null){
      ListNode temp = head.next;
      ListNode tail = head.next.next.next;
      head.next = head.next.next;
      head.next.next = temp;
      temp.next = tail;
      head = head.next.next;
    }
    ListNode temp = newHead.next;
    newHead.next = newHead.next.next;
    temp.next = newHead;
    return temp;
  }
}
