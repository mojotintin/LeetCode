package solutions.array;

import java.util.Arrays;

/**
 * Created by Calabash on 2017/4/23.
 * Problem Number : 561
 * Problem Name : Array Partition I
 * Description : https://leetcode.com/problems/array-partition-i/#/description
 * Difficulty : Easy
 * Tags : Array
 */
public class ArrayPartitionI {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 41ms
   */
  public int arrayPairSum(int[] nums) {
    int sum = 0;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i += 2) {
      sum += nums[i];
    }
    return sum;
  }
}
