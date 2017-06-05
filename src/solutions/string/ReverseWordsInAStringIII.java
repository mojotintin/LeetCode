package solutions.string;

/**
 * Created by calabash on 2017/4/9.
 * Problem Number : 557
 * Problem Name : Reverse Words in a String III
 * Description : https://leetcode.com/problems/reverse-words-in-a-string-iii/#/description
 * Difficulty : Easy
 * Tags : String
 */
public class ReverseWordsInAStringIII {

  /**
   * Submission : 1
   * Status : Time Limit Exceeded
   */
  public String reverseWords_1(String s) {
    String reString = "";
    int start = 0;
    for (int i = 0; i < s.length(); i++){
      if (s.charAt(i) == ' '){
        for (int j = i - 1; j >= start; j--) {
          reString += s.charAt(j);
        }
        reString += " ";
        start = i + 1;
      }
    }
    for (int j = s.length() - 1; j >= start; j--) {
      reString += s.charAt(j);
    }
    return reString;
  }

  /**
   * Submission : 2
   * Status : Accepted
   * Runtime : 203ms
   */
  public String reverseWords_2(String s) {
    String reString = "";
    String word = "";
    for (int i = 0; i < s.length(); i++){
      if (s.charAt(i) != ' ') {
        word = s.charAt(i) + word;
      }
      else {
        reString += word + " ";
        word = "";
      }
    }
    return reString + word;
  }

  /**
   * Submission : 3
   * Status : Accepted
   * Runtime : 52ms
   */
  public String reverseWords_3(String s) {
    StringBuilder reString = new StringBuilder();
    StringBuilder word = new StringBuilder();
    for (int i = 0; i < s.length(); i++){
      if (s.charAt(i) != ' ') {
        word.insert(0, s.charAt(i));
      }
      else {
        reString.append(word).append(" ");
        word = new StringBuilder();
      }
    }
    return reString.toString() + word.toString();
  }
}
