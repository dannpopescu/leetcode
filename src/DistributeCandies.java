import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();

        int maxDistinctCandies = candies.length / 2;

        for (int n : candies) {
            set.add(n);
            if (set.size() >= maxDistinctCandies) {
                return maxDistinctCandies;
            }
        }

        return set.size();
    }
}
