package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList linkedList = new ImmutableLinkedList();

    public Object peek() {
        return linkedList.getFirst();
    }

    public Object dequeue() {
        Object val = peek();
        linkedList = linkedList.removeFirst();
        return val;
    }

    public void enqueue(Object e) {
        linkedList = linkedList.addLast(e);
    }
}