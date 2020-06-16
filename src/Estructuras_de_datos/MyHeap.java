package Estructuras_de_datos;

import java.io.Serializable;

public class MyHeap<T extends Comparable<T>> implements Serializable {

    private int maxSize;
    private int size;
    private T[] H;

    public MyHeap(int maxSize) {
        maxSize ++;
        this.maxSize = maxSize;
        this.H = (T[]) new Comparable[maxSize];
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

    public T getMax() {
        return H[1];
    }

    public void siftUp(int index) {
        while (index > 1 && H[parent(index)].compareTo(H[index]) < 0) {
            T aux = H[parent(index)];
            H[parent(index)] = H[index];
            H[index] = aux;
            index = parent(index);
        }
    }

    public void siftDown(int index) {
        int maxIndex = index;
        int leftIndex = left(index);
        if (leftIndex <= size && H[leftIndex].compareTo(H[maxIndex]) > 0)
            maxIndex = leftIndex;
        int rightIndex = right(index);
        if (rightIndex <= size && H[rightIndex].compareTo(H[maxIndex]) > 0)
            maxIndex = rightIndex;
        if (index != maxIndex){
            T aux = H[index];
            H[index] = H[maxIndex];
            H[maxIndex] = aux;
            siftDown(maxIndex);
        }
    }

    public void insert(T x) {
        if (size == maxSize)
            throw new RuntimeException("The heap is full");
        else {
            size++;
            H[size] = x;
            siftUp(size);
        }
    }

    public T extractMax() {
        T result = H[1];
        H[1] = H[size];
        size--;
        siftDown(1);
        return result;
    }

    public void remove(int index) {
        H[index] = getMax();
        siftUp(index);
        extractMax();
    }

    public void changePriority(int index, T newPriority) {
        T oldPriority =  H[index];
        H[index] = newPriority;
        if (newPriority.compareTo(oldPriority) > 0)
            siftUp(index);
        else
            siftDown(index);
    }

    public void heapSort(T[] array) {
        int size = array.length;
        MyHeap arrayTree = new MyHeap(size);
        for (int i = 0; i < size; i++)
            arrayTree.insert(array[i]);
        for (int i = size-1; i>=0; i--)
            array[i] = extractMax();
    }

    public MyHeap buildHeap(T[] array) {
        int size = array.length;
        MyHeap heap = new MyHeap(size);
        for (int i = 0; i < size; i++)
            heap.H[i+1] = array[i];
        for (int i = heap.maxSize/2; i >= 1; i--)
            heap.siftDown(i);
        return heap;
    }

    public T[] inPlaceHeapSort(T[] array) {
        MyHeap A = buildHeap(array);
        for (int i = 0; i < array.length - 1; i++){
            T aux = (T) A.H[1];
            A.H[1] = A.H[A.size];
            A.H[A.size] = aux;
            A.size--;
            A.siftDown(1);
        }
        return (T[]) A.H;
    }

    public void levels() {
        for (int i = 1; i <= size; i++) {
            System.out.print(H[i] + " ");
        }
        System.out.println();
    }
}