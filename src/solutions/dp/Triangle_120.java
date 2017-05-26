package solutions.dp;

import java.util.List;

/**
 * Created by Calabash on 2017/5/14.
 * Problem Number : 120
 * Problem Name : Triangle
 * Description : https://leetcode.com/problems/triangle/#/description
 * Tags : Array, Dynamic Programming
 */
public class Triangle_120 {

    /**
     * Status : Accepted
     * Runtime : 7ms
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        int[] miniPath = new int[triangle.size() + 1];
        for (int i = triangle.size(); i > 0; i--) {
            for (int j = 0; j < i; j ++) {
                miniPath[j] = Math.min(miniPath[j], miniPath[j + 1]) + triangle.get(i - 1).get(j);
            }
        }

        return miniPath[0];
    }
}
