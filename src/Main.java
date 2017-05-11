import entities.ListNode;
import entities.TreeNode;
import solution.*;

public class Main {

    public static void main(String[] args) {

        ListNode n1 = new ListNode(0);
        n1.next = new ListNode(1);
        ListNode n2 = n1;
        n1 = n1.next;
        System.out.println(n1.val);
        System.out.println(n2.val);
    }
}