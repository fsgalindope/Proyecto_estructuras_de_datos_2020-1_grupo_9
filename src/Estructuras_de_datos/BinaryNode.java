package Estructuras_de_datos;

import java.io.Serializable;

public class BinaryNode<T extends Comparable<T>> implements Serializable {

    private T item;
    private BinaryNode<T> parent, left, right;
    private int height = 0;

    public BinaryNode(T item, BinaryNode<T> parent, BinaryNode<T> left, BinaryNode<T> right, int height) {
        this.item = item;
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.height = height;
    }

    public BinaryNode(T item) {
        this.item = item;
        this.left = new BinaryNode<>();
        this.right = new BinaryNode<>();
        this.parent = new BinaryNode<>();
        this.height = 0;
    }

    public BinaryNode() {
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public BinaryNode<T> getParent() {
        return parent;
    }

    public void setParent(BinaryNode<T> parent) {
        this.parent = parent;
    }



    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean hasChild() {
        return (this.left != null || this.right != null);
    }

    public BinaryNode<T> getLargerChild() {
        if (left.getItem().compareTo(right.getItem()) > 0)
            return this.left;
        else
            return this.right;
    }

    public BinaryNode<T> leftDescendant(BinaryNode<T> node) {
        if (node.getLeft().getItem() == null)
            return node;
        else
            return leftDescendant(node.getLeft());
    }

    public BinaryNode<T> rightAncestor(BinaryNode<T> node) {
        if (node.getParent().getItem() != null) {
            if (node.getItem().compareTo(node.getParent().getItem()) < 0)
                return node.getParent();
            else
                return rightAncestor(node.getParent());
        }else
            return node;
    }

    public BinaryNode<T> next(BinaryNode<T> node) {
        if (node.getRight().getItem() != null)
            return leftDescendant(node.getRight());
        else
            return rightAncestor(node);
    }
}