import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        // Push to q2
        q2.add(x);

        // Add all elements of q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (!q1.isEmpty()) {
            return q1.poll();
        }
        return -1; // or throw exception
    }

    public int top() {
        if (!q1.isEmpty()) {
            return q1.peek();
        }
        return -1; // or throw exception
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
