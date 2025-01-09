package DSA;

import java.util.ArrayList;

public class Stack {
    //static int capacity = 100;
    int top;
    //int arr[] = new int[capacity];
    ArrayList<Integer> arr = new ArrayList<>();

    Stack(){
        top=-1;
    }

    int push(int el) {
        //if(top ==capacity-1) return -1;
        top++;
        arr.add(top, el);
        return arr.get(top);
    }

    int pop() {
        if(top ==-1) return -1;
        int el = arr.get(top);
        top--;
        return el;
    }

    int peek() {
        if (top ==-1) return -1;
        return arr.get(top);
    }

    boolean isEmpty() {
        return top ==-1;
    }

    public static void main(String args[]) {
        Stack stack = new Stack();
        System.out.println(stack.isEmpty());
        System.out.println( stack.push(1));
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
