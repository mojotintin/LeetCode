package algorithms.string;

/**
 * Created by Calabash on 2017/4/21.
 * Problem Number : 151
 * Problem Name : Reverse Words in a String
 * Description : https://leetcode.com/problems/reverse-words-in-a-string/#/description
 * Difficulty : Medium
 * Tags : String
 */
public class ReverseWordsInAString {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 69ms
   */
  public String reverseWords_1(String s) {
    if (s.trim() == "") {
      return "";
    }
    String[] words = s.trim().split("\\s+");
    String res = "";
    for (String word : words) {
      res = word + " " + res;
    }

    return res.trim();
  }

  /**
   * Submission : 2
   * Status : Accepted
   * Runtime : 17ms
   */
  public String reverseWords_2(String s) {
    if (s.trim().equals("")) {
      return "";
    }
    String[] words = s.trim().split("\\s+");
    StringBuilder reS = new StringBuilder();
    for (String word : words) {
      reS.insert(0, word + " ");
    }
    return reS.toString().trim();
  }
}
