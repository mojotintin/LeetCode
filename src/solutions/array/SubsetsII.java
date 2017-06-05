package solutions.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by calabash on 2017/5/30.
 * Problem Number : 90
 * problem Name : Subsets II
 * Description : https://leetcode.com/problems/subsets-ii/#/description
 * Difficulty : Medium
 * Tags : Array, Backtracking
 */
public class SubsetsII {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 2ms
   */
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>());
    Arrays.sort(nums);
    if (nums.length == 0) {
      return subsets;
    }
    List<Integer> subset = new ArrayList<>();
    subset.add(nums[0]);
    subsets.add(subset);
    int count = subsets.size();
    for (int i = 1; i < nums.length; i++) {
      int size = subsets.size();
      if (nums[i] != nums[i - 1]) {
        count = size;
      }
      else if (count == size) {
        count = size / 2;
      }
      for (int j = size - count; j < size; j++) {
        List<Integer> newSub = new ArrayList<>(subsets.get(j));
        newSub.add(nums[i]);
        subsets.add(newSub);
      }
    }
    return subsets;
  }
}
