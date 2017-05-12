package solutions.linkedlist;

import entities.ListNode;

/**
 * Created by Calabash on 2017/5/5.
 * The LeetCode 141th
 * Tags : Linked List, Two Points
 */
public class LinkedListCycle_141 {


    /*
     * Time Limit Exceeded
     * Wrong Answer
     */
    public boolean hasCycle_1(ListNode head) {

        if(head == null) return false;
        ListNode node = head;
        while (head.next != null) {
            if (head.next == node) return true;
            head = head.next;
        }
        return false;
    }

    /*
     * Accepted
     * Extra space : 0(1)
     */
    public boolean hasCycle_2(ListNode head) {
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
