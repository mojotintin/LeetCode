package solutions.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Calabash on 2017/6/11.
 * Problem Number : 39
 * Problem Name : Combination Sum
 * Description : https://leetcode.com/problems/combination-sum/#/description
 * Difficulty : Medium
 * Tags ： Array, Backtracking
 */
public class CombinationSum {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 19ms
   */
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        index = walkIndex.remove(walkIndex.size() - 1) + 1;
        walkSum -= candidates[index - 1];
        continue;
      }
      if (walkSum + candidates[index] < target) {
        walkSum += candidates[index];
        walk.add(candidates[index]);
        walkIndex.add(index);
      } else if (walkSum + candidates[index] == target) {
        List<Integer> path = new ArrayList<>(walk);
        path.add(candidates[index]);
        paths.add(path);
        if (walk.size() == 0) {
          break;
        }
        walk.remove(walk.size() - 1);
        index = walkIndex.remove(walkIndex.size() - 1) + 1;
        walkSum -= candidates[index - 1];
      }
    }
    return paths;
  }
}
