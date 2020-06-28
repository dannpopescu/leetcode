import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/keyboard-row/
 */
public class KeyboardRow {

    public String[] findWords(String[] words) {
        char[][] keyboard = {
                {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
                {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
                {'z', 'x', 'c', 'v', 'b', 'n', 'm'}
        };

        List<String> foundWords = new ArrayList<>();

        for (String word : words) {
            int rowNo = -1;
            for (int i = 0; i < keyboard.length; i++) {
                if (contains(keyboard[i], word.charAt(0))) {
                    rowNo = i;
                    break;
                }
            }

            if (containsAllLetters(keyboard[rowNo], word)) {
                foundWords.add(word);
            }
        }

        return foundWords.toArray(new String[0]);
    }

    public boolean contains(char[] array, char letter) {
        letter = Character.toLowerCase(letter);
        for (char ch : array) {
            if (ch == letter) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAllLetters(char[] array, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!contains(array, word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    static class Solution2 {
        public String[] findWords(String[] words) {
            Set<Character> row1 = Set.of('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p');
            Set<Character> row2 = Set.of('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l');
            Set<Character> row3 = Set.of('z', 'x', 'c', 'v', 'b', 'n', 'm');

            List<String> output = new ArrayList<>();

            for (String word : words) {
                List<Character> chars = stringToList(word);
                if (row1.containsAll(chars) || row2.containsAll(chars) || row3.containsAll(chars)) {
                    output.add(word);
                }
            }

            return output.toArray(new String[0]);
        }

        public List<Character> stringToList(String string) {
            string = string.toLowerCase();
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < string.length(); i++) {
                list.add(string.charAt(i));
            }
            return list;
        }
    }
}
