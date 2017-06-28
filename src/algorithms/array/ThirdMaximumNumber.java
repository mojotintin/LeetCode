package algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/6/28.
 * Problem Number : 414
 * Problem Name : Third Maximum Number
 * Description : https://leetcode.com/problems/third-maximum-number/#/description
 * Difficulty : Medium
 * Tags : Array
 */
public class ThirdMaximumNumber {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 9ms
   */
  public int thirdMax(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            helper(list, num);
        }
        if (list.size() < 3) {
            return list.get(0);
        } else {
            return list.get(2);
        }
    }

    private void helper(List<Integer> list, int num) {
        int i;
        for (i = 0; i < list.size(); i++) {
            if (list.get(i) == num) {
                return;
            }
            if (list.get(i) < num) {
                break;
            }
        }
        list.add(i, num);
        if (list.size() > 3) {
            list.remove(3);
        }
    }
}
