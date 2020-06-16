package Estructuras_de_datos;

import java.io.Serializable;

public class BinaryNode implements Serializable {

    private int key;
    private BinaryNode parent;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(int key, BinaryNode parent, BinaryNode left, BinaryNode right) {
        this.key = key;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(int key) {
        this.key = key;
    }

    public BinaryNode() {
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public BinaryNode getParent() {
        return parent;
    }

    public void setParent(BinaryNode parent) {
        this.parent = parent;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
