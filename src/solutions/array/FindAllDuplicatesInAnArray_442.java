package solutions.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/5/19.
 * LeetCode 442th : Find All Duplicates in an Array
 * Description : https://leetcode.com/problems/find-all-duplicates-in-an-array/#/description
 * Difficulty : Medium
 * Tags : Array
 */
public class FindAllDuplicatesInAnArray_442 {

    /**
     * Status : Accepted
     * Runtime : 17ms
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
        	num = Math.abs(num);
         	if (nums[num - 1] < 0) {
        		list.add(num);
        	} else {
        		nums[num - 1] = - nums[num - 1];
        	}
        }
        return list;
    }
}
