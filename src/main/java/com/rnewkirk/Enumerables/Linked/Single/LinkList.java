package com.rnewkirk.Enumerables.Linked.Single;

import com.rnewkirk.Enumerables.Enumerable;

import java.util.Collection;

public class LinkList<T> implements Enumerable<T> {
    private Node<T> head;
    private int size;

    public LinkList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void addFirst(T element) {
        if (this.head == null) {
            this.head = new Node<>(element, null);
        } else {
            Node<T> node = new Node<>(element, this.head);
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    @Override
    public T getFirst() {
        return this.head.data;
    }

    @Override
    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
        this.size--;

    }

    @Override
    public void addLast(T element) {

        Node<T> lastNode = getLastNode();

        lastNode.next = new Node<>(element, null);
        this.size++;
    }

    private Node<T> getLastNode() {
        Node<T> current = head;

        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    @Override
    public T getLast() {
        Node<T> lastNode = getLastNode();

        return lastNode.data;
    }

    @Override
    public void removeLast() {

        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            previous = current;
            current = current.next;
        }

        previous.next = null;

        this.size--;

    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(T element) {
        boolean contains = false;
        Node<T> next = this.head;

        while (next.next != null) {
            if (next.data.equals(element)) {
                contains = true;
                break;
            } else {
                next = next.next;
            }
        }

        return contains;
    }

    @Override
    public void add(T element) {
        addLast(element);
    }

    @Override
    public boolean remove(T element) {
        boolean delete = false;
        if (!isEmpty()) {
            if (head.data.equals(element)) {
                head = head.next;
            } else {
                Node<T> current = this.head;
                Node<T> previous = null;

                while (current != null && !current.data.equals(element)) {
                    previous = current;
                    current = current.next;
                }

                if (current != null) {
                    previous.next = current.next;
                    delete = true;
                }

            }
        }
        return delete;
    }

    @Override
    public void addAll(Collection<T> elements) {
        for (T element : elements) {
            addLast(element);
        }
    }
}
