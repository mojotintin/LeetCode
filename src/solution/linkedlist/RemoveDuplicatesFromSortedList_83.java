package solution.linkedlist;

import entities.ListNode;

/**
 * Created by Calabash on 2017/4/24.
 * The LeetCode 83th
 * Tags : Linked List
 */
public class RemoveDuplicatesFromSortedList_83 {

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
