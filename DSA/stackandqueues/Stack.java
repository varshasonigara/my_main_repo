package DSA.stackandqueues;

import java.util.ArrayList;


public class Stack {
    private ArrayList<Integer> arr;

    Stack() {
        arr = new ArrayList<>();
    }

    @Override
    public String toString() {
        return arr.toString();
    }

    Stack push(int el) {
        arr.add(el);
        return this;
    }

    Stack pop() {
        if (arr.size() == 0) return null;
        arr.remove(arr.size() - 1);
        return this;
    }

    int peek() {
        if (arr.size() == 0) return -1;
        return arr.get(arr.size() - 1);
    }

    boolean isEmpty() {
        return arr.isEmpty();
    }

    public static void main(String args[]) {
        Stack stack = new Stack();
        System.out.println(stack.isEmpty());
        System.out.println(stack.push(1));
        System.out.println(stack.push(2));
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());

    }

}
