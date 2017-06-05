package solutions.linkedlist;

import entities.ListNode;

/**
 * Created by calabash on 2017/3/29.
 * Problem Number : 328
 * Problem Name : Odd Even Linked List
 * Description : https://leetcode.com/problems/odd-even-linked-list/#/description
 * Difficulty : Medium
 * Tags : Linked List, Two Points
 */
public class OddEvenLinkedList {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 1ms
   */
  public ListNode oddEvenList(ListNode head) {
    boolean isOdd = false;
    ListNode rs = head;
    ListNode odd = head;
    while (head.next != null) {
      if (isOdd) {
        ListNode node = head.next;
        head.next = head.next.next;
        node.next = odd.next;
        odd.next = node;
        odd = odd.next;
        isOdd = false;
      } else {
        head = head.next;
        isOdd = true;
      }
    }
    return rs;
  }
}
