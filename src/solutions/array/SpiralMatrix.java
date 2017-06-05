package solutions.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/6/3.
 * Problem Number : 54
 * Problem Name : Spiral Matrix
 * Description : https://leetcode.com/problems/spiral-matrix/#/description
 * Difficulty : Medium
 * Tags : Array
 */
public class SpiralMatrix {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 3ms
   */
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> order = new ArrayList<>();
    if (matrix.length == 0) {
      return order;
    }
    int ore = 0;
    int count = 0;
    int width = matrix[0].length;
    int height = matrix.length;
    int i = 0;
    int j = 0;
    int[][] flag = new int[height][width];
    while (count < width * height) {
      order.add(matrix[i][j]);
      flag[i][j] = 1;
      count++;
      if (ore == 0) {
        if (j == width - 1|| flag[i][j + 1] == 1) {
          i++;
          ore = 1;
        } else {
          j++;
        }
      } else if (ore == 1) {
        if (i == height - 1|| flag[i + 1][j] == 1) {
          j--;
          ore = 2;
        } else {
          i++;
        }
      } else if (ore == 2) {
        if (j == 0 || flag[i][j - 1] == 1) {
          i--;
          ore = 3;
        } else {
          j--;
        }
      } else {
        if (i == 0 || flag[i - 1][j] == 1) {
          j++;
          ore = 0;
        } else {
          i--;
        }
      }
    }
    return order;
  }
}
