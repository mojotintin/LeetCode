/*
 * Created by calabash on 2017/8/17.
 * Problem Number: 309.
 * Problem Name: Best Time to Buy and Sell Stock with Cooldown.
 * Difficulty: Medium.
 * Related Topics: Dynamic Programming.
 * Source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/.
 */

package algorithms.dp;

/**
 * # --------------------------------------------------------------------------
 * # Say you have an array for which the ith element is the price of a given
 * # stock on day i.
 * # Design an algorithm to find the maximum profit. You may complete as many
 * # transactions as you like (ie, buy one and sell one share of the stock
 * # multiple times) with the following restrictions:
 * #   > You may not engage in multiple transactions at the same time (ie,
 * #     you must sell the stock before you buy again).
 * #   > After you sell your stock, you cannot buy stock on next day. (ie,
 * #     cooldown 1 day)
 * #
 * # Example:
 * # prices = [1, 2, 3, 0, 2]
 * # maxProfit = 3
 * # transactions = [buy, sell, cooldown, buy, sell]
 * # --------------------------------------------------------------------------
 */
public class BestTimeToBuyAndSellStockWithCooldown {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 15ms
   */
  public int maxProfit(int[] prices) {
    int preBuy = Integer.MIN_VALUE;
    int preSell = 0;
    int preRest = 0;
    int maxProfile = 0;
    for (int price : prices) {
      int buy = Math.max(preBuy, preRest - price);
      int sell = Math.max(preSell, preBuy + price);
      int rest = Math.max(preRest, preSell);
      maxProfile = Math.max(sell, rest);
      preBuy = buy;
      preSell = sell;
      preRest = rest;
    }
    return maxProfile;
  }
}
