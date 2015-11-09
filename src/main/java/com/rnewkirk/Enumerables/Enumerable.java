package com.rnewkirk.Enumerables;

import java.util.Collection;

public interface Enumerable<T> {

    void addFirst(T element);

    T getFirst();

    void removeFirst();

    void addLast(T element);

    T getLast();

    void removeLast();

    boolean isEmpty();

    int size();

    boolean contains(T element);

    void add(T element);

    boolean remove(T element);

    void addAll(Collection<T> elements);


}