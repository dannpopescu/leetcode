import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> firstListIndices = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            firstListIndices.put(list1[i], i);
        }

        List<String> output = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {
            if (firstListIndices.containsKey(list2[i])) {
                int sum = firstListIndices.get(list2[i]) + i;

                if (sum == min) {
                    output.add(list2[i]);
                } else if (sum < min) {
                    output.clear();
                    output.add(list2[i]);
                    min = sum;
                }
            }
        }

        return output.toArray(new String[0]);
    }
}
