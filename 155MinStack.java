// my approach
class MinStack {
    ArrayList<Integer> stack = new ArrayList<>();
    int top;
    int bottom;
    int min;
    public MinStack() {
        top = -1;
        bottom = -1;
        min = 0;
    }

    public void push(int val) {
        stack.add(++top, val);
    }

    public void pop() {
        if (top != bottom) {
            stack.remove(top--);
        }
    }

    public int top() {
        if (top != bottom) {
            return stack.get(top);
        } else {
            return 0;
        }
    }

    public int getMin() {
        int k = top;
        min = stack.get(top);
        while (k != bottom) {
            if (min > stack.get(k))
                min = stack.get(k);
            k--;
        }
        return min;
    }
}