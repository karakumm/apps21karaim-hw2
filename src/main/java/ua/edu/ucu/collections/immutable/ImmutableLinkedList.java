package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;

    public ImmutableLinkedList(Object[] elements) {
        Node previousNode = null;

        for (Object el: elements) {
            Node currentNode = new Node();
            currentNode.setValue(el);
            currentNode.setPrevious(previousNode);

            if (previousNode != null) {
                previousNode.setNext(currentNode);
            } else {
                head = currentNode;
            }
            previousNode = currentNode;
        }
        tail = previousNode;
    }

    public ImmutableLinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(size(), new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > size() + c.length) {
            throw new IllegalArgumentException();
        }
        Object[] lst = new Object[size() + c.length];

        int idx = 0;
        Node currNode = getHead();

        for (int i = 0; i < index; i++) {
            lst[idx] = currNode.getValue();
            currNode = currNode.getNext();
            idx++;
        }
        for (Object element : c) {
            lst[idx] = element;
            idx++;
        }
        for (int i = index; i < size(); i++) {
            lst[idx] = currNode.getValue();
            currNode = currNode.getNext();
            idx++;
        }
        return new ImmutableLinkedList(lst);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException();
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 || index > size()) {
            throw new IllegalArgumentException();
        }
        Object[] lst = new Object[size()-1];
        Node currentNode = head;
        int idx = 0;
        while (idx < index) {
            lst[idx] = currentNode.getValue();
            currentNode = currentNode.getNext();
            idx++;
        }
        currentNode = currentNode.getNext();
        for (int i = index; i < lst.length; i++) {
            lst[i] = currentNode.getValue();
            currentNode = currentNode.getNext();
        }
        return new ImmutableLinkedList(lst);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index < 0 || index > size()) {
            throw new IllegalArgumentException();
        }
        Object[] lst = toArray();
        lst[index] = e;
        return new ImmutableLinkedList(lst);
    }

    @Override
    public int indexOf(Object e) {
        Node currentNode = head;
        int count = 0;
        while (currentNode != null) {
            if (currentNode.getValue() == e) {
                return count;
            }
            count++;
            currentNode = currentNode.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        int size = 0;
        Node currentNode = getHead();
        while (currentNode != null) {
            currentNode = currentNode.getNext();
            size++;
        }
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList(new Object[size()]);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        Node currentNode = head;
        Object[] lst = new Object[size()];
        int idx = 0;
        while (currentNode != null) {
            lst[idx] = currentNode.getValue();
            currentNode = currentNode.getNext();
            idx++;
        }
        return lst;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(size(), e);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        if (size() == 0) {
            throw new IllegalArgumentException();
        }
        return head.getValue();
    }

    public Object getLast() {
        if (size() == 0) {
            throw new IllegalArgumentException();
        }
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        if (size() == 0) {
            throw new IllegalArgumentException();
        }
        Object[] lst = Arrays.copyOfRange(toArray(), 1, size());
        return new ImmutableLinkedList(lst);
    }

    public ImmutableLinkedList removeLast() {
        if (size() == 0) {
            throw new IllegalArgumentException();
        }
        Object[] lst = Arrays.copyOf(toArray(), size()-1);
        return new ImmutableLinkedList(lst);
    }
}
