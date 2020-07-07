package Estructuras_de_datos;

import java.io.Serializable;

public class MyBinaryTree<T extends Comparable<T>> implements Serializable {

    private BinaryNode<T> root;

    public MyBinaryTree() {
        root = null;
    }

    public MyBinaryTree(BinaryNode<T> root) {
        this.root = root;
    }

    public BinaryNode<T> root(){
        return root;
    }

    public void setRoot(BinaryNode<T> root) {
        this.root = root;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    public boolean contains(T x, BinaryNode<T> root) {
        if (root == null || root.getItem() == null)
            return false;
        if (x.compareTo(root.getItem()) < 0)
            return contains(x, root.getLeft());
        else if (x.compareTo(root.getItem()) > 0)
            return contains(x, root.getRight());
        else
            return true;
    }

    public T findMin() {
        if (isEmpty())
            throw new RuntimeException("The tree is empty");
        else
            return findMin(this.root).getItem();
    }

    public BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node.getItem() == null)
            return null;
        else if (node.getLeft().getItem() == null)
            return node;
        return findMin(node.getLeft());
    }

    public T findMax() {
        if (isEmpty())
            throw new RuntimeException("The tree is empty");
        else
            return findMax(this.root).getItem();
    }

    public BinaryNode<T> findMax(BinaryNode<T> node) {
        if (node.getItem() == null)
            return null;
        else if (node.getRight().getItem() == null)
            return node;
        return findMax(node.getRight());
    }

    public int size(){
        return size(root);
    }

    public int size(BinaryNode<T> node) {
        if (node.getItem() == null)
            return 0;
        else
            return 1 + size(node.getLeft()) + size(node.getRight());
    }

    public BinaryNode<T> find(T k) {
        return find(k, root);
    }

    public BinaryNode<T> find(T k, BinaryNode root) {
        if (root.getItem().compareTo(k) > 0) {
            if (root.getLeft() != null)
                return find(k, root.getLeft());
        } else {
            if (root.getRight() != null)
                return find(k, root.getRight());
        }
        return root;
    }

    public BinaryNode<T> leftDescendant(BinaryNode<T> node) {
        if (node.getLeft() == null || node.getLeft().getItem() == null)
            return node;
        else
            return leftDescendant(node.getLeft());
    }

    public BinaryNode<T> rightAncestor(BinaryNode<T> node) {
        if (node.getItem().compareTo(node.getParent().getItem()) < 0)
            return node.getParent();
        else
            return rightAncestor(node.getParent());
    }

    public BinaryNode<T> next(BinaryNode<T> node) {
        if (node.getRight() != null)
            return leftDescendant(node.getRight());
        else
            return rightAncestor(node);
    }

    public MyArrayList<BinaryNode<T>> rangeSearch(T x, T y, BinaryNode<T> root) {
        MyArrayList<BinaryNode<T>> list = new MyArrayList<>();
        BinaryNode<T> node = new BinaryNode<>();
        node = find(x, root);
        while (node.getItem().compareTo(y) <= 0) {
            if (node.getItem().compareTo(x) >= 0)
                list.pushBack(node);
            node = next(node);
        }
        return list;
    }

    public void insert(T k, BinaryNode<T> root) {
        BinaryNode<T> node = find(k, root);
        if (k.compareTo(node.getItem()) < 0) {
            BinaryNode<T> child = new BinaryNode<>(k);
            node.setLeft(child);
            child.setParent(node);
        } else if (k.compareTo(node.getItem()) > 0) {
            BinaryNode child = new BinaryNode(k);
            node.setRight(child);
            child.setParent(node);
        }
    }

    public void insert(T k) {
        if (this.root() == null) {
            BinaryNode<T> r = new BinaryNode<>(k);
            this.setRoot(r);
        } else
            insert(k, this.root());
    }

    public void delete(BinaryNode node) {
        if (node.getRight() == null || node.getRight().getItem() == null)
            node = node.getLeft();
        else {
            BinaryNode x = next(node);
            node = x;
            x.setParent(x.getRight());
        }
    }

    public void remove(T x) {
        root = remove(x, root);
    }

    public BinaryNode<T> remove (T x, BinaryNode<T> node) {
        if (node == null || node.getItem() == null)
            return null;
        if (x.compareTo(node.getItem()) < 0)
            node.setLeft(remove(x, node.getLeft()));
        else if (x.compareTo(node.getItem()) > 0)
            node.setRight(remove(x, node.getRight()));
        else if (node.getLeft().getItem() != null && node.getRight().getItem() != null) {
            node.setItem(findMin(node.getRight()).getItem());
            node.setRight(remove(node.getItem(),node.getRight()));
        } else {
            if (node.getLeft().getItem() != null)
                node = node.getLeft();
            else
                node = node.getRight();
        }
        return node;
    }

    public int height(BinaryNode<T> node) {
        if (node == null)
            return 0;
        else
            return 1+ Math.max(height(node.getLeft()), height(node.getRight()));
    }

    public void rotateRight(BinaryNode<T> x) {
        BinaryNode<T> p = x.getParent();
        BinaryNode<T> y = x.getLeft();
        BinaryNode<T> b = y.getRight();
        BinaryNode<T> x1 = new BinaryNode<>();
        if (p.getItem() != null) {
            y.setParent(p);
            if (y.getItem().compareTo(p.getItem()) < 0)
                p.setLeft(y);
            else
                p.setRight(y);
        } else {
            y.setParent(x1);
            root = y;
        }
        x.setParent(y);
        y.setRight(x);
        b.setParent(x);
        x.setLeft(b);
    }

    public void preOrder(BinaryNode<T> node) {
        if (node.getItem() != null) {
            System.out.print(node.getItem() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    public MyArrayList<T> preOrderList(MyArrayList<T> list, BinaryNode<T> node) {
        if (node.getItem() != null) {
            list.pushBack(node.getItem());
            preOrderList(list, node.getLeft());
            preOrderList(list, node.getRight());
        }
        return list;
    }

    public MyArrayList<T> preOrderList() {
        MyArrayList<T> list = new MyArrayList<>();
        return preOrderList(list, root);
    }

    public void postOrder(BinaryNode<T> node) {
        if (node.getItem() != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getItem() + " ");
        }
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    public MyArrayList<T> postOrderList(MyArrayList<T> list, BinaryNode<T> node) {
        if (node.getItem() != null) {
            postOrderList(list, node.getLeft());
            postOrderList(list, node.getRight());
            list.pushBack(node.getItem());
        }
        return list;
    }

    public MyArrayList<T> postOrderList() {
        MyArrayList<T> list = new MyArrayList<>();
        return postOrderList(list, root);
    }

    public void inOrder(BinaryNode<T> node) {
        if (node.getItem() != null) {
            inOrder(node.getLeft());
            System.out.print(node.getItem() + " ");
            inOrder(node.getRight());
        }
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    public MyArrayList inOrderList(MyArrayList<T> list, BinaryNode<T>node) {
        if (node.getItem() != null) {
            inOrderList(list, node.getLeft());
            list.pushBack(node.getItem());
            inOrderList(list, node.getRight());
        }
        return list;
    }

    public MyArrayList<T> inOrderList() {
        MyArrayList<T> list = new MyArrayList<>();
        return inOrderList(list, root);
    }

    public void levels(BinaryNode<T> root) {
        if (root.getItem() != null) {
            ArrayQueue<BinaryNode<T>> q = new ArrayQueue<>();
            q.enqueue(root);
            while (!q.empty()) {
                BinaryNode<T> node = q.dequeue();
                System.out.print(node.getItem() + " ");
                if (node.getLeft().getItem() != null)
                    q.enqueue(node.getLeft());
                if (node.getRight().getItem() != null)
                    q.enqueue(node.getRight());
            }
        }
    }

    public void levels() {
        levels(root);
    }

    public MyArrayList<T> levelsList(MyArrayList<T> list, BinaryNode<T> root) {
        if (root.getItem() != null) {
            ArrayQueue<BinaryNode<T>> q = new ArrayQueue<>();
            q.enqueue(root);
            while (!q.empty()) {
                BinaryNode<T> node = q.dequeue();
                list.pushBack(node.getItem());
                if (node.getLeft().getItem() != null)
                    q.enqueue(node.getLeft());
                if (node.getRight().getItem() != null)
                    q.enqueue(node.getRight());
            }
        }
        return list;
    }

    public MyArrayList<T> levelsList() {
        MyArrayList<T> list = new MyArrayList<>();
        return levelsList(list, root);
    }

    public int calculateHeigth(int h,BinaryNode<T> nodo){
        if(nodo.getParent().getItem()!=null){
            h++;
            h=calculateHeigth(h,nodo.getParent());
        }
        return h;
    }
}