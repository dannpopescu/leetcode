import java.util.Arrays;

public class FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);

        int total = 0;               // total number of requests
        int count = 0;               // number of requests for the last distinct age
        int sameAgeCounter = 1;      // number of people that have the last age

        for (int i = 1; i < ages.length; i++) {

            if (ages[i] == ages[i - 1]) {
                sameAgeCounter++;
            } else {
                // people of the same age will friend request each other only if
                // the first condition is false
                long sameAgeRequests = (ages[i - 1] > ages[i - 1] * 0.5 + 7)
                        ? permutation(sameAgeCounter, 2)
                        : 0;

                // add the number of friend requests to people of different ages
                // plus the number of requests to the people of the same age
                total += count * sameAgeCounter + sameAgeRequests;

                // number of friend requests that people of the current age will
                // send to people of DIFFERENT ages
                count = binarySearchFriendRequests(ages, i);

                sameAgeCounter = 1;
            }
        }
        total += count * sameAgeCounter + permutation(sameAgeCounter, 2);
        return total;
    }


    /**
     * Search the number of request using a binary search
     */
    public int binarySearchFriendRequests(int[] ages, int i) {
        int lo = 0;
        int hi = i - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;

            if (ages[mid] > ages[i] * 0.5 + 7) hi = mid - 1;
            else                              lo = mid + 1;
        }
        return i - lo;
    }

    /**
     * Compute the number of permutations of n objects taken r at a time
     */
    public long permutation(int n, int r) {
        long result = 1;
        for (int i = n; i > n - r; i--) {
            result *= i;
        }
        return result;
    }
}
