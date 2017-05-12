package solutions.linkedlist;

import entities.ListNode;

/**
 * Created by Calabash on 2017/5/11.
 * The LeetCode 86th
 * Tags : Linked List, Two Points
 */
public class PartitionList_86 {

    public ListNode partition(ListNode head, int x) {
        ListNode walkNode = new ListNode(0);
        ListNode newHead = new ListNode(0);
        ListNode lessNode = new ListNode(0);
        ListNode moreHead = walkNode;
        walkNode.next = head;
        newHead = lessNode;

        while (walkNode.next != null) {
        	if (walkNode.next.val < x) {
        		ListNode temp = walkNode.next;
        		walkNode.next = walkNode.next.next;
        		lessNode.next = temp;
        		lessNode = lessNode.next;
        	} else {
        		walkNode= walkNode.next;
        	}
        }
        lessNode.next = moreHead.next;
        return newHead.next;
    }
}
