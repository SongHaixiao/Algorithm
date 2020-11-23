/* java code
 *
 * */

 public class GenericArray<T> {

    private T[] data; // generic type array
    private int count; // record the number of element in array

    // constructor with one parameter
    public GenericArray(int capacity) {
        this.data = (T[]) new Object[capacity]; // allocate the memeroy for array and size is capacity
        this.count = 0; // initialization the count as 0
    }

    // constructor without parameter
    // set the capacity as 10 in default
    public GenericArray() {
        this(10); // this() : call current constructor function
    }

    // get the array size
    public int getCapacity() {
        return this.data.length;
    }

    // get the number of elemens in array
    public int getCount() {
        return this.count;
    }

    // determine if array is empty
    public boolean isEmpty() {
        return this.count == 0;
    }

    // change the element of index
    public void set(int index, T e) {
        checkIndex(index); // determine if the index is valid
        this.data[index] = e;
    }

    // get the target data of index
    public T get(int index) {
        checkIndex(index); // determine if the index is valid
        return this.data[index];
    }

    // loop up the target element
    // if find it, return its index
    // otherwise, return -1
    // Time - Complexity : O(n)
    public int find(T e) {
        for (int i = 0; i < this.count; i++) {
            if (this.data[i].equals(e)) { // equals method : determine if the element in array equals to target data
                return i;
            }
        }
        return -1;
    }

    // add data in target index
    // Time - Complexity : O(m + n)
    public void add(int index, T e) {
        checkIndexForAdd(index); // determine if the index is valid
        // if valid, throw exception(in function)
        // otherwise, do add operation

        // determine the array is full
        // if full : expand size to 2 times of original
        // Time - Complexity : O(m)
        if (this.count == this.data.length) {
            resize(2 * this.data.length);
        }

        // moveing elements behind target index backward
        // Time - Complexity : O(n)
        for (int i = this.count - 1; i >= index; i--) {
            this.data[i + 1] = this.data[i];
        }

        this.data[index] = e;
        this.count++;
    }

    // add data in head
    public void addHead(T e) {
        add(0, e);
    }

    // add data in tail
    public void addTail(T e) {
        add(this.count, e);
    }

    // delete data of taget index
    // and return its value
    // Time - Complexity : O(m + n)
    public T remove(int index) {
        checkIndex(index); // determine if the index is valid
        // if valid, throw exception(in function)
        // otherwise, do delete operation

        T ret = this.data[index]; // sotre the value of deleting data

        // moving elements behind target index forward
        // Time - Complexity : O(m)
        for (int i = index + 1; i < this.count; i++) {
            this.data[i - 1] = this.data[i];
        }

        this.count--; // number minus 1
        this.data[this.count] = null; // set the last element as null

        // when the number of elements meet the following conditions
        // reduce the capacity to a half of original size
        // Time - Complexity : O(n)
        if (this.count == this.data.length / 4 && this.data.length / 2 != 0) { // Make the code more Lazy, prevent
                                                                               // complexity shocks, and prevent the
                                                                               // length of the array from being 1,
                                                                               // because 1/2 = 0
            resize(this.data.length / 2);
        }

        return ret;
    }

    // delete data at head
    public T removeHead() {
        return remove(0);
    }

    // delete data at Tail
    public T removeTail() {
        return remove(this.count - 1);
    }

    // delete target element
    public void removeElement(T e) {
        int index = find(e); // get the element's index

        // determine if the index is -1
        // if is -1, the element is not in array
        // else, it is in array and delete it
        if (index != -1) {
            remove(index);
        }
    }

    // change the capacity of array
    // Time - Complexity : O(n)
    private void resize(int capacity) {

        // set a new array with new capacity
        T[] newData = (T[]) new Object[capacity];

        // move the elements from original array data
        // to new array newData
        for (int i = 0; i < this.count; i++) {
            newData[i] = this.data[i];
        }

        // use array data replace replaces newData array
        this.data = newData;
    }

    // index check for add operation
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > this.count) {
            throw new IllegalAccessError("Invalid Index !!! Required index >= 0 and index <= size.");
        }
    }

    // index check for set、 get element and delete operation
    private void checkIndex(int index) {
        if (index < 0 || index >= this.count) {
            throw new IllegalArgumentException("Invalid Index !!! Required index >= 0 and index < size.");
        }
    }

    // print function

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d\n", this.count, this.data.length));
        builder.append('[');
        for (int i = 0; i < this.count; i++) {
            builder.append(this.data[i]);
            if (i != this.count - 1) {
                builder.append(", ");
            }
        }

        builder.append(']');
        return builder.toString();
    }

    // main part
    public static void main(String[] args) {
        GenericArray array = new GenericArray();
        array.addHead(0);
        array.addHead(0);
        array.add(1, 5);
        array.add(3, 9);
        array.add(3, 10);
        array.add(3, 11);
        array.addTail(20);
        System.out.println(array.toString());

        array.removeHead();
        array.removeTail();
        array.removeElement(3);
        array.removeElement(11);
        System.out.println(array.toString());

        array.remove(3);
        System.out.println(array.toString());
    }
}