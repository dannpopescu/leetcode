import java.util.Arrays;

public class FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);

        int cnt = 0;

        for (int i = ages.length - 1; i > 0; i--) {
            int j = i - 1;

            while (j >= 0 && ages[j] > ages[i] / 2 + 7) {
                cnt++;
                if (ages[i] == ages[j]) cnt++;
                j--;
            }
        }

        return cnt;
    }
}
