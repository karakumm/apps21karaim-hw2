package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] lstImmutable;


    public ImmutableArrayList(Object[] elements) {
        lstImmutable = Arrays.copyOf(elements, elements.length);
    }

    public ImmutableArrayList() {
        lstImmutable = new Object[0];
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(lstImmutable.length, new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(lstImmutable.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > lstImmutable.length + c.length || index < 0) {
            throw new IllegalArgumentException();
        }
        Object[] lst = new Object[c.length + lstImmutable.length];

        int idx = 0;
        for (int i = 0; i < index; i++) {
            lst[idx] = lstImmutable[i];
            idx++;
        }
        for (Object element : c) {
            lst[idx] = element;
            idx++;
        }
        for (int i = index; i < lstImmutable.length; i++) {
            lst[idx] = lstImmutable[i];
            idx++;
        }

        return new ImmutableArrayList(lst);
    }

    @Override
    public Object get(int index) {
        if (0 > index || index >= lstImmutable.length) {
            throw new IllegalArgumentException();
        }
        return lstImmutable[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (lstImmutable.length == 0 || index > lstImmutable.length) {
            throw new IllegalArgumentException();
        }
        Object[] lst = new Object[lstImmutable.length-1];

        for (int i = 0; i < index; i++) {
            lst[i] = lstImmutable[i];
        }
        for (int i = index; i < lst.length; i++) {
            lst[i] = lstImmutable[i+1];
        }
        return new ImmutableArrayList(lst);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (lstImmutable.length == 0 || index > lstImmutable.length) {
            throw new IllegalArgumentException();
        }
        Object[] lst = Arrays.copyOf(lstImmutable, lstImmutable.length);
        lst[index] = e;

        return new ImmutableArrayList(lst);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < lstImmutable.length; i++) {
            if (lstImmutable[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return lstImmutable.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList(new Object[lstImmutable.length]);
    }

    @Override
    public boolean isEmpty() {
        return lstImmutable.length == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(lstImmutable, lstImmutable.length);
    }
}
