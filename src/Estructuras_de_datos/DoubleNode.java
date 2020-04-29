package Estructuras_de_datos;

import java.io.Serializable;

public class DoubleNode<T> implements Serializable {

    private T item;
    private DoubleNode<T> next;
    private DoubleNode<T> prev;

    public DoubleNode() {
        this(null);
    }

    public DoubleNode(T item) {
        this.item = item;
        next = null;
        prev = null;
    }

    public T getItem() {
        return item;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public DoubleNode<T> getPrev() {
        return prev;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }
}
