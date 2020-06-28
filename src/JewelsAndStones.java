import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for (char jewel : J.toCharArray()) {
            jewels.add(jewel);
        }

        int numJewels = 0;
        for (char stone : S.toCharArray()) {
            if (jewels.contains(stone)) {
                numJewels++;
            }
        }

        return numJewels;
    }
}
