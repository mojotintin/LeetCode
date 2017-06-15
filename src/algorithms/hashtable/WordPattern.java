package algorithms.hashtable;

import java.util.HashMap;

/**
 * Created by Calabash on 2017/6/15.
 * Problem Number : 290
 * Problem Name : Word Pattern
 * Description : https://leetcode.com/problems/word-pattern/#/description
 * Difficulty : Easy
 * Tags : Hash Table
 */
public class WordPattern {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 2ms
   */
  public boolean wordPattern(String pattern, String str) {
    HashMap<Character, String> map = new HashMap<>();
    String[] words = str.split(" ");
    if (pattern.length() != words.length) {
      return false;
    }
    for (int i = 0; i < pattern.length(); i++) {
      if (map.containsKey(pattern.charAt(i))) {
        if (!words[i].equals(map.get(pattern.charAt(i)))) {
          return false;
        }
      } else if (map.containsValue(words[i])) {
        return false;
      } else {
        map.put(pattern.charAt(i), words[i]);
      }
    }
    return true;
  }
}
