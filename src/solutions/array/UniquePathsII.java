package solutions.array;

/**
 * Created by Calabash on 2017/6/3.
 * Problem NUmber : 63
 * Problem Name : Unique Paths II
 * Description : https://leetcode.com/problems/unique-paths-ii/#/description
 * Difficulty : Medium
 * Tags : Array, Dynamic Programming
 */
public class UniquePathsII {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 1ms
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid[0][0] == 0) obstacleGrid[0][0] = 1;
        else obstacleGrid[0][0] = 0;

        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) obstacleGrid[0][i] = 0;
            else obstacleGrid[0][i] = obstacleGrid[0][i - 1];
        }

        for (int j = 1; j < obstacleGrid.length; j++) {
            if (obstacleGrid[j][0] == 1) obstacleGrid[j][0] = 0;
            else obstacleGrid[j][0] = obstacleGrid[j - 1][0];
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) obstacleGrid[i][j] = 0;
                else obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }

        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
