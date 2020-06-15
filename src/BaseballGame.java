import java.util.ArrayDeque;
import java.util.Deque;

public class BaseballGame {

    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String op : ops) {
            if (isNumeric(op)) {
                stack.push(Integer.parseInt(op));

            } else if (op.equals("+")) {
                int lastPoints = stack.pop();
                int currentPoints = lastPoints + stack.peek();
                stack.push(lastPoints);
                stack.push(currentPoints);

            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);

            } else if (op.equals("C")) {
                stack.pop();
            }
        }

        int sum = 0;
        for (int e : stack) {
            sum += e;
        }

        return sum;
    }

    private boolean isNumeric(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) {
                    return false;
                } else {
                    continue;
                }
            }

            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
