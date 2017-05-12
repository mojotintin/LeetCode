package solutions;

/**
 * Created by Calabash on 2017/4/13.
 * The LeetCode 400th
 * √
 */
public class NthDigit_400 {

    public int findNthDigit(int n) {
        int c = 1;
        long m = 9;
        while (n > c * m){
            n -= c * m;
            c += 1;
            m *= 10;
        }
        return Character.getNumericValue((String.valueOf((long) (Math.pow(10, c - 1)) + (n - 1) / c).charAt((n - 1) % c)));
    }
}