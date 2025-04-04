package DSA.hashtables;

public class MyHashTable {

    // Hashtable is a key value pair table
    // dynamic array of initial cap containing of objects(key, value)
    // [{k1:v1}, {k2:v2}, ...]
    // collision case can be array of linkedlists of objects
    // [{k1:v1}->{k3:v3}, {k2:v2}, ....]

    int size;
    MyObject[] table;

    class MyObject {
        int key;
        int value;
    }

    int hash(int key) {
        return key % size;
    }

    void put(int key, int value) {

    }

    int get(int key) {
        return 0;
    }



    public static void main(String[] args) {

    }
}
