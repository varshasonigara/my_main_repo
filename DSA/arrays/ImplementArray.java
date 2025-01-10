package DSA.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
Static and Dynamic Array
array {
    length:0;
    data:Object[], simplicity lets say int[]
    initialCap: 3
}
i can
add(el)
get(index)
pop()
delete(index)

?? what happens , how to design if i want to grow an array maintian size.
* */
public class ImplementArray {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.add(101);
        myArray.add(102);
        myArray.add(103);
        myArray.delete(1);
        System.out.println(myArray);
    }
}

class MyArray {
    int length;
    int[] data;
    int initialCap;

    @Override
    public String toString() {
        return "MyArray{" +
                "length=" + length +
                ", data=" + Arrays.toString(data) +
                ", initialCap=" + initialCap +
                '}';
    }

    MyArray() {
        this.length =0;
        this.initialCap = 3;
        this.data = new int[this.initialCap];
    }

    int add(int element) {
        this.data[length] = element;
        this.length++;
        return this.length;
    }

    int get(int index) {
        return this.data[index];
    }

    int pop() {
        this.data[length-1] = 0;
        length--;
        return length;
    }

    int delete(int index) {
        // shift all elemnts after index till length-1
        for(int i = index; i<length-1; i++) {
            this.data[i] = this.data[i+1];
        }
        this.data[length-1] =0;
        this.length--;
        return this.length;

    }
}
