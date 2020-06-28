import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> firstArrayFreq = new HashMap<>();
        List<Integer> output = new ArrayList<>();

        for (int n : nums1) {
            firstArrayFreq.put(n, firstArrayFreq.getOrDefault(n, 0) + 1);
        }

        for (int n : nums2) {
            if (firstArrayFreq.containsKey(n) && firstArrayFreq.get(n) > 0) {
                output.add(n);
                firstArrayFreq.put(n, firstArrayFreq.get(n) - 1);
            }
        }

        return listOfIntegerToArray(output);
    }

    public int[] listOfIntegerToArray(List<Integer> listOfInteger) {
        int[] array = new int[listOfInteger.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = listOfInteger.get(i);
        }

        return array;
    }
}
