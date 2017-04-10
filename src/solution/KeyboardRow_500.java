package solution;

/**
 * Created by calabash on 2017/4/10.
 * The LeetCode 500th
 * √
 */
public class KeyboardRow_500 {

    public String[] findWords(String[] words) {
        String[] rowWords = new String[words.length];
        int count = 0;
        boolean flag;
        for (String s : words) {
            flag =  true;
            String ss = s.toLowerCase();
            for (int i = 0; i < ss.length() - 1; i++){
                if (rowCount(ss.charAt(i)) != rowCount(ss.charAt(i+1))){
                    flag = false;
                    break;
                }
            }
            if (flag){ rowWords[count++] = s; }
        }

        String[] rString = new String[count];
        for (int i = 0; i < count; i++){ rString[i] = rowWords[i]; }
        return rString;
    }

    public int rowCount(char c){
        char[] row1 = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        char[] row2 = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        char[] row3 = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        for (char i : row1) { if (i == c){ return 1; } }
        for (char i : row2) { if (i == c){ return 2; } }
        return 3;
    }
}
