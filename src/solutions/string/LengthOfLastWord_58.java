package solutions.string;

/**
 * Created by Calabash on 2017/4/15.
 * LeetCode 58th : Length of Last Word
 * Description : https://leetcode.com/problems/length-of-last-word/#/description
 * Difficulty : Easy
 * Tags : String
 */
public class LengthOfLastWord_58 {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 9ms
     */
    public int lengthOfLastWord_1(String s) {
        int end = s.length() - 1;
        for (int i = s.length() - 1; i >= 0; i --)
            if (s.charAt(i) != ' '){
                end = i;
                break;}
        for (int i = end; i >= 0; i --)
            if (s.charAt(i) == ' ' || i == 0)
                return end - i + 1;
        return 0;
    }

    /**
     * Submission : 2
     * Status : Accepted
     * Runtime : 5ms
     */
    public int lengthOfLastWord_2(String s) {
        int end = s.length() - 1;
        int start = -1;
        for (int i = s.length() - 1; i >= 0; i --){
            if (s.charAt(i) != ' '){
                end = i;
                break;
            }
        }
        for (int i = end; i >= 0; i --){
            if (s.charAt(i) == ' '){
                start = i;
                break;
            }
        }
        return end - start;
    }
}
