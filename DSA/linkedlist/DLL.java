package DSA.linkedlist;

public class DLL {
    Node head;
    Node tail;
    int length;

    DLL(int value) {
        this.head = new Node(value);
        this.length = 1;
        this.tail = this.head;
    }

    @Override
    public String toString() {
        return "DLL{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }

    DLL append(int value) {
        Node newNode = new Node(value);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        this.length++;
        return this;
    }

    DLL insert(int index, int value) {
        // 10 -> 5 -> 9 -> 51
        // Index 2 -> 20
        // 10 -> 5 -> ?
        // back is 5 , front is 9

        Node newNode = new Node(value);
        if (index >= this.length) return this.append(value); // add at end if wrong index
        Node back = this.traverseTo(index - 1);
        // TODO: if (index ==0) return this.prepend(value) // head changes
        // System.out.println(back.value);
        Node front = back.next;

        back.next = newNode;
        newNode.prev = back;
        newNode.next = front;
        front.prev = newNode;

        this.length++;
        return this;
    }

    DLL remove(int index) {
        // O(N) insert and remove
        // TODO: not checked head and tail changes when removing start or end.
        Node back = this.traverseTo(index-1);
        Node toBeDeleted = back.next;
        Node front = toBeDeleted.next;

        back.next = front;
        front.prev = back;
        this.length--;
        // this.traverseInOrder();
        return this;
    }

    private Node traverseTo(int index) {
        int counter = 0;
        Node node = this.head;
        while (counter != index) { // counter < index
            node = node.next;
            counter++;
        }
        return node;
    }

    void traverseInOrder() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    void traverseInReverseOrder() {
        Node currentNode = tail;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.prev;
        }
        System.out.println();
    }


    DLL reverseLinkedList() {
        // input
        //         5 -> 10 -> 9 -> 51 -> null
        // null <- 5 <- 10 <- 9 <- 51

        // output
        //         51 -> 9 -> 10 -> 5 -> null
        // null <- 51 <- 9 <- 10 <- 5

        // with Memory solution -> use a stack and form a new list SP - O(N), TC -> O(2N)

        // reversing links as shown in above daiagram // O(N) and no space

        Node curr = this.head;
        while(curr != null) {
            Node front = curr.next;
            Node back = curr.prev;
            curr.next = back;
            curr.prev = front;
            curr = front;
        }
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        this.traverseInOrder();
        System.out.println(this.head);
        System.out.println(this.tail);
        System.out.println(this.length);
        return this;
    }

    public static void main(String[] args) {
        DLL linkedList = new DLL(10);
        linkedList.append(5);
        linkedList.append(9);
        linkedList.append(51);
        //System.out.println(linkedList);
//        linkedList.insert(2, 20);
//        linkedList.traverseInOrder();
//        linkedList.traverseInReverseOrder();
//        linkedList.remove(3);
//        System.out.println(linkedList.length);
        System.out.println(linkedList.reverseLinkedList());

    }
}

class Node {
    int value;
    Node prev;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node prev, Node next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
