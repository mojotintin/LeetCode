package solutions.hashtable;

/**
 * Created by Calabash on 2017/4/17.
 * Problem Number : 242
 * Problem Name : Valid Anagram
 * Description : https://leetcode.com/problems/valid-anagram/#/description
 * Difficulty : Easy
 * Tags : Hash Table, Sort
 */
public class ValidAnagram {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 8ms
   */
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] sc = new int[26];
    int[] tc = new int[26];
    for (int i = 0; i < s.length(); i ++) {
      sc[s.charAt(i) - 'a'] ++;
      tc[t.charAt(i) - 'a'] ++;
    }
    for (int i = 0; i < 26; i++) {
      if (sc[i] != tc[i])
        return false;
    }
    return true;
  }
}
