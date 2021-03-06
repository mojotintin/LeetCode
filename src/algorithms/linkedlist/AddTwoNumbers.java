package algorithms.linkedlist;

import algorithms.entities.ListNode;

/**
 * Created by Calabash on 2017/5/2.
 * Problem Number : 2
 * Problem Name : Add Two Numbers
 * Description : https://leetcode.com/problems/add-two-numbers/#/description
 * Difficulty ; Medium
 * Tags : Linked List, Math
 */
public class AddTwoNumbers {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 66ms
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) {
      return null;
    }
    ListNode sumList = new ListNode(0);
    ListNode reList = sumList;
    ListNode tailNode = null;
    int overTen = 0;
    while (l1 != null || l2 != null) {
      if (l1 == null) {
        if (l2.val + overTen >= 10) {
          sumList.val = l2.val + overTen - 10;
          overTen = 1;
        } else {
          sumList.val = l2.val + overTen;
          overTen = 0;
        }
        l2 = l2.next;
      } else if (l2 == null){
        if (l1.val + overTen >= 10) {
          sumList.val = l1.val + overTen - 10;
          overTen = 1;
        } else {
          sumList.val = l1.val + overTen;
          overTen = 0;
        }
        l1 = l1.next;
      } else {
        if (l1.val + l2.val + overTen >= 10){
          sumList.val = l1.val + l2.val + overTen - 10;
          overTen = 1;
        } else {
          sumList.val = l1.val + l2.val + overTen;
          overTen = 0;
        }
        l1 = l1.next;
        l2 = l2.next;
      }
      sumList.next = new ListNode(0);
      tailNode = sumList;
      sumList = sumList.next;
    }
    if (overTen == 1) {
      sumList.val = 1;
    } else {
      tailNode.next = null;
    }
    return reList;
  }
}
