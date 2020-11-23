// java code

public class Array {

    // int array to sotre the dates
    public int data[];

    // the capacity of array
    private int capacity;

    // the actual numbers of array
    private int count;

    // constructor to define the capacity of array
    public Array(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
        this.count = 0; // in the begining, no elements in the array
    }

    // find the element by index
    public int find(int index) {
        if (index < 0 || index >= this.count) {
            return -1;
        }
        return this.data[index];
    }

    // insert element in target index
    // Time - Complexity : O(n)
    public boolean insert(int index, int value) {

        // no elements in array
        // function is repetitive
        // can omit...

        /*
         * if (index == this.count && this.count == 0) { this.data[index] = value;
         * ++this.count; return true; }
         */

        // capacity of array is full
        if (this.count == this.capacity) {
            System.out.println("Array is full, no free location to insert new element.");
            return false;
        }

        // capacity of array is not full
        // insert new elements into array

        // index is invalid
        // index 0 ~ count -1 : just can insert in the middle of array
        if (index < 0 || index > this.count) {
            System.out.println("Insert Failed !!! Index is invalid！Requires index 0 ~ " + this.count);
            return false;
        }

        // 从插入位置开始，将后面的元素向后移动一位
        // Time - Complexity : O (n)
        for (int i = this.count; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }

        // insert element in target index
        this.data[index] = value;

        // insert a new element, actual number + 1
        this.count++;

        return true;
    }

    // delete target element by index
    // Time - Complexity : O(n)
    public boolean delete(int index) {

        // index is invalid
        // index 0 ~ count - 1 : just can delete the element in the middle of array
        if (index < 0 || index > this.count) {
            System.out.println("Delete Failed !!! Index is invalid！ Require index from 0 ~" + this.count);
            return false;
        }

        // 从删除位置开始，将后面的元素向前移动一位
        for (int i = index + 1; i < this.count; i++) {
            this.data[i - 1] = this.data[i];
        }

        // delete elements in tail
        // function is repetitive, can omit...
        /*
         * int[] arr = new int[this.count - 1];
         *
         * for (int i = 0; i < this.count - 1; i++) { arr[i] = data[i]; }
         *
         * this.data = arr;
         */

        // delete a elemnt from array
        // actual number - 1
        this.count--;
        return true;
    }

    // display
    public void display() {
        for (int i = 0; i < this.count; i++) {
            System.out.print(this.data[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.display();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        // array.insert(3, 11); // Array is full
        array.display();
    }
}