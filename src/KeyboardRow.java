import java.util.ArrayList;
import java.util.List;

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
}
