package Estructuras_de_datos;

import java.io.Serializable;

public class AvlNodeTree<T extends Comparable<T>> implements Serializable {

    private AvlNode<T> root;

    public AvlNodeTree(AvlNode<T> root) {

        this.root = root;
    }

    public AvlNodeTree() {
    }

    public AvlNode<T> root() {
        return root;
    }

    public void setRoot(AvlNode<T> root) {
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

    public boolean contains(T x, AvlNode<T> root) {
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
            return null;
        else
            return findMin(this.root).getItem();
    }

    public AvlNode<T> findMin(AvlNode<T> node) {
        if (node.getItem() == null)
            return null;
        else if (node.getLeft().getItem() == null)
            return node;
        return findMin(node.getLeft());
    }

    public T findMax() {
        if (isEmpty())
            return null;
        else
            return findMax(this.root).getItem();
    }

    public AvlNode<T> findMax(AvlNode<T> node) {
        if (node.getItem() == null)
            return null;
        else if (node.getRight().getItem() == null)
            return node;
        return findMax(node.getRight());
    }

    public int size() {
        return size(root);
    }

    public int size(AvlNode<T> node) {
        if (node.getItem() == null)
            return 0;
        else
            return 1 + size(node.getLeft()) + size(node.getRight());
    }

    public AvlNode<T> find(T k) {
        return find(k, root);
    }

    public AvlNode<T> find(T k, AvlNode<T> root) {
        if (root.getItem().compareTo(k) == 0) {
            return root;
        } else if (root.getItem().compareTo(k) > 0) {
            if (root.getLeft().getItem() != null) {
                return find(k, root.getLeft());
            } else {
                return root;
            }
        } else {
            if (root.getRight().getItem() != null) {
                return find(k, root.getRight());
            } else {
                return root;
            }
        }
    }

    public AvlNode<T> leftDescendant(AvlNode<T> node) {
        if (node.getLeft() == null || node.getLeft().getItem() == null)
            return node;
        else
            return leftDescendant(node.getLeft());
    }

    public AvlNode<T> rightAncestor(AvlNode<T> node) {
        if (node.getItem().compareTo(node.getParent().getItem()) < 0)
            return node.getParent();
        else
            return rightAncestor(node.getParent());
    }

    public AvlNode<T> next(AvlNode<T> node) {
        if (node.getRight() != null)
            return leftDescendant(node.getRight());
        else
            return rightAncestor(node);
    }

    public MyArrayList<AvlNode<T>> rangeSearch(T x, T y, AvlNode<T> root) {
        MyArrayList<AvlNode<T>> list = new MyArrayList<>();
        AvlNode<T> node = new AvlNode<T>();
        node = find(x, root);
        while (node.getItem().compareTo(y) <= 0) {
            if (node.getItem().compareTo(x) >= 0)
                list.pushBack(node);
            node = next(node);
        }
        return list;
    }

    public void insert(T k, AvlNode<T> root) {
        AvlNode<T> N = find(k, root);
        if (N.getItem().compareTo(k) > 0) {
            AvlNode<T> child = new AvlNode<>(k);
            N.setLeft(child);
            child.setParent(N);
        } else if (N.getItem().compareTo(k) < 0) {
            AvlNode<T> child = new AvlNode<>(k);
            N.setRight(child);
            child.setParent(N);
        }
        rebalance(N);
    }

    public void insert(T k) {
        if (this.root() == null) {
            AvlNode<T> r = new AvlNode<>(k);
            this.setRoot(r);
        } else
            insert(k, this.root());
    }

    public void rebalance(AvlNode<T> N) {
        AvlNode<T> P = N.getParent();
        if (N.getLeft().getHeight() > N.getRight().getHeight() + 1) {
            rebalanceRight(N);
        }
        if (N.getRight().getHeight() > N.getLeft().getHeight() + 1) {
            rebalanceLeft(N);
        }
        adjustHeight(N);
        if (P.getItem() != null) {
            rebalance(P);
        }
    }

    public void rebalanceRight(AvlNode<T> N) {
        AvlNode<T> M = N.getLeft();
        if (M.getRight().getHeight() > M.getLeft().getHeight()) {
            rotateLeft(M);
        }
        rotateRight(N);
        adjustHeight(N);
        adjustHeight(M);
    }

    public void rebalanceLeft(AvlNode<T> N) {
        AvlNode<T> M = N.getRight();
        if (M.getLeft().getHeight() > M.getRight().getHeight())
            rotateRight(M);
        rotateLeft(N);
        adjustHeight(N);
        adjustHeight(M);
    }

    public void delete(AvlNode<T> node) {
        if (node.getRight() == null || node.getRight().getItem() == null)
            node = node.getLeft();
        else {
            AvlNode<T> x = next(node);
            node = x;
            x.setParent(x.getRight());
        }
    }

    public void remove(T x) {
        root = remove(x, root);
    }

    public AvlNode<T> remove(T x, AvlNode<T> node) {
        if (node == null || node.getItem() == null)
            return null;
        if (x.compareTo(node.getItem()) < 0)
            node.setLeft(remove(x, node.getLeft()));
        else if (x.compareTo(node.getItem()) > 0)
            node.setRight(remove(x, node.getRight()));
        else if (node.getLeft().getItem() != null && node.getRight().getItem() != null) {
            node.setItem(findMin(node.getRight()).getItem());
            node.setRight(remove(node.getItem(), node.getRight()));
        } else {
            if (node.getLeft().getItem() != null)
                node = node.getLeft();
            else
                node = node.getRight();
        }
        return node;
    }

    public int height(AvlNode<T> node) {
        if (node.getItem() == null)
            return 0;
        else
            return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    public void adjustHeight(AvlNode<T> N) {
        N.setHeight(1 + Math.max(height(N.getLeft()), height(N.getRight())));
    }

    public void rotateLeft(AvlNode<T> y) {
        AvlNode<T> p = y.getParent();
        AvlNode<T> x = y.getRight();
        AvlNode<T> b = x.getLeft();
        AvlNode<T> x1 = new AvlNode<>();
        if (p.getItem() != null) {
            x.setParent(p);
            if (x.getItem().compareTo(p.getItem()) < 0)
                p.setLeft(x);
            else
                p.setRight(x);
        } else {
            x.setParent(x1);
            root = x;
        }
        y.setParent(x);
        x.setLeft(y);
        b.setParent(y);
        y.setRight(b);
    }

    public void rotateRight(AvlNode<T> x) {
        AvlNode<T> p = x.getParent();
        AvlNode<T> y = x.getLeft();
        AvlNode<T> b = y.getRight();
        AvlNode<T> x1 = new AvlNode<>();
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

    public void preOrder(AvlNode<T> node) {
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

    public void postOrder(AvlNode<T> node) {
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

    public void inOrder(AvlNode<T> node) {
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
    
    //public MyLinkedList<T> inOrderArray()
    
    public MyArrayList inOrderList(MyArrayList<T> list, AvlNode<T>node) {
        if (node.getItem() != null) {           
            inOrderList(list, node.getLeft());
            list.pushBack(node.getItem());
            inOrderList(list, node.getRight());
        }
        return list;
    }
    
    public MyArrayList<T> inOrderList(AvlNode<T>node) {
        MyArrayList<T> list = new MyArrayList<>();
        return inOrderList(list, node.getParent());
    }
    
    public MyArrayList<T> inOrderList() {
        MyArrayList<T> list = new MyArrayList<>();
        return inOrderList(list, root);
    }

    public void levels(AvlNode<T> root) {
        if (root.getItem() != null) {
            ArrayQueue<AvlNode<T>> q = new ArrayQueue<>();
            q.enqueue(root);
            while (!q.empty()) {
                AvlNode<T> node = q.dequeue();
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
}