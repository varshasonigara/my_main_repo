package DSA.stackandqueues;

import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class MyQueue {
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

    Node front;// remove at front
    Node rear; // add at back;
    int length ;
    MyQueue() {
        this.front = null;
        this.rear = null;
        this.length =0;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "front=" + front +
                ", rear=" + rear +
                ", length=" + length +
                '}';
    }

    Node peek() {
        return this.front;
    }
    MyQueue enqueue(String value) {
        Node newNode = new Node(value);
        if(length ==0) {
            this.front = newNode;
            this.rear = newNode;
        } else {
            Node curr = this.rear;
            curr.next = newNode;
            this.rear = newNode;
        }
        this.length++;
        return this;
    }

    MyQueue dequeue() {
        if(this.length ==0) {
            return this;
        }
        if(this.rear == this.front) { // 1 element
            this.rear = null;
            this.front = null;
        } else {
            Node curr = this.front;
            this.front = curr.next;
        }
        this.length--;
        return this;
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.enqueue("google"));
        System.out.println(myQueue.enqueue("microsoft"));
        System.out.println(myQueue.peek());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
    }
}
