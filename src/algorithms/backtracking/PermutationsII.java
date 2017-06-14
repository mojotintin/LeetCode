package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by calabash on 2017/5/29.
 * Problem Number : 46
 * Problem Name : Permutations II
 * Description : https://leetcode.com/problems/permutations-ii/#/description
 * Difficulty : Medium
 * Tags : Backtracking
 */
public class PermutationsII {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 8ms
   */
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> permutes = new ArrayList<>();
    List<Integer> per = new ArrayList<>();
    Arrays.sort(nums);
    per.add(nums[0]);
    permutes.add(per);
    for (int i = 1; i < nums.length; i++) {
      List<List<Integer>> newPermutes = new ArrayList<>();
      for (List<Integer> permute : permutes) {
        int start = findLast(permute, nums[i]);
        for (int j = start + 1; j <= permute.size(); j++) {
          List<Integer> newPermute = new ArrayList<>(permute);
          newPermute.add(j, nums[i]);
          newPermutes.add(newPermute);
        }
      }
      permutes = newPermutes;
    }
    return permutes;
  }

  private int findLast(List<Integer> permute, int target) {
    for (int i = permute.size() - 1; i >= 0; i--) {
      if (permute.get(i) == target) {
        return i;
      }
    }
    return -1;
  }
}
