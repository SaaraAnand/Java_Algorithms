import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int poppedValue = stack.pop();
            if (poppedValue == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(2);
        minStack.push(7);
        minStack.push(1);
        System.out.println("Minimum element in the stack: " + minStack.getMin()); // Output: -3
        minStack.pop();
        System.out.println("Top element in the stack: " + minStack.top()); // Output: 0
        System.out.println("Minimum element in the stack: " + minStack.getMin()); // Output: -2
    }
}
