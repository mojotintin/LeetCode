package solutions.greedy;

/**
 * Created by Calabash on 2017/5/22.
 * Problem Number : 135
 * Problem Name : Candy
 * Description : https://leetcode.com/problems/candy/#/description
 * Difficulty : Hard
 * Tags : Greedy
 */
public class Candy {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 5ms
     */
    public int candy(int[] ratings) {
        if (ratings.length == 1) return 1;
        int[] candys = new int[ratings.length];

        for (int i = 1; i < ratings.length - 1; i++) {
        	if (ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]) {
        		candys[i] = 1;
        	}
        }
        if (ratings[0] <= ratings[1]) {
        	candys[0] = 1;
        }
        if (ratings[ratings.length - 1] <= ratings[ratings.length - 2]) {
        	candys[ratings.length - 1] = 1;
        }

        for (int i = 1; i < ratings.length; i++) {
        	if (ratings[i] > ratings[i - 1]) {
        		candys[i] = candys[i - 1] + 1;
        	}
        }
        int candyNum = candys[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
        	if (ratings[i] > ratings[i + 1]) {
        		candys[i] = Math.max(candys[i + 1] + 1, candys[i]);
        	}
        	candyNum += candys[i];
        }
        return candyNum;
    }
}
