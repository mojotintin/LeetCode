package solutions.string;

/**
 * Created by calabash on 2017/4/5.
 * LeetCode 459th :  Repeated Substring Pattern
 * Description : https://leetcode.com/problems/repeated-substring-pattern/#/description
 * Difficulty : Easy
 * Tags : String
 */
public class RepeatedSubstringPattern_459 {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 39ms
     */
    public boolean repeatedSubstringPattern(String s) {

        for (int i = s.length() / 2; i >= 1 ; i--){
            if (s.length() % i == 0 && isPrimeNumber(s.length() / i)) {
                for (int j = i; j < s.length(); j++){
                    if (s.charAt(j) != s.charAt(j % i)) break;
                    else if (j == s.length() - 1) return true;
                }
            }
        }
        return false;
    }

    public boolean isPrimeNumber(int n) {
        if (n == 2) return true;
        else if (n % 2 == 0) return false;
        for (int i = 3; i < (int)Math.sqrt(n); i += 2){
            if (n % i == 0) return false;
        }
        return true;
    }
}
