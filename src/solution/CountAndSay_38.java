package solution;

/**
 * Created by Calabash on 2017/5/2.
 * The LeetCode 38th
 * √
 */
public class CountAndSay_38 {

    public String countAndSay(int n) {
        StringBuilder re = new StringBuilder();
        String se = "1";

        for (int i = 1; i < n; i++) {
            int count = 1;

            for (int j = 1; j < se.length(); j++) {
                if (se.charAt(j) == se.charAt(j  - 1)) {
                    count ++;
                } else {
                    re.append(count);
                    re.append(se.charAt(j - 1));
                    count = 1;
                }
            }

            re.append(count);
            re.append(se.charAt(se.length() - 1));
            se = re.toString();
            re.delete(0, re.length());
        }

        return se;
    }
}
