/*
 * Created by calabash on 2017/8/17.
 * Problem Number: 322.
 * Problem Name: Coin Change.
 * Difficulty: Medium.
 * Related Topics: Dynamic Programming.
 * Source: https://leetcode.com/problems/coin-change/.
 */

package algorithms.dp;

import java.util.Arrays;

/**
 * # --------------------------------------------------------------------------
 * # You are given coins of different denominations and a total amount of money
 * # amount. Write a function to compute the fewest number of coins that you
 * # need to make up that amount. If that amount of money cannot be made up by
 * # any combination of the coins, return -1.
 * #
 * # Example 1:
 * # coins = [1, 2, 5], amount = 11
 * # return 3 (11 = 5 + 5 + 1)
 * #
 * # Example 2:
 * # coins = [2], amount = 3
 * # return -1.
 * #
 * # Note:
 * # You may assume that you have an infinite number of each kind of coin.
 * # --------------------------------------------------------------------------
 */
public class CoinChange {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 27ms
   */
  public int coinChange(int[] coins, int amount) {
    // new an array to store all the number of coins from amount 0 to amount
    int[] numbers = new int[amount + 1];
    Arrays.fill(numbers, Integer.MAX_VALUE);
    numbers[0] = 0;
    // sort the coins array
    Arrays.sort(coins);
    // for every amount, find the fewest number of coins
    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (coin > i) {
          break;
        }
        // if we have the number of amount(i - coin)
        // the number of amount(i) = the number amount(i - coin) + 1
        // find the minimal one 
        if (numbers[i - coin] != Integer.MAX_VALUE) {
          numbers[i] = Math.min(numbers[i], numbers[i - coin] + 1);
        }
      }
    }
    return numbers[amount] == Integer.MAX_VALUE ? -1 : numbers[amount];
  }
}
