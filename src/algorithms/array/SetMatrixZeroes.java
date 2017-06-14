package algorithms.array;

/**
 * Created by calabash on 2017/5/30.
 * Problem Number : 73
 * Problem Name : Set Matrix Zeroes
 * Description : https://leetcode.com/problems/set-matrix-zeroes/#/description
 * Difficulty : Medium
 * Tags : Array
 */
public class SetMatrixZeroes {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 2ms
   */
  public void setZeroes(int[][] matrix) {
    int width  = matrix[0].length;
    int height = matrix.length;
    int[] iFlag = new int[height];
    int[] jFlag = new int[width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width;  j++) {
        if (matrix[i][j] == 0) {
          iFlag[i] = -1;
          jFlag[j] = -1;
        }
      }
    }
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width;  j++) {
        if (iFlag[i] == -1 || jFlag[j] == -1) {
          matrix[i][j] = 0;
        }
      }
    }
  }
}
