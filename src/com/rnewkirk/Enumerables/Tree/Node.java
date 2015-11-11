package com.rnewkirk.Enumerables.Tree;

public class Node<T extends Comparable<T>> implements Comparable<T> {
    private Node<T> right;
    private Node<T> left;
    private T data;

    public Node(Node<T> right, Node<T> left, T data) {
        this.right = right;
        this.left = left;
        this.data = data;
    }

    public boolean hasRight() {
        return right != null;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> node) {
        right = node;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> node) {
        left = node;
    }

    public T getData() {
        return data;
    }

    @Override
    public int compareTo(T data) {
        return data.compareTo(data);
    }

}
