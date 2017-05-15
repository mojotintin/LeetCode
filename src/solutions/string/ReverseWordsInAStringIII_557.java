package solutions.string;

/**
 * Created by calabash on 2017/4/9.
 * The leetCode 557th
 * Tags : String
 */
public class ReverseWordsInAStringIII_557 {

    /**
     * Time Limit Exceeded
     */
    public String reverseWords_1(String s) {

        String reString = "";
        int start = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                for (int j = i - 1; j >= start; j--){reString += s.charAt(j);}
                reString += " ";
                start = i + 1;
            }
        }

        for (int j = s.length() - 1; j >= start; j--) {reString += s.charAt(j);}

        return reString;
    }

    /**
     * Status : Accepted
     */
    public String reverseWords_2(String s) {

        String reString = "", word = "";
        int start = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != ' ') { word = s.charAt(i) + word; }
            else {
                reString += word + " ";
                word = "";
            }
        }
        return reString + word;
    }
}
