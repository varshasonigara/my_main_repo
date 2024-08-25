package DSA;

public class DoublyLinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;


        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        Node (int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1};
        Node head = convertArrToDLL(arr);
        head = reverseDLL(head);
        printDLL(head);
    }

    private static Node reverseDLL(Node head) {
        if (head == null) return null; // empty
        if(head.next == null) return head; // single
        Node curr = head;
        Node last = null;
        while(curr != null) {
            last = curr.prev;
            curr.prev = curr.next;
            curr.next = last;

            curr = curr.prev;
        }
        return last.prev;
    }

    private static Node insertNodeBeforeValue(Node head, int key) {
        if (head == null) return null;
        Node curr = head;
        while(curr != null) {
            if(curr.data == key) break;
            curr = curr.next;
        }

        // not found case
        if(curr == null) return head;

        if(curr.prev == null) {
            // head node
            Node temp = new Node(10);
            temp.next = curr;
            curr.prev = temp;
            head = temp;
        } else {
            //middle node
            Node temp = new Node(10);
            Node back = curr.prev;

            back.next = temp;
            temp.prev = back;

            temp.next = curr;
            curr.prev = temp;

        }
        return head;
    }

    private static Node deleteNodeByValue(Node head, int key) {
        if (head == null) return null;

        Node temp = head;
        while(temp != null) {
            if(temp.data == key) {
                break;
            }
            temp = temp.next;
        }

        if (temp == null) return head;

        Node prev = temp.prev;
        Node next = temp.next;

        if(prev == null && next == null){
            // one element only
            return null;
        } else if (next == null) {
            //delete tail
            temp.prev.next = null;
            temp.prev = null;
        } else if (prev == null) {
            //delete head
            return deleteHead(head);
        } else {
            // middle el
            // middle element links to be set null
            // before that, rearrange links
            prev.next = next;
            next.prev = prev;

            temp.prev= null;
            temp.next = null;
        }

        return head;
    }

    private static Node deleteHead(Node head) {
        if(head == null) return null;
        Node newHead = head.next;
        newHead.prev = null;
        head.next = null;
        return newHead;
    }

    private static void printDLL(Node head) {
        Node pointer = head;
        while(pointer != null) {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
        System.out.println();
        // traverse back
        Node backPointer = head;
        if (backPointer == null) return;
        // last node is my tail = backpointer
        while(backPointer.next != null) {
            backPointer = backPointer.next;
        }
        // starting from tail to head.prev i.e null
        while(backPointer != null) {
            System.out.print(backPointer.data + " ");
            backPointer = backPointer.prev;
        }

    }

    private static Node convertArrToDLL(int[] arr) {
        // create a new node
        // that node next is null
        // that node prev = prev
        // prev node next = new node
        // move prev = new node
        if (arr == null || arr.length == 0) return null;
        Node head = new Node(arr[0]);
        if (arr.length == 1) return head;

        Node prev = head;
        for (int i =1; i<arr.length; i++) {
            Node temp = new Node(arr[i]);
            prev.next = temp;
            temp.prev = prev;
            prev = temp;
        }
        return head;
    }
}
