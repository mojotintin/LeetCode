package solutions.linkedlist;

import entities.ListNode;

/**
 * Created by Calabash on 2017/5/5.
 * Problem Number : 141
 * Problem Name : Linked List Cycle
 * Description : https://leetcode.com/problems/linked-list-cycle/#/description
 * Difficulty : Easy
 * Tags : Linked List, Two Points
 */
public class LinkedListCycle {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 1ms
     * Space Complexity: o(1)
     */
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode node = head;
        while (head.next != null && node.next != null && node.next.next != null) {
            if (head.next == node.next.next) {
                return true;
            }

            head = head.next;
            node = node.next.next;
        }

        return false;
    }
}
