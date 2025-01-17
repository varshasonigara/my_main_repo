package DSA.stackandqueues;
import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueUsingStack() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void push(int x) {
        
    }

    public int pop() {
        this.s2.push(this.s1.pop());
        return 0;
    }

    public int peek() {
        return 0;
    }

    public boolean empty() {
        return this.s1.isEmpty();
    }


    public static void main(String[] args) {
        QueueUsingStack obj = new QueueUsingStack();
        obj.push(1);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}
