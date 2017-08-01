package algorithms.bitmanipulation;

/**
 * Created by calabash on 2017/8/1.
 * Problem Number: 318
 * Problem Name: Maximum Product of Word Lengths
 * Difficulty : Medium
 * Related Topics: Bit Manipulation
 * Source: https://leetcode.com/problems/maximum-product-of-word-lengths/
 *
 * #---------------------------------------------------------------------------
 * # Given a string array words, find the maximum value of length(word[i]) *
 * # length(word[j]) where the two words do not share common letters. You may
 * # assume that each word will contain only lower case letters. If no such two
 * # words exist, return 0.
 * #
 * # Example 1:
 * # Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * # Return 16
 * # The two words can be "abcw", "xtfn".
 * #
 * # Example 2:
 * # Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * # Return 4
 * # The two words can be "ab", "cd".
 * #
 * # Example 3:
 * # Given ["a", "aa", "aaa", "aaaa"]
 * # Return 0
 * # No such pair of words.
 * #---------------------------------------------------------------------------
 */
public class MaximumProductOfWordLengths {

  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 78ms
   */
  public int maxProduct(String[] words) {
    int[] tags = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        tags[i] =tags[i] | (int)Math.pow(2, words[i].charAt(j) - 'a');
      }
    }
    int max = 0;
    for (int i = 0; i < words.length - 1; i++) {
      for (int j = i + 1; j < words.length; j++) {
        if ((tags[i] & tags[j]) == 0) {
          max = Math.max(max, words[i].length() * words[j].length());
        }
      }
    }
    return max;
  }
}
