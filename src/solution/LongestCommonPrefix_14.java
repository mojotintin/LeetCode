package solution;

/**
 * Created by Calabash on 2017/5/4.
 *
 */
public class LongestCommonPrefix_14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int prefixLen = 0, prefixMaxLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            prefixMaxLen = Math.min(prefixLen, strs[i].length());
        }

        for (int i = 0; i < prefixMaxLen; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[j - 1].charAt(i)) return strs[0].substring(0, prefixLen);
            }

            prefixLen ++;
        }
        return strs[0].substring(0, prefixLen);
    }
}
