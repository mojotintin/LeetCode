package solution.linkedlist;

import entities.ListNode;

/**
 * Created by Calabash on 2017/5/7.
 *
 */
public class RemoveLinkedListElements_203 {

     public ListNode removeElements(ListNode head, int val) {
        if (head == null) return  null;
        ListNode newHead = head;
        while(head.next != null){
            if(head.next.val == val){
                head.next = head.next.next;
            } else{
                head = head.next;
            }
        }
        if (newHead.val == val)return newHead.next;
        else return newHead;
    }
}
