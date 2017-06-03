package solutions.linkedlist;

import entities.ListNode;

/**
 * Created by Calabash on 2017/4/24.
 * Problem Number : 83
 * Problem Name : Partition List
 * Description : https://leetcode.com/problems/partition-list/#/description
 * Difficulty : Medium
 * Tags : Linked List
 */
public class RemoveDuplicatesFromSortedList {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 1ms
     */
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;
        ListNode node = head;
        while (head.next != null) {
            if (head.next.val == head.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return node;
    }
}
