package algorithms.array;

/**
 * Created by Calabash on 2017/4/19.
 * LeetCode 167th : Two Sum II - Input array is sorted
 * Description : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/#/description
 * Difficulty : Easy
 * Tags : Array, Two Points, Binary Search
 */
public class TwoSumII_InputArrayISorted {

  /*
   * Submission : 1
   * Status : Accepted
   * Runtime : 48ms
   * Time complexity : O(n ^ 2)
   */
  public int[] twoSum_1(int[] numbers, int target) {
    int[] index = new int[2];
    for (int i = 0; i < numbers.length; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        if (numbers[i] + numbers[j] == target) {
          index[0] = i + 1;
          index[1] = j + 1;
          return index;
        }
      }
    }
    return index;
  }

  /*
  * Submission : 2
  * Status : Accepted
  * Runtime : 1ms
  * Time complexity : O(n)
  */
  public int[] twoSum_2(int[] numbers, int target) {
    int in1 = 0;
    int in2 = numbers.length - 1;
    while (numbers[in1] + numbers[in2] != target) {
      if (numbers[in1] + numbers[in2] > target) {
        in2 --;
      }
      else {
        in1 ++;
      }
    }
    return new int[]{in1 + 1, in2 + 1};
  }
}
