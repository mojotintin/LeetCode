package solutions.unionfind;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/6/9.
 * Problem Number : 200
 * Problem Name : Number of Island
 * Description : https://leetcode.com/problems/number-of-islands/#/description
 * Difficulty ； Medium
 * Tags : Depth-first Search, Breadth-first Search
 */
public class NumberofIslands {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 15ms
   */
  public int numIslands(char[][] grid) {
    if (grid.length == 0) {
      return 0;
    }
    int height = grid.length;
    int width  = grid[0].length;
    int count = 0;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (grid[i][j] == '1') {
          count++;
          grid[i][j] = '0';
          int[] point = new int[]{i, j};
          List<int[]> list = new ArrayList<>();
          list.add(point);
          while (!list.isEmpty()) {
            List<int[]> island = new ArrayList<>();
            for (int[] p : list) {
              if (p[0] + 1 < height) {
                if (grid[p[0] + 1][p[1]] == '1') {
                  island.add(new int[]{p[0] + 1, p[1]});
                  grid[p[0] + 1][p[1]] = '0';
                }
              }
              if (p[1] + 1 < width) {
                if (grid[p[0]][p[1] + 1] == '1') {
                  island.add(new int[]{p[0], p[1] + 1});
                  grid[p[0]][p[1] + 1] = '0';
                }
              }
              if (p[0] > 0) {
                if (grid[p[0] - 1][p[1]] == '1') {
                  island.add(new int[]{p[0] - 1, p[1]});
                  grid[p[0] - 1][p[1]] = '0';
                }
              }
              if (p[1] > 0) {
                if (grid[p[0]][p[1] - 1] == '1') {
                  island.add(new int[]{p[0], p[1] - 1});
                  grid[p[0]][p[1] - 1] = '0';
                }
              }
            }
            list = island;
          }
        }
      }
    }
    return count;
  }
}
