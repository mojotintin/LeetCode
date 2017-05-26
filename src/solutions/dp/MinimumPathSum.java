package solutions.dp;

/**
 * Created by Calabash on 2017/5/22.
 * Problem Number : 64
 * Problem Name : Minimum Path Sum
 * Description : https://leetcode.com/problems/minimum-path-sum/#/description
 * Difficulty : Medium
 * Tags : Array, Dynamic Programming
 */
public class MinimumPathSum {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 4ms
     */
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[][] paths = new int[height][width];
        paths[0][0] = grid[0][0];
        for (int i = 1; i < width; i++) {
        	paths[0][i] = paths[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < height; i++) {
        	paths[i][0] = paths[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < height; i++) {
        	for (int j = 1; j < width; j++) {
        		paths[i][j] = Math.min(paths[i - 1][j], paths[i][j - 1]) + grid[i][j];
        	}
        }
        return paths[height - 1][width - 1];
    }
}
