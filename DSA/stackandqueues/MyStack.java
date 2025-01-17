package DSA.stackandqueues;

import java.util.Objects;

public class MyStack {
    class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
            this.next = null;
        }

        public String toString() {
            return "value: " + value + " , next: " + (Objects.nonNull(next) ? next : "null");
        }
    }

    private Node top;
    private Node bottom;
    private int length;

    MyStack() {
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }

    MyStack push(String value) {
        Node newNode = new Node(value);
        if(length ==0) {
            this.top = newNode;
            this.bottom = newNode;
        } else {
            Node curr = this.top;
            newNode.next = curr;
            this.top = newNode;
        }
        this.length++;
        return this;
    }

    MyStack pop() {
        if(length ==0) {
            this.top = null;
            this.bottom = null;
            return this;
        }
        if(this.top == this.bottom) {
            this.bottom = null;
        }
        Node curr = this.top;
        this.top = curr.next;
        this.length--;
        return this;
    }

    String peek() {
        return this.top.value;
    }


    @Override
    public String toString() {
        return "MyStack{" +
                "top: " + top +
                ", bottom: " + bottom +
                ", length: " + length +
                '}';
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        System.out.println(myStack.push("google"));
        System.out.println(myStack.push("apple"));
        System.out.println(myStack.push("microsoft"));
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}


