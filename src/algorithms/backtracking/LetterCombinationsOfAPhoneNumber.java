package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Calabash on 2017/5/8.
 * problem Number : 17
 * Problem Name : Letter Combinations of a Phone Number
 * Description : https://leetcode.com/problems/letter-combinations-of-a-phone-number/#/description
 * Difficulty : Medium
 * Tags : Backtracking, String
 */
public class LetterCombinationsOfAPhoneNumber {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 5ms
   */
  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0){
      return new ArrayList<>();
    }
    String[] cha = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> letters = new ArrayList<>();
    letters.add("");
    for (int i = 0; i < digits.length(); i ++) {
      List<String> list = new ArrayList<>();
      String digit = cha[Character.getNumericValue(digits.charAt(i)) - 1];
      if (Objects.equals(digit, "")) {
        return new ArrayList<>();
      }
      for (String s : letters) {
        for (int j = 0; j < digit.length(); j ++) {
          list.add(s + digit.charAt(j));
        }
      }
      letters = list;
    }
    return letters;
  }
}
