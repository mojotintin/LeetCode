package solution;

/**
 * Created by Calabash on 2017/4/17.
 * The LeetCode 242th
 * √
 */
public class ValidAnagram_242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
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
