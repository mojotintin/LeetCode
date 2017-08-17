/*
 * Created by calabash on 2017/8/17.
 * Problem Number: 373.
 * Problem Name: Find K Pairs with Smallest Sums.
 * Difficulty: Medium.
 * Related Topics: Heap.
 * Source: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/.
 */

package algorithms.heap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * # --------------------------------------------------------------------------
 * # You are given two integer arrays nums1 and nums2 sorted in ascending order
 * # and an integer k.
 * # Define a pair (u,v) which consists of one element from the first array and
 * # one element from the second array.
 * # Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * #
 * # Example 1:
 * # Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 * # Return: [1,2],[1,4],[1,6]
 * # The first 3 pairs are returned from the sequence:
 * # [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * #
 * # Example 2:
 * # Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 * # Return: [1,1],[1,1]
 * # The first 2 pairs are returned from the sequence:
 * # [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * #
 * # Example 3:
 * # Given nums1 = [1,2], nums2 = [3],  k = 3
 * # Return: [1,3],[2,3]
 * # All possible pairs are returned from the sequence:
 * # [1,3],[2,3]
 * # --------------------------------------------------------------------------
 */
public class FindKPairswithSmallestSums {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 33ms
   */
  public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<int[]> pairs = new LinkedList<>();
    // if nums1 or nums2 is empty, the pairs is empty.
    if (nums1.length == 0 || nums2.length == 0) {
      return pairs;
    }
    // record the in-degree of every pair,
    // for example, [0, 0] -> [0, 1] && [1, 0],
    // the structure is a heap.
    int[][] inDegrees = new int[nums1.length][nums2.length];
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        if (i == 0 || j == 0) {
          inDegrees[i][j] = 1;
        } else {
          inDegrees[i][j] = 2;
        }
      }
    }
    // record all the possible pairs of next smallest sum,
    List<int[]> nexts = new ArrayList<>();
    nexts.add(new int[]{0, 0});
    inDegrees[0][0] = 0;
    for (int i = 0; i < k; i++) {
      if (nexts.size() == 0) {
        break;
      }
      // find the smallest sum in all possible next pairs
      // delete it after it added into answer.
      int minValue = Integer.MAX_VALUE;
      int nextIndex = 0;
      for (int j = 0; j < nexts.size(); j++) {
        if (nums1[nexts.get(j)[0]] + nums2[nexts.get(j)[1]] < minValue) {
          minValue = nums1[nexts.get(j)[0]] + nums2[nexts.get(j)[1]];
          nextIndex = j;
        }
      }
      int nexti = nexts.get(nextIndex)[0];
      int nextj = nexts.get(nextIndex)[1];
      nexts.remove(nextIndex);
      pairs.add(new int[]{nums1[nexti], nums2[nextj]});
      // when a pair's in-degree is 0, it's possible be the next pair.
      if (nexti + 1 < nums1.length) {
        inDegrees[nexti + 1][nextj] -= 1;
        if (inDegrees[nexti + 1][nextj] == 0) {
          nexts.add(new int[]{nexti + 1, nextj});
        }
      }
      if (nextj + 1 < nums2.length) {
        inDegrees[nexti][nextj + 1] -= 1;
        if (inDegrees[nexti][nextj + 1] == 0) {
          nexts.add(new int[]{nexti, nextj + 1});
        }
      }
    }
    return pairs;
  }
}
