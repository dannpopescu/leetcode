import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStack {

    private Deque<Integer> stack;
    private Deque<Integer> auxStack;

    /**
     * Initialize your data structure here.
     */
    public ImplementQueueUsingStack() {
        stack = new ArrayDeque<>();
        auxStack = new ArrayDeque<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!stack.isEmpty()) {
            auxStack.push(stack.pop());
        }

        stack.push(x);

        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }
}
