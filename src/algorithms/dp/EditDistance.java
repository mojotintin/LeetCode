package algorithms.dp;

/**
 * Created by calabash on 2017/7/11.
 * Problem Number : 72
 * Problem Name : Edit Distance
 * Difficulty : Hard
 * Tags : Dynamic Programming, String
 * Description : https://leetcode.com/problems/edit-distance/#/description
 * #---------------------------------------------------------------------------
 * # Given two words word1 and word2, find the minimum number of steps required
 * # to convert word1 to word2. (each operation is counted as 1 step.)
 * #
 * # You have the following 3 operations permitted on a word:
 * # a) Insert a character
 * # b) Delete a character
 * # c) Replace a character
 * #---------------------------------------------------------------------------
 */
public class EditDistance {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 18ms
   * Space Complexity : o(m * n)
   */
  public int minDistance(String word1, String word2) {
    int[][] distance =  new int[word1.length() + 1][word2.length () + 1];
    for (int i = 0; i <= word1.length(); i++) {
      distance[i][0] = i;
    }
    for (int j = 0; j <= word2.length(); j++) {
      distance[0][j] = j;
    }
    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          distance[i][j] = distance[i - 1][j - 1];
        } else {
          distance[i][j] = Math.min(distance[i - 1][j - 1],
              Math.min(distance[i][j - 1], distance[i - 1][j])) + 1;
        }
      }
    }
    return distance[word1.length()][word2.length()];
  }
}
