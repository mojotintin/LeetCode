package algorithms.unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Calabash on 2017/6/24.
 * Problem Number : 128
 * Problem Name : Longest Consecutive Sequence
 * Description : https://leetcode.com/problems/longest-consecutive-sequence/#/description
 * Difficulty : Hard
 * Tags : Array, Union Find
 */
public class LongestConsecutiveSequence {

  /**
   * Submission : 1
   * Status : Time Limit Exceeded
   * Runtime : N/A
   */
  public int longestConsecutive_1(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int len = 0;
    for (int num : nums) {
      int value;
      int up = num + 1;
      int down = num - 1;
      if (!set.contains(num)) {
        while (set.contains(up)) {
          up += 1;
        }
        while (set.contains(down)) {
          down -= 1;
        }
        value = up - down - 1;
        len = Math.max(len, value);
        set.add(num);
      }
    }
    return len;
  }

  /**
   * Submission : 2
   * Status : Accepted
   * Runtime : 17ms
   * Time Complexity : O(n)
   * Note : Hash Map
   */
  public int longestConsecutive_2(int[] nums) {
    Map<Integer, Boolean> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, true);
    }
    int len = 0;
    for (int num : nums) {
      if (map.get(num)) {
        int up = num + 1;
        int down = num - 1;
        while (map.containsKey(up)) {
          map.replace(up, false);
          up += 1;
        }
        while (map.containsKey(down)) {
          map.replace(down, false);
          down -= 1;
        }
        if (len < up - down - 1) {
          len = up - down - 1;
        }
      }
    }
    return len;
  }

  /**
   * Submission : 3
   * Status : Accepted
   * Runtime : 11ms
   * Time Complexity : O(n)
   * Note : Hash Set
   */
  public int longestConsecutive_3(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    int len = 0;
    for (int num : nums) {
      if (set.contains(num)) {
        int up = num + 1;
        int down = num - 1;
        while (set.contains(up)) {
          set.remove(up++);
        }
        while (set.contains(down)) {
          set.remove(down--);
        }
        if (len < up - down - 1) {
          len = up - down - 1;
        }
      }
    }
    return len;
  }
}
