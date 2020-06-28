import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> distincts = new HashSet<>();
        for (int n : nums) {
            if (distincts.contains(n)) {
                return true;
            } else {
                distincts.add(n);
            }
        }
        return false;
    }
}
