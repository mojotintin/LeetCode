package algorithms.graph;

import java.util.Stack;

/**
 * Created by Calabash on 2017/7/27.
 * Problem Number: 210
 * Problem Name: Course Schedule II
 * Difficulty: Medium
 * Tags: Depth-first Search, Breadth-first Search, Graph, Topological Sort
 * #---------------------------------------------------------------------------
 * # Description: https://leetcode.com/problems/course-schedule-ii/tabs/description
 * # There are a total of n courses you have to take, labeled from 0 to n - 1.
 * # Some courses may have prerequisites, for example to take course 0 you have
 * # to first take course 1, which is expressed as a pair: [0,1].
 * # Given the total number of courses and a list of prerequisite pairs, return
 * # the ordering of courses you should take to finish all courses.
 * # There may be multiple correct orders, you just need to return one of them.
 * # If it is impossible to finish all courses, return an empty array.
 * #
 * # For example:
 * # 2, [[1,0]]
 * # There are a total of 2 courses to take. To take course 1 you should have
 * # finished course 0. So the correct course order is [0,1].
 * # 4, [[1,0],[2,0],[3,1],[3,2]]
 * # There are a total of 4 courses to take. To take course 3 you should have
 * # finished both courses 1 and 2. Both courses 1 and 2 should be taken after
 * # you finished course 0. So one correct course order is [0,1,2,3]. Another
 * # correct ordering is[0,2,1,3].
 * #
 * # Note:
 * # 1. The input prerequisites is a graph represented by a list of edges, not
 * #    adjacency matrices. Read more about how a graph is represented.
 * # 2. You may assume that there are no duplicate edges in the input
 * #    prerequisites.
 * #---------------------------------------------------------------------------
 */

public class CourseScheduleII {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 49ms
   */
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    boolean[][] graph = new boolean[numCourses][numCourses];
    int[] inDegree = new int[numCourses];
    for (int[] prerequisite : prerequisites) {
      inDegree[prerequisite[0]] += 1;
      graph[prerequisite[1]][prerequisite[0]] = true;
    }
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < inDegree.length; i++) {
      if (inDegree[i] == 0) {
        stack.push(i);
      }
    }
    int[] order = new int[numCourses];
    int count = 0;
    while (!stack.isEmpty()) {
      int node = stack.pop();
      order[count++] = node;
      for (int i = 0; i < numCourses; i++) {
        if (graph[node][i]) {
          inDegree[i] -= 1;
          if (inDegree[i] == 0) {
            stack.push(i);
          }
        }
      }
    }
    if (count == numCourses) {
      return order;
    } else {
      return new int[0];
    }
  }
}
