package solution;

import entities.ListNode;

/**
 * Created by Calabash on 2017/5/5.
 *
 */
public class LinkedListCycle_141 {


    // Time Limit Exceeded
    public boolean hasCycle_1(ListNode head) {

        if(head == null) return false;
        ListNode node = head;
        while (head.next != null) {
            if (head.next == node) return true;
            head = head.next;
        }
        return false;
    }

    // Time Limit Exceeded
    public boolean hasCycle_2(ListNode head) {

        if (head == null) return false;

        return false;
    }
}
