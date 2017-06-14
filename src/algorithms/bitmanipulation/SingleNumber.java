package algorithms.bitmanipulation;

/**
 * Created by calabash on 2017/5/29.
 * Problem Number : 136
 * Problem Name : Single Number
 * Description : https://leetcode.com/problems/single-number/#/description
 * Difficulty : Easy
 * Tags : Hash Table, Bit Manipulation
 */
public class SingleNumber {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 1ms
   * Note : Bit Manipulation
   */
  public int singleNumber(int[] nums) {
    int i = 0;
    for (int num : nums) {
      i ^= num;
    }
    return i;
  }
}
