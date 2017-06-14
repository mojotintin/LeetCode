package algorithms.twopointers;

/**
 * Created by Calabash on 2017/5/3.
 * Problem Number : 567
 * Problem Name : Permutation in String
 * Description : https://leetcode.com/problems/permutation-in-string/#/description
 * Difficulty : Medium
 * Tags : Two Points
 */
public class PermutationInString {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 25ms
   */
  public boolean checkInclusion(String s1, String s2) {
    if (s2.length() < s1.length()) {
      return false;
    }
    int[] charCount1 = new int[26];
    int[] charCount2 = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      charCount1[s1.charAt(i) - 'a'] ++;
      charCount2[s2.charAt(i) - 'a'] ++;
    }
    if (isPermutation(charCount1, charCount2)) {
      return true;
    } else {
      for (int i = s1.length(); i < s2.length(); i++) {
        charCount2[s2.charAt(i) - 'a'] ++;
        charCount2[s2.charAt(i - s1.length()) - 'a'] --;
        if (isPermutation(charCount1, charCount2)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean isPermutation(int[] charCount1, int[] charCount2) {
    for (int i = 0; i < 26; i++) {
      if (charCount1[i] != charCount2[i]) {
        return false;
      }
    }
    return true;
  }
}

