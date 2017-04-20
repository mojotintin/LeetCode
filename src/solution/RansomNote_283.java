package solution;

/**
 * Created by Calabash on 2017/4/20.
 *
 */
public class RansomNote_283 {

    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) return false;
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (int i = 0; i < ransomNote.length(); i++){ c1[ransomNote.charAt(i) - 'a'] ++; }
        for (int i = 0; i < magazine.length(); i++){ c2[magazine.charAt(i) - 'a'] ++; }

        for (int i = 0; i < 26; i++){
            if (c1[i] > c2[i]) return false;
        }
        return true;
    }
}
