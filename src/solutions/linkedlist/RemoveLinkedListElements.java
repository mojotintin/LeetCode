package solutions.linkedlist;

import entities.ListNode;

/**
 * Created by Calabash on 2017/5/7.
 * Problem Number : 203
 * Problem Name : Remove Linked List Elements
 * Description : https://leetcode.com/problems/remove-linked-list-elements/#/description
 * Difficulty : Easy
 * Tags : Linked List
 */
public class RemoveLinkedListElements {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 1ms
   */
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return  null;
    }
    ListNode newHead = head;
    while(head.next != null){
      if(head.next.val == val){
        head.next = head.next.next;
      } else{
        head = head.next;
      }
    }
    if (newHead.val == val) {
      return newHead.next;
    }
    else {
      return newHead;
    }
  }
}
