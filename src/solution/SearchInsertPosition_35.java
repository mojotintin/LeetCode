package solution;

/**
 * Created by Calabash on 2017/5/4.
 *
 */
public class SearchInsertPosition_35 {

    public int searchInsert(int[] nums, int target) {

        if (nums.length == 0) return 0;

        int min = 0, max = nums.length - 1, mid = (min + max) / 2;

        while (max - min > 1) {
            System.out.println(mid);
            if (nums[mid] > target) {
                max = mid;
                mid = (min + max) / 2;
            }
            else if (nums[mid] < target){
                min = mid;
                mid = (min + max) / 2;
            } else return mid;
        }

        if (nums[max] < target) return max + 1;
        else if (nums[min] >= target) return min;
        else return min + 1;
    }
}
