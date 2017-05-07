import entities.ListNode;
import entities.TreeNode;
import solution.*;

public class Main {

    public static void main(String[] args) {


        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = node;

        LinkedListCycle_141 sol = new LinkedListCycle_141();
        System.out.println(sol.hasCycle(node));
    }
}