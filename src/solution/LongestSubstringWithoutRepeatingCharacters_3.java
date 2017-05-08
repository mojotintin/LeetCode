package solution;

/**
 * Created by Calabash on 2017/5/8.
 *
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

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
