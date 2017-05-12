package solutions.string;

/**
 * Created by Calabash on 2017/4/21.
 * The LeetCode 151th
 * Tags : String
 */
public class ReverseWordsInAString_151 {

    public String reverseWords(String s) {
        if (s.trim() == "") return "";
        String[] words = s.trim().split("\\s+");
        String res = "";
        for (String word : words) {
            res = word + " " + res;
        }

        return res.trim();
    }
}
