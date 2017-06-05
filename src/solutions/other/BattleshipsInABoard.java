package solutions.other;

/**
 * Created by Calabash on 2017/4/17.
 * Problem Number : 419
 * Problem Name : Battleships in a Board
 * Description : https://leetcode.com/problems/battleships-in-a-board/#/description
 * Difficulty : Medium
 * Tags : Other
 */
public class BattleshipsInABoard {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 4ms
   */
  public int countBattleships(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j ++) {
        if (board[i][j] == 'X'
            && (i + 1 == board.length || board[i + 1][j] == '.')
            && (j + 1 == board[0].length || board[i][j + 1] == '.')) {
          count ++;
        }
      }
    }
    return count;
  }
}
