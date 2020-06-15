import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (char p : s.toCharArray()) {
            if (isOpen(p)) {
                stack.push(p);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char lastOpenP = stack.pop();
                if (!areSameType(p, lastOpenP)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public boolean isOpen(char p) {
        return p == '(' || p == '[' || p == '{';
    }

    public boolean areSameType(char p1, char p2) {
        int diff = Math.abs(p1 - p2);
        return diff == 1 || diff == 2;
    }
}
