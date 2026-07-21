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
// best approach to get O(1)tc for each function call, 
// but increases sc from O(n) to O(n+n)---- using two stack
class MinStack {
    ArrayList<Integer> stack = new ArrayList<>();
    ArrayList<Integer> mstack = new ArrayList<>();
    int top;
    int bottom;
    int min;
    public MinStack() {
        top = -1;
        bottom = -1;
        min = 0;
    }

    public void push(int val) {
        stack.add(val);
        int cmin;
        if (!mstack.isEmpty()) {
            cmin = mstack.get(top);
        } else {
            cmin = val;
        }
        val = Math.min(cmin, val);
        mstack.add(val);
        top++;
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.remove(top);
            mstack.remove(top);
            top--;
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.get(top);
        } else {
            return 0;
        }
    }

    public int getMin() {
        return mstack.get(top);
    }
}
