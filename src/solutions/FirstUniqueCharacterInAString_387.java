package solutions;

/**
 * Created by Calabash on 2017/4/15.
 * The LeetCode 387th
 * √
 */
public class FirstUniqueCharacterInAString_387 {

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
