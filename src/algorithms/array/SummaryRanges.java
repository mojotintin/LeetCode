package algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/6/28.
 * Problem Number : 228
 * Problem Name : Summary Ranges
 * Description : https://leetcode.com/problems/summary-ranges/#/description
 * Difficulty : Medium
 * Tags : Array
 */
public class SummaryRanges {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 0ms
   */
  public List<String> summaryRanges(int[] nums) {
    List<String> list = new ArrayList<>();
    if (nums.length == 0) {
      return list;
    }
    int start = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i + 1] != nums[i] + 1) {
        if (start == i) {
          list.add(String.valueOf(nums[start]));
        } else {
          list.add(nums[start] + "->" + nums[i]);
        }
        start = i + 1;
      }
    }
    if (start == nums.length - 1) {
      list.add(String.valueOf(nums[start]));
    } else {
      list.add(nums[start] + "->" + nums[nums.length - 1]);
    }
    return list;
  }
}
