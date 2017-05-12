package solutions;

/**
 * Created by Calabash on 2017/4/19.
 * The leetCode 167th
 * √
 */
public class TwoSumII_InputArrayISorted_167 {

    /*
     * time takes too long
     * o(n*n) solutions
     */
    public int[] twoSum_1(int[] numbers, int target) {
        int[] index = new int[2];
        for (int i = 0; i < numbers.length; i ++)
            for (int j = i + 1; j < numbers.length; j ++)
                if (numbers[i] + numbers[j] == target) {
                    index[0] = i + 1;
                    index[1] = j + 1;
                    return index;
                }
        return index;
    }

    // o(n) solutions
     public int[] twoSum_2(int[] numbers, int target) {
        int in1 = 0, in2 = numbers.length - 1;
        while (numbers[in1] + numbers[in2] != target) {
            if (numbers[in1] + numbers[in2] > target)
                in2 --;
            else
                in1 ++;
        }
        return new int[]{in1 + 1, in2 + 1};
    }
}
