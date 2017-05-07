package solution;

import entities.ListNode;

/**
 * Created by Calabash on 2017/5/7.
 *
 */
public class SwapNodesInPairs_24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
    		return head;
    	}
        ListNode newHead = head;
        head = head.next;
        while(head.next != null && head.next.next != null){
        	ListNode temp = head.next;
        	ListNode tail = head.next.next.next;
        	head.next = head.next.next;
        	head.next.next = temp;
        	temp.next = tail;
        	head = head.next.next;
        }
        ListNode temp = newHead.next;
        newHead.next = newHead.next.next;
        temp.next = newHead;
        return temp;
    }
}
