import entities.ListNode;
import entities.TreeNode;
import solution.*;

public class Main {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        AddTwoNumbers_2 sol = new AddTwoNumbers_2();
        System.out.println(sol.addTwoNumbers(l1, l2).toString());
    }
}