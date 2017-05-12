package solutions;

/**
 * Created by Calabash on 2017/4/15.
 * The LeetCode 58th
 *
 */
public class LengthOfLastWord_58 {

     public int lengthOfLastWord(String s) {
         int end = s.length() - 1;
         for (int i = s.length() - 1; i >= 0; i --)
             if (s.charAt(i) != ' '){
                 end = i;
                 break;
             }
         for (int i = end; i >= 0; i --)
             if (s.charAt(i) == ' ' || i == 0)
                 return end - i + 1;
         return 0;
     }
}
