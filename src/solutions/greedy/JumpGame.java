package solutions.greedy;

/**
 * Created by Calabash on 2017/5/12.
 * Problem Number : 55
 * Problem NAme : Jump Game
 * Description : https://leetcode.com/problems/jump-game/#/description
 * Difficulty : Medium
 * Tags : Array, Greedy
 */
public class JumpGame {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 8ms
   */
  public boolean canJump(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == 0) {
        int flag = 0, k = 1;
        for (int j = i - 1; j >= 0; j--) {
          if (nums[j] > k++) {
            flag = 1;
            break;
          }
        }
        if (flag == 0) {
          return false;
        }
      }
    }
    return true;
  }
}
