package solutions.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/5/9.
 * Problem Number : 46
 * Problem Name : Permutations
 * Description : https://leetcode.com/problems/permutations/#/description
 * Difficulty : Medium
 * Tags : Backtracking
 */
public class Permutations {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 6ms
     */
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            permutations.add(permutation);
            return permutations;
        }
        permutation.add(nums[0]);
        permutations.add(permutation);

        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> pers = new ArrayList<>();
            for (List<Integer> per : permutations) {
                for (int j = 0; j <= per.size(); j++) {
                    List<Integer> temp = new ArrayList<>(per);
                    temp.add(j, nums[i]);
                    pers.add(temp);
                }
            }
            permutations = pers;
        }

        return permutations;
    }
}
