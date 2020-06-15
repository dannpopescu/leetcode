import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MinStack {

    int topIndex;
    private ArrayList<Integer> elements;
    private Deque<Integer> minIndices;

    // elements:   -2  0  -3  1  5  -5
    // minIndices:  0  0   2  2  2   5

    public MinStack() {
        this.elements = new ArrayList<>();
        this.minIndices = new ArrayDeque<>();
        this.topIndex = -1;
    }

    public void push(int x) {
        elements.add(x);

        if (elements.size() == 1 || x < getMin()) {
            minIndices.push(topIndex + 1);
        } else {
            minIndices.push(minIndices.peek());
        }

        topIndex++;
    }

    public void pop() {
        elements.remove(topIndex--);
        minIndices.pop();
    }

    public int top() {
        return elements.get(topIndex);
    }

    public int getMin() {
        if (minIndices.isEmpty()) {
            throw new IllegalStateException();
        }
        return elements.get(minIndices.peek());
    }
}
