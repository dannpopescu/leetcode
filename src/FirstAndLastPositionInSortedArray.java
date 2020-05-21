/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FirstAndLastPositionInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int lo1 = 0;
        int hi1 = nums.length - 1;
        while (lo1 <= hi1) {
            int mid = (lo1 + hi1) >>> 1;

            if (nums[mid] >= target) {
                hi1 = mid - 1;
            } else {
                lo1 = mid + 1;
            }
        }

        int lo2 = 0;
        int hi2 = nums.length - 1;
        while (lo2 <= hi2) {
            int mid = (lo2 + hi2) >>> 1;

            if (nums[mid] <= target) {
                lo2 = mid + 1;
            } else {
                hi2 = mid - 1;
            }
        }

        if (lo1 > hi2) {
            return new int[]{-1, -1};
        } else {
            return new int[]{lo1, hi2};
        }
    }
}
