/*
 * Created by calabash on 2017/9/28.
 * Problem Number: 56.
 * Problem Name: Merge Intervals.
 * Difficulty: Medium.
 * Related Topics: Sort.
 * Source: https://leetcode.com/problems/merge-intervals/.
 */

package algorithms.sort;

import algorithms.entities.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * # --------------------------------------------------------------------------
 * # Given a collection of intervals, merge all overlapping intervals.
 * #
 * # For example,
 * # Given [1,3],[2,6],[8,10],[15,18],
 * # return [1,6],[8,10],[15,18].
 * # --------------------------------------------------------------------------
 */
public class MergeIntervals {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 107ms
   */
  public List<Interval> merge(List<Interval> intervals) {
    List<Interval> list = new ArrayList<>();
    if (intervals.size() == 0) {
      return list;
    }
    intervals.sort(Comparator.comparingInt(i2 -> i2.start));
    int start = intervals.get(0).start;
    int end = intervals.get(0).end;
    for (Interval i : intervals) {
      if (i.start > end) {
        list.add(new Interval(start, end));
        start = i.start;
        end = i.end;
      } else if (i.end > end) {
        end = i.end;
      }
    }
    list.add(new Interval(start, end));
    return list;
  }
}
