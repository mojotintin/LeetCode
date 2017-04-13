import entities.TreeNode;
import solution.*;

public class Main {

    public static void main(String[] args) {

        FindLargestValueInEachTreeRow_515 sol = new FindLargestValueInEachTreeRow_515();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(sol.largestValues(root));
    }
}