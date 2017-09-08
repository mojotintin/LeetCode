/*
 * Created by calabash on 2017/9/8.
 * Problem Number: 406.
 * Problem Name: Queue Reconstruction by Height.
 * Difficulty: Medium.
 * Related Topics: Greedy.
 * Source: https://leetcode.com/problems/queue-reconstruction-by-height/.
 */

package algorithms.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * # --------------------------------------------------------------------------
 * # Suppose you have a random list of people standing in a queue. Each person
 * # is described by a pair of integers (h, k), where h is the height of the
 * # person and k is the number of people in front of this person who have a
 * # height greater than or equal to h. Write an algorithm to reconstruct the
 * # queue.
 * #
 * # Note:
 * # The number of people is less than 1,100.
 * #
 * # Example
 * # Input:
 * # [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * # Output:
 * # [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * # --------------------------------------------------------------------------
 */
public class QueueReconstructionByHeight {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 93ms
   */
  public int[][] reconstructQueue(int[][] people) {
    int[][] p = new int[people.length][2];
    for (int i = 0; i < people.length; i++) {
      p[i][0] = people[i][0];
      p[i][1] = people[i][1];
    }
    boolean[] used = new boolean[people.length];
    int[][] rePeople = new int[people.length][2];
    int count = 0;
    List<Integer> nextPeople = new ArrayList<>();
    for (int i = 0; i < people.length; i++) {
      if (people[i][1] == 0) {
        nextPeople.add(i);
        used[i] = true;
      }
    }
    while (count < people.length) {
      int h = Integer.MAX_VALUE;
      int index = 0;
      int ri = 0;
      for (int i = 0; i < nextPeople.size(); i++) {
        if (people[nextPeople.get(i)][0] < h) {
          h = people[nextPeople.get(i)][0];
          index = nextPeople.get(i);
          ri = i;
        }
      }
      nextPeople.remove(ri);
      rePeople[count][0] = p[index][0];
      rePeople[count][1] = p[index][1];
      count += 1;
      for (int i = 0; i < people.length; i++) {
        if (!used[i] && people[i][0] <= h) {
          people[i][1] -= 1;
          if (people[i][1] == 0) {
            used[i] = true;
            nextPeople.add(i);
          }
        }
      }
    }
    return rePeople;
  }
}
