package com.rnewkirk.Enumerables.Linked.Double;

import com.rnewkirk.Enumerables.Enumerable;

import java.util.Collection;

public class List<T> implements Enumerable<T> {
    private Node<T> head;
    private int size;

    public List() {
        head = null;
        size = 0;
    }

    @Override
    public void addFirst(T element) {
        if (head != null) {
            head = new Node<>(element, null, head);
        } else {
            head = new Node<>(element, null, null);
        }
        size++;
    }

    @Override
    public T getFirst() throws RuntimeException {

        if (head != null) {
            return head.data;
        }
        throw new RuntimeException("The list is empty");
    }

    @Override
    public void removeFirst() throws RuntimeException {
        if (head != null) {
            head = head.getNext();
        } else {
            throw new RuntimeException("The list is empty");
        }

        size--;
    }

    @Override
    public void addLast(T element) {
        Node<T> current = head;

        while (current.hasNext()) {
            current = current.getNext();
        }

        current.setNext(new Node<T>(element, current, null));
        size++;
    }

    @Override
    public T getLast() {
        Node<T> last = head;

        while (last.hasNext()) {
            last = last.getNext();
        }

        return last.data;
    }

    @Override
    public void removeLast() {
        Node<T> last = head;

        while (last.hasNext()) {
            last = last.getNext();
        }

        last.getPrevious().setNext(null);

        size--;
    }

    @Override
    public boolean isEmpty() {
        return head != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T element) {
        boolean contains = false;
        Node<T> current = head;

        while (current.hasNext()) {
            if (current.data.equals(element)) {
                contains = true;
                break;
            } else {
                current = current.getNext();
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
        boolean removed = false;
        Node<T> current = head;

        while (current.hasNext()) {
            if (current.data.equals(element)) {
                break;
            } else {
                current = current.getNext();
            }
        }
        if (current != null) {
            current.getPrevious().setNext(current.getNext());
            removed = true;
        }

        return removed;
    }

    @Override
    public void addAll(Collection<T> elements) {
        for (T elem : elements) {
            add(elem);
        }
    }
}
