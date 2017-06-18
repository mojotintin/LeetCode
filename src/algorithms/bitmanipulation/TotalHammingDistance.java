package algorithms.bitmanipulation;

/**
 * Created by Calabash on 2017/6/17.
 * Problem Number : 477
 * Problem Name : Total Hamming Distance
 * Description : https://leetcode.com/problems/total-hamming-distance/#/description
 * Difficulty : Medium
 * Tags : Bit Manipulation
 */
public class TotalHammingDistance {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 71ms
   */
  public int totalHammingDistance_1(int[] nums) {
    int hamDistance = 0;
    int countOne    = 0;
    int countZero   = 0;
    int max = 0;
    for (int num : nums) {
      if (num > max) {
        max = num;
      }
    }
    int round = (int) (Math.log(max) / Math.log(2)) + 1;
    for (int i = 0; i < round; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (nums[j] % 2 == 1) {
          countOne  += 1;
        } else {
          countZero += 1;
        }
        nums[j] >>= 1;
      }
      hamDistance += countOne * countZero;
      countOne  = 0;
      countZero = 0;
    }
    return hamDistance;
  }

  /**
   * Submission : 2
   * Status : Accepted
   * Runtime : 35ms
   */
  public int totalHammingDistance_2(int[] nums) {
    int hamDistance = 0;
    int countOne    = 0;
    int countZero;
    int max = 0;
    for (int num : nums) {
      if (num > max) {
        max = num;
      }
    }
    int round = (int) (Math.log(max) / Math.log(2)) + 1;
    for (int i = 0; i < round; i++) {
      for (int j = 0; j < nums.length; j++) {
        countOne += nums[j] % 2;
        nums[j] >>= 1;
      }
      countZero = nums.length - countOne;
      hamDistance += countOne * countZero;
      countOne = 0;
    }
    return hamDistance;
  }
}
