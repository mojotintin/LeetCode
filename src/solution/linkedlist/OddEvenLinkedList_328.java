package solution.linkedlist;

import entities.ListNode;

/**
 * Created by calabash on 2017/3/29.
 * The LeetCode 328th
 * Tags : Linked List, Two Points
 */
public class OddEvenLinkedList_328 {

    public ListNode oddEvenList(ListNode head) {
        boolean isOdd = false;
        ListNode rs = head;
        ListNode odd = head;
        while (head.next != null) {
            if (isOdd) {
                ListNode node = head.next;
                head.next = head.next.next;
                node.next = odd.next;
                odd.next = node;
                odd = odd.next;
                isOdd = false;
            } else {
                head = head.next;
                isOdd = true;
            }
        }
        return rs;
    }
}
