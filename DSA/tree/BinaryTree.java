package DSA.tree;

public class BinaryTree {
    class Node{
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value =value;
            this.left =  null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    Node root;
    BinaryTree() {
        this.root = null;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }

    BinaryTree insert(int value) {
        Node newNode = new Node(value);
        if(this.root == null) {
            this.root = newNode;
            return this;
        } else {
            Node curr = this.root;
            while(true) {
                if(value <= curr.value) {
                    //left
                    if(curr.left == null) {
                        curr.left = newNode;
                       return this;
                    } else {
                        curr = curr.left;
                    }
                } else {
                    //right
                    if(curr.right == null) {
                        curr.right = newNode;
                        return this;
                    } else {
                        curr = curr.right;
                    }
                }
            }
        }
    }

    boolean lookup(int key) {
        if(this.root == null) return false;
        Node curr = this.root;
        while(true) {
            if(curr.value == key) {
                return true;
            } else if(key < curr.value) {
                if(curr.left == null) return false;
                else {
                    curr = curr.left;
                }
            } else {
                if(curr.right == null) return false;
                else {
                    curr = curr.right;
                }
            }
        }
    }

    BinaryTree remove(int value) {
        return this;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(9);
        binaryTree.insert(4);
        binaryTree.insert(6);
        binaryTree.insert(20);
        binaryTree.insert(170);
        binaryTree.insert(15);
        binaryTree.insert(1);

        System.out.println(binaryTree);

//        System.out.println(binaryTree.lookup(9));
//        System.out.println(binaryTree.lookup(4));
//        System.out.println(binaryTree.lookup(20));
//        System.out.println(binaryTree.lookup(15));
//        System.out.println(binaryTree.lookup(100));
//        System.out.println(binaryTree.lookup(2));

    }
}
