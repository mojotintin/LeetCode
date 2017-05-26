package solutions.other;

/**
 * Created by Calabash on 2017/4/15.
 * Problem Number :  387
 * Problem Name : First Unique Character in a String
 * Description : https://leetcode.com/problems/first-unique-character-in-a-string/#/description
 * Difficulty : Easy
 * Tags : Other
 */
public class FirstUniqueCharacterInAString {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 38ms
     */
    public int firstUniqChar(String s) {

        int[] cha = new int[26];
        for (int i = 0; i < s.length(); i++)
            cha[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (cha[s.charAt(i) - 'a'] == 1)
                return i;
        return 0;
    }
}
