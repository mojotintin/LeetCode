package solutions.math;

/**
 * Created by Calabash on 2017/5/14.
 * The LeetCode 343th
 * Description : https://leetcode.com/problems/integer-break/#/description
 * Tags : Dynamic Programming, Math
 */
public class IntegerBreak_343 {

    /**
     * Status : Accepted
     * Runtime : 0ms
     * Note : Math
     */
    public int integerBreak(int n) {

        if(n == 2) return 1;
        if(n == 3) return 2;
        int x = n / 3;
        int y = n % 3;
        if (y == 0) {
        	return (int)Math.pow(3, x);
        } else if (y == 1) {
        	return (int)Math.pow(3, x - 1) * 4;
        } else{
        	return (int)Math.pow(3, x) * 2;
        }
    }

}
