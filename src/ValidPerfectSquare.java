/**
 * https://leetcode.com/problems/valid-perfect-square/
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        long lo = 1;
        long hi = num;

        while (lo <= hi) {
            long mid = (hi + lo) / 2;

            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return false;
    }
}
