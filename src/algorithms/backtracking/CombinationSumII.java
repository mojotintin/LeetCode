package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Calabash on 2017/6/11.
 * problem Number : 40
 * Problem Name : Combination Sum II
 * Description : https://leetcode.com/problems/combination-sum-ii/#/description
 * Difficulty : Medium
 * Tags : Array, Backtracking
 */
public class CombinationSumII {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 27ms
   */
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> paths = new ArrayList<>();
    Arrays.sort(candidates);
    int valid = candidates.length;
    for (int i = 0; i < candidates.length; i++) {
      if (candidates[i] > target) {
        valid = i;
        break;
      }
    }
    List<Integer> walk = new ArrayList<>();
    List<Integer> walkIndex = new ArrayList<>();
    int walkSum = 0;
    int index = 0;
    while (index < valid || walk.size() != 0) {
      if (index >= valid || walkSum + candidates[index] > target) {
        walk.remove(walk.size() - 1);
        int in = walkIndex.remove(walkIndex.size() - 1);
        walkSum -= candidates[in];
        index = valid;
        for (int i = in + 1; i < valid; i++) {
          if (candidates[i] != candidates[in]) {
            index = i;
            break;
          }
        }
        continue;
      }
      if (walkSum + candidates[index] < target) {
        walkSum += candidates[index];
        walk.add(candidates[index]);
        walkIndex.add(index);
        index++;
      } else if (walkSum + candidates[index] == target) {
        List<Integer> path = new ArrayList<>(walk);
        path.add(candidates[index]);
        paths.add(path);
        if (walk.size() == 0) {
          break;
        }
        walk.remove(walk.size() - 1);
        int in = walkIndex.remove(walkIndex.size() - 1);
        walkSum -= candidates[in];
        index = valid;
        for (int i = in + 1; i < valid; i++) {
          if (candidates[i] != candidates[in]) {
            index = i;
            break;
          }
        }
      }
    }
    return paths;
  }
}
