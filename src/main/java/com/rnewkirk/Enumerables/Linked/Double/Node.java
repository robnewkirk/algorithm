package com.rnewkirk.Enumerables.Linked.Double;

public class Node<T> {
    private Node<T> next;
    private Node<T> previous;
    public T data;

    public Node(T data, Node<T> previous, Node<T> next){
        this.data = data;
        this.previous = previous;
        this.next = next;
    }


    public Node<T> getNext() {
        return next;
    }

    public boolean hasNext(){
        return next != null;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}
