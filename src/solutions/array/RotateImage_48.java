package solutions.array;

/**
 * Created by Calabash on 2017/4/13.
 * LeetCode 48th : Rotate Image
 * Description : https://leetcode.com/problems/rotate-image/#/description
 * Difficulty : Medium
 * Tags : Array
 */
public class RotateImage_48 {

    /**
     * Status : Accepted
     * Runtime : 4ms
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int mi, mj;
        if (len % 2 == 0) {
            mi = len / 2;
            mj = len / 2;
        } else {
            mi = len / 2;
            mj = len / 2 + 1;
        }
        for (int i = 0; i < mi; i++) {
            for (int j = 0; j < mj; j++) {
                int tem = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = tem;
            }
        }
    }
}
