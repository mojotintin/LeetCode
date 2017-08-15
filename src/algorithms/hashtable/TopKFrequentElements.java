/*
 * Created by calabash on 2017/8/15.
 * Problem Number: 347.
 * Problem Name: Top K Frequent Elements.
 * Difficulty: Medium.
 * Related Topics: Hash Table, Heap.
 * Source: https://leetcode.com/problems/top-k-frequent-elements/.
 */

package algorithms.hashtable;

import java.util.*;

/**
 * #---------------------------------------------------------------------------
 * # Given a non-empty array of integers, return the k most frequent elements.
 * #
 * # For example,
 * # Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * #
 * # Note:
 * # > You may assume k is always valid, 1 ? k ? number of unique elements.
 * # > Your algorithm's time complexity must be better than O(n log n), where
 * #   n is the array's size.
 * #---------------------------------------------------------------------------
 */
public class TopKFrequentElements {

  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 114ms
   */
  public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int unique = 0;
    for (int num : nums) {
      if (map.containsKey(num)) {
        map.replace(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
        unique += 1;
      }
    }
    int[][] numsWithFrequency = new int[unique][2];
    int count = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      numsWithFrequency[count][0] = entry.getKey();
      numsWithFrequency[count][1] = entry.getValue();
      count += 1;
    }
    Arrays.sort(numsWithFrequency, (num1, num2) -> num2[1] - num1[1]);
    List<Integer> elements = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      elements.add(numsWithFrequency[i][0]);
    }
    return elements;
  }
}
