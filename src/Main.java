import entities.TreeNode;
import solution.*;

public class Main {

    public static void main(String[] args) {

        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater_42 sol = new TrappingRainWater_42();
        System.out.println(sol.trap(height));
    }
}