/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras_de_datos;

import java.io.Serializable;

/**
 * @author FABIa
 */
public class ArrayStack<T> implements Serializable {
    private static final int N = 3;
    private int top;
    private T[] sarray;

    public ArrayStack(int n) {
        top = 0;
        sarray = (T[]) new Object[n];
    }

    public ArrayStack() {
        this(N);
    }

    public boolean empty() {
        return (top <= 0);
    }

    public boolean full() {
        return (top >= sarray.length);
    }

    public T pop() {
        if (empty()) {
            throw new RuntimeException("Nothing to stack, the stack is empty.");
        } else {
            T item = sarray[top-1];
            sarray[top-1] = null;
            top--;
            return item;
        }
    }

    public void push(T item) {
        if (full())
            throw new RuntimeException("The stack is full");
        sarray[top] = item;
        top++;
    }

    public T peek() {
        if (empty())
            return null;
        else
            return sarray[top];
    }


}
