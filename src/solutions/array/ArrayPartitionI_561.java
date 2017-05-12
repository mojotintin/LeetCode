package solutions.array;

import java.util.Arrays;

/**
 * Created by Calabash on 2017/4/23.
 * The LeetCode 561th
 * Tags : Array
 */
public class ArrayPartitionI_561 {

    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
