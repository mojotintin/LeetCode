package solutions.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by calabash on 2017/5/29.
 * Problem Number : 137
 * Problem name : Single Number II
 * Description : https://leetcode.com/problems/single-number-ii/#/description
 * Difficulty : Medium
 * Tags : Bit Manipulation
 */
public class SingleNumberII {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 11ms
   * Note : Hash Table
   */
  public int singleNumber(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        map.replace(num, map.get(num)+1);
      }
      else {
        map.put(num, 1);
      }
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        return entry.getKey();
      }
    }
    return 0;
  }
}
