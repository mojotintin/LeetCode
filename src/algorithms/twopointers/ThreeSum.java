package algorithms.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Calabash on 2017/7/5.
 * Problem Number : 15
 * Problem Name : 3Sum
 * Description : https://leetcode.com/problems/3sum/#/description
 * Difficulty : Medium
 * Tags : Array, Two Pointers
 */
public class ThreeSum {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 84ms
   */
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> triplets = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
        int start = i + 1;
        int end = nums.length - 1;
        int sum = 0 - nums[i];
        while (start < end) {
          if (nums[start] + nums[end] == sum) {
            triplets.add(Arrays.asList(nums[i], nums[start], nums[end]));
            while (start < end && nums[start] == nums[start + 1]) {
              start += 1;
            }
            while (start < end && nums[end] == nums[end - 1]) {
              end -= 1;
            }
            start += 1;
            end -= 1;
          } else if (nums[start] + nums[end] < sum) {
            start += 1;
          } else {
            end -= 1;
          }
        }
      }
    }
    return triplets;
  }
}
