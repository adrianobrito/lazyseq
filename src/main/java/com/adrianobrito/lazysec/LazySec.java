package com.adrianobrito.lazysec;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by adriano on 10/05/16.
 */
public class LazySec<T> implements Iterator<T>{

    private T head;
    private LazyCommand<T> tail;
    private LazySec<T> tailSec;

    public LazySec(T head, LazyCommand<T> tail){
        this.head = head;
        this.tail = tail;
        this.tailSec = this;
    }

    public boolean hasNext() {
        LazySec<T> nextLazySec = tailSec.executeCommand();
        return nextLazySec.head() != null;
    }

    public T next() {
        T next = tailSec.head();
        tailSec = tailSec.executeCommand();
        return next;
    }

    public T head(){
        return head;
    }

    private LazySec<T> executeCommand(){
        return tail.execute(head);
    }

}
