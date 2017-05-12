package solutions;

/**
 * Created by calabash on 2017/4/7.
 *
 */
public class StupidThief_JD {

    public int stupidThiefCount(String s, int len) {
        int end = -1, count = 0;
        int[] flag = new int[len];
        for (int i = 0; i < len; i++) flag[i] = 0;
        for (int i = 0; i < len; i++){
            if (s.charAt(i) != 'X' && s.charAt(i) != '#') end =Math.max(i + s.charAt(i) - 48, end);
            else if (i <= end && s.charAt(i) == 'X') {
                count += 1;
                flag[i] = 1;
            }
        }
        end = len;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != 'X' && s.charAt(i) != '#') end = Math.min(i - (s.charAt(i) - 48), end);
            else if (i >= end && s.charAt(i) == 'X' && flag[i] == 0) {
                count += 1;
            }
        }
        return count;
    }
}
