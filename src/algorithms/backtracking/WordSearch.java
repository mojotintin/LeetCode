package algorithms.backtracking;

/**
 * Created by Calabash on 2017/7/8.
 * Problem Number : 79
 * Problem Name : Word Search
 * Difficulty : Medium
 * Tags : Array, Backtracking
 * Description : https://leetcode.com/problems/word-search/#/description
 * #---------------------------------------------------------------------------
 * # Given a 2D board and a word, find if the word exists in the grid.
 * # The word can be constructed from letters of sequentially adjacent cell,
 * # where "adjacent" cells are those horizontally or vertically neighboring.
 * # The same letter cell may not be used more than once.
 * #
 * # For example,
 * # Given board =
 * # [['A','B','C','E'],
 * #  ['S','F','C','S'],
 * #  ['A','D','E','E']]
 * # word = "ABCCED", -> returns true,
 * # word = "SEE", -> returns true,
 * # word = "ABCB", -> returns false.
 * #---------------------------------------------------------------------------
 */
public class WordSearch {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 15ms
   * Space Complexity : o(m * n)
   */
  public boolean exist_1(char[][] board, String word) {
    if (board.length == 0) {
      return false;
    }
    boolean[][] flags = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (helper_1(board, flags, i, j, word, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean helper_1(char[][] board, boolean[][] flags, int i, int j, String word, int p) {
    if (p == word.length()) {
      return true;
    }
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
      return false;
    }
    boolean searched = false;
    if (word.charAt(p) == board[i][j] && !flags[i][j]) {
      flags[i][j] = true;
      searched = helper_1(board, flags, i + 1, j, word, p + 1)
          || helper_1(board, flags, i - 1, j, word, p + 1)
          || helper_1(board, flags, i, j + 1, word, p + 1)
          || helper_1(board, flags, i, j - 1, word, p + 1);
      flags[i][j] = false;
    }
    return searched;
  }

  /**
   * Submission : 2
   * Status : Accepted
   * Runtime : 14ms
   * Space Complexity : o(1)
   */
  public boolean exist_2(char[][] board, String word) {
    if (board.length == 0) {
      return false;
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (helper_2(board, i, j, word, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean helper_2(char[][] board, int i, int j, String word, int p) {
    if (p == word.length()) {
      return true;
    }
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
      return false;
    }
    boolean searched = false;
    if (word.charAt(p) == board[i][j]) {
      board[i][j] ^= 256;
      searched = helper_2(board, i + 1, j, word, p + 1)
          || helper_2(board, i - 1, j, word, p + 1)
          || helper_2(board, i, j + 1, word, p + 1)
          || helper_2(board, i, j - 1, word, p + 1);
      board[i][j] ^= 256;
    }
    return searched;
  }
}
