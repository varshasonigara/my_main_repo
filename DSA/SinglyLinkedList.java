package DSA;

public class SinglyLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node (int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        Node head = convertArrToLinkedList(arr);
        printLL(head);
    }

    private static Node insertNodeBeforeValue(Node head, int newValue, int value) {
        // If traversing required - O(N) for traversing but insertion is O(1)
        if(head == null) return null;
        if(head.data == value) {
            head = new Node(newValue, head);
            return head;
        }
        Node curr = head.next;
        Node prev = head;

        while(curr != null) {
            if(curr.data == value) {
                Node temp = new Node(newValue, curr);
                prev.next = temp;
            }
            prev = curr;
            curr = curr.next;
        }
        return  head;
    }

    private static Node deleteNode(Node head, Node node) {
        // Deleting head O(1)
        // Deleting worst case O(N) traversal, delete O(1)
        if (head == null) return null;
        if (node == null) return head;
        if (node.data == head.data) return deleteHead(head);
        Node temp = head.next;
        Node prev = head;
        while(temp != null) {
            if(temp.data == node.data) {
                prev.next = temp.next;
                temp.next = null;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node deleteElementAtPositionK(Node head, int position) {
        // Deleting head O(1)
        // Deleting worst case O(N) traversal, delete O(1)
        if (head == null) return null;
        if (position == 1) return deleteHead(head);
        int i = 1;
        Node temp = head.next;
        Node prev = head;
        while(temp != null) {
            i++;
            if(i == position) {
                prev.next = temp.next;
                temp.next = null;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node deleteTail(Node head) {
        // best case = constant
        // worst case = O(N)
        if(head == null || head.next == null) return null;
        Node curr = head;
        while(curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    private static Node deleteHead(Node head) {
        // O(1)
        if(head == null) return null;
        Node newHead = head.next;
        head.next = null;
        return newHead;
    }

    private static int sizeOfLL(Node head) {
        // O(n)
        int counter =0;
        while(head != null) {
            counter++;
            head = head.next;
        }
        return counter;
    }

    private static boolean searchElementInLL(Node head, int key) {
        // best case head is the key omega(1)
        // worst case tail is key or not found O(N), where N is size
        // average case theta(N/2)
        boolean found = false;
        while(head != null) {
            if (head.data == key) {
                found = true;
                break;
            }
            head = head.next;
        }
        return found;
    }

    private static void printLL(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    private static Node convertArrToLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        Node head = new Node(arr[0]);
        if (arr.length == 1) return head;

        Node temp = head;
        for (int i =1; i<arr.length; i++) {
            temp.next= new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }
}
