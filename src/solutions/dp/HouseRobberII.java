package solutions.dp;

/**
 * Created by Calabash on 2017/5/24.
 * Problem Number : 231
 * problem Name : House Robber
 * Description : https://leetcode.com/problems/house-robber-ii/#/description
 * Difficulty : Medium
 * Tags : Dynamic Programming
 */
public class HouseRobberII {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 0ms
   */
  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int[] money = new int[nums.length];
    boolean isLastChosen;
    money[0] = nums[0];
    if (nums[0] >= nums[1]) {
      isLastChosen = false;
      money[1] = nums[0];
    } else {
      isLastChosen = true;
      money[1] = nums[1];
    }
    if (nums.length == 2) {
      return money[1];
    }
    for (int i = 2; i < nums.length - 1; i++){
      if (!isLastChosen) {
        money[i] = nums[i] + money[i - 1];
        isLastChosen = true;
      } else {
        if (money[i - 2] + nums[i] > money[i - 1]) {
          money[i] = money[i - 2] + nums[i];
          isLastChosen = true;
        } else {
          money[i] = money[i - 1];
          isLastChosen = false;
        }
      }
    }
    int money1 = money[nums.length - 2];
    money = new int[nums.length];
    money[1] = nums[1];
    if (nums[1] >= nums[2]) {
      isLastChosen = false;
      money[2] = nums[1];
    } else {
      isLastChosen = true;
      money[2] = nums[2];
    }
    for (int i = 3; i < nums.length; i++){
      if (!isLastChosen) {
        money[i] = nums[i] + money[i - 1];
        isLastChosen = true;
      } else {
        if (money[i - 2] + nums[i] > money[i - 1]) {
          money[i] = money[i - 2] + nums[i];
          isLastChosen = true;
        } else {
          money[i] = money[i - 1];
          isLastChosen = false;
        }
      }
    }
    int money2 = money[nums.length - 1];
    return Math.max(money1, money2);
  }
}
