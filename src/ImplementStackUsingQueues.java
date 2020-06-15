import java.util.ArrayDeque;
import java.util.Queue;

public class ImplementStackUsingQueues {

    private Queue<Integer> queue;

    public ImplementStackUsingQueues() {
        this.queue = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        Queue<Integer> newQueue = pollFirstNElements(queue.size() - 1);

        int element = queue.poll();
        queue = newQueue;

        return element;
    }

    /**
     * Get the top element.
     */
    public int top() {
        Queue<Integer> newQueue = pollFirstNElements(queue.size() - 1);

        int element = queue.poll();
        newQueue.offer(element);
        queue = newQueue;

        return element;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

    /**
     * Move first n elements from the internal queue to a new queue, and return it.
     */
    private Queue<Integer> pollFirstNElements(int n) {
        Queue<Integer> newQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            newQueue.offer(queue.poll());
        }
        return newQueue;
    }
}
