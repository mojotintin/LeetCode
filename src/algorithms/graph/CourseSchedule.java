package algorithms.graph;

import java.util.Stack;

/**
 * Created by Calabash on 2017/7/26.
 * Problem Number : 207
 * Problem Name : Course Schedule
 * Difficulty : Medium
 * Tags : Depth-first Search, Breadth-first Search, Graph, Topological Sort
 * #---------------------------------------------------------------------------
 * # Description : https://leetcode.com/problems/course-schedule/#/description
 * # There are a total of n courses you have to take, labeled from 0 to n - 1.
 * # Some courses may have prerequisites, for example to take course 0 you have
 * # to first take course 1, which is expressed as a pair: [0,1]
 * # Given the total number of courses and a list of prerequisite pairs, is it
 * # possible for you to finish all courses?
 * #
 * # For example:
 * # 2, [[1,0]]
 * # There are a total of 2 courses to take. To take course 1 you should have
 * # finished course 0. So it is possible.
 * # 2, [[1,0],[0,1]]
 * # There are a total of 2 courses to take. To take course 1 you should have
 * # finished course 0, and to take course 0 you should also have finished
 * # course 1. So it is impossible.
 * #
 * # Note:
 * # 1. The input prerequisites is a graph represented by a list of edges, not
 * #    adjacency matrices. Read more about how a graph is represented.
 * # 2. You may assume that there are no duplicate edges in the input
 * #    prerequisites.
 * #---------------------------------------------------------------------------
 */

public class CourseSchedule {

  /**
   * Submission: 1
   * Status：Accepted
   * Runtime: 52ms
   * Algorithm: Topological Sort
   */
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    boolean[][] graph = new boolean[numCourses][numCourses];
    int[] inDegree = new int[numCourses];
    for (int[] prerequisite : prerequisites) {
      inDegree[prerequisite[1]] += 1;
      graph[prerequisite[0]][prerequisite[1]] = true;
    }
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < inDegree.length; i++) {
      if (inDegree[i] == 0) {
        stack.push(i);
      }
    }
    int count = 0;
    while (!stack.isEmpty()) {
      int node = stack.pop();
      count += 1;
      for (int i = 0; i < numCourses; i++) {
        if (graph[node][i]) {
          inDegree[i] -= 1;
          if (inDegree[i] == 0) {
            stack.push(i);
          }
        }
      }
    }
    return count == numCourses;
  }
}
