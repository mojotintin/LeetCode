package solutions.linkedlist;

import entities.ListNode;

/**
 * Created by Calabash on 2017/5/7.
 * Problem Number : 324
 * Problem Name : Odd Even Linked List
 * Description : https://leetcode.com/problems/odd-even-linked-list/#/description
 * Difficulty : Medium
 * Tags : Linked List, Two Points
 */
public class PalindromeLinkedList {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 1ms
   */
  public boolean isPalindrome(ListNode head) {
    int count = 0;
    ListNode node = head;
    ListNode halfHead = head;
    while(head != null){
      count ++;
      head = head.next;
    }
    for (int i = 0; i < count / 2 + count %2; i++) {
      node = node.next;
    }
    ListNode prev = null;
    while(node != null) {
      ListNode temp = node.next;
      node.next = prev;
      prev = node;
      node = temp;
    }
    for(int i = 0; i < count / 2; i ++) {
      if (prev.val != halfHead.val) {
        return false;
      }
      else {
        prev = prev.next;
        halfHead = halfHead.next;
      }
    }
    return true;
  }
}
