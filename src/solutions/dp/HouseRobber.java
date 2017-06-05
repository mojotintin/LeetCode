package solutions.dp;

/**
 * Created by Calabash on 2017/5/24.
 * Problem Number : 198
 * problem Name : House Robber
 * Description : https://leetcode.com/problems/house-robber/#/description
 * Difficulty : Easy
 * Tags : Dynamic Programming
 */
public class HouseRobber {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 0ms
   */
  public int rob_1(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    int[] money = new int[nums.length];
    boolean isLastChoSen;
    money[0] = nums[0];
    if (nums[0] >= nums[1]) {
      isLastChoSen = false;
      money[1] = nums[0];
    } else {
      isLastChoSen = true;
      money[1] = nums[1];
    }
    for (int i = 2; i < nums.length; i++){
      if (!isLastChoSen) {
        money[i] = nums[i] + money[i - 1];
        isLastChoSen = true;
      } else {
        if (money[i - 2] + nums[i] > money[i - 1]) {
          money[i] = money[i - 2] + nums[i];
          isLastChoSen = true;
        } else {
          money[i] = money[i - 1];
          isLastChoSen = false;
        }
      }
    }
    return money[nums.length - 1];
  }

  /**
   * Submission : 2
   * Status : Accepted
   * Runtime : 1ms
   */
  public int rob_2(int[] nums) {
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    } else if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    int[] money = new int[nums.length];
    money[0] = nums[0];
    if (nums[0] >= nums[1]) {
      money[1] = nums[0];
    }
    else {
      money[1] = nums[1];
    }
    for (int i = 2; i < nums.length; i++){
      money[i] = Math.max(money[i - 1], money[i - 2] + nums[i]);
    }
    return money[nums.length - 1];
  }
}
