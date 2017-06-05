package solutions.hashtable;

/**
 * Created by calabash on 2017/4/10.
 * Problem Number : 500
 * Problem Name : Keyboard Row
 * Description : https://leetcode.com/problems/keyboard-row/#/description
 * Difficulty : Easy
 * Tags : Hash Table
 */
public class KeyboardRow {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 3ms
   */
  public String[] findWords(String[] words) {
    String[] rowWords = new String[words.length];
    int count = 0;
    boolean flag;
    for (String s : words) {
      flag =  true;
      String ss = s.toLowerCase();
      for (int i = 0; i < ss.length() - 1; i++){
        if (rowCount(ss.charAt(i)) != rowCount(ss.charAt(i+1))){
          flag = false;
          break;
        }
      }
      if (flag){ rowWords[count++] = s; }
    }
    String[] rString = new String[count];
    System.arraycopy(rowWords, 0, rString, 0, count);
    return rString;
  }

  private int rowCount(char c){
    char[] row1 = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
    char[] row2 = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
    for (char i : row1) { if (i == c){ return 1; } }
    for (char i : row2) { if (i == c){ return 2; } }
    return 3;
  }
}
