package Estructuras_de_datos;

import java.io.Serializable;

public class ArrayQueue<T> implements Serializable{

    private int capacity = 10;
    private int head, tail, size;
    private T[] qarray;

    public ArrayQueue(){
        head = tail = size = 0;
        qarray = (T[]) new Object[capacity];
    }

    public boolean empty(){
        return size <= 0;
    }

    public boolean full(){
        return size >= capacity;
    }

    public int getSize() {
        return size;
    }

    public void enqueue(T item){
        if (full()) {
            T[] newQarray = (T[]) new Object[capacity * 2];
            int count = 0;
            if (head > tail) {
                for (int i = head; i < capacity; i++) {
                    newQarray[count] = qarray[i];
                    count++;
                }
                for (int i = 0; i <= tail; i++){
                    newQarray[count] = qarray[i];
                    count++;
                }
            } else {
                for (int i = head; i <= tail; i++){
                    newQarray[count] = qarray[i];
                    count++;
                }
            }
            head = 0;
            tail = capacity - 1;
            capacity = capacity * 2;
            qarray = newQarray;
        }
        tail = (tail + 1) % capacity;
        qarray[tail] = item;
        size++;
    }

    public T dequeue(){
        if (empty())
            throw new RuntimeException("Nothing to dequeue, the queue is empty.");
        else {
            T item = qarray[head];
            qarray[head] = null;
            head = (head + 1) % capacity;
            size--;
            return item;
        }
    }

    public T getHead(){
        if (empty())
            return null;
        else
            return qarray[head];
    }

    public T getTail(){
        if (empty())
            return null;
        else
            return qarray[tail];
    }
}