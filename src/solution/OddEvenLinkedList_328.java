package solution;

import entities.ListNode;

/**
 * Created by calabash on 2017/3/29.
 * Leetcode 328th Odd Even aLinked List
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
