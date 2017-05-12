package solutions.linkedlist;

import entities.ListNode;

/**
 * Created by Calabash on 2017/5/5.
 * The LeetCode 206th
 * Tags : Linked List
 */
public class ReverseLinkedList_206 {

    // Change the node value
    public ListNode reverseList_1(ListNode head) {
        int[] var = new int[10000];
        int count = 0;
        ListNode node = head;
        ListNode re = head;
        while (head != null) {
            var[count++] = head.val;
            head = head.next;
        }

        while (node != null){
            node.val = var[--count];
            node = node.next;
        }

        return re;
    }

    // Do not change the node value
    public ListNode reverseList_2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode  prev = null;
        while (head != null) {
            ListNode trNode = head.next;
            head.next = prev;
            prev = head;
            head = trNode;
        }

        return prev;
    }
}
