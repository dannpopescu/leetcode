import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = arrayToSet(nums1);
        Set<Integer> set2 = arrayToSet(nums2);
        set1.retainAll(set2);

        int[] output = new int[set1.size()];
        int i = 0;
        for (int n : set1) {
            output[i++] = n;
        }

        return output;
    }

    public Set<Integer> arrayToSet(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int n : array) {
            set.add(n);
        }
        return set;
    }
}
