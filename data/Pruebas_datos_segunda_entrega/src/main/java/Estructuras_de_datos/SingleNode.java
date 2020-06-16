package Estructuras_de_datos;

import java.io.Serializable;

public class SingleNode<T> implements Serializable {

    private T item;
    private SingleNode<T> next;

    public SingleNode() {
        this(null);
    }

    public SingleNode(T item) {
        this.item = item;
        next = null;
    }

    public T getItem() {
        return item;
    }

    public SingleNode<T> getNext() {
        return next;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void setNext(SingleNode<T> next) {
        this.next = next;
    }
}