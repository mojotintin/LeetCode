package solutions.bitmanipulation;

/**
 * Created by calabash on 2017/3/27.
 * Problem Number : 476
 * Problem Name : Number Complement
 * Description : https://leetcode.com/problems/number-complement/#/description
 * Difficulty : Easy
 * Tags : Bit Manipulation
 */
public class NumberComplement {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 13ms
     */
    public int findComplement_1(int num) {
        int re = 0, count = 0;
        while(num / 2 > 0){
            if (num % 2 == 0){
                re += Math.pow(2, count);
            }
            count++;
            num = num / 2;
        }
        return re;
    }

    /**
     * Submission : 2
     * Status : Time Limit Exceeded
     * Runtime : N/A
     */
    public int findComplement_2(int num) {
        int i = 1;
        while(i <= num){
            i = i << 1;
        }
        return (i - 1) ^ num;
    }
}
