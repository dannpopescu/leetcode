import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> letterIndices = new HashMap<>();

        int maxLength = 0;
        int currentLength = 0;

        for (int index = 0; index < s.length(); index++) {
            char letter = s.charAt(index);
            if (letterIndices.containsKey(letter)) {
                maxLength = Math.max(currentLength, maxLength);
                int prevIndex = letterIndices.get(letter);
                currentLength = Math.min(index - prevIndex, currentLength + 1);
            } else {
                currentLength++;
            }
            letterIndices.put(letter, index);
        }

        return Math.max(currentLength, maxLength);
    }
}
