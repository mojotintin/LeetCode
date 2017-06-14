package solutions.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Calabash on 2017/6/14.
 * Problem Number : 219
 * Problem Name : Contains Duplicate II
 * Description : https://leetcode.com/problems/contains-duplicate-ii/#/description
 * Difficulty : Medium
 * Tags : Array, Hash Table
 */
public class ContainsDuplicateII {

  /**
   * Submission : 2
   * Status : Accepted
   * Runtime : 21ms
   */
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    if (nums.length <= k + 1) {
      for (int num : nums) {
        if (set.contains(num)) {
          return true;
        } else {
          set.add(num);
        }
      }
    } else {
      for (int i = 0; i < k + 1; i++) {
        if (set.contains(nums[i])) {
          return true;
        } else {
          set.add(nums[i]);
        }
      }
      for (int j = k + 1; j < nums.length; j++) {
        set.remove(nums[j - k - 1]);
        if (set.contains(nums[j])) {
          return true;
        } else {
          set.add(nums[j]);
        }
      }
    }
    return false;
  }
}
