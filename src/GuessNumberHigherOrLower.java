/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */
public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        int mid;

        while (true) {
            mid = (lo + hi) >>> 1;
            int guess = guess(mid);

            if (guess == 0) {
                break;
            } else if (guess == 1) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return mid;
    }

    /**
     * Written just for compile. The method isn't available on Leetcode.
     */
    public int guess(int num) {
        return -1;
    }
}
