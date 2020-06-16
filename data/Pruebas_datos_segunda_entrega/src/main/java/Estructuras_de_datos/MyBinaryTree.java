package Estructuras_de_datos;

import java.io.Serializable;

public class MyBinaryTree implements Serializable {

    private BinaryNode root;

    public MyBinaryTree() {
        root = null;
    }

    public MyBinaryTree(BinaryNode root) {
        this.root = root;
    }

    public BinaryNode root(){
        return root;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(int x) {
        return contains(x, root);
    }

    public boolean contains(int x, BinaryNode root) {
        if (root == null)
            return false;
        if (x < root.getKey())
            return contains(x, root.getLeft());
        else if (x > root.getKey())
            return contains(x, root.getRight());
        else
            return true;
    }

    public int findMin() {
        if (isEmpty())
            throw new RuntimeException("The tree is empty");
        else
            return findMin(this.root).getKey();
    }

    public BinaryNode findMin(BinaryNode node) {
        if (node == null)
            return null;
        else if (node.getLeft() == null)
            return node;
        return findMin(node.getLeft());
    }

    public int findMax() {
        if (isEmpty())
            throw new RuntimeException("The tree is empty");
        else
            return findMax(this.root).getKey();
    }

    public BinaryNode findMax(BinaryNode node) {
        if (node == null)
            return null;
        else if (node.getRight() == null)
            return node;
        return findMax(node.getRight());
    }

    public int size(){
        return size(root);
    }

    public int size(BinaryNode node) {
        if (node == null)
            return 0;
        else
            return 1 + size(node.getLeft()) + size(node.getRight());
    }

    public BinaryNode find(int k) {
        return find(k, root);
    }

    public BinaryNode find(int k, BinaryNode root) {
        if (root.getKey() > k) {
            if (root.getLeft() != null)
                return find(k, root.getLeft());
        } else {
            if (root.getRight() != null)
                return find(k, root.getRight());
        }
        return root;
    }

    public BinaryNode leftDescendant(BinaryNode node) {
        if (node.getLeft() == null)
            return node;
        else
            return leftDescendant(node.getLeft());
    }

    public BinaryNode rightAncestor(BinaryNode node) {
        if (node.getKey() < node.getParent().getKey())
            return node.getParent();
        else
            return rightAncestor(node.getParent());
    }

    public BinaryNode next(BinaryNode node) {
        if (node.getRight() != null)
            return leftDescendant(node.getRight());
        else
            return rightAncestor(node);
    }

    public MyArrayList<BinaryNode> rangeSearch(int x, int y, BinaryNode root) {
        MyArrayList<BinaryNode> list = new MyArrayList<>();
        BinaryNode node = new BinaryNode();
        node = find(x, root);
        while (node.getKey() <= y) {
            if (node.getKey() >= x)
                list.pushBack(node);
            node = next(node);
        }
        return list;
    }

    public void insert(int k, BinaryNode root) {
        BinaryNode node = find(k, root);
        if (k < node.getKey()) {
            BinaryNode child = new BinaryNode(k);
            node.setLeft(child);
            child.setParent(node);
        } else if (k > node.getKey()) {
            BinaryNode child = new BinaryNode(k);
            node.setRight(child);
            child.setParent(node);
        }
    }

    public void delete(BinaryNode node) {
        if (node.getRight() == null)
            node = node.getLeft();
        else {
            BinaryNode x = next(node);
            node = x;
            x.setParent(x.getRight());
        }
    }

    public void remove(int x) {
        root = remove(x, root);
    }

    public BinaryNode remove (int x, BinaryNode node) {
        if (node == null)
            return null;
        if (x < node.getKey())
            node.setLeft(remove(x, node.getLeft()));
        else if (x > node.getKey())
            node.setRight(remove(x, node.getRight()));
        else if (node.getLeft() != null && node.getRight() != null) {
            node.setKey(findMin(node.getRight()).getKey());
            node.setRight(remove(node.getKey(),node.getRight()));
        } else {
            if (node.getLeft() != null)
                node = node.getLeft();
            else
                node = node.getRight();
        }
        return node;
    }

    public int height(BinaryNode node) {
        if (node == null)
            return -1;
        else
            return 1+ Math.max(height(node.getLeft()), height(node.getRight()));
    }

    public void rotateRight(BinaryNode x) {
        BinaryNode p = x.getParent();
        BinaryNode y = x.getLeft();
        BinaryNode b = y.getRight();
        y.setParent(p);
        if (y.getKey() < p.getKey())
            p.setLeft(y);
        else
            p.setRight(y);
        x.setParent(y);
        y.setRight(x);
        b.setParent(x);
        x.setLeft(b);
    }

    public void preOrder(BinaryNode node) {
        if (node != null) {
            System.out.print(node.getKey() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void postOrder(BinaryNode node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getKey() + " ");
        }
    }

    public void inOrder(BinaryNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getKey() + " ");
            inOrder(node.getRight());
        }
    }

    public void levels(BinaryNode node) {
        if (node != null) {
            ArrayQueue<BinaryNode> nodeQueue = new ArrayQueue<>();
            BinaryNode aux = new BinaryNode();
            nodeQueue.enqueue(node);
            while (!nodeQueue.empty()) {
                aux = nodeQueue.dequeue();
                System.out.println(aux.getKey());
                if (aux.getLeft() != null)
                    nodeQueue.enqueue(aux.getLeft());
                if (aux.getRight() != null)
                    nodeQueue.enqueue(aux.getRight());
            }
        }
    }


}
