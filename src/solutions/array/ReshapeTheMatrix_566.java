package solutions.array;

/**
 * Created by Calabash on 2017/5/3.
 * LeetCode 566th
 * Tags : Array
 */
public class ReshapeTheMatrix_566 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {

        if (nums.length == 0) return nums;
        if (nums.length * nums[0].length != r * c) return nums;
        int m = 0, n = 0;
        int[][] reshapedNums = new int[r][c];
        for (int[] num : nums) {
            for (int j = 0; j < nums[0].length; j++) {
                reshapedNums[m][n] = num[j];
                if (n + 1 == c) {
                    n = 0;
                    m++;
                } else {
                    n++;
                }
            }
        }

        return reshapedNums;
    }
}
