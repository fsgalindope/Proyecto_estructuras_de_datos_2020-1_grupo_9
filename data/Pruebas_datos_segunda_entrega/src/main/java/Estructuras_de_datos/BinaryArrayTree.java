package Estructuras_de_datos;

import java.io.Serializable;

public class BinaryArrayTree<T extends Comparable<T>> implements Serializable {

    private int maxSize;
    private int size;
    private T[] array;

    public BinaryArrayTree(int maxSize) {
        maxSize ++;
        this.maxSize = maxSize;
        this.array = (T[]) new Comparable[maxSize];
        this.size = 0;
    }

    public int parent(int index){
        return index/2;
    }

    public int left(int index) {
        return 2*index;
    }

    public int right(int index) {
        return (2*index) + 1;
    }

    public void insert(T x) {
        if (size == maxSize)
            throw new RuntimeException("The heap is full");
        else {
            size++;
            array[size] = x;
        }
    }

    public boolean contains(T item, int index) {
        if (array[index].compareTo(item) == 0)
            return true;
        else {
            if (item.compareTo(array[index]) < 0)
                return contains(item, left(index));
            if (item.compareTo(array[index]) > 0)
                return contains(item, right(index));
        }
        return true;
    }

    public boolean contains(T item) {
        return contains(item, 1);
    }

    public int find(T item, int index) {
        if (array[index].compareTo(item) > 0) {
            if (left(index) <= size && array[left(index)] != null)
                return find(item, left(index));
        } else {
            if (array[index].compareTo(item) < 0) {
                if (right(index) <= size && array[right(index)] != null)
                    return find(item, right(index));
            }
        }
        return index;
    }

    public int find(T item) {
        return find(item, 1);
    }

    public int height(int index) {
        if (array[index] == null)
            return 0;
        else
            return 1 + Math.max(height(left(index)), height(right(index)));
    }
    
    public MyArrayList inOrderList(MyArrayList<T> list, int index) {
        if (index < size) {
            if (array[index] != null) {           
                inOrderList(list, left(index));
                list.pushBack(array[index]);
                inOrderList(list, right(index));
            }
        }
        return list;
    }
    
    public MyArrayList<T> inOrderList(int index) {
        MyArrayList<T> list = new MyArrayList<>();
        return inOrderList(list, index);
    }
    
    public MyArrayList<T> inOrderList() {
        MyArrayList<T> list = new MyArrayList<>();
        return inOrderList(list, 1);
    }

    public void levels() {
        for (int i = 1; i <= size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
