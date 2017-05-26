package solutions.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/5/18.
 * Problem Number : 119
 * Problem Name : Pascal's Triangle II
 * Description : https://leetcode.com/problems/pascals-triangle-ii/#/description
 * Difficulty : Easy
 * Tags : Array
 */
public class PascalsTriangleII {

    /**
     * Submission : 1
     * Status : Accepted
     * Runtime : 3ms
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        if (rowIndex == 0) return row;
        row.add(1);
        if (rowIndex == 1) return row;

        for (int i = 1; i < rowIndex; i++) {
            for (int j = i; j > 0; j--){
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }

        return row;
    }
}