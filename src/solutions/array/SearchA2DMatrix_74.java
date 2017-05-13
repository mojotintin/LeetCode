package solutions.array;

/**
 * Created by Calabash on 2017/5/13.
 * The LeetCode 74th
 * Description : https://leetcode.com/problems/search-a-2d-matrix/#/description
 * Tags : Array, Binary Search
 */
public class SearchA2DMatrix_74 {

    public boolean searchMatrix(int[][] matrix, int target) {

    	if (matrix.length == 0) return false;
    	if (matrix[0].length == 0) return false;
        int width = matrix[0].length;
        int height = matrix.length;

        int min = 0;
        int max = width * height - 1;
        int mid = (min + max) / 2;
        int x = mid / width;
        int y = mid % width;

        while (max - min > 1) {
        	if (matrix[x][y] < target) {
        		min = mid;
        	} else if (matrix[x][y] > target) {
        		max = mid;
        	} else return true;

        	mid = (min + max) / 2;
        	x = mid / width;
        	y = mid % width;
        }

        return target == matrix[min / width][min % width] || target == matrix[max / width][max % width];
    }
}