package algorithms.greedy;

/**
 * Created by Calabash on 2017/7/7.
 * Problem Number : 134
 * Problem Name : Gas Station
 * Difficulty : Medium
 * Tags : Greedy
 * Description : https://leetcode.com/problems/gas-station/#/description
 * #-----------------------------------------------------------------------
 * # There are N gas stations along a circular route, where the amount of
 * # gas at station i is gas[i].
 * # You have a car with an unlimited gas tank and it costs cost[i] of gas
 * # to travel from station i to its next station (i+1). You begin the
 * # journey with an empty tank at one of the gas stations.
 * # Return the starting gas station's index if you can travel around the
 * # circuit once, otherwise return -1.
 * # NOTE : The solution is guaranteed to be unique.
 * #-----------------------------------------------------------------------
 */
public class GasStation {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 1ms
   */
  public int canCompleteCircuit_1(int[] gas, int[] cost) {
    int[] rest = new int[gas.length];
    int allGas = 0;
    int allCost = 0;
    // 计算储油总数和耗油总数，以及每段路程储油与耗油的差值.
    for (int i = 0; i < gas.length; i++) {
      rest[i] = gas[i] - cost[i];
      allGas += gas[i];
      allCost += cost[i];
    }
    // 如果储油数量少于耗油数量，肯定无法到达终点，返回 -1.
    if (allGas < allCost) {
      return -1;
    }
    int station = 0;
    int curGas = 0;
    for (int i = 0; i < rest.length; i++) {
      if (curGas + rest[i] >= 0) {
        curGas += rest[i];
      } else {
        curGas = 0;
        station = i + 1;
      }
    }
    return station;
  }

  /**
   * Submission : 1
   * Status: Accepted
   * Runtime : 0ms
   */
  public int canCompleteCircuit_2(int[] gas, int[] cost) {
    int station = 0;
    int tank = 0;
    int diff = 0;
    for (int  i =0; i < gas.length; i++) {
      int k = gas[i] - cost[i];
      diff += k;
      if (tank + k < 0) {
        station = i + 1;
      } else {
        tank += k;
      }
    }
    if (diff < 0) {
      return -1;
    } else {
      return station;
    }
  }
}
