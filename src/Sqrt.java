/**
 * https://leetcode.com/problems/sqrtx/
 */
public class Sqrt {

    public int mySqrt(int x) {
        long lo = 1;
        long hi = x;

        while (lo <= hi) {
            long mid = (lo + hi) >>> 1;

            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return (int) hi;
    }
}
