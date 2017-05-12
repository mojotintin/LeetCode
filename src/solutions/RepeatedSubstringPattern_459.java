package solutions;

/**
 * Created by calabash on 2017/4/5.
 *
 */
public class RepeatedSubstringPattern_459 {

    // Time Limit Exceeded
    public boolean repeatedSubstringPattern_1(String s) {
         for (int i = 1; i <= s.length() / 2; i++){
             for (int j = i; j < s.length(); j++){
                 System.out.println(i + " " + s.charAt(j) + " " +s.charAt(j % i));
                 if (s.charAt(j) != s.charAt(j % i)){
                     break;
                 } else if (j == s.length() - 1  && (j + 1) % i == 0){
                     return true;
                 }
             }
         }
        return false;
    }

    // work
    public boolean repeatedSubstringPattern_2(String s) {

        for (int i = s.length() / 2; i >= 2 ; i--){
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
