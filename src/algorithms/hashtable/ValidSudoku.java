/*
 * Created by calabash on 2017/8/14.
 * Problem Number: 36.
 * Problem Name: Valid Sudoku.
 * Difficulty: Medium.
 * Related Topics: Hash Table.
 * Source: https://leetcode.com/problems/valid-sudoku/
 */

package algorithms.hashtable;

/**
 * #---------------------------------------------------------------------------
 * # Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * # The Sudoku board could be partially filled, where empty cells are filled
 * # with the character '.'.
 * #
 * # 5| 3|  |  | 7|  |  |  |  |  |
 * # 6|  |  | 1| 9| 5|  |  |  |  |
 * #  | 9| 8|  |  |  |  |  | 6|  |
 * # 8|  |  |  | 6|  |  |  |  | 3|
 * # 4|  |  | 8|  | 3|  |  |  | 1|
 * # 7|  |  |  | 2|  |  |  |  | 6|
 * #  | 6|  |  |  |  |  | 2| 8|  |
 * #  |  |  | 4| 1| 9|  |  |  | 5|
 * #  |  |  |  | 8|  |  |  | 7| 9|
 * # A partially filled sudoku which is valid.
 * #
 * # Note:
 * # A valid Sudoku board (partially filled) is not necessarily solvable. Only
 * # the filled cells need to be validated.
 * #---------------------------------------------------------------------------
 */
public class ValidSudoku {

  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 28ms
   */
  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      int[] flag = new int[9];
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          if (flag[board[i][j] - '1'] == 1) {
            return false;
          } else {
            flag[board[i][j] - '1'] = 1;
          }
        }
      }
    }
    for (int i = 0; i < 9; i++) {
      int[] flag = new int[9];
      for (int j = 0; j < 9; j++) {
        if (board[j][i] != '.') {
          if (flag[board[j][i] - '1'] == 1) {
            return false;
          } else {
            flag[board[j][i] - '1'] = 1;
          }
        }
      }
    }
    for (int k = 0; k < 9; k++) {
      int row = k / 3;
      int column = k % 3;
      int[] flag = new int[9];
      for (int i = 3 * row; i < 3 * row + 3; i++) {
        for (int j = 3 * column; j < 3 * column + 3; j++) {
          if (board[i][j] != '.') {
            if (flag[board[i][j] - '1'] == 1) {
              return false;
            } else {
              flag[board[i][j] - '1'] = 1;
            }
          }
        }
      }
    }
    return true;
  }
}