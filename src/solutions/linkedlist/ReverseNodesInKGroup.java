package solutions.linkedlist;

import entities.ListNode;

/**
 * Created by Calabash on 2017/6/3.
 * Problem Number : 25
 * Problem Name : Reverse Nodes in k-Group
 * Description : https://leetcode.com/problems/reverse-nodes-in-k-group/#/description
 * Difficulty : Hard
 * Tags : Linked List
 */
public class ReverseNodesInKGroup {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 13ms
     */
    public ListNode reverseKGroup_1(ListNode head, int k) {

        ListNode testNode = head;
        int count = 0;
        while (testNode != null && count < k) {
            testNode = testNode.next;
            count++;
        }

        if (count != k) return head;

        ListNode prev = new ListNode(0);
        prev.next = null;
        count = 0;
        ListNode tail = head;
        while (count < k) {
            count++;
            ListNode temp = head.next;
            head.next = prev.next;
            prev.next = head;
            head = temp;
        }
        tail.next = reverseKGroup_1(head, k);

        return prev.next;
    }

    /**
     * Submission : 2
     * Status : Accepted
     * Runtime : 9ms
     */
    public ListNode reverseKGroup_2(ListNode head, int k) {

        int count = 0;
        ListNode prev = new ListNode(0);
        prev.next = null;
        ListNode tail = head;
        while (head != null && count < k) {
            count++;
            ListNode temp = head.next;
            head.next = prev.next;
            prev.next = head;
            head = temp;
        }
        if (count == k) {
            tail.next = reverseKGroup_2(head, k);
            return prev.next;
        }

        ListNode rev = new ListNode(0);
        rev.next = null;
        prev = prev.next;
        while (prev != null) {
            ListNode temp = prev.next;
            prev.next = rev.next;
            rev.next = prev;
            prev = temp;
        }
        return rev.next;
    }
}
