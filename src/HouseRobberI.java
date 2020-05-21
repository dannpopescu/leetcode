/**
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobberI {

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int maxTwoHousesBefore = nums[0];
        int maxOneHouseBefore = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int crtMax = Math.max(maxTwoHousesBefore + nums[i], maxOneHouseBefore);
            maxTwoHousesBefore = maxOneHouseBefore;
            maxOneHouseBefore = crtMax;
        }

        return maxOneHouseBefore;
    }
}
