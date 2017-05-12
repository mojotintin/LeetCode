package solutions;

/**
 * Created by Calabash on 2017/4/24.
 * The LeetCode 42th
 */
public class TrappingRainWater_42 {

    public int trap(int[] height) {
        int water = 0;
        int[] waterHeight = new int[height.length];
        int curMax = 0;
        for (int i = 0; i < height.length; i ++) {
            if (height[i] >= curMax) {
                curMax = height[i];
                waterHeight[i] = curMax;
            } else {
                waterHeight[i] = curMax;
            }
        }

        curMax = 0;
        for (int i = height.length - 1; i >= 0; i --) {
            if (height[i] >= curMax) {
                curMax = height[i];
                waterHeight[i] = curMax;
            } else {
                waterHeight[i] = Math.min(curMax, waterHeight[i]);
            }
        }
        for (int i = 0; i < height.length; i ++) {
            water += waterHeight[i] - height[i];
        }


        return water;
    }
}
