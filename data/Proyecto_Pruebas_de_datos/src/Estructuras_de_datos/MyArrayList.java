package Estructuras_de_datos;

import java.io.Serializable;

public class MyArrayList<T> implements Serializable{

    private int capacity = 10;
    private int size;
    private T[] listArray;

    public MyArrayList() {
        size = 0;
        listArray = (T[]) new Object[capacity];
    }

    public boolean empty() {
        return size <= 0;
    }

    public boolean full(){
        return size >= capacity;
    }

    public int getSize() {
        return size;
    }

    public boolean isListed (T item) {
        if (empty())
            return false;
        else {
            boolean isListed = false;
            for (int i = 0; i<size && !isListed; i++)
                isListed = listArray[i] == item;
            return isListed;
        }
    }

    public void pushFront(T item) {
        if (full()){
            T[] newListArray = (T[]) new Object[capacity*2];
            for (int i = 0; i < capacity; i++){
                newListArray[i+1] = listArray[i];
            }
            capacity = capacity * 2;
            listArray = newListArray;
        } else {
            for (int i = size; i > 0; i--){
                listArray[i] = listArray[i-1];
            }
        }
        listArray[0] = item;
        size++;
    }

    public void popFront() {
        if (empty())
            throw new RuntimeException("Nothing to remove, the list is empty.");
        for (int i = 0; i < size-1; i++){
            listArray[i] = listArray[i+1];
        }
        listArray[size-1] = null;
        size--;
    }

    public void pushBack(T item) {
        if (full()){
            T[] newListArray = (T[]) new Object[capacity*2];
            for (int i = 0; i < capacity; i++){
                newListArray[i] = listArray[i];
            }
            capacity = capacity * 2;
            listArray = newListArray;
        }
        listArray[size] = item;
        size++;
    }

    public void popBack() {
        if (empty())
            throw new RuntimeException("Nothing to remove, the list is empty.");
        listArray[size-1] = null;
        size--;
    }

    public int getIndex(T item) {
        if (empty())
            return -1;
        else {
            int index = -1;
            boolean isListed = false;
            for (int i = 0; i<size && !isListed; i++) {
                if (listArray[i] == item) {
                    index = i;
                    isListed = true;
                }
            }
            return index;
        }
    }

    public T getItem(int index) {
        if (index < 0 || index > size-1)
            throw new IndexOutOfBoundsException("Invalid index. " +
                    "Current list size: = " + size + ".");
        return listArray[index];
    }

    public void add(int index, T item) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Invalid index. " +
                    "Current list size: = " + size + ".");
        } else {
            if (index == 0) {
                pushFront(item);
            } else if (index == size) {
                pushBack(item);
            } else {
                if (full()){
                    T[] newListArray = (T[]) new Object[capacity*2];
                    for (int i = 0; i < index; i++){
                        newListArray[i] = listArray[i];
                    }
                    for (int i = index; i < capacity; i++){
                        newListArray[i+1] = listArray[i];
                    }
                    capacity = capacity * 2;
                    listArray = newListArray;
                } else {
                    for (int i = size; i > index; i--) {
                        listArray[i] = listArray[i - 1];
                    }
                }
                listArray[index] = item;
                size++;
            }
        }
    }

    public void removeIndex(int index) {
        if (index < 0 || index > size-1){
            throw new IndexOutOfBoundsException("Invalid index. " +
                    "Current list size: = " + size + ".");
        } else {
            if (index == 0) {
                popFront();
            } else if (index == size-1) {
                popBack();
            } else {
                for (int i = index; i < size; i++) {
                    listArray[i] = listArray[i+1];
                }
                listArray[size-1] = null;
                size--;
            }
        }
    }

    public void removeItem(T item) {
        if (empty())
            throw new RuntimeException("Nothing to remove, the list is empty.");
        else {
            int index = getIndex(item);
            removeIndex(index);
        }
    }

    public void printList() {
        if (empty()) {
            System.out.println("The list is empty.");
        }else {
            for (int i = 0; i < size; i++) {
                System.out.print(listArray[i] + " ");
            }
            System.out.println();
            System.out.println("Size: " + getSize() + " Capacity: " + capacity + ".");
        }
    }

}
