public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] frequencies = new int[128];

        for (int i = 0; i < s.length(); i++) {
            frequencies[s.charAt(i)]++;
        }

        int halfLength = 0;

        for (int frequency : frequencies) {
            halfLength += frequency >> 1;
        }

        return (halfLength * 2 < s.length())
                ? halfLength * 2 + 1
                : halfLength * 2;
    }
}
