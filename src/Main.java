import entities.TreeNode;
import solution.*;

public class Main {

    public static void main(String[] args) {

        RotateImage_48 sol = new RotateImage_48();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        sol.rotate(matrix);
    }
}