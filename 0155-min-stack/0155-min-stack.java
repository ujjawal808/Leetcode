class MinStack {

    Stack<Integer> s;
    Stack<Integer> min;

    public MinStack() {
        s = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {

        s.push(val);

        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }
    }

    public void pop() {

        if (s.peek().equals(min.peek())) {
            min.pop();
        }

        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min.peek();
    }
}