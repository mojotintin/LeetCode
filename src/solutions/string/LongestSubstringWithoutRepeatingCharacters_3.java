package solutions.string;

/**
 * Created by Calabash on 2017/5/8.
 * LeetCode 3th : Longest Substring Without Repeating Characters
 * Description : https://leetcode.com/problems/longest-substring-without-repeating-characters/#/description
 * Difficulty : Medium
 * Tags : Hash Table, Two Points, String
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

    /**
     * Status : Accepted
     * Runtime : 55ms
     */
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int len = 0;
        for (int i = 0; i < s.length() ; i ++) {
        	for (int j = start; j <  i; j ++) {
        		if (s.charAt(i) == s.charAt(j)) {
        			len = Math.max(len, i - start);
        			start = j + 1;
        			break;
        		}
        	}
        }
        len = Math.max(len, s.length() - start);
        return len;
    }
}
