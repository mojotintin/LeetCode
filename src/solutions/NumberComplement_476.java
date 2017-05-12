package solutions;

/**
 * Created by calabash on 2017/3/27.
 * LeetCode 476th Number Complement
 */
public class NumberComplement_476 {

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

    public int findComplement_2(int num) {
        int i = 1;
        while(i <= num){
            i = i << 1;
        }
        return (i - 1) ^ num;
    }
}
