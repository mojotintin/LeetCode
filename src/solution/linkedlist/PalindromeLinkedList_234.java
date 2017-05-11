package solution.linkedlist;

import entities.ListNode;

/**
 * Created by Calabash on 2017/5/7.
 * The LeetCode 324th
 * Tags : Linked List, Two Points
 */
public class PalindromeLinkedList_234 {

    public boolean isPalindrome(ListNode head) {
        int count = 0;
        ListNode node = head;
        ListNode halfHead = head;
        while(head != null){
            count ++;
            head = head.next;
        }
        for (int i = 0; i < count / 2 + count %2; i++) {
            node = node.next;
        }
        ListNode prev = null;
        while(node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        for(int i = 0; i < count / 2; i ++) {
            if (prev.val != halfHead.val) return false;
            else {
                prev = prev.next;
                halfHead = halfHead.next;
            }
        }

        return true;
    }
}
