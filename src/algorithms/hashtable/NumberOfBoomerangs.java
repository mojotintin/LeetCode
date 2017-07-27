package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Calabash on 2017/7/27.
 * Problem Number: 447
 * Problem Name: Number of Boomerangs
 * Difficulty : Easy
 * Tags: Hash Table
 * #---------------------------------------------------------------------------
 * # Description: https://leetcode.com/problems/number-of-boomerangs/tabs/description
 * # Given n points in the plane that are all pairwise distinct, a "boomerang"
 * # is a tuple of points (i, j, k) such that the distance between i and j
 * # equals the distance between i and k (the order of the tuple matters).
 * # Find the number of boomerangs. You may assume that n will be at most 500
 * # and coordinates of points are all in the range [-10000, 10000] (inclusive).
 * #
 * # Example:
 * # Input:
 * # [[0,0],[1,0],[2,0]]
 * # Output:
 * # 2
 * # Explanation:
 * # The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 * #---------------------------------------------------------------------------
 */

public class NumberOfBoomerangs {

  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 274ms
   */
  public int numberOfBoomerangs(int[][] points) {
    int boomerangs = 0;
    for (int[] point : points) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int[] point1 : points) {
        int distance = (point[0] - point1[0]) * (point[0] - point1[0]) +
            (point[1] - point1[1]) * (point[1] - point1[1]);
        if (map.containsKey(distance)) {
          map.put(distance, map.get(distance) + 1);
        } else {
          map.put(distance, 1);
        }
      }
      for (Integer key : map.keySet()) {
        if (map.get(key) > 1) {
          boomerangs += map.get(key) * (map.get(key) - 1);
        }
      }
    }
    return boomerangs;
  }
}
