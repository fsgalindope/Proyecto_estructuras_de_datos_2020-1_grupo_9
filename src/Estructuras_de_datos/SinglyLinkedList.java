package Estructuras_de_datos;

import java.io.Serializable;

public class SinglyLinkedList<T> implements Serializable {

    private SingleNode<T> head;
    private SingleNode<T> tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
    }

    public boolean empty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public T getFront() {
        if (empty())
            return null;
        else
            return head.getItem();
    }

    public T getBack() {
        if (empty())
            return null;
        else
            return tail.getItem();
    }

    public boolean isListed(T item) {
        if (empty())
            return false;
        else {
            boolean isListed = false;
            SingleNode<T> node;
            node = head;
            for (int i = 0; i < size && !isListed; i++) {
                if (node.getItem().equals(item)) {
                    isListed = true;
                } else {
                    node = node.getNext();
                }
            }
            return isListed;
        }
    }

    public void pushFront(T item) {
        SingleNode<T> node = new SingleNode<>(item);
        node.setNext(head);
        head = node;
        if (tail == null)
            tail = node;
        size++;
    }

    public void popFront() {
        if (empty())
            throw new RuntimeException("Nothing to remove, the list is empty.");
        head = head.getNext();
        if (empty()) {
            tail = null;
        }
        size--;
    }

    public void pushBack(T item) {
        SingleNode<T> node = new SingleNode<T>(item);
        if (tail == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    public void popBack() {
        if (empty())
            throw new RuntimeException("Nothing to remove, the list is empty.");
        else {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                SingleNode<T> node;
                node = head;
                while (node.getNext().getNext() != null) {
                    node = node.getNext();
                }
                node.setNext(null);
                tail = node;
            }
            size--;
        }
    }

    public int getIndex(T item) {
        if (empty())
            return -1;
        else {
            int index = -1;
            boolean isListed = false;
            SingleNode<T> node;
            node = head;
            for (int i = 0; i < size && !isListed; i++) {
                if (node.getItem().equals(item)) {
                    index = i;
                    isListed = true;
                } else {
                    node = node.getNext();
                }
            }
            return index;
        }
    }

    public SingleNode<T> getNode(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Invalid index. " +
                    "Current list size: = " + size + ".");
        } else {
            SingleNode<T> node;
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            return node;
        }
    }

    public T getItem(int index) {
        return getNode(index).getItem();
    }

    public void addAfter(SingleNode<T> node, T item) {
        SingleNode<T> node2 = new SingleNode<>(item);
        node2.setNext(node.getNext());
        node.setNext(node2);
        if (tail == node)
            tail = node2;
        size++;
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index. " +
                    "Current list size: = " + size + ".");
        } else {
            if (index == 0) {
                pushFront(item);
            } else if (index == size) {
                pushBack(item);
            } else {
                addAfter(getNode(index - 1), item);
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

    public void removeIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Invalid index. " +
                    "Current list size: = " + size + ".");
        } else {
            if (index == 0) {
                popFront();
            } else if (index == size - 1) {
                popBack();
            } else {
                getNode(index - 1).setNext(getNode(index - 1).getNext().getNext());
                size--;
            }
        }
    }

    public void printList() {
        if (empty()) {
            System.out.println("The list is empty.");
        } else {
            SingleNode<T> node;
            node = head;
            for (int i = 0; i < size; i++) {
                System.out.print(node.getItem() + " ");
                node = node.getNext();
            }
            System.out.println();
        }

    }
}