package solutions.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/5/25.
 * Problem Number : 78
 * problem Name : Subsets
 * Description : https://leetcode.com/problems/house-robber/#/description
 * Difficulty : Medium
 * Tags : Array, Backtracking, Bit Manipulation
 */
public class Subsets {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 2ms
     */
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int num : nums) {
            int len = list.size();
            for (int i = 0; i < len; i++) {
                List<Integer> newSet = new ArrayList<>(list.get(i));
                newSet.add(num);
                list.add(newSet);
            }
        }

        return list;
    }
}
