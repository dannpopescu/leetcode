public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] a) {
        if (a.length == 0) return 0;

        int slow, fast;
        int max = 0;

        for (slow = 0, fast = 0; fast < a.length; fast++) {
            if (a[fast] == 0) {
                max = Math.max(max, fast - slow);
                slow = fast + 1;
            }
        }

        return Math.max(max, fast - slow);
    }
}
